package Test;

import SeleniumFrameworkMethod.ReadLog4j;
import WebDrivers.BrowserTypes;
import WebDrivers.Drivers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TesA {
    private final ReadLog4j log = new ReadLog4j( TesA.class );
    private WebDriver driver;

    @BeforeClass
    public void methodA() {
        Drivers drivers = new Drivers( BrowserTypes.chrome );
        driver = drivers.driver;
    }

    @Test
    public void methodB() {
        log.info( "打开淘宝网页" );
        driver.get( "http://www.taobao.com/" );
        Assert.assertTrue( true );
    }

    @AfterMethod
    public void methodC() {
        driver.quit();
    }
}
