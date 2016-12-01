package bin.Test;

import org.testng.annotations.Test;
<<<<<<< HEAD
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
<<<<<<< HEAD

=======
>>>>>>> tw_regression
=======

>>>>>>> tw_regression
import bin.Pages.Homepage_1;
import bin.Pages.InstitutePage;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class InstituteTest extends Homepage_1 {
<<<<<<< HEAD
	private Actions action;
	
=======
>>>>>>> tw_regression
	
	private Actions action;
	/*private WebDriverWait wait;*/
	
	public void HandleAlerts() {
		
		try {
			
			Alert alert=driver.switchTo().alert();
			alert.sendKeys("Hi");
			System.out.println("POPUP."+alert.getText());
		} catch (NoAlertPresentException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	

  @Test
  public void test04() {
	  
	  InstitutePage institutepage = new InstitutePage();
	  Pause(1000);
	  institutepage.VerifyPageBanner();
  }
  
  @Test
  public void test05() {
	  
	  InstitutePage institutepage = new InstitutePage();
	  Pause(1000);
	  institutepage.VerifyInstituteTab();
  }
<<<<<<< HEAD
  
 /* @Test
  public void test06() {
	  InstitutePage institutepage = new InstitutePage();
	  Pause(1000);
	  institutepage.VerifyPageFooter();
	  
  }*/
  /*
  @Test
  public void test06() {
	  
	  InstitutePage institutepage = new InstitutePage();
	  Pause(1000);
	  institutepage.RatingFilter();
  }
  */
=======
 
>>>>>>> tw_regression
  @Test
  public void test07() {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  InstitutePage institutepage = new InstitutePage();
	  Pause(1000);
	  institutepage.SelectInstitute();
	  CaptureScreenShot("Institutes Page");
	  Homepage_1 Homepage = new Homepage_1();
	  WebElement Image = driver.findElement(By.xpath(".//*[@id='container-fluid']/div[4]/div/div[1]/img"));
	  Homepage.VerifyImage(Image); 
  }
  
  @Test
  public void test08() {
<<<<<<< HEAD
	  action=new Actions(driver);
	 
	 /* WebElement Courseslist=driver.findElement(By.xpath(".//*[@id='filtered-loading']"));
	  if(Courseslist.isDisplayed()) {
=======
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  Pause(1000);
	  driver.manage().window().maximize();
	  action=new Actions(driver);
	  WebElement Courseslist=driver.findElement(By.xpath(".//*[@id='filtered-loading']"));
>>>>>>> tw_regression
	  ((JavascriptExecutor) driver).executeScript(
			                   	"arguments[0].scrollIntoView();", Courseslist);
	  Pause(1000);
	  System.out.println(Courseslist.getText());
<<<<<<< HEAD
	  } else {
		  System.err.println("No Courses");
	  }*/
	  WebElement ContactInstitutebtn = driver.findElement(By.cssSelector("button.hover.button-style"));
	  action.moveToElement(ContactInstitutebtn);
	/*  ((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();", ContactInstitutebtn);*/
	  boolean btnPresence = ContactInstitutebtn.isDisplayed();
	  boolean btnEnabled = ContactInstitutebtn.isEnabled();
	  if(btnPresence==true &&  btnEnabled==true) {
		  System.out.println("Button IS Present."+ContactInstitutebtn.getText());
		  ContactInstitutebtn.click();
		  Pause(1000);
		  selenium.type("notification_body", "Gouse Basha");
		  selenium.click("link=Submit");
	  }
	  else {
		  System.out.println("Contact Institute Button Not Present.");
	  }	 
=======
	  action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 WebElement ContactInstitute = driver.findElement(By.xpath(".//*[@id='container-fluid']/div[4]/div/div[1]/button"));
	 action.moveToElement(ContactInstitute).click().build().perform();
	 Pause(1000);
	 driver.findElement(By.id("notification_body")).sendKeys("Goutham");
	 driver.findElement(By.linkText("Submit")).click();
	 
>>>>>>> tw_regression
  }

<<<<<<< HEAD
 /* @BeforeMethod
  public void beforeMethod() {
  	Homepage_1 Homepage = new Homepage_1();
  	Homepage.ValidateBrokenlinks();
  }
  */
=======
>>>>>>> tw_regression
  @BeforeTest
  public void StartBrowser() {
   Homepage_1 Homepage = new Homepage_1(); 
   Homepage.intDriver("chrome");
   CaptureScreenShot("Home Page");
   Homepage.ClickOnlinks("INSTITUTES");
   CaptureScreenShot("Institutes Page");
  		
  }

  @AfterTest
  public void tearDown() {
  	if(driver!=null) {
  		
  	}
  }

}
