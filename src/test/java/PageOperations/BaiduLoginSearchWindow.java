package PageOperations;

import LabelImportOperations.BaiduFirstPage;
import SeleniumFrameworkMethod.ReadLog4j;
import WebDrivers.Drivers;
import org.openqa.selenium.Dimension;

public class BaiduLoginSearchWindow {
    private final ReadLog4j log = new ReadLog4j( BaiduLoginSearchWindow.class );

    private BaiduFirstPage baiduFirstPage = new BaiduFirstPage();

    public void windowOperation() throws InterruptedException {
        Dimension dimension = new Dimension( 700, 700 );

        log.info( "--Window adjust size :" + dimension );
        Drivers.driver.manage().window().setSize( dimension );
        baiduFirstPage.seleniumMethodBase.sleep( 3 );

        log.info( "--Window size max" );
        Drivers.driver.manage().window().maximize();
        baiduFirstPage.seleniumMethodBase.sleep( 3 );
    }

    public void baiDuSearch(String text) throws InterruptedException {
        log.info( "--Search box input: " + text );
        baiduFirstPage.inputSearch.inputTexts(text);
        baiduFirstPage.seleniumMethodBase.sleep( 3 );

        log.info( "--delete more text." );
        baiduFirstPage.inputSearch.keysBackspaceS();
        baiduFirstPage.seleniumMethodBase.sleep( 3 );

        log.info( "--doubleClick Text" );
        baiduFirstPage.inputSearch.doubleClickS();
        baiduFirstPage.seleniumMethodBase.sleep( 3 );

        log.info( "--Cut box text :" + text + "." );
        baiduFirstPage.inputSearch.keysXS();
        baiduFirstPage.seleniumMethodBase.sleep( 3 );

        log.info( "--Copy box text :" + text + "." );
        baiduFirstPage.inputSearch.keysVS();
        baiduFirstPage.seleniumMethodBase.sleep( 3 );

        log.info( "--Click search button" );
        baiduFirstPage.baiduSearchButton.clikcElements();
        baiduFirstPage.seleniumMethodBase.sleep( 3 );

        log.info( "--Referesh window" );
        Drivers.driver.navigate().refresh();
        baiduFirstPage.seleniumMethodBase.sleep( 3 );

        log.info( "--Back first page" );
        Drivers.driver.navigate().back();
        baiduFirstPage.seleniumMethodBase.sleep( 3 );

        log.info( "--Forward Search page" );
        Drivers.driver.navigate().forward();
        baiduFirstPage.seleniumMethodBase.sleep( 3 );
    }

    public boolean hotSearchAssert() {
        log.info( "--Assert hotSearch exists" );
        String xpath = baiduFirstPage.searchPageAssertHost.getXpath();
        baiduFirstPage.seleniumMethodBase.waitElement( xpath );
        return baiduFirstPage.seleniumMethodBase.elementsIsEmpty(xpath);
    }

    public void ifLogin() throws InterruptedException {
        String xpath = baiduFirstPage.loginedImg.getXpath();
        // baiduFirstPage.seleniumMethodBase.waitElement( xpath );
        baiduFirstPage.seleniumMethodBase.sleep( 3 );
        if (baiduFirstPage.seleniumMethodBase.elementsIsEmpty( xpath )) {
            log.info( "--Click back img" );
            baiduFirstPage.backImg.clikcElements();
            baiduFirstPage.seleniumMethodBase.sleep( 3 );

            log.info( "--Click confirm back button" );
            Drivers.driver.switchTo().defaultContent();
            Drivers.driver.switchTo().frame( 0 );
            baiduFirstPage.backConfirmButton.clikcElements();
            baiduFirstPage.seleniumMethodBase.sleep( 3 );

            Drivers.driver.switchTo().defaultContent();
        }
    }

    public void loginUser(String userName, String pwd) throws InterruptedException {
        log.info( "--Click login button" );
        baiduFirstPage.loginButton.clikcElements();
        baiduFirstPage.seleniumMethodBase.sleep( 3 );

        log.info( "--Select Login for UserName" );
        baiduFirstPage.selectUserName.clikcElements();
        baiduFirstPage.seleniumMethodBase.sleep( 3 );

        log.info( "--Input userName box." );
        baiduFirstPage.userNameBox.inputTexts( userName );
        baiduFirstPage.seleniumMethodBase.sleep( 3 );

        log.info( "--Input pwd box." );
        baiduFirstPage.userPwd.inputTexts( pwd );
        baiduFirstPage.seleniumMethodBase.sleep( 3 );

        log.info( "--Click loging button." );
        baiduFirstPage.logingButton.clikcElements();
        baiduFirstPage.seleniumMethodBase.sleep( 3 );
    }

    public boolean loginAssert() {
        boolean resultValue = false;
        String xpath = baiduFirstPage.loginConfirmImgAssert.getXpath();
        baiduFirstPage.seleniumMethodBase.waitLoadingElement(xpath);
//        baiduFirstPage.seleniumMethodBase.waitElement( xpath );
        try {
            log.info( "--Check Elemnet exists." );
            if(baiduFirstPage.seleniumMethodBase.elementsIsEmpty(xpath)) {
                resultValue = true;
            };
        }catch (Exception e) {
            log.info( "--Element not exist page" );
            e.printStackTrace();
        }

        return resultValue;
    }

}
