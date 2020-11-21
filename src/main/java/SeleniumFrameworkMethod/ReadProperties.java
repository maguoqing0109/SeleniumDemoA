package SeleniumFrameworkMethod;

import java.io.*;
import java.util.Properties;

public class ReadProperties {
    private Properties pro = new Properties();
    private String value=null;

    public ReadProperties(String fileLocated) {
        this.loadFile( fileLocated );
    }

    public void loadFile(String fileLocated) {
        File file = new File(fileLocated);
        try {
            InputStream in = new FileInputStream( file );
            InputStreamReader isr = new InputStreamReader( in );
            BufferedReader br = new BufferedReader( isr );
            pro.load( br );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        value = pro.getProperty( key ).trim();
        try {
            value = new String(value.getBytes( "UTF-8" ), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

/*    public static void main(String[] args) throws UnsupportedEncodingException {
        String fileLocated = System.getProperty( "user.dir" ) + "\\src\\main\\resources\\UIxpathMap.properties";
        ReadProperties rp = new ReadProperties( fileLocated );

        System.out.println(rp.getValue( "test" ));
    }*/
}
