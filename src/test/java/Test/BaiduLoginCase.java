package Test;

import PageOperations.BaiduLoginSearchWindow;
import SeleniumFrameworkMethod.ReadLog4j;
import TestData.TestEnv;
import WebDrivers.BrowserTypes;
import WebDrivers.Drivers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaiduLoginCase {
    WebDriver driver;
    private BaiduLoginSearchWindow baiduLoginSearchWindow = new BaiduLoginSearchWindow();
    private ReadLog4j log = new ReadLog4j( BaiduLoginCase.class );

    @BeforeClass
    public void inItDriver() {
        log.info( "--Loading driver--" );
        Drivers drivers = new Drivers( BrowserTypes.chrome );
        driver = drivers.driver;
        driver.get( TestEnv.URL );
    }

    @Test
    public void methodLogin() throws InterruptedException {
       log.info( "--Start test Case--" );
       baiduLoginSearchWindow.ifLogin();
       baiduLoginSearchWindow.loginUser(TestEnv.USERNAME, TestEnv.PWD);
       Boolean resultValue = baiduLoginSearchWindow.loginAssert();
        Assert.assertTrue(resultValue, "Check page key word.");
    }

    @AfterMethod
    public void clearDriver() {
        driver.quit();
    }
}
