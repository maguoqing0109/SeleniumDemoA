package Test;

import SeleniumFrameworkMethod.ReadLog4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestJenkins {
    ReadLog4j log = new ReadLog4j( TestJenkins.class );

    @BeforeClass
    public void methodA() {
        log.info( "这是 BeforeClass" );
    }

    @Test
    public void methodB() {
        log.info( "这是 Test" );
    }

    @AfterMethod
    public void methodC() {
        log.info( "这是 AfterMethod." );
    }
}
