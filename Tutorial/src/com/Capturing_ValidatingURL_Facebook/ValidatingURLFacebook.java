package com.Capturing_ValidatingURL_Facebook;

import org.openqa.selenium.chrome.ChromeDriver;

public class ValidatingURLFacebook {

	public static void main(String[] args) {
		 String facebook_url="http://facebook.com";
			
			System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//chromedriver.exe");
	        ChromeDriver driver=new ChromeDriver();
	        driver.get(facebook_url);
	        
	        String actual_FacebookHomepageTitle=driver.getTitle();
	        System.out.println("The Actual Title of Facebook Homepage is :"+actual_FacebookHomepageTitle);
	        
	        String expected_FacebookHomepageTitle="Facebook � log in or sign up";
	        System.out.println("The Expected Title of Facebook Homepage is :"+expected_FacebookHomepageTitle);
	        
	        if(actual_FacebookHomepageTitle.equalsIgnoreCase(expected_FacebookHomepageTitle))
	        {
	        	System.out.println("Title Matched - PASS");
	        }
	        else
	        {
	        	System.out.println("Title Not Matched - FAIL");
	        }
	        
	        String actual_FacebookURL=driver.getCurrentUrl();
	        System.out.println("The Actual Title of Facebook Homepage is :"+actual_FacebookHomepageTitle);
	        
	        String expected_FacebookURL="facebook.com";
	        System.out.println("The Expected Title of Facebook Homepage is :"+expected_FacebookURL);
	        
	        if(actual_FacebookHomepageTitle.equalsIgnoreCase(expected_FacebookHomepageTitle))
	        {
	        	System.out.println("URL Matched - PASS");
	        }
	        else
	        {
	        	System.out.println("URL Not Matched - FAIL");
	        }
	        

	}

}
