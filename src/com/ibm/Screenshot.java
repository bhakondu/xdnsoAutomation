package com.ibm;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	
	public static void CapturexDNSOScreenshot(WebDriver driver, String screenshotName)
	{
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File source= ts.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(source, new File("C:/Selenium/xDNSO/xDNSOtestscreenshots"+ screenshotName + ".png"));
		 	System.out.println("Screenshot captured");
		   } 
		
		catch (Exception e) 
		 {
			System.out.println("Exception while taking screenshot "+e.getMessage());
		 } 
}

}
