package kth.castor;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class InstrumenterTest {

    Instrumenter inst;

    @Before
    public void instantiateInstrumenter() {
        inst = new Instrumenter();
    }

    @Test
    public void checkThatIsNotNull() throws IOException {
        inst.printDependencies("src/main/resources/weka-stable-3.8.3-SNAPSHOT-jar-with-dependencies.jar", "org/apache/commons");
        assertNotNull(inst.getMethodsCalled());
    }

    @Test
    public void check() throws IOException {
        inst.printDependencies("src/test/resources/uselib/target/uselib-1.0-SNAPSHOT.jar", "se/kth/castor/types");
        assertNotNull(inst.getMethodsCalled());
    }
}

