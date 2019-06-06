package com.turner.cnn.utilities;

import java.io.IOException;

import com.aventstack.extentreports.Status;
import com.turner.base.utilities.support.ConfigProp;
import com.turner.base.utilities.support.ConfigProvider;
import com.turner.base.utilities.support.UMReporter;


public class CommonFunctions {
	
	/**
	 * This function will choose the Environment url based on environment specified in the Scenario sheet
	 * @return URL of the specified environment - String
	 * @throws IOException
	 */
		
	public static String chooseEnvironment() throws IOException {
		String url = null;
		String desiredEnvironment = ConfigProvider.getConfig("Environment").toUpperCase();
		if(desiredEnvironment.contains("QA")) {
			   url=ConfigProp.getPropertyValue("CNN_QA");
				UMReporter.log(Status.INFO, "QA Environment has been selected");
		}
		return url;
	}	
		
}
