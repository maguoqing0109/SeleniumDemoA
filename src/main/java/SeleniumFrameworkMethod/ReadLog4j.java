package SeleniumFrameworkMethod;

import WebDrivers.Drivers;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ReadLog4j {
    private Properties pro = new Properties();
    private Logger logger=null;
    private String logFileLocated = System.getProperty( "user.dir" ) +
            "\\src\\main\\resources\\log4j.properties";

    public ReadLog4j(Class<?> T) {
        this.loadLog( T );

    }


    public void loadLog(Class<?> T) {

        if(logger==null) {
            try {
                File file = new File( logFileLocated );
                InputStream in = new FileInputStream( file );
                InputStreamReader isr = new InputStreamReader( in );
                BufferedReader br = new BufferedReader( isr );
                pro.load( br );
            } catch (IOException e) {
                e.printStackTrace();
            }

            PropertyConfigurator.configure( pro );
            logger = Logger.getLogger( T );
        }
    }

    public void info(String msg) {
        logger.info( msg );
    }

    public void warn(String msg) {
        logger.warn( msg );
    }

    public void error(String msg) {
        logger.error( msg );
    }

    public void debug(String msg) {
        logger.debug( msg );
    }

    // screenShotFile
    public void getScreenShot(String CaseInfo) throws IOException {
        String screenShotPngLocated = System.getProperty( "user.dir" ) +
                "\\src\\main\\resources\\TestCaseShot\\";
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMdd" );
        Date date = new Date();
        String timeId = sdf.format( date );

        File screenShotFile = ((TakesScreenshot) Drivers.driver).getScreenshotAs( OutputType.FILE );
        FileUtils.copyFile( screenShotFile, new File(screenShotPngLocated + timeId + CaseInfo + ".png") );
    }
}
