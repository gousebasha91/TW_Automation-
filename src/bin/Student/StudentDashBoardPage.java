package bin.Student;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Up;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;


import bin.Pages.TutorsPage;
import bin.Utility.BrowserConfig;
import bin.Utility.Utility;

public class StudentDashBoardPage extends Utility {
	
/*	
	*/
	private WebDriverWait wait;
	private static Actions action;
	private Screen s;
	private String SikuliPath = "D:\\share\\Automation\\TutorsWeb\\SikuliImages.sikuli\\";
	//DefaultSelenium selenium = new defaul
	
	Utility utility = new Utility();
	 
	
	public void VerifyStudentProfile() {		
				
		WebElement StudentProfile = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[7]/div/button"));
		
		if(StudentProfile.isDisplayed())
		{
			System.out.println("Student LoggedIn Sucessfuly");
			System.out.println("Student Profile  Is Displayed: "+StudentProfile.getText());
			StudentProfile.click();
			WebElement ProfileMenu = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[7]/div/ul"));
			System.out.println("Student Profile SubMenu Options Are . "+ProfileMenu.getText());
		} else {
			System.out.println("Element Not Found");
		}
		
	}
	
	public void VerifyStudentDashBoard() {
		//action = new Actions(driver);
		s = new Screen();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		 WebElement DashBoard = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[1]/a/span[2]"));
		
		 WebElement EnrollCourse = driver.findElement(By.linkText("Enroll for a Course"));
		 WebElement Notifications = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[2]/a/span"));
		 WebElement MyClassRoom = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[3]/a/span"));
		 WebElement MyCertificates = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[4]/a/span"));
		 WebElement UpComingSessions = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[5]/a/span"));
		 WebElement MyQA = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[6]/a"));
		 WebElement InviteAFriend = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[7]/a"));
		 WebElement MyWishlist = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[8]/a"));
		 WebElement AccountSettings = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/div/a[1]/i"));
		 WebElement Logout = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/div/a[2]/span"));
		 WebElement DashBoardText = driver.findElement(By.xpath(".//*[@id='contents']/div[1]/div/div[1]/div/h1"));
		 WebElement ChromeText = driver.findElement(By.xpath(".//*[@id='contents']/div[1]/div/div[2]/div/div/div"));
		 WebElement Chromelink = driver.findElement(By.xpath(".//*[@id='contents']/div[1]/div/div[2]/div/h4"));
		 
		 if(DashBoard.isDisplayed() && DashBoard.isEnabled()) {
			 
			 System.out.println("DashBoard Option is Present. "+DashBoard.getText());
			 takescreesnshot("Student Dashboard");
			 utility.VerifyPageTitle();
			 utility.VerifyPageURL();
			 Pause(5000);
		 } else 
		 {
			 System.out.println("DashBoard Option Is Not Present");
		 }
			
		if(Notifications.isDisplayed() && Notifications.isEnabled()) {
			 
			 System.out.println("Notifications Option IS Present. "+Notifications.getText());
			Notifications.click();
			utility.VerifyPageTitle();
			 utility.VerifyPageURL();
			 takescreesnshot("Notifications");
			 
			Pause(5000);
			
		 } else {
			 System.out.println("Notifications Option Not Avalilable");
		 }
		 
		  
		 try {
			
			s.click(SikuliPath+"1471867541699.png"); 
			 utility.VerifyPageTitle();
			 utility.VerifyPageURL();// My Class Room
			 takescreesnshot("Student My ClassRoom");
				Pause(5000);	
			s.click(SikuliPath+"1471867551795.png");  //My Certificates
			utility.VerifyPageTitle();
			 utility.VerifyPageURL();
			 takescreesnshot("My Certificates");
				Pause(5000);
			s.click(SikuliPath+"1471947372080.png"); //Upcoming Sessions 
			utility.VerifyPageTitle();
			 utility.VerifyPageURL();
			 takescreesnshot("Upcoming Sessions");
				Pause(5000);
			s.click(SikuliPath+"1471947385344.png"); // My Q&A
			utility.VerifyPageTitle();
			 utility.VerifyPageURL();
			 takescreesnshot("My Q&A");
				Pause(5000);
			s.click(SikuliPath+"1471947408624.png"); // Invite A Friend
			utility.VerifyPageTitle();
			 utility.VerifyPageURL();
			takescreesnshot("Invite A Friend");
				Pause(5000);
			s.click(SikuliPath+"1471949350665.png"); // My WishListed
			utility.VerifyPageTitle();
			 utility.VerifyPageURL();
			 takescreesnshot("My Wish Listed");
			
		} catch (FindFailed e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static void Click(WebElement Element1, String Locator1) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Element1 = driver.findElement(By.xpath(Locator1));
		if(Element1.isDisplayed()&& Element1.isEnabled()) {
			System.out.println("Element Is Present: "+Element1.getText());
			Element1.click();
			Pause(1000);
				
			} else {
				System.out.println("Element1 Is Not Present");
			}
		
	}
	
	public void HireTutor() {
		
		//action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement DashBoard = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[1]/a/span[2]"));
		Click(DashBoard,".//*[@id='sidebar']/div/div[2]/div/ul/li[1]/a/span[2]");
	
		WebElement HireNow = driver.findElement(By.linkText("Hire a Tutor"));
		if(HireNow.isDisplayed()) {
			System.out.println("Hire A Tutor Option IS Present.: "+HireNow.getText());
			HireNow.click();
			
		} else {
				System.out.println("Hire A Tutor Option Not Avalibale");
			}
	}
	
	public void ASkQuestion() {
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement DashBoard = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[1]/a/span[2]"));
		Click(DashBoard,".//*[@id='sidebar']/div/div[2]/div/ul/li[1]/a/span[2]");
		WebElement Question = driver.findElement(By.linkText("Ask a Question?"));
		if(Question.isDisplayed() && Question.isEnabled()) {
			System.out.println("Ask Questions Link Is Visible: "+Question.getText());
			Question.click();
			
		} else {
			System.err.println("Ask Questions Link Is Not Visible");
		}
		
	}
	
	public void SelectTutor() {
		 
		 //selenium.setSpeed("3000");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 WebElement Tutor=driver.findElement(By.xpath(".//*[@id='tutors_review']/div[2]/div/a/div[5]/p"));
		 action=new Actions(driver);
		 action.moveToElement(Tutor).build().perform();
		 //Pause(3000);
		Tutor.click();  
		
		WebElement HireNow_btn = driver.findElement(By.cssSelector("#hire-btn"));
		if(HireNow_btn.isDisplayed()) {
		System.out.println("Hire Now Button IS Present.: "+HireNow_btn);
		String Fontcolor=HireNow_btn.getCssValue("color");
		System.out.println("Color Before Mouse Hover:"+Fontcolor);
		action.moveToElement(HireNow_btn).build().perform();
		System.out.println("Aftere Mouse Hover:"+Fontcolor);
		HireNow_btn.click(); 		
		}  else {
			 		System.out.println("Hire Now Button Is Not Present.");
			 	} 
		}
	
	public  static void ClickOnEnrollCourse() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement DashBoard = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[1]/a/span[2]"));
			Click(DashBoard,".//*[@id='sidebar']/div/div[2]/div/ul/li[1]/a/span[2]");
		
			WebElement EnrollCourse = driver.findElement(By.linkText("Enroll for a Course"));
			if(EnrollCourse.isDisplayed()) {
			
			System.out.println("Enroll Course Link Is Present: "+EnrollCourse.getText());
			Reporter.log("Enroll Course Link Is Present: "+EnrollCourse.getText());
			EnrollCourse.click();
			} else {
			System.out.println("Link Text Is Not Present");
			}
			
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	public static void SelectCourse() {
		
		try
		{
			
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement Course = driver.findElement(By.cssSelector(".overlay-content>h2"));
			action = new Actions(driver);
			action.moveToElement(Course).build().perform();
			System.out.println("Courses Are Avaliable:"+Course.getText());
			Course.click();  
			//System.out.println("Courses Are Not Present In Given Time");
					
	} catch (NullPointerException ex) {
		System.out.println(ex.getMessage());
	
	
	}
 }
	
	
	 public void EnrollCourse_AddtoCart(String ButtonType) {
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 WebElement Button=driver.findElement(By.partialLinkText(ButtonType));
		 
		 if(ButtonType.equalsIgnoreCase("Enroll Now"))
		 {
			 System.out.println("Enroll Now Button Was Clicked: "+Button.getText());
			 Button.click();
			 Pause(2000);
			 String SucessText=driver.findElement(By.xpath("..//*[@id='flash']/div")).getText(); 
			 System.out.println("AcknowledgeMent Text Is :"+SucessText);
		 } else if(ButtonType.equalsIgnoreCase("add to cart")) 
		 {
			 System.out.println("Enroll Now Button Was Clicked: "+Button.getText());
			 Button.click();
			 Pause(2000);
			 try {
				 
				 String SucessText=driver.findElement(By.xpath(".//*[@id='flash']/div")).getText();
				// Assert.assertEquals(actual, expected);
				 System.out.println("AcknowledgeMent Text Is :"+SucessText);
				 
			 } catch (ElementNotFoundException e) {
				 System.out.println(e.getMessage());
			 }
			 
			 
		 }
		
	 }
	 
	 public void CheckOut() {
		 
		 try 
		 {
			 
		 Pause(3000); 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 WebElement Shoppingcart=driver.findElement(By.xpath(".//*[@id='navigation']/li/a/i"));
		 WebElement ProccedToCheckOut=driver.findElement(By.xpath(".//*[@id='navigation']/li/ul/li[2]/a"));
		 action = new Actions(driver);
		 action.moveToElement(Shoppingcart).
		 					moveToElement(ProccedToCheckOut).build().perform();
		 
		if(Shoppingcart.isDisplayed() && Shoppingcart.isEnabled()) {
			System.out.println(Shoppingcart.getText());
			ProccedToCheckOut.click();
			Reporter.log("Procced To CheckOut Button Clicked");
	 } else {
		 System.out.println("Shoping Cart Icon Not Visible");
	 }
		 } catch (NullPointerException ex) {
			 System.out.println(ex.getMessage());
		 }
		 
	 }
	 
	 
	 public void Signout() {
		 
		 
		 
		 
	 }
}



