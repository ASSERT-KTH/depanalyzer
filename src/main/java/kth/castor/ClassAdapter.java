package kth.castor;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ClassAdapter extends ClassVisitor implements Opcodes {

    String dependencyName;
    DependencyTree dt;

    public ClassAdapter(final ClassVisitor cv, String dependencyName, DependencyTree dt) {
        super(ASM5, cv);
        this.dependencyName = dependencyName;
        this.dt = dt;
    }

    @Override
    public MethodVisitor visitMethod(final int access, final String name,
                                     final String desc, final String signature, final String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        return mv == null ? null : new MethodAdapter(mv, dependencyName, dt);
    }
}
