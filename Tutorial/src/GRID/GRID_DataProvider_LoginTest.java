package GRID;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GRID_DataProvider_LoginTest {
	
	@DataProvider(parallel=true)
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		
		data[0][0]="tutorial";
		data[0][1]="tutorial";
		data[0][2]="chrome";
		
		data[1][0]="tutorial";
		data[1][1]="tutorial";
		data[1][2]="firefox";
		return data;
	}
	
	@Test(dataProvider="getData")
	public void logIn(String useraname,String password,String browser) throws MalformedURLException
	{
	  System.out.println("The browser name is :"+browser);
	  
	  DesiredCapabilities cap=null;
	  WebDriver driver=null;
	  
	  if(browser.equalsIgnoreCase("chrome"))
	  {
		cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
	  }
	  else
	  {
	    cap=DesiredCapabilities.firefox();
	    cap.setBrowserName("firefox");
	    cap.setPlatform(Platform.WINDOWS);
	  }
	 
	  //HUB Server=http://192.168.1.32:4444/wd/hub
	 String base_url="http://192.168.1.32:4444/wd/hub";
	 driver=new RemoteWebDriver(new URL(base_url), cap);
	 
	 driver.get("http://newtours.demoaut.com/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	 driver.findElement(By.name("userName")).sendKeys(useraname);
	 driver.findElement(By.name("password")).sendKeys(password);
	 driver.findElement(By.name("login")).click();
	 driver.quit();
	 
	}
	

}
