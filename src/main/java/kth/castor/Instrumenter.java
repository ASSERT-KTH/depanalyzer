package kth.castor;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.TreeMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Instrumenter {

    public static TreeMap<String, List<DependencyTree>> methodsCalled;
    public static DependencyTree dt = new DependencyTree();

    public Instrumenter() {
        this.methodsCalled = new TreeMap<>();
    }

    public static void main(final String args[]) throws Exception {
        Instrumenter instrumenter = new Instrumenter();
        if (args.length != 2) {
            instrumenter.printUsage();
        } else {
            instrumenter.printDependencies(args[0], args[1]);
        }
    }

    /**
     * Prints the name of the methods in the jar file that call some method in the dependency.
     *
     * @param pathToJar     path to the jar file that is going to be analyzed
     * @param dependencyPkg fully qualified name of the packaged dependency
     * @throws IOException if the jar file is missing
     */
    public static void printDependencies(String pathToJar, String dependencyPkg) throws IOException {
        JarFile jarFile = new JarFile(new File(pathToJar));
        Enumeration<JarEntry> entries = jarFile.entries();
        //DependencyTree dt = new DependencyTree();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String entryName = entry.getName();
            if (entryName.endsWith(".class")) {
                //DependencyTree dt = new DependencyTree();
                InputStream classFileInputStream = jarFile.getInputStream(entry);
                try {
                    ClassReader cr = new ClassReader(classFileInputStream);
                    ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                    ClassVisitor cv = new ClassAdapter(cw, dependencyPkg, dt);
                    cr.accept(cv, 0);
                } finally {
                    classFileInputStream.close();
                }

                /*if (!methodsCalled.containsKey(entryName)) {
                    List list = new ArrayList<DependencyTree>();
                    list.add(dt);
                    methodsCalled.put(entryName, list);
                } else if (methodsCalled.containsKey(entryName)) {
                    methodsCalled.get(entryName).add(dt);
                }*/

            }
        }

        if (!dt.getDependencies().isEmpty()) {
            System.out.println("Usage of " + dependencyPkg + " by " + pathToJar);
            dt.printDependencyTree();
        }
    }

    private static void printUsage() {
        System.err.println("Incorrect arguments!\nArguments should be:");
        System.err.println("\t 1 - path to the jar file, e.g. \"target/Dep-analyzer-1.0-SNAPSHOT.jar\".");
        System.err.println("\t 2 - fully qualified name of the packaged dependency, e.g. \"org/objectweb/asm\".");
    }

    public static TreeMap<String, List<DependencyTree>> getMethodsCalled() {
        return methodsCalled;
    }
}


