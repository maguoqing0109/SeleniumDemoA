package LabelImportOperations;

import LabelOperation.ButtonMethod;
import LabelOperation.InputMethod;
import SeleniumFrameworkMethod.ReadProperties;
import SeleniumFrameworkMethod.SeleniumMethodBase;

import java.io.FileNotFoundException;

public class BaiduFirstPage {

    public SeleniumMethodBase seleniumMethodBase = new SeleniumMethodBase();

    public String fileLocated = System.getProperty( "user.dir" ) +
            "\\src\\main\\resources\\UIxpathMap.properties";

    public ReadProperties rp = new ReadProperties(fileLocated);

    public InputMethod inputSearch = new InputMethod(rp.getValue( "Baidu.FirstPage.SearchBox" ));

    public ButtonMethod baiduSearchButton = new ButtonMethod( rp.getValue( "Baidu.FirstPage.SearchButton" ) );

    public ButtonMethod searchPageAssertHost = new ButtonMethod( rp.getValue( "Baidu.SearchPage.Assert.Host" ) );

    public ButtonMethod loginedImg = new ButtonMethod( rp.getValue( "BaiDu.Logined.Img" ) );

    public ButtonMethod backImg = new ButtonMethod( rp.getValue( "BaiDu.Logined.quic" ) );

    public ButtonMethod backConfirmButton = new ButtonMethod( rp.getValue( "BaiDu.Logined.quic.confirm"  ));

    public ButtonMethod loginButton = new ButtonMethod( rp.getValue("Baidu.Login.Button") );

    public ButtonMethod selectUserName = new ButtonMethod( rp.getValue( "Baidu.Select.UserNameLogin" ) );

    public InputMethod userNameBox = new InputMethod( rp.getValue("Baidu.Login.InputUserName" ));

    public InputMethod userPwd = new InputMethod( rp.getValue("Baidu.Login.InputPwd" ));

    public ButtonMethod logingButton = new ButtonMethod( rp.getValue("Baidu.Login.Button.Alert" ));

    public ButtonMethod loginConfirmImgAssert = new ButtonMethod( rp.getValue("Baidu.Login.Img.Assert" ));



}
