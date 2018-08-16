package TestSuite;

//import TestCases.ConsultasFechaTest;
//import TestCases.ConsultasTitularTest;
//import TestCases.IngresoBROUTest;
import TestCases.TrazabilidadTest;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
//@Suite.SuiteClasses({TestCases.IngresoBROUTest.class})
public class AfiliadorSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(TrazabilidadTest.class);
        return suite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

}
