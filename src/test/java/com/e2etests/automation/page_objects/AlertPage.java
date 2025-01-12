package com.e2etests.automation.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Wait;

public class AlertPage {

	private ConfigFileReader configfilereader;
	private SeleniumUtils seleniumUtils;
	private Wait wait;

	@FindBy(how = How.ID, using = "alertButton")
	public static WebElement btnalert;

	@FindBy(how = How.ID, using = "timerAlertButton")
	public static WebElement alertbtn;

	@FindBy(how = How.ID, using = "confirmButton")
	public static WebElement confirmbtn;

	@FindBy(how = How.ID, using = "confirmResult")
	public static WebElement messageSelected;

	@FindBy(how = How.ID, using = "promtButton")
	public static WebElement promtbtn;
	
	@FindBy(how = How.ID, using = "promptResult")
	public static WebElement messagepromptresult;

	public AlertPage() {
		PageFactory.initElements(Setup.getDriver(), this);
		this.configfilereader = new ConfigFileReader();
		this.seleniumUtils = new SeleniumUtils();
		this.wait = new Wait(Setup.getDriver());
	}

	public void clickBtnAlert() {
		btnalert.click();

	}

	public void clickAlertBtn() {
		alertbtn.click();
	}

	public void clickConfirmBtn() {
//		seleniumUtils.waitForElementToBeClickable(By.id("confirmButton"));
		WebElement confirmButton = Setup.getDriver().findElement(By.id("confirmButton"));
		((JavascriptExecutor) Setup.getDriver()).executeScript("arguments[0].scrollIntoView(true);", confirmButton);
		confirmbtn.click();
	}

	public void clickPromtBtn() {
		WebElement promtButton = Setup.getDriver().findElement(By.id("promtButton"));
		((JavascriptExecutor) Setup.getDriver()).executeScript("arguments[0].scrollIntoView(true);", promtButton);
		promtbtn.click();
	}

	public void acceptAlert() {
//		Setup.getDriver().switchTo().alert().accept();
		seleniumUtils.waitFor(10);
		seleniumUtils.acceptAlert();
	}

	public void cancelAlert() {
//		Setup.getDriver().switchTo().alert().dismiss();
//		seleniumUtils.waitFor(10);
		seleniumUtils.cancelAlert();
	}

	public void fillName(String name) {
		Setup.getDriver().switchTo().alert().sendKeys(name);
	}

	public void verifier() {
		String title = Setup.getDriver().getTitle();
		System.out.println(title);
	}

}
