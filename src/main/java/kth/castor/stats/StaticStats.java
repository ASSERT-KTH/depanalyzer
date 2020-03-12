package kth.castor.stats;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class StaticStats {

    /**
     * The names of classes and methods in the project
     */
    Map<String, List<String>> project;
    /**
     * The names of classes and methods in the project's dependencies
     */
    Map<String, List<String>> dependencies;

    /**
     * Constructor
     */
    public StaticStats() {
        project = new HashMap<>();
        dependencies = new HashMap<>();
    }

    /**
     * Counts the total number of classes in the project.
     *
     * @return the number of classes
     */
    public int totalClassesInProject() {
        return project.size();
    }

    /**
     * Counts the total number of methods in the project.
     *
     * @return the number of classes
     */
    public int totalMethodsInProject() {
        int totalMethods = 0;
        for (Map.Entry<String, List<String>> entry : project.entrySet()) {
            totalMethods += entry.getValue().size();
        }
        return totalMethods;
    }

    /**
     * Counts the total number of classes in the project's dependencies.
     *
     * @return the number of classes
     */
    public int totalClassesInDependencies() {
        return dependencies.size();
    }

    /**
     * Counts the total number of methods in the project's dependencies.
     *
     * @return the number of classes
     */
    public int totalMethodsInDependencies() {
        int totalMethods = 0;
        for (Map.Entry<String, List<String>> entry : dependencies.entrySet()) {
            totalMethods += entry.getValue().size();
        }
        return totalMethods;
    }

    /**
     * Records the number of classes an methods in a jar file.
     *
     * @param pathToJarWithDependencies path to the jar file that is going to be analyzed
     * @param packageName               start of the fully qualified name project's packages
     * @throws IOException throws if the jar file is missing
     */
    public void getStats(String pathToJarWithDependencies, String packageName) throws IOException {
        JarFile jarFile = new JarFile(new File(pathToJarWithDependencies));
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String entryName = entry.getName();
            if (entryName.endsWith(".class")) {
                InputStream classFileInputStream = jarFile.getInputStream(entry);
                List<String> methods = new ArrayList<>();
                try {
                    ClassReader cr = new ClassReader(classFileInputStream);
                    ClassNode classNode = new ClassNode();
                    cr.accept(classNode, 0);

                    if (classNode.name.startsWith(packageName)){
                        for (MethodNode methodNode : classNode.methods) {
                            methods.add(methodNode.name);
                        }
                        project.put(classNode.name, methods);
                    }else{
                        for (MethodNode methodNode : classNode.methods) {
                            methods.add(methodNode.name);
                        }
                        dependencies.put(classNode.name, methods);
                    }


                } finally {
                    classFileInputStream.close();
                }
            }
        }
    }
}
