package com.base;

import java.io.IOException;
import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.pom.LoginPage;
import com.utility.ProprtyClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;

public class BaseClass extends ProprtyClass{
	
	public static WebDriver driver;
	LoginPage lp;
	
	@BeforeClass
	@Parameters({"browser"})
    public void setUp(String browser) throws IOException
	{

          //logger.info("Initializing WebDriver...");
		
        if (browser.equalsIgnoreCase("chrome")) 
        {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Chrome launch");
            
            //logger.info("WebDriver initialized and window maximized");
            
        } 
        else 
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("Edge launch");
            //logger.info("WebDriver initialized and window maximized");
            
            //driver.get("https://www.entrata.com/");
           

        }
        
        driver.get(getBaseUrl("baseUrl"));
        System.out.println("URL launch");
        //driver.get("http://101.53.145.125:3030/home");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
        driver.manage().window().maximize();
        //return driver;
        
	}
	
	
	//Login
	public void LoginPage() throws InterruptedException
	{
		lp = new LoginPage(driver);
		//lp.txtUserName(getUserNameAdmin("userNameAdmin"));
		lp.txtUserName(getUserNameAdmin("userNameAdmin"));
		lp.txtPass(getPassAdmin("passAdmin"));
		lp.clickBtnSubmit();
		//lp.clickLogout();
		
	}
	
	
	
	
   //@AfterClass
    public WebDriver setDown()
    {
        if (driver != null) {
            driver.close();
            driver.quit();
            //logger.info("Browser closed successfully");
        }
        return driver;
    }
   

}
