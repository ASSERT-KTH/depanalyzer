package kth.castor;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DependencyTree {

    TreeMap<String, List<String>> dt;

    public DependencyTree() {
        this.dt = new TreeMap<>();
    }

    public TreeMap<String, List<String>> getDependencies() {
        return dt;
    }

    public void printDependencyTree(){
        for (Map.Entry<String, List<String>> entry : dt.entrySet()) {
            System.out.println("\tClass used: " + entry.getKey() + "  Methods used: " + entry.getValue());
        }
    }
}
