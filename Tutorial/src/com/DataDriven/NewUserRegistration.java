package com.DataDriven;



	import org.testng.annotations.Test;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.log4j.Logger;
	import org.apache.log4j.PropertyConfigurator;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.Test;

	public class NewUserRegistration extends BaseTest{
		
		
		@Test(priority=1)
		public void register()
		{    
			//<a href="mercuryregister.php">REGISTER</a>
			WebElement register=driver.findElement(By.linkText("REGISTER"));
			register.click();
			
		}
		
		@Test(priority=2)
		public void userRegistration() throws IOException
		{   
			FileInputStream file= new FileInputStream("C://Users//Dell//Desktop//Tutorial//src//com//ApplicationTestDataFiles//RegistrationTestData.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("sheet1");
			int rowCount=sheet.getLastRowNum();
			System.out.println("The Total no. of rows are:"+rowCount);
			
			for(int i=1;i<=rowCount;i++)
			{ 
				Row row=sheet.getRow(i);
			
			WebElement firstName=driver.findElement(By.name("firstName"));
			firstName.clear();
			firstName.sendKeys(row.getCell(0).getStringCellValue());
			
			WebElement lastName=driver.findElement(By.name("lastName"));
			lastName.clear();
			lastName.sendKeys(row.getCell(1).getStringCellValue());
			
	        // Type Casting
			double d=row.getCell(2).getNumericCellValue();
			long x=(long)d;
			String phoneNumber=Long.toString(x);
			
			WebElement phone=driver.findElement(By.name("phone"));
			phone.clear();
			phone.sendKeys(phoneNumber);
			
			WebElement email=driver.findElement(By.name("userName"));
			email.clear();
			email.sendKeys(row.getCell(3).getStringCellValue());
			
			WebElement address1=driver.findElement(By.name("address1"));
			address1.clear();
			address1.sendKeys(row.getCell(4).getStringCellValue());
			
			WebElement city=driver.findElement(By.name("city"));
			city.clear();
			city.sendKeys(row.getCell(5).getStringCellValue());
			
			WebElement state=driver.findElement(By.name("state"));
			state.clear();
			state.sendKeys(row.getCell(6).getStringCellValue());
			
			double p=row.getCell(7).getNumericCellValue();
			long y=(long)p;
			String postal=Long.toString(y);
			
			WebElement postalCode=driver.findElement(By.name("postalCode"));
			postalCode.clear();
			postalCode.sendKeys(postal);
			
			WebElement country=driver.findElement(By.name("country"));
			country.sendKeys(row.getCell(8).getStringCellValue());
			
			WebElement userName=driver.findElement(By.name("email"));
			userName.clear();
			userName.sendKeys(row.getCell(9).getStringCellValue());
			
			WebElement password=driver.findElement(By.name("password"));
			password.clear();
			password.sendKeys(row.getCell(10).getStringCellValue());
			
			WebElement confirmPassword=driver.findElement(By.name("confirmPassword"));
			confirmPassword.clear();
			confirmPassword.sendKeys(row.getCell(11).getStringCellValue());
			
			WebElement register=driver.findElement(By.name("register"));
			register.click();
			System.out.println("registration Successfull");
			
			String expected_Username=row.getCell(9).getStringCellValue();
			System.out.println("The expected userName is :"+expected_Username);
			
			//<b> Note: Your user name is shubh.</b>
			String actual_RegisteredUsername=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
			System.out.println("The actual Registered userName is :"+actual_RegisteredUsername);
			
			if(actual_RegisteredUsername.contains(expected_Username))
			{
				System.out.println("Registration Sucessfull-PASS");
				row.createCell(12).setCellValue("Registration Sucessfull-PASS");
			}
			else
			{   
				System.out.println("Registration Unucessfull-FAIL");
				row.getCell(12).setCellValue("Registration Unucessfull-FAIL");
			}
			
			FileOutputStream file1=new FileOutputStream("C://Users//Dell//Desktop//Tutorial//Tutorial//src//com//TestDataResults//NewTours_NewRegistrationTestResults.xlsx");
			workbook.write(file1);
			
			driver.navigate().back();
			
			
			}
		}
	}

	

