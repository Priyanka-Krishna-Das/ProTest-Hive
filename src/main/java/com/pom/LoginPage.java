package com.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class LoginPage {
	
	private WebDriver driver;
	SoftAssert sa = new SoftAssert();

	//Const
	public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // PageFactory initialization
    }
	
	//Xpath
	 @FindBy(xpath = "//input[@id='username']")
	    private WebElement usernameField;
	 
	 @FindBy(xpath = "//input[@id='password']")
	    private WebElement passwordField;
	 
	 @FindBy(xpath = "//button[@type='submit']")
	    private WebElement submitButton;
	 
	 @FindBy(xpath = "//h6[contains(text(),'Admin')]")
	    private WebElement adminLoginTxt;
	 
	 //Logout
	 @FindBy(xpath = "(//img[contains(@alt,'profile')])[2]")
	    private WebElement headerProfileSection;
	 
//	 @FindBy(xpath = "(//div[contains(@class,'MuiStack-root css-j7qwjs')])[5]")
//	    private WebElement headerProfileSection;
	 
	 @FindBy(xpath = "//span[contains(text(),'Cerrar sesión')]")
	    private WebElement headerLogoutSection;
	 
	 @FindBy(xpath = "//h2[contains(text(),'Iniciar sesión')]")
	    private WebElement loginPageText;
	 
	 
	 //Action method
	 public void txtUserName(String userNameAdmin) throws InterruptedException
	 {
		 usernameField.sendKeys(userNameAdmin);
		 TimeUnit.SECONDS.sleep(2);
	 }
	 
	 public void txtPass(String passAdmin)
	 {
		 passwordField.sendKeys(passAdmin);
	 }
	 
	 public void clickBtnSubmit()
	 {
		 submitButton.click();
		 
//		 String adminLoginText = adminLoginTxt.getText();
//		 System.out.println("Admin login text: "+adminLoginText);
//		 
//		 if (adminLoginText.equalsIgnoreCase("Administración")) 
//		 {
//			sa.assertEquals(adminLoginText, "Administración");
//			System.out.println("Admin loged in");
//		}
//		 else {
//			 System.out.println("Admin not loged in");
//		 }
	 }
	 
	 public void clickSectionProfile()
	 {
		 headerProfileSection.click();
	 }

	 public void clickLogout() throws InterruptedException
	 {
		 TimeUnit.SECONDS.sleep(6);
		 Actions action = new Actions(driver);
         action.moveToElement(headerProfileSection).click().perform();
		 
		 TimeUnit.SECONDS.sleep(2);
		 headerLogoutSection.click();
		 
		 String dispLoginPageText=loginPageText.getText();
		 System.out.println("Login page txt is visible: "+ dispLoginPageText);
		 
		 if (dispLoginPageText.equalsIgnoreCase("Iniciar sesión")) 
		 {
			sa.assertEquals(dispLoginPageText, "Iniciar sesión");
			System.out.println("Admin loged out");
		}
		 else {
			 System.out.println("Admin not loged out");
		 }
	 }
	 
}
