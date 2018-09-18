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
        inst.printDependencies("src/main/resources/descartes-1.2.4.jar", "org/pitest");
        assertNotNull(inst.getMethodsCalled());
    }
}