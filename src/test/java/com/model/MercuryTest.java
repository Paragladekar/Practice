package com.model;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MercuryTest 
{
	public WebDriver driver;
	
  @Test(priority=1,description="user1 has login successfully")
  public void loginwithvalidds()
  {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Paragladekar12");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Parag@123");
	  driver.findElement(By.xpath("//a[@href='mercurysignoff.php']")).click();
  }
  
  @Test(priority=2,description="User2 has login successfully")
  public void loginwithvalid()
  {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("krishna7577");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("krishn@");
	  driver.findElement(By.xpath("//a[@href='mercurysignoff.php']")).click();
  }
	  
  
  @BeforeMethod
  public void getCookie()
  {
	  Set<Cookie> cookie=driver.manage().getCookies();
	  for(Cookie cookies:cookie)
	  {
		  System.out.println(cookies.getName());
		  System.out.println("Cookies has get successfully");
	  }
	  
  }

  @AfterMethod
  public void ScreenShot() throws IOException
  {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src , new File("P:\\selenium_testing\\Mercury_Ts_Demo\\src\\test\\resources\\MavenScreenshot\\"));
  }

  @BeforeClass
  public void MaximazieBrowser() 
  
  {
	  driver.manage().window().maximize();
	  System.out.println("Webpage has maximize successfully");
  }

  @AfterClass
  public void deleteAllcookies()
  {
	  driver.manage().deleteAllCookies();
  }

  @BeforeTest
  public void ApplicationUrl()
  {
	  driver.get("http://newtours.demoaut.com/");
	  System.out.println("Application has open successfully");
  }

  @AfterTest
  public void dbCoonectionClosed()
  {
	  System.out.println("db coonection has closed successfully");
  }
  
  @BeforeSuite
  public void opneBrowser()
  {
	  System.setProperty("webdriver.chrome.driver", "E:\\Automation\\29062019\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  System.out.println("browser has open successfully");
  }

  @AfterSuite
  public void close()
  {
	  driver.close();
  }
  }


