package com.e2etests.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class is used to perform various kinds of validations in the test cases.
 */
public class Validations extends BasePage {

	private WebDriver driver;

	/**
	 * Instanciation de assertions.
	 */
	public Validations() {
		super();
		this.driver = Setup.getDriver();
	}

	public void checkUrlChange(String url) {
		String actualUrl = Setup.getDriver().getCurrentUrl();
		if (actualUrl.equals(url)) {
			log.info("The page did not change");
		} else {
			log.info("The page has changed");
		}
		log.info("Actual URL is : " + actualUrl);

	}

}
