package Test;

import LabelImportOperations.BaiduFirstPage;
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

import java.io.IOException;

public class BaiduSearchWindow {
    private ReadLog4j log = new ReadLog4j( BaiduSearchWindow.class );
    private WebDriver driver;
    private BaiduLoginSearchWindow baiduLoginSearchWindow = new BaiduLoginSearchWindow();
    private String caseInfo = "SearchboxWindow";

    @BeforeClass
    public void loadDriver() {
        Drivers drivers = new Drivers( BrowserTypes.chrome );
        driver = drivers.driver;
        driver.get( TestEnv.URL );
    }

    @Test
    public void SearchboxWindow() throws InterruptedException, IOException {
        log.info( "--Test Case start." );
        baiduLoginSearchWindow.windowOperation();
        baiduLoginSearchWindow.baiDuSearch(TestEnv.SEARCHTEXT);
        Assert.assertTrue( baiduLoginSearchWindow.hotSearchAssert(), "Verify hostSearch exist.");
    }

    @AfterMethod
    public void clearEnv() {
        driver.quit();
    }

}
