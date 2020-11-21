package SeleniumFrameworkMethod;

import TestData.TestEnv;
import WebDrivers.Drivers;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class SeleniumMethodBase {
    private final ReadLog4j log = new ReadLog4j( SeleniumMethodBase.class);

    public WebElement getElement(String xpath) {
        log.debug( "get element xpath: " + xpath + ".");
        return Drivers.driver.findElement( By.xpath(xpath) );
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void clearBox(WebElement element) {
        element.clear();
    }

    public void inputText(WebElement element, String text) {
        element.sendKeys( text );
    }

    // wait
    public void sleep(int i) throws InterruptedException {
        Thread.sleep( 1000 * i );
    }

    public void waitToBeclick(String xpath) {
        WebDriverWait wait = new WebDriverWait( Drivers.driver, TestEnv.TIMEOUT );
        wait.until( ExpectedConditions.elementToBeClickable( By.xpath( xpath ) ) );
    }

    public void waitElement(String xpath) {
        WebDriverWait wait = new WebDriverWait( Drivers.driver, TestEnv.TIMEOUT );
        wait.until( ExpectedConditions.presenceOfElementLocated( By.xpath( xpath ) ) );
    }

    public void waitLoadingElement(final String xpath) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>( Drivers.driver ).
                withTimeout( TestEnv.TIMELOADING, TimeUnit.SECONDS ).  //  //div[contains(@class, 'header')]/h3    //div[contains(@class, 'mod-vcode-content-mkd')]/p[1]
                pollingEvery( 1, TimeUnit.SECONDS ).
                ignoring( org.openqa.selenium.NoSuchElementException.class).
                withMessage( "Wait loading succeed." );

        wait.until( new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement( By.xpath( xpath ) );
            }
        } );
    }


    // isEnsble, isSelected, isDisplayed
    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    public boolean isSeleced(WebElement element) {
        return element.isSelected();
    }

    public boolean is(WebElement element) {
        return element.isDisplayed();
    }

    // Actions
    public void doubleClick(WebElement element) {
        Actions actions = new Actions( Drivers.driver );
        actions.doubleClick( element ).perform();
    }

    public void moveElement(WebElement elementA, WebElement elementB) {
        Actions actions = new Actions( Drivers.driver );
        actions.clickAndHold(elementA).
                moveToElement( elementB ).
                release(elementA).perform();
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions( Drivers.driver );
        actions.moveToElement( element ).perform();
    }

    public void moveClick(WebElement element) {
        Actions actions = new Actions( Drivers.driver );
        actions.moveToElement( element ).
                click(element).perform();
    }
    public void keyDownUpShift(WebElement element, WebElement elementA) {
        Actions actions = new Actions( Drivers.driver );
        actions.keyDown( Keys.SHIFT ).
                click(element).
                click(elementA).
                keyUp( Keys.SHIFT ).perform();
    }

    public void keyDownUpControl(WebElement element, WebElement elementA) {
        Actions actions = new Actions( Drivers.driver );
        actions.keyDown( Keys.CONTROL ).
                click(element).
                click(elementA).
                keyUp( Keys.CONTROL ).perform();
    }

    // JS Page
    public void pageSlipeElement(WebElement element) {
        ((JavascriptExecutor)Drivers.driver).executeScript(
                "arguments[0].scrollIntoView(true);", element);
    }

    public void pageSlipeBase() {
        ((JavascriptExecutor)Drivers.driver).executeScript(
                "window.scrollTo(0, document.body.scrollHeight)" );
    }

    // Select
    public void selectIndex(WebElement element, int i) {
        Select select = new Select( element );
        select.selectByIndex( i );
    }

    public void selectText(WebElement element, String text) {
        Select select = new Select( element );
        select.selectByVisibleText( text );
    }

    public void selectValue(WebElement element, String value) {
        Select select = new Select( element );
        select.selectByValue( value );
    }

    public void keysC(WebElement element) {
        element.sendKeys( Keys.CONTROL, "c" );
    }

    public void keysX(WebElement element) {
        element.sendKeys( Keys.CONTROL, "x");
    }

    public void keysBackspace(WebElement element) {
        element.sendKeys( Keys.BACK_SPACE );
    }

    public void keysV(WebElement element) {
        element.sendKeys( Keys.CONTROL, "v" );
    }

    public boolean elementsIsEmpty(String xpath) {
        boolean resultValue = false;
        try {
            if(!Drivers.driver.findElements( By.xpath( xpath ) ).isEmpty()) {
                resultValue = true;
            }
        } catch (Exception e) {
            log.error( "Find element error" );
            e.printStackTrace();
        }
        return resultValue;
    }

    public boolean elementsIsSelected(String xpath) {
        boolean resultValue = false;
        try {
            if(Drivers.driver.findElement( By.xpath( xpath ) ).isSelected()) {
                resultValue = true;
            }
        } catch (Exception e) {
            log.error( "Find element error" );
            e.printStackTrace();
        }
        return resultValue;
    }

    public boolean elementsIsPlayed(String xpath) {
        boolean resultValue = false;
        try {
            if(Drivers.driver.findElement( By.xpath( xpath ) ).isDisplayed()) {
                resultValue = true;
            }
        } catch (Exception e) {
            log.error( "Find element error" );
            e.printStackTrace();
        }
        return resultValue;
    }
}
