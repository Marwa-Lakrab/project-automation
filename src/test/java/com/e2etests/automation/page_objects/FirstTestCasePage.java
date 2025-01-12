package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

public class FirstTestCasePage {

	private ConfigFileReader configfilereader;
	/* @FindBy */
	@FindBy(how = How.ID, using ="user-name")
	public static WebElement name;
	
	@FindBy(how = How.ID, using = "password")
	public static WebElement password;
	
	@FindBy(how = How.ID, using = "login-button")
	public static WebElement btnlogin;
	
	@FindBy(how = How.XPATH, using = "//span[@class='title']")
	public static WebElement products;
	
	public FirstTestCasePage() {
		PageFactory.initElements(Setup.getDriver(), this);
		this.configfilereader = new ConfigFileReader();
		
	}
	
	public void fillName(String uname) {
		name.sendKeys(uname);
	}
	
	public void fillPassword (String upassword) {
		password.sendKeys(upassword);
	}
	
	public void clickLogin() {
		btnlogin.click();
	}
   
//	public void goToURL() {
//		Setup.getDriver().get(configfilereader.getProperties("home.url"));
//	}

}
