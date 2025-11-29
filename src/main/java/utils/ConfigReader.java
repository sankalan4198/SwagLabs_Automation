package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    //Properties is a built-in Java class used to store key–value pairs
    //(e.g., browser=chromium, headless=false, baseUrl=https://...).
    //it is STATIC because config values should load only once
    private static Properties properties=new Properties();

    static {
        try{
            //Load config.properties from classpath
            InputStream inputStream=ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");

            if(inputStream!=null)
            {
                properties.load(inputStream);
            }
            else {
                throw new RuntimeException("config.properties file is not found in resources folder");
            }

        } catch (Exception e){
            throw new RuntimeException("Failed to load config.properties: "+e.getMessage(),e);
        }
    }

    public static String get(String key)
    {
        String value= properties.getProperty(key);

        if(value==null){
            throw new RuntimeException("key "+key+" is not found in config.properties");
        }

        return value.trim();
    }
}
