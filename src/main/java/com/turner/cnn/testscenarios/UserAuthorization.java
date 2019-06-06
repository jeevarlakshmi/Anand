package com.turner.cnn.testscenarios;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.turner.base.utilities.support.UMReporter;
import com.turner.cnn.testscenarios.BaseTest;
import com.turner.cnnnew.pageobject.LoginPage;
import com.turner.cnnnew.pageobject.contributeStories;

public class UserAuthorization extends BaseTest {
	private static final Logger LOGGER = Logger.getLogger(String.class.getSimpleName());

	@Test(dataProvider = "GlobalTestData")
	public void wireUserAuthorization(Map<String, String> elem, Map<String, String> eTest, ITestContext ctx)
			throws IOException {

		try {
			LoginPage.navigateToPage("landing");
			LoginPage.articleUserlogin();
			/*
			 * LandingPage.wireArticleUserValidation();
			 * 
			 * LoginPage.navigateToPage("session");
			 * SessionPage.validatePermissionForWireArticleUser();
			 */

		} catch (Exception e) {
			LOGGER.log(Level.WARNING, MSG, e);
		}
	}

	@Test(dataProvider = "GlobalTestData")
	public void clearButtonValidation(Map<String, String> elem, Map<String, String> eTest, ITestContext ctx)
			throws IOException {
		try {
			LoginPage.navigateToPage("landing");
			LoginPage.articleUserlogin();
			contributeStories.clearForm();
			UMReporter.log(Status.PASS, "Succesfully clicked on Clear Button");
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, MSG, e);
		}
	}

	@Test(dataProvider = "GlobalTestData")
	public void invalidSubmitbutton(Map<String, String> elem, Map<String, String> eTest, ITestContext ctx)
			throws IOException, InterruptedException {
		try {
			LoginPage.navigateToPage("landing");
			LoginPage.articleUserlogin();
			contributeStories.invalidSubmit();
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, MSG, e);
		}
	}

	@Test(dataProvider = "GlobalTestData")
	public void invalidEmailValidation(Map<String, String> elem, Map<String, String> eTest, ITestContext ctx)
			throws IOException, InterruptedException {

		try {
			LoginPage.navigateToPage("landing");
			LoginPage.articleUserlogin();
			contributeStories.invalidEmail();
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, MSG, e);
		}

	}

	@Test(dataProvider = "GlobalTestData")
	public void onlySubmitValidation(Map<String, String> elem, Map<String, String> eTest, ITestContext ctx)
			throws IOException, InterruptedException {

		try {
			LoginPage.navigateToPage("landing");
			LoginPage.articleUserlogin();
			contributeStories.onlySubmit();
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, MSG, e);
		}
	}

	@Test(dataProvider = "GlobalTestData")
	public void slugErrorValidation(Map<String, String> elem, Map<String, String> eTest, ITestContext ctx)
			throws IOException, InterruptedException {

		try {
			LoginPage.navigateToPage("landing");
			LoginPage.articleUserlogin();
			contributeStories.slugError();
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, MSG, e);
		}
	}

	@Test(dataProvider = "GlobalTestData")
	public void stateErrorValidation(Map<String, String> elem, Map<String, String> eTest, ITestContext ctx)
			throws IOException, InterruptedException {

		try {
			LoginPage.navigateToPage("landing");
			LoginPage.articleUserlogin();
			contributeStories.stateError();
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, MSG, e);
		}
	}

	@Test(dataProvider = "GlobalTestData")
	public void headlineErrorValidation(Map<String, String> elem, Map<String, String> eTest, ITestContext ctx)
			throws IOException, InterruptedException {

		try {
			LoginPage.navigateToPage("landing");
			LoginPage.articleUserlogin();
			contributeStories.headlineError();
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, MSG, e);
		}
	}
	@Test(dataProvider = "GlobalTestData")
	public void bylineErrorValidation(Map<String, String> elem, Map<String, String> eTest, ITestContext ctx)
			throws IOException, InterruptedException {

		try {
			LoginPage.navigateToPage("landing");
			LoginPage.articleUserlogin();
			contributeStories.bylineError();
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, MSG, e);
		}
	}
	@Test(dataProvider = "GlobalTestData")
	public void datelineErrorValidation(Map<String, String> elem, Map<String, String> eTest, ITestContext ctx)
			throws IOException, InterruptedException {

		try {
			LoginPage.navigateToPage("landing");
			LoginPage.articleUserlogin();
			contributeStories.datelineError();
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, MSG, e);
		}
	}
	@Test(dataProvider = "GlobalTestData")
	public void bodyTextErrorValidation(Map<String, String> elem, Map<String, String> eTest, ITestContext ctx)
			throws IOException, InterruptedException {

		try {
			LoginPage.navigateToPage("landing");
			LoginPage.articleUserlogin();
			contributeStories.bodyTextError();
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, MSG, e);
		}
	}
	@Test(dataProvider = "GlobalTestData")
	public void submitButtonValidation(Map<String, String> elem, Map<String, String> eTest, ITestContext ctx)
			throws IOException, InterruptedException {

		try {
			LoginPage.navigateToPage("landing");
			LoginPage.articleUserlogin();
			contributeStories.validSubmit();
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, MSG, e);
		}
	}
}
