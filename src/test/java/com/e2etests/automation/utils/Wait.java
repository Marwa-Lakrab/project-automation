package com.e2etests.automation.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	private WebDriver driver;

	/**
	 * Instanciation de wait.
	 *
	 * @param driver
	 */
	public Wait(WebDriver driver) {
		this.driver = driver;
	}
	
	private void waitUntilCondition(ExpectedCondition condition, String timeoutMessage, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.withMessage(timeoutMessage);
		wait.until(condition);
	}
	
	public void forLoading(Duration timeout) {
		ExpectedCondition<Object> condition = ExpectedConditions
				.jsReturnsValue("return document.readyState==\"complete\";");
		String timeoutMessage = "Page didn't load after " + timeout + " seconds.";
		waitUntilCondition(condition, timeoutMessage, timeout);
	}


	public void forPresenceOfElements(Duration timeout, By elementLocator, String elementName) {
		ExpectedCondition<List<WebElement>> condition = ExpectedConditions
				.presenceOfAllElementsLocatedBy(elementLocator);
		String timeoutMessage = elementName + " elements were not displayed after " + timeout + " seconds.";
		waitUntilCondition(condition, timeoutMessage, timeout);
	}
	
	public static WebElement waitUntilClickable(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}
}
