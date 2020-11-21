package LabelOperation;

import SeleniumFrameworkMethod.ReadLog4j;
import SeleniumFrameworkMethod.SeleniumMethodBase;

public class InputMethod extends SeleniumMethodBase{

    private final ReadLog4j log = new ReadLog4j( InputMethod.class );
    private String xpath;

    public InputMethod(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return this.xpath;
    }

    public void inputTexts(String text) {
        waitElement( this.xpath );
        clearBox( getElement( this.xpath ) );
        inputText( getElement( this.xpath ), text);
    }

    public void keysBackspaceS() {
        waitElement( this.xpath );
        keysBackspace( getElement( this.xpath ) );
    }

    public void doubleClickS() {
        waitElement( this.xpath );
        doubleClick( getElement( this.xpath ) );
    }

    public void keysXS() {
        waitElement( this.xpath );
        keysX( getElement( this.xpath ) );
    }

    public void keysVS() {
        waitElement( this.xpath );
        keysV( getElement( this.xpath ) );
    }
}
