package testcases;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest {
//	WebDriver driver;
	 HtmlUnitDriver driver;
  
  @BeforeTest
  public void beforeTest() {

//	  WebDriverManager.firefoxdriver().setup();
//	  driver = new FirefoxDriver();
	  driver = new HtmlUnitDriver();
	  driver.get("http://localhost:9090/PetStoreWebApp");
	  
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  }
                      
  @Test
  public void test01_titleTest() {
	  String pageTitle = driver.getTitle();
	  System.out.println("Title of this page is .........." +pageTitle);
	  Assert.assertEquals(pageTitle, "Pet Store");
	 
  }
//  @Test
  public void test02_contentTest() {
	  WebElement typeDropdown = driver.findElement(By.name("Type"));
	  Select petType = new Select(typeDropdown);
	  petType.selectByVisibleText("CAT");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
  }

  @AfterTest
  public void afterTest() {
//	  driver.close();
  }

}
