package WebDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Drivers {
    private String driverLocator = System.getProperty( "user.dir" ) +
            "\\DriverExe\\";

    public static WebDriver driver=null;

    public Drivers(BrowserTypes browserTypes) {
        switch (browserTypes) {
            case chrome:
                System.setProperty( "webdriver.chrome.driver", driverLocator + "chromedriver.exe" );
                ChromeOptions options = new ChromeOptions();
                options.addArguments( "--start-maximized" );
                driver = new ChromeDriver( options );
                break;

            case firefox:
                System.setProperty( "webdriver.gecko.driver", driverLocator + "geckodriver.exe" );
                System.setProperty( "webdriver.firefox.bin", "D:\\ruanjianceshi\\Firefox\\" + "firefox.exe" );
                driver = new FirefoxDriver();
                break;

            case ie:
                System.setProperty( "webdriver.ie.driver", driverLocator + "IEDriverServer.exe" );
                driver = new InternetExplorerDriver();
                break;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        String url = "www.baidu.com";
        Drivers drivers = new Drivers( BrowserTypes.firefox );
        driver = drivers.driver;

        if(url.startsWith( "http" )) {
            System.out.println("aaaa: " + url);
            driver.get( url );
        } else {
            String urlS = "Https://" + url;
            System.out.println(urlS);
            driver.get( urlS );
        }

        Thread.sleep( 10 );

//        driver.quit();

    }
}
