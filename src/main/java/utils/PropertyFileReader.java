package utils;

import java.io.FileReader;
import java.util.Properties;

public class PropertyFileReader {
    static Properties prop;

    public static void readApplicationProperties(){
        String p = System.getProperty("user.dir")+"/main/resources";
        System.out.println(p);
        try{
            FileReader read = new FileReader("application.properties");
            prop = new Properties();
            prop.load(read);
        }catch(Exception e){
            System.out.println("Exception occured while reading property file"+e.getMessage());
        }
    }

    public static String getBrowser(){
        readApplicationProperties();
        return prop.getProperty("browser");
    }

    public static String getUrl(){
        readApplicationProperties();
        return prop.getProperty("url");
    }
}
