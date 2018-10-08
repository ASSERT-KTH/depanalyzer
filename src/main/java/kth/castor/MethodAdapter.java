package kth.castor;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;

class MethodAdapter extends MethodVisitor implements Opcodes {

    DependencyTree dt;
    String dependencyPkg;

    public MethodAdapter(final MethodVisitor mv, String dependencyName, DependencyTree dt) {
        super(ASM5, mv);
        this.dependencyPkg = dependencyName;
        this.dt = dt;
    }

    public void processUsage( final String owner, final String name, final String descriptor) {
        String sig = getSignature(name,descriptor);
        if (owner.startsWith(dependencyPkg)) {
            if (!dt.getDependencies().containsKey(owner)) {
                List list = new ArrayList<String>();
                list.add(sig);
                dt.getDependencies().put(owner, list);
            } else if (!dt.getDependencies().get(owner).contains(sig)) {
                dt.getDependencies().get(owner).add(sig);
            }
        }
    }

    @Override
    public void visitFieldInsn(final int opcode, final String owner, final String name, final String descriptor) {
        processUsage(owner, name, descriptor);
        mv.visitFieldInsn(opcode, owner, name, descriptor);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, final String descriptor, boolean itf) {
        processUsage(owner, name, descriptor);
        mv.visitMethodInsn(opcode, owner, name, descriptor, itf);
    }

    public static String getSignature(String name, String desc) {
        return name + desc;
    }
}
