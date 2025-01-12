package com.e2etests.automation.page_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;

public class ClickPage {

	private Actions actions;
	private SeleniumUtils seleniumUtils;

	@FindBy(how = How.ID, using = "doubleClickBtn")
	public static WebElement doubleclickbtn;

	@FindBy(how = How.ID, using = "rightClickBtn")
	public static WebElement rightClickBtn;

	@FindBy(how = How.XPATH, using ="//div/button[text() = 'Click Me']")
	public static WebElement clickbtn;
	
//	@FindBy(how = How.XPATH, using ="(//button[@class='btn btn-primary'])[3]")
//	public static WebElement clickbtn;

	@FindBy(how = How.ID, using = "doubleClickMessage")
	public static WebElement doubleClickMessage;

	@FindBy(how = How.ID, using = "rightClickMessage")
	public static WebElement rightClickMessage;

	@FindBy(how = How.ID, using = "dynamicClickMessage")
	public static WebElement dynamicClickMessage;

	public ClickPage() {
		PageFactory.initElements(Setup.getDriver(), this);
		this.actions = new Actions(Setup.getDriver());
		this.seleniumUtils = new SeleniumUtils();
	}

	public void clickDoubleBtn() {
		actions.doubleClick(doubleclickbtn).perform();

	}

	public void clickRightBtn() {
		actions.contextClick(rightClickBtn).perform();
	}

	public void clickBtn() {
//		WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(30));
//		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("(//button[@class='btn btn-primary'])[3]")));
//		Setup.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebElement button = Setup.getDriver().findElement(By.id("(//button[@class='btn btn-primary'])[3]"));
//		WebElement clickButton = Setup.getDriver().findElement(By.id("(//button[@class='btn btn-primary'])[3]"));
//		((JavascriptExecutor) Setup.getDriver()).executeScript("arguments[0].scrollIntoView(true);", clickButton);
//		seleniumUtils.waitFor(10);
		WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(30));
//		WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-primary'])[3]")));
		WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/button[text() = 'Click Me']")));
		((JavascriptExecutor) Setup.getDriver()).executeScript("arguments[0].scrollIntoView(true);", button);
		clickbtn.click();
	}
}
