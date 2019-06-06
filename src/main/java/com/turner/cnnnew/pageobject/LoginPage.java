package com.turner.cnnnew.pageobject;

import java.io.IOException;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;
import com.turner.base.utilities.support.ConfigProp;
import com.turner.base.utilities.support.UMReporter;
import com.turner.base.utilities.support.WrapperMethods;
import com.turner.cnn.utilities.CommonFunctions;

public class LoginPage {
	
	private static By userName = By.id("username");
	private static By password = By.id("password");
	private static By submitButton = By.xpath("//button[@type='submit']");
	private static By videoElementHomePage=By.xpath("//span[text()='Content Type']//following::li/label/span[text()='Video']");
	private static By selOption = By.xpath("//div[text()='I WANT TO']");
	private static By contOpt = By.xpath(("//*[contains(text(),'Contribute Stories')]"));
	private static By sendWireStoryLink = By.xpath("//a[text()='Send Wire Story']");
	
	/**
	 * This Function is used to navigate to any desired page
	 * @param pageName - Page link to be navigated
	 * @throws IOException
	 */
	
	public static void navigateToPage(String pageName) throws IOException {
		String url = CommonFunctions.chooseEnvironment()+pageName;
		WrapperMethods.goTo(url);
		UMReporter.log(Status.INFO, "Navigated to the URL -- "+url);
	}
	
	/**
	 * Login to the Application with the Given credentials
	 * @param user - UserName to Login 
	 * @param password - Password to Login
	 * @throws IOException
	 */		
	public static void login(String user, String password) throws IOException {
		WrapperMethods.sendkeys(userName, user, "UserName has been entered", "Unable to enter userName");
		WrapperMethods.sendkeys(LoginPage.password, password, "Entered Password", "Unable to enter Password");
		WrapperMethods.click(submitButton);
		WrapperMethods.waitForElement(videoElementHomePage, 30, "Logged in successfully as '"+user+"' user", "Home page not visible after Login");
		WrapperMethods.click(selOption);
		WrapperMethods.waitForElement(contOpt, 30, "Successfully clicked on I Want to ", "Unable to find I want to label");
		WrapperMethods.click(contOpt);
		UMReporter.log(Status.PASS, "Succesfully clicked on Contribute Stories");
		WrapperMethods.waitForElement(sendWireStoryLink, 30, "Successfully clicked on Send Wire Story Link ", "Unable to find Send Wire Storey Link");
		WrapperMethods.click(sendWireStoryLink);
		
	}
	
	/**
	 * Login as user who has access only to wire article
	 * @throws IOException
	 */
	public static void articleUserlogin() throws IOException {
		login(ConfigProp.getPropertyValue("User_Article"),ConfigProp.getPropertyValue("Password_Admin"));
	}
	
	/**
	 * Login as user who has access only to Download option
	 * @throws IOException
	 */



}
