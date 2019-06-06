package com.turner.cnnnew.pageobject;

import java.io.IOException;
//import java.util.ArrayList;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
//import com.turner.base.drivers.DeskDriver;
//import com.turner.base.drivers.DriverFactory;
//import com.turner.base.utilities.jsonvalidation.JsonValidater;
import com.turner.base.utilities.support.ConfigProp;
import com.turner.base.utilities.support.UMReporter;
import com.turner.base.utilities.support.WrapperMethods;

public class contributeStories {

	private static String slug;
	private static String headline;
	private static String byline;
	private static String dateline;
	private static String contributor;
	private static String story;
	private static String storylinkError;
	private static String body;
	private static String name;
	private static String phone;
	private static String email;
	private static String email1;

	private static By clearText = By.xpath("//button[text()='Clear Form']");
	private static By slugText = By.xpath("//input[@id='form-slug']");
//	private static By sendWireStoryLink = By.xpath("//a[text()='Send Wire Story']");
	private static By stateSelect = By.xpath("//*[@id='form-state']");
	private static By headlineText = By.xpath("//input[@id='form-headline']");
	private static By bylineText = By.xpath("//input[@id='form-byline']");
	private static By datelineText = By.xpath("//input[@id='form-dateline']");
	private static By contributorText = By.xpath("//input[@id='form-contributor']");
	private static By storyLinkText = By.xpath("//input[@id='form-storyLink']");
	private static By storyBodyText = By.xpath("//textarea[@id='form-storyBody']");
	private static By userNameText = By.xpath("//input[@id='form-name']");
	private static By userPhoneText = By.xpath("//input[@id='form-phone']");
	private static By userEmailText = By.xpath("//input[@id='form-email']");
	private static By submitText = By.xpath("//button[@type='submit']");
//	private static By sendWireStoryHover = By.cssSelector("a[class*='navlink-active-hover']");
	private static By stateOption = By.xpath("//option[@value='10']");
	private static By failuremsg = By.xpath("//*[contains(text(),'Failed to submit wire')]");
	private static By emailError = By.xpath("//input[@id='form-email']/following-sibling::div");
	private static By slugError = By.xpath("//input[@id='form-slug']/following-sibling::div");
	private static By stateError = By.xpath("//*[@id='form-state']/following-sibling::div");
	private static By headLineError = By.xpath("//input[@id='form-headline']/following-sibling::div");
	private static By bylineError = By.xpath("//input[@id='form-byline']/following-sibling::div");
	private static By dateLineError = By.xpath("//input[@id='form-dateline']/following-sibling::div");
	private static By storyBodyError = By.xpath("//textarea[@id='form-storyBody']/following-sibling::div");
	private static By successmsg = By.xpath("//*[contains(text(),'You have successfully submitted the wire')]");
	private static By successClose = By.xpath("//button[contains(text(),'Close')]");
	private static By wireArticleCheckBox = By.xpath("//span[contains(text(),'Wire Article')]");
	//private static By searchText = By.cssSelector("input[id='search-input']");
	private static By searchText=By.xpath("//input[@placeholder='Search for stories, videos, footage type or id #']");
	private static By searchButton = By.cssSelector("button[id='search-button']");
	private static By headLineText = By.xpath("//h4[contains(text(),headline)]");
	private static By regionalCheckBox = By.xpath("//span[contains(text(),'Regional')]");
	private static By cancel = By.xpath("//input[@id='search-input']//following-sibling::div/span");
//The following test case is executed Without entering any text click on 'Clear Form'
	public static void clearForm() throws IOException {
		WrapperMethods.click(clearText);
		UMReporter.log(Status.PASS, "Succesfully clicked on Clear Button");
		WrapperMethods.contains_Text("", WrapperMethods.getText(slugText), "As expected Slug did not have any text",
				"Slug has value which is a failed condition");

	}
//Test case execute Entering wrong website address ex: www.google.com (without http)
	public static void invalidSubmit() throws IOException, InterruptedException {
		slug = ConfigProp.getPropertyValue("Slug");
		headline = ConfigProp.getPropertyValue("Headline");
		byline = ConfigProp.getPropertyValue("Byline");
		dateline = ConfigProp.getPropertyValue("Dateline");
		contributor = ConfigProp.getPropertyValue("Contributor");
		storylinkError = ConfigProp.getPropertyValue("StorylinkError");
		body = ConfigProp.getPropertyValue("Body");
		name = ConfigProp.getPropertyValue("Name");
		phone = ConfigProp.getPropertyValue("Phone");
		email = ConfigProp.getPropertyValue("Email");
		WrapperMethods.click(clearText);
		WrapperMethods.sendkeys(slugText, slug, "Slug Description succesfully entered",
				"Unable to enter Slug description");
		WrapperMethods.click(stateSelect);
		WrapperMethods.click(stateOption);
		WrapperMethods.sendkeys(headlineText, headline, "Headline succesfully entered", "Unable to enter Headline");
		WrapperMethods.sendkeys(bylineText, byline, "Byline text entered", "Unable to enter byline text");
		WrapperMethods.sendkeys(datelineText, dateline, "Dateline text entered", "Unable to enter Dateline");
		WrapperMethods.sendkeys(contributorText, contributor, "Succesfully entered contributor details",
				"Unable to enter contributor details");
		WrapperMethods.sendkeys(storyLinkText, storylinkError, "Story link entered succesfully",
				"Unable to enter story link");
		WrapperMethods.sendkeys(storyBodyText, body, "Body entered succesfully", "Unable to enter body");
		WrapperMethods.sendkeys(userNameText, name, "Name entered succesfully", "Unable to enter name");
		WrapperMethods.sendkeys(userPhoneText, phone, "Phone number entered succesfully",
				"Unable to enter phone number");
		WrapperMethods.sendkeys(userEmailText, email, "Email id entered entered succesfully",
				"Unable to enter Email id");
		WrapperMethods.click(submitText);
		UMReporter.log(Status.PASS, "Succesfully clicked on Submit Button");
		WrapperMethods.waitForElement(failuremsg, 30, "Failure message is displayed",
				"Failure message is not displayed");
		String failedMessage = WrapperMethods.getText(failuremsg);
		if (failedMessage.contains("Failed to submit wire")) {
			UMReporter.log(Status.PASS, "Failed to submit wire message displayed as expected");
		} else
			UMReporter.log(Status.FAIL, "Test Case Failed-Failed to submit wire message did not get displayed");
		WrapperMethods.click(successClose);
		UMReporter.log(Status.PASS, "Close button clicked successfully");

	}
//This test case is executed when wrong email id is entered
	public static void invalidEmail() throws IOException, InterruptedException {
		slug = ConfigProp.getPropertyValue("Slug");
		headline = ConfigProp.getPropertyValue("Headline");
		byline = ConfigProp.getPropertyValue("Byline");
		dateline = ConfigProp.getPropertyValue("Dateline");
		contributor = ConfigProp.getPropertyValue("Contributor");
		story = ConfigProp.getPropertyValue("Storylink");
		body = ConfigProp.getPropertyValue("Body");
		name = ConfigProp.getPropertyValue("Name");
		phone = ConfigProp.getPropertyValue("Phone");
		email1 = ConfigProp.getPropertyValue("Email1");
		WrapperMethods.click(clearText);
		WrapperMethods.sendkeys(slugText, slug, "Slug Description succesfully entered",
				"Unable to enter Slug description");
		WrapperMethods.click(stateSelect);
		WrapperMethods.click(stateOption);
		WrapperMethods.sendkeys(headlineText, headline, "Headline succesfully entered", "Unable to enter Headline");
		WrapperMethods.sendkeys(bylineText, byline, "Byline text entered", "Unable to enter byline text");
		WrapperMethods.sendkeys(datelineText, dateline, "Dateline text entered", "Unable to enter Dateline");
		WrapperMethods.sendkeys(contributorText, contributor, "Succesfully entered contributor details",
				"Unable to enter contributor details");
		WrapperMethods.sendkeys(storyLinkText, story, "Story link entered succesfully", "Unable to enter story link");
		WrapperMethods.sendkeys(storyBodyText, body, "Body entered succesfully", "Unable to enter body");
		WrapperMethods.sendkeys(userNameText, name, "Name entered succesfully", "Unable to enter name");
		WrapperMethods.sendkeys(userPhoneText, phone, "Phone number entered succesfully",
				"Unable to enter phone number");
		WrapperMethods.sendkeys(userEmailText, email1, "Invalid Email id entered successfully",
				"Unable to enter Email id");
		WrapperMethods.click(submitText);
		String str = WrapperMethods.getText(emailError);
		if (str.equalsIgnoreCase("Please enter a valid email address.")) {
			UMReporter.log(Status.PASS,
					"Please enter a valid email address error is thrown when invalid email id is entered.");
		} else
			UMReporter.log(Status.FAIL, "Please enter a invalid email address");

	}
//This test case is executed when submit button is entered without entering any data
	public static void onlySubmit() throws IOException, InterruptedException {
		WrapperMethods.click(clearText);
		WrapperMethods.click(submitText);
		UMReporter.log(Status.PASS, "Successfully clicked on submit button without entering any data");
		String slugErrorMsg = WrapperMethods.getText(slugError);
		String stateErrorMsg = WrapperMethods.getText(stateError);
		String headlineErrorMsg = WrapperMethods.getText(headLineError);
		String bylineErrorMsg = WrapperMethods.getText(bylineError);
		String datelineErrorMsg = WrapperMethods.getText(dateLineError);
		String storyBodyErrorMsg = WrapperMethods.getText(storyBodyError);

		if ((slugErrorMsg.contains("Please provide a slug for your wire."))
				&& (stateErrorMsg.contains("Please select a state."))
				&& (headlineErrorMsg.contains("Please provide a headline."))
				&& (bylineErrorMsg.contains("Please provide a byline or credit for your wire."))
				&& (datelineErrorMsg.contains("Please provide a dateline."))
				&& (storyBodyErrorMsg.contains("Please provide a body for your wire.")))

		{
			UMReporter.log(Status.PASS,
					"Proper Error messages are thrown when submit button is clicked without entering any data");
		} else
			UMReporter.log(Status.FAIL, "Test Case Failed as proper error messages are not thrown");

	}
//This test case is executed when slug message is not entered and validating the error message
	public static void slugError() throws IOException {
		WrapperMethods.click(clearText);
		headline = ConfigProp.getPropertyValue("Headline");
		byline = ConfigProp.getPropertyValue("Byline");
		dateline = ConfigProp.getPropertyValue("Dateline");
		contributor = ConfigProp.getPropertyValue("Contributor");
		story = ConfigProp.getPropertyValue("Storylink");
		body = ConfigProp.getPropertyValue("Body");
		name = ConfigProp.getPropertyValue("Name");
		phone = ConfigProp.getPropertyValue("Phone");
		email = ConfigProp.getPropertyValue("Email");
		WrapperMethods.sendkeys(slugText, "", "Slug Description succesfully entered",
				"Unable to enter Slug description");
		WrapperMethods.click(stateSelect);
		WrapperMethods.click(stateOption);
		WrapperMethods.sendkeys(headlineText, headline, "Headline succesfully entered", "Unable to enter Headline");
		WrapperMethods.sendkeys(bylineText, byline, "Byline text entered", "Unable to enter byline text");
		WrapperMethods.sendkeys(datelineText, dateline, "Dateline text entered", "Unable to enter Dateline");
		WrapperMethods.sendkeys(contributorText, contributor, "Succesfully entered contributor details",
				"Unable to enter contributor details");
		WrapperMethods.sendkeys(storyLinkText, story, "Story link entered succesfully", "Unable to enter story link");
		WrapperMethods.sendkeys(storyBodyText, body, "Body entered succesfully", "Unable to enter body");
		WrapperMethods.sendkeys(userNameText, name, "Name entered succesfully", "Unable to enter name");
		WrapperMethods.sendkeys(userPhoneText, phone, "Phone number entered succesfully",
				"Unable to enter phone number");
		WrapperMethods.sendkeys(userEmailText, email, "Email id entered entered succesfully",
				"Unable to enter Email id");
		WrapperMethods.click(submitText);
		String slugErrorMsg1 = WrapperMethods.getText(slugError);
		if (slugErrorMsg1.contains("Please provide a slug for your wire.")) {
			UMReporter.log(Status.PASS,
					"Please provide a slug for your wire. error message is thrown when Slug text is not provided");
		} else
			UMReporter.log(Status.FAIL, "Test Case Failed as proper slug error messages are not thrown");
	}
	//This test case is executed when state is not selected and validating the error message
	public static void stateError() throws IOException {
		WrapperMethods.click(clearText);
		slug = ConfigProp.getPropertyValue("Slug");
		headline = ConfigProp.getPropertyValue("Headline");
		byline = ConfigProp.getPropertyValue("Byline");
		dateline = ConfigProp.getPropertyValue("Dateline");
		contributor = ConfigProp.getPropertyValue("Contributor");
		story = ConfigProp.getPropertyValue("Storylink");
		body = ConfigProp.getPropertyValue("Body");
		name = ConfigProp.getPropertyValue("Name");
		phone = ConfigProp.getPropertyValue("Phone");
		email = ConfigProp.getPropertyValue("Email");
		WrapperMethods.sendkeys(slugText, slug, "Slug Description succesfully entered",
				"Unable to enter Slug description");
		WrapperMethods.sendkeys(headlineText, headline, "Headline succesfully entered", "Unable to enter Headline");
		WrapperMethods.sendkeys(bylineText, byline, "Byline text entered", "Unable to enter byline text");
		WrapperMethods.sendkeys(datelineText, dateline, "Dateline text entered", "Unable to enter Dateline");
		WrapperMethods.sendkeys(contributorText, contributor, "Succesfully entered contributor details",
				"Unable to enter contributor details");
		WrapperMethods.sendkeys(storyLinkText, story, "Story link entered succesfully", "Unable to enter story link");
		WrapperMethods.sendkeys(storyBodyText, body, "Body entered succesfully", "Unable to enter body");
		WrapperMethods.sendkeys(userNameText, name, "Name entered succesfully", "Unable to enter name");
		WrapperMethods.sendkeys(userPhoneText, phone, "Phone number entered succesfully",
				"Unable to enter phone number");
		WrapperMethods.sendkeys(userEmailText, email, "Email id entered entered succesfully",
				"Unable to enter Email id");
		WrapperMethods.click(submitText);
		if (WrapperMethods.getText(stateError).contains("Please select a state.")) {
			UMReporter.log(Status.PASS, "Please select a state error message is thrown when State is not selected");
		} else
			UMReporter.log(Status.FAIL, "Test Case Failed as proper state error messages are not thrown");
	}
	//This test case is executed when headline message is not entered and validating the error message
	public static void headlineError() throws IOException {
		WrapperMethods.click(clearText);
		slug = ConfigProp.getPropertyValue("Slug");
		byline = ConfigProp.getPropertyValue("Byline");
		dateline = ConfigProp.getPropertyValue("Dateline");
		contributor = ConfigProp.getPropertyValue("Contributor");
		story = ConfigProp.getPropertyValue("Storylink");
		body = ConfigProp.getPropertyValue("Body");
		name = ConfigProp.getPropertyValue("Name");
		phone = ConfigProp.getPropertyValue("Phone");
		email = ConfigProp.getPropertyValue("Email");
		WrapperMethods.sendkeys(slugText, slug, "Slug Description succesfully entered",
				"Unable to enter Slug description");
		WrapperMethods.click(stateSelect);
		WrapperMethods.click(stateOption);
		WrapperMethods.sendkeys(bylineText, byline, "Byline text entered", "Unable to enter byline text");
		WrapperMethods.sendkeys(datelineText, dateline, "Dateline text entered", "Unable to enter Dateline");
		WrapperMethods.sendkeys(contributorText, contributor, "Succesfully entered contributor details",
				"Unable to enter contributor details");
		WrapperMethods.sendkeys(storyLinkText, story, "Story link entered succesfully", "Unable to enter story link");
		WrapperMethods.sendkeys(storyBodyText, body, "Body entered succesfully", "Unable to enter body");
		WrapperMethods.sendkeys(userNameText, name, "Name entered succesfully", "Unable to enter name");
		WrapperMethods.sendkeys(userPhoneText, phone, "Phone number entered succesfully",
				"Unable to enter phone number");
		WrapperMethods.sendkeys(userEmailText, email, "Email id entered entered succesfully",
				"Unable to enter Email id");
		WrapperMethods.click(submitText);
		if (WrapperMethods.getText(headLineError).contains("Please provide a headline.")) {
			UMReporter.log(Status.PASS,
					"Please provide a headline error message is thrown when headline text is not entered");
		} else
			UMReporter.log(Status.FAIL, "Test Case Failed as proper headline error messages are not thrown");
	}
	//This test case is executed when byline message is not entered and validating the error message
	public static void bylineError() throws IOException {
		WrapperMethods.click(clearText);
		slug = ConfigProp.getPropertyValue("Slug");
		headline = ConfigProp.getPropertyValue("Headline");
		dateline = ConfigProp.getPropertyValue("Dateline");
		contributor = ConfigProp.getPropertyValue("Contributor");
		story = ConfigProp.getPropertyValue("Storylink");
		body = ConfigProp.getPropertyValue("Body");
		name = ConfigProp.getPropertyValue("Name");
		phone = ConfigProp.getPropertyValue("Phone");
		email = ConfigProp.getPropertyValue("Email");
		WrapperMethods.sendkeys(slugText, slug, "Slug Description succesfully entered",
				"Unable to enter Slug description");
		WrapperMethods.click(stateSelect);
		WrapperMethods.click(stateOption);
		WrapperMethods.sendkeys(headlineText, headline, "Headline succesfully entered", "Unable to enter Headline");
		WrapperMethods.sendkeys(datelineText, dateline, "Dateline text entered", "Unable to enter Dateline");
		WrapperMethods.sendkeys(contributorText, contributor, "Succesfully entered contributor details",
				"Unable to enter contributor details");
		WrapperMethods.sendkeys(storyLinkText, story, "Story link entered succesfully", "Unable to enter story link");
		WrapperMethods.sendkeys(storyBodyText, body, "Body entered succesfully", "Unable to enter body");
		WrapperMethods.sendkeys(userNameText, name, "Name entered succesfully", "Unable to enter name");
		WrapperMethods.sendkeys(userPhoneText, phone, "Phone number entered succesfully",
				"Unable to enter phone number");
		WrapperMethods.sendkeys(userEmailText, email, "Email id entered entered succesfully",
				"Unable to enter Email id");
		WrapperMethods.click(submitText);
		if (WrapperMethods.getText(bylineError).contains("Please provide a byline or credit for your wire.")) {
			UMReporter.log(Status.PASS,
					"Please provide a byline or credit for your wire error message is thrown when headline text is not entered");
		} else
			UMReporter.log(Status.FAIL, "Test Case Failed as proper byline error messages are not thrown");
	}
	//This test case is executed when dateline message is not entered and validating the error message
	public static void datelineError() throws IOException {
		WrapperMethods.click(clearText);
		slug = ConfigProp.getPropertyValue("Slug");
		headline = ConfigProp.getPropertyValue("Headline");
		byline = ConfigProp.getPropertyValue("Byline");
		contributor = ConfigProp.getPropertyValue("Contributor");
		story = ConfigProp.getPropertyValue("Storylink");
		body = ConfigProp.getPropertyValue("Body");
		name = ConfigProp.getPropertyValue("Name");
		phone = ConfigProp.getPropertyValue("Phone");
		email = ConfigProp.getPropertyValue("Email");
		WrapperMethods.sendkeys(slugText, slug, "Slug Description succesfully entered",
				"Unable to enter Slug description");
		WrapperMethods.click(stateSelect);
		WrapperMethods.click(stateOption);
		WrapperMethods.sendkeys(headlineText, headline, "Headline succesfully entered", "Unable to enter Headline");
		WrapperMethods.sendkeys(bylineText, byline, "Byline text entered", "Unable to enter byline text");
		WrapperMethods.sendkeys(contributorText, contributor, "Succesfully entered contributor details",
				"Unable to enter contributor details");
		WrapperMethods.sendkeys(storyLinkText, story, "Story link entered succesfully", "Unable to enter story link");
		WrapperMethods.sendkeys(storyBodyText, body, "Body entered succesfully", "Unable to enter body");
		WrapperMethods.sendkeys(userNameText, name, "Name entered succesfully", "Unable to enter name");
		WrapperMethods.sendkeys(userPhoneText, phone, "Phone number entered succesfully",
				"Unable to enter phone number");
		WrapperMethods.sendkeys(userEmailText, email, "Email id entered entered succesfully",
				"Unable to enter Email id");
		WrapperMethods.click(submitText);
		if (WrapperMethods.getText(dateLineError).contains("Please provide a dateline.")) {
			UMReporter.log(Status.PASS,
					"Please provide a dateline error message is thrown when dateline text is not entered");
		} else
			UMReporter.log(Status.FAIL, "Test Case Failed as proper dateline error messages are not thrown");
	}
	//This test case is executed when body message is not entered and validating the error message
	public static void bodyTextError() throws IOException {
		WrapperMethods.click(clearText);
		slug = ConfigProp.getPropertyValue("Slug");
		headline = ConfigProp.getPropertyValue("Headline");
		byline = ConfigProp.getPropertyValue("Byline");
		contributor = ConfigProp.getPropertyValue("Contributor");
		story = ConfigProp.getPropertyValue("Storylink");
		dateline = ConfigProp.getPropertyValue("Dateline");
		name = ConfigProp.getPropertyValue("Name");
		phone = ConfigProp.getPropertyValue("Phone");
		email = ConfigProp.getPropertyValue("Email");
		WrapperMethods.sendkeys(slugText, slug, "Slug Description succesfully entered",
				"Unable to enter Slug description");
		WrapperMethods.click(stateSelect);
		WrapperMethods.click(stateOption);
		WrapperMethods.sendkeys(headlineText, headline, "Headline succesfully entered", "Unable to enter Headline");
		WrapperMethods.sendkeys(bylineText, byline, "Byline text entered", "Unable to enter byline text");
		WrapperMethods.sendkeys(datelineText, dateline, "Dateline text entered", "Unable to enter Dateline");
		WrapperMethods.sendkeys(contributorText, contributor, "Succesfully entered contributor details",
				"Unable to enter contributor details");
		WrapperMethods.sendkeys(storyLinkText, story, "Story link entered succesfully", "Unable to enter story link");

		WrapperMethods.sendkeys(userNameText, name, "Name entered succesfully", "Unable to enter name");
		WrapperMethods.sendkeys(userPhoneText, phone, "Phone number entered succesfully",
				"Unable to enter phone number");
		WrapperMethods.sendkeys(userEmailText, email, "Email id entered entered succesfully",
				"Unable to enter Email id");
		WrapperMethods.click(submitText);
		if (WrapperMethods.getText(storyBodyError).contains("Please provide a body for your wire.")) {
			UMReporter.log(Status.PASS,
					"Please provide a body for your wire error message is thrown when body text is not entered");
		} else
			UMReporter.log(Status.FAIL, "Test Case Failed as proper body error messages are not thrown");
	}
//This test case is executed when all fields are entered and validating the wire article is created
	public static void validSubmit() throws IOException, InterruptedException {
		WrapperMethods.click(clearText);
		slug = ConfigProp.getPropertyValue("Slug");
		headline = ConfigProp.getPropertyValue("Headline");
		byline = ConfigProp.getPropertyValue("Byline");
		contributor = ConfigProp.getPropertyValue("Contributor");
		body = ConfigProp.getPropertyValue("Body");
		story = ConfigProp.getPropertyValue("Storylink");
		dateline = ConfigProp.getPropertyValue("Dateline");
		name = ConfigProp.getPropertyValue("Name");
		phone = ConfigProp.getPropertyValue("Phone");
		email = ConfigProp.getPropertyValue("Email");
		WrapperMethods.sendkeys(slugText, slug, "Slug Description succesfully entered",
				"Unable to enter Slug description");
		WrapperMethods.click(stateSelect);
		WrapperMethods.click(stateOption);
		WrapperMethods.sendkeys(headlineText, headline, "Headline succesfully entered", "Unable to enter Headline");
		WrapperMethods.sendkeys(bylineText, byline, "Byline text entered", "Unable to enter byline text");
		WrapperMethods.sendkeys(datelineText, dateline, "Dateline text entered", "Unable to enter Dateline");
		WrapperMethods.sendkeys(contributorText, contributor, "Succesfully entered contributor details",
				"Unable to enter contributor details");
		WrapperMethods.sendkeys(storyLinkText, story, "Story link entered succesfully", "Unable to enter story link");
		WrapperMethods.sendkeys(storyBodyText, body, "Body entered succesfully", "Unable to enter body");
		WrapperMethods.sendkeys(userNameText, name, "Name entered succesfully", "Unable to enter name");
		WrapperMethods.sendkeys(userPhoneText, phone, "Phone number entered succesfully",
				"Unable to enter phone number");
		WrapperMethods.sendkeys(userEmailText, email, "Email id entered entered succesfully",
				"Unable to enter Email id");
		WrapperMethods.click(submitText);
		UMReporter.log(Status.PASS, "Submit button clicked");
		WrapperMethods.waitForElement(successmsg, 30, "Successmessage is displayed", "Sucessmessage is not displayed");
		String successmessage = WrapperMethods.getText(successmsg);
		if (successmessage.contains("You have successfully submitted the wire")) {
			UMReporter.log(Status.PASS, "Wire article has been created successfully");
		} else
			UMReporter.log(Status.FAIL, "Test Case Failed and wire article not created");
		WrapperMethods.click(successClose);
		UMReporter.log(Status.PASS, "Close button clicked successfully");
	/*	WrapperMethods.navigateBack();
		WrapperMethods.waitForElement(wireArticleCheckBox, 30, "Navigated back to Landing Page",
				"Failed to navigate to landing page");
		WrapperMethods.click(wireArticleCheckBox);
		WrapperMethods.sendkeys(searchText, headline, "Successfully entered the Headline for search",
				"Unable to enter the Search text");
		WrapperMethods.click(searchButton);
		boolean b = WrapperMethods.isElementPresent(headLineText, 30);
		WrapperMethods.assertIsTrue(b, "Created article found in the wire article section of landing page",
				"Created article not found in the wire article section of landing page");
		WrapperMethods.click(cancel);
		WrapperMethods.click(regionalCheckBox);
		UMReporter.log(Status.PASS, "Regional checkbox  clicked successfully");
		WrapperMethods.sendkeys(searchText, headline, "Successfully entered the Headline for search",
				"Unable to enter the Search text");
		WrapperMethods.click(searchButton);
		boolean c = WrapperMethods.isElementPresent(headLineText, 30);
		WrapperMethods.assertIsTrue(c, "Created article found in the Regional section",
				"Created article not found in the Regional section");*/

	}

}
