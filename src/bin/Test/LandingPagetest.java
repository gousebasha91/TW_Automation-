package bin.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.PauseAction;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import bin.Pages.LandingPage;

import bin.Utility.BrowserConfig;
import bin.Utility.Utility;

@Listeners(GenerateReport.class)
public class LandingPagetest {
	
	
	LandingPage page = new LandingPage();
	Utility utility = new Utility();
	
  @Test(description = "Verifying Landing Page Header")
  public void test01() {
	  
	  
	  page.VerifyPageHeader();
  }
  
  @Test(description = "Verifying DropDowns In Landing Page")
  public void test02() {
	  
	  page.HomePageDropDowns();
  }
  
  @Test(description = "Verifying Course Types")
  public void test03() {
	  
	  page.VerifyLearningNeeds();
  }
  
  @Test(description = "Validating Landing Page")
  public void test04() {
	  
	  page.VerifyPgae();
  }
  
  
  @Test(description = "Capturing All The Links In Landing Page")
  public void test05() {
	  
	  utility.Printlinks();
  }
  @Test(description = "Validating Broken Links ")
  public void test06() {
	  
	  utility.ValidateBrokenlinks();
  }
  
  @BeforeMethod(description = "Verifying Both Launched Page Titles & Page URL")
  public void beforemethod() {
	  
	  utility.VerifyPageTitle();
	  utility.VerifyPageURL();
	  Utility.takescreesnshot("Home Page");
	  
  }
  
  @BeforeTest
  public void StartBrowser(/*String browser*/) {
				
	  BrowserConfig.StartBrowser("chrome");
	}
	

  
		  
	
 }

