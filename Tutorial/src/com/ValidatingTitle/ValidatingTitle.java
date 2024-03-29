package com.ValidatingTitle;

import org.openqa.selenium.chrome.ChromeDriver;

public class ValidatingTitle {

	public static void main(String[] args) {
        String google_url="http://google.com";
		
		System.setProperty("webdriver.chrome.driver", "C://Users//Dell//Desktop//Tutorial//Driver Files//chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.get(google_url);
        
        String actual_GoogleHomepageTitle=driver.getTitle();
        System.out.println("The Actual Title of Google Homepage is :"+actual_GoogleHomepageTitle);
        
        String expected_GoogleHomepageTitle="google";
        System.out.println("The Expected Title of Google Homepage is :"+expected_GoogleHomepageTitle);
        
        if(actual_GoogleHomepageTitle.equalsIgnoreCase(expected_GoogleHomepageTitle))
        {
        	System.out.println("Title Matched - PASS");
        }
        else
        {
        	System.out.println("Title Not Matched - FAIL");
        }
	}

}
