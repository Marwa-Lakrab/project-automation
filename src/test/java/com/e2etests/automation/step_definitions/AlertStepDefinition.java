package com.e2etests.automation.step_definitions;

import org.junit.Assert;

import com.e2etests.automation.page_objects.AlertPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertStepDefinition {

	private AlertPage alertPage;
	private ConfigFileReader configfilereader;

	public AlertStepDefinition() {
		this.alertPage = new AlertPage();
		this.configfilereader = new ConfigFileReader();
	}

	@Given("Je me rends sur le site DemoQA alerts")
	public void jeMeRendsSurLeSiteDemoQAAlerts() {
		Setup.getDriver().get(configfilereader.getProperties("alert.url"));
	}

	@When("Je clique sur le boutton click me")
	public void jeCliqueSurLeBouttonClickMe() {
		alertPage.clickBtnAlert();

	}

	@When("Je clique sur le bouton click me")
	public void jeCliqueSurLeBoutonClickMe() {
		alertPage.clickAlertBtn();
	}

	@When("Je clique sur le bouton Click mme")
	public void jeCliqueSurLeBoutonClickMme() {
		alertPage.clickConfirmBtn();
	}

	@When("Je clique sur le boutonpromt Click me")
	public void jeCliqueSurLeBoutonpromtClickMe() {
		alertPage.clickPromtBtn();
	}

	@When("Je Saisis le name {string}")
	public void jeSaisisLeName(String name) {
		alertPage.fillName(name);
	}

	@When("Je clique sur le bouton OK")
	public void jeCliqueSurLeBoutonOK() {
		alertPage.acceptAlert();
	}

	@When("Je clique sur le bouton Annuler")
	public void jeCliqueSurLeBoutonAnnuler() {
		alertPage.cancelAlert();
	}

	@Then("L alerte se ferme")
	public void lAlerteSeFerme() {
		alertPage.verifier();
	}

	@Then("Un message s affiche {string}")
	public void unMessageSAffiche(String text) {
		String message = alertPage.messageSelected.getText();
		Assert.assertEquals(message, text);
		System.out.println("***" + message + "***");
	}

	@Then("Un message s afiche {string}")
	public void unMessageSAfiche(String text) {
		String messagepromt = alertPage.messagepromptresult.getText();
		Assert.assertEquals(messagepromt, text);
		System.out.println("***" + messagepromt + "***");
	}

}
