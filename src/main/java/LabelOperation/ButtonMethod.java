package LabelOperation;

import SeleniumFrameworkMethod.ReadLog4j;
import SeleniumFrameworkMethod.SeleniumMethodBase;
import org.openqa.selenium.WebElement;

public class ButtonMethod extends SeleniumMethodBase{
    private final ReadLog4j log = new ReadLog4j(ButtonMethod.class);

    private String xpath;

    public ButtonMethod(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return this.xpath;
    }

    public void clikcElements() {
        log.debug( "click element xpath: " + this.xpath + ".");
        waitElement( this.xpath );
        waitToBeclick(this.xpath);
        WebElement element = getElement( this.xpath );
        clickElement( element );
    }

    public void mouseClick() {
        waitElement( this.xpath );
        moveClick(getElement( this.xpath ));
    }
}
