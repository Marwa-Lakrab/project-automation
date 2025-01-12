package com.e2etests.automation.step_definitions;

import org.junit.Assert;

import com.e2etests.automation.page_objects.FirstTestCasePage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstTestCaseStepDefinition {

	private FirstTestCasePage swaglabspage;
	private ConfigFileReader configfilereader;
	
	public FirstTestCaseStepDefinition() {
		this.swaglabspage = new FirstTestCasePage();
		this.configfilereader = new ConfigFileReader();
	}

	@Given("Je me connecte sur l application Swag Labs")
	public void jeMeConnecteSurLApplicationSwagLabs() {
//		swaglabspage.goToURL();
		Setup.getDriver().get(configfilereader.getProperties("home.url"));
	}
	@When("Je saisis le username {string}")
	public void jeSaisisLeUsername(String username) {
		swaglabspage.fillName(username);
	}
	@When("Je saisis le password {string}")
	public void jeSaisisLePassword(String Password) {
		swaglabspage.fillPassword(Password);
	}
	@When("Je clique sur le bouton login")
	public void jeCliqueSurLeBoutonLogin() {
		swaglabspage.clickLogin();
	}
	@Then("Je me redirige vers la page products {string}")
	public void jeMeRedirigeVersLaPageProducts(String text) {
	    String products = swaglabspage.products.getText();
	    Assert.assertEquals(products, text);
	    System.out.println("***"+products+"***");
	}




}
