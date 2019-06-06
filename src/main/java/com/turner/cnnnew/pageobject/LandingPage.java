package com.turner.cnnnew.pageobject;

import java.io.IOException;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;
import com.turner.base.utilities.support.UMReporter;
import com.turner.base.utilities.support.WrapperMethods;

public class LandingPage {
	
	private static By videoCount = By.xpath("//span[text()='Content Type']//following::li/label/span[text()='Video']//following-sibling::i/span");
	private static By downloadableCount = By.xpath("//span[text()='Content Type']//following::li/label/span[text()='Downloadable']//following-sibling::i/span");
	private static By embeddableCount = By.xpath("//span[text()='Content Type']//following::li/label/span[text()='Embeddable']//following-sibling::i/span");
	private static By wireArticleLink = By.xpath("//a[@data-tip='Wire Article']");
	private static By downloadLink = By.xpath("//button[@aria-label='Download']/span");
	private static By embedLink=By.xpath("//button[@aria-label='Embed']/span");
	
	public static int getCountDisplayed(By element) throws IOException {
		return Integer.parseInt(WrapperMethods.getText(element));
	}
	
	/**
	 * Validate Links and UI for Wire Article user
	 * @throws IOException
	 */
	public static void wireArticleUserValidation() throws IOException{
		WrapperMethods.waitForElement(wireArticleLink,30, "Wire Article Link is visible successfully", "Wire Article Link is not visble");
		WrapperMethods.isElementNotPresent(downloadLink, 5, "As expected, Download Link is not visible", "Download link is visible for Wire Article user");
		WrapperMethods.isElementNotPresent(embedLink, 5, "As expected, Embed Link is not visible", "Embed link is visible for Wire Article user");
		int vdCount = getCountDisplayed(videoCount);
		if(vdCount==0) {
		UMReporter.log(Status.PASS, "No Video counts is available for Wire Article user : ("+vdCount+")");
		}
		else {
			UMReporter.log(Status.FAIL, "Video counts are available for Wire Article user");
		}
		UMReporter.log(Status.INFO, "UI Validation Completed for Wire Article user");

	}
	
	/**
	 * Validate Links and UI for Embed user 
	 * @throws IOException
	 */
	public static void embedUserValidation() throws IOException{
		
		WrapperMethods.waitForElement(embedLink,30, "Embed Link is visible successfully","Embed link is missing");
		WrapperMethods.isElementNotPresent(downloadLink, 5, "As expected, Download Link is not visible", "Download link is visible for Embed user");
		WrapperMethods.isElementNotPresent(wireArticleLink, 5, "As expected, Wire Article Link is not visible", "Wire Article link is visible for Embed user");
		int edCount = getCountDisplayed(embeddableCount);
		if(edCount!=0) {
			UMReporter.log(Status.PASS, "Embeddable counts are available for Embeddable user : ("+edCount+")");
		}
		else {
			UMReporter.log(Status.FAIL, "No Embeddable counts are available for the Embeddable user");
		}		
		UMReporter.log(Status.INFO, "UI Validation Completed for Embed user");

	}
	
	/**
	 * Validate Links and UI for Downloadable user 
	 * @throws IOException
	 */
	public static void downloadUserValidation() throws IOException{		
		
		WrapperMethods.waitForElement(downloadLink,30, "Download Link is visible successfully","Download link is missing");
		WrapperMethods.isElementNotPresent(embedLink, 5, "As expected, Embed Link is not visible", "Embed link is visible for Wire Download user");
		WrapperMethods.isElementNotPresent(wireArticleLink, 5, "As expected, Wire Article Link is not visible", "Wire Article link is visible for Download user");
		int ddCount = getCountDisplayed(downloadableCount);
		if(ddCount!=0) {
			UMReporter.log(Status.PASS, "Download counts are available for Download user : ("+ddCount+")");
		}
		else {
			UMReporter.log(Status.FAIL, "No Download counts are available for the Download user");
		}
		UMReporter.log(Status.INFO, "UI Validation Completed for Download user");

	}
	
	/**
	 * Validate Links and UI for Admin user
	 * @throws IOException
	 */
	public static void adminUserValidation() throws IOException {
		
		WrapperMethods.waitForElement(embedLink, 30, "Embed Link is visible successfully", "Embed Link is missing");
		WrapperMethods.waitForElement(downloadLink,30, "Download Link is visisble", "Download Link is missing");
		WrapperMethods.waitForElement(wireArticleLink,30, "Wire Article Link is visisble", "Wire Article link is missing");
		int vdCount = getCountDisplayed(videoCount);
		if(vdCount!=0) {
			UMReporter.log(Status.PASS, "Video and Embed counts are available for admin user : ("+vdCount+")");
		}
		else {
			UMReporter.log(Status.FAIL, "No video and Embed counts are available for the Admin user");
		}
		UMReporter.log(Status.INFO, "UI Validation completed for Admin user");		

	}	

}
