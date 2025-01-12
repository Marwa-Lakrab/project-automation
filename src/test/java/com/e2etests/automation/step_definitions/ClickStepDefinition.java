package com.e2etests.automation.step_definitions;

import org.junit.Assert;

import com.e2etests.automation.page_objects.ClickPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClickStepDefinition {

	private ConfigFileReader configfilereader;
	private ClickPage clickpage;

	public ClickStepDefinition() {
		this.configfilereader = new ConfigFileReader();
		this.clickpage = new ClickPage();
	}

	@Given("Je me rends sur le site DemoQA buttons")
	public void jeMeRendsSurLeSiteDemoQAButtons() {
		Setup.getDriver().get(configfilereader.getProperties("buttons.url"));
	}

	@When("Je clique sur le bouton double click me")
	public void jeCliqueSurLeBoutonDoubleClickMe() {
		clickpage.clickDoubleBtn();
	}

	@When("Je clique sur le bouton right click me")
	public void jeCliqueSurLeBoutonRightClickMe() {
		clickpage.clickRightBtn();
	}

	@When("Je clique sur le bouton Click me")
	public void jeCliqueSurLeBoutonClickMe() {
		clickpage.clickBtn();
	}

	@Then("Un Message s affiche  {string}")
	public void unMessageSAffiche(String text) {
		String message = clickpage.doubleClickMessage.getText();
		Assert.assertEquals(message, text);
		System.out.println("***" + message + "***");

	}

	@Then("Un Message s afiche  {string}")
	public void unMessageSAfiche(String text) {
		String message = clickpage.rightClickMessage.getText();
		Assert.assertEquals(message, text);
		System.out.println("***" + message + "***");

	}

	@Then("Un Messag s affiche  {string}")
	public void unMessagSAffiche(String text) {
		String message = clickpage.dynamicClickMessage.getText();
		Assert.assertEquals(message, text);
		System.out.println("***" + message + "***");
	}

}
