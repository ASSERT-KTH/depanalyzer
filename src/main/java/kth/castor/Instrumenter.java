package kth.castor;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Instrumenter {

    public static void main(final String args[]) throws Exception {
        if (args.length != 2){
            printUsage();
        }else {
            printDependencies(args[0], args[1]);
        }
    }

    /**
     * Prints the name of the methods in the jar file that call some method in the dependency.
     *
     * @param pathToJar Path to the jar file that is going to be analyzed
     * @param dependencyPkg Fully qualified name of the packaged dependency
     * @throws IOException
     */
    private static void printDependencies(String pathToJar, String dependencyPkg) throws IOException {
        JarFile jarFile = new JarFile(new File(pathToJar));
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String entryName = entry.getName();
            if (entryName.endsWith(".class")) {
                DependencyTree dt = new DependencyTree();
                InputStream classFileInputStream = jarFile.getInputStream(entry);
                try {
                    ClassReader cr = new ClassReader(classFileInputStream);
                    ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
                    ClassVisitor cv = new ClassAdapter(cw, dependencyPkg, dt);
                    cr.accept(cv, 0);
                } finally {
                    classFileInputStream.close();
                }
                dt.printDependencyTree();
            }
        }
    }

    private static void printUsage(){
        System.err.println("Incorrect arguments. Arguments should be:");
        System.err.println("\t 1 - path to the jar file, e.g. \"target/Dep-analyzer-1.0-SNAPSHOT.jar\".");
        System.err.println("\t 2 - fully qualified name of the packaged dependency, e.g. \"org/objectweb/asm\".");
    }
}


