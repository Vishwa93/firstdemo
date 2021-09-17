package com.picnic;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleSelenium 
{
	
	ExtentSparkReporter reporter;
	ExtentReports extent;
	
	@BeforeSuite
	public void setUp() {
	reporter = new ExtentSparkReporter("myreport.html");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	}
	@Test
	public void TestMethod()
	{
	
		ExtentTest test = extent.createTest("My first test");
		test.log(Status.INFO, "This shows info");

 //System.setProperty("webdriver.gecko.driver","C:\\Users\\vishwab\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
    WebDriverManager.chromedriver().setup();
     
	WebDriver driver = new ChromeDriver();
driver.get("https://www.google.com");
driver.manage().window().maximize();
String title = driver.getTitle();
System.out.println(title);
//driver.findElement(By.xpath(title="//input[@name=\"q\"]").sendKeys("Maveric"))
WebElement searchBox = driver.findElement(By.name("q"));
searchBox.sendKeys("Maveric");
searchBox.submit();
//searchBox.click();
//Thread.sleep(5000);
driver.quit();
}
	@Test
	public void TestMethod2()
	{
	
		ExtentTest test = extent.createTest("My Second test");
		test.log(Status.INFO, "This shows info");

 //System.setProperty("webdriver.gecko.driver","C:\\Users\\vishwab\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
    WebDriverManager.chromedriver().setup();
     
	WebDriver driver = new ChromeDriver();
driver.get("https://www.google.com");
driver.manage().window().maximize();
String title = driver.getTitle();
System.out.println(title);
//driver.findElement(By.xpath(title="//input[@name=\"q\"]").sendKeys("Maveric"))
WebElement searchBox = driver.findElement(By.name("q"));
searchBox.sendKeys("Maveric");
searchBox.submit();
//searchBox.click();
//Thread.sleep(5000);
driver.quit();
}
	@AfterSuite
	public void tearDown() {
	extent.flush();
	}
}


