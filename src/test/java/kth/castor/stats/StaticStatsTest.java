package kth.castor.stats;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class StaticStatsTest {

    StaticStats ps;

    @Before
    public void setUp() throws IOException {
        ps = new StaticStats();
        ps.getStats("src/main/resources/weka-stable-3.8.3-SNAPSHOT-jar-with-dependencies.jar", "weka");
    }

    @Test
    public void totalClassesInProject() {
        System.out.println("Classes in the project: " + ps.totalClassesInProject());
    }

    @Test
    public void totalMethodsInProject() {
        System.out.println("Methods in the project: " + ps.totalMethodsInProject());
    }

    @Test
    public void totalClassesInDependencies() {
        System.out.println("Classes in the project's dependencies: " + ps.totalClassesInDependencies());
    }

    @Test
    public void totalMethodsInDependencies() {
        System.out.println("Methods in the project's dependencies: " + ps.totalMethodsInDependencies());
    }

}