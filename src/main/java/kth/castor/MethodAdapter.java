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

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {

        if (owner.startsWith(dependencyPkg)) {
            if (!dt.getDependencies().containsKey(owner)) {
                List list = new ArrayList<String>();
                list.add(name);
                dt.getDependencies().put(owner, list);
            } else if (!dt.getDependencies().get(owner).contains(name)) {
                dt.getDependencies().get(owner).add(name);
            }
        }

        // do call
        mv.visitMethodInsn(opcode, owner, name, desc, itf);
    }
}
