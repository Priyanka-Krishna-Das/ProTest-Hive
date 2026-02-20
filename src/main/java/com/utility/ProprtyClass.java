package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProprtyClass {
	
	Properties properties;

    public ProprtyClass() {
        try {
            // Path to your .properties file
            FileInputStream file = new FileInputStream("C:\\Users\\Priyanka D\\git\\repository\\ProTest\\src\\main\\java\\com\\utility\\config.properties");
            properties = new Properties();
            properties.load(file);
        } 
        catch (IOException e) {
            System.out.println("Failed to load config file: " + e.getMessage());
        }
    }

    public String getBaseUrl(String baseUrl) 
    {
        return properties.getProperty(baseUrl);
    }
    
    public String getUserNameAdmin(String userNameAdmin) 
    {
        return properties.getProperty(userNameAdmin);
    }

    public String getPassAdmin(String passAdmin) 
    {
        return properties.getProperty(passAdmin);
    }
    
    
    //api
    public String getbaseUrlApi(String baseUrlAPI) 
    {
        return properties.getProperty(baseUrlAPI);
    }
    
    public String getApiKey(String apiKey) 
    {
        return properties.getProperty(apiKey);
    }
    
    public String getApiSecrete(String apiSecrete) 
    {
        return properties.getProperty(apiSecrete);
    }
}
