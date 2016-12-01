package bin.Pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import bin.Utility.BrowserConfig;
import bin.Utility.Utility;

public class LandingPage extends Utility{
	
	private static  Actions action;
	
	
	public void VerifyPageHeader() {
		
		try {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Locators.LandingPage.Logo_img(driver);
				System.out.println("Logo Is Prsenet." +Locators.LandingPage.Logo_img(driver).getAttribute("src"));
				System.out.println("Logo Size: "
							+Locators.LandingPage.Logo_img(driver).getSize().getHeight()
							+Locators.LandingPage.Logo_img(driver).getSize().getWidth());
				Reporter.log("Logo Is Present :"+Locators.LandingPage.Logo_img(driver).getAttribute("src"));
		
				Locators.LandingPage.Tutors_lnk(driver);
				Reporter.log("Tutors Button Is Present."
							+Locators.LandingPage.Tutors_lnk(driver).getText());
				Locators.LandingPage.Courses_lnk(driver);
				Reporter.log("Courses Button Is Present."
							+Locators.LandingPage.Courses_lnk(driver).getText());
				Locators.LandingPage.Institute_lnk(driver);
				Reporter.log("Institute Button IS Present. "
					+Locators.LandingPage.Institute_lnk(driver).getText());
				Locators.LandingPage.Questions_lnk(driver);
				Reporter.log("Questions Button Is Present. "+
				Locators.LandingPage.Questions_lnk(driver).getText());
				Locators.LandingPage.Howitworks_lnk(driver);
				Reporter.log("How It Works Button Is Present. " +Locators.LandingPage.Howitworks_lnk(driver).getText());
				Locators.LandingPage.SignIn_btn(driver);
				Reporter.log("SignIn Button Is Present."+ Locators.LandingPage.SignIn_btn(driver).getText());
				Locators.LandingPage.Signup_btn(driver);		
				Reporter.log("SignUp Button IS Dispalyed: "
					+Locators.LandingPage.Signup_btn(driver).getText());
				Locators.LandingPage.Shopping_Cart(driver);
				Reporter.log("Shopping Cart Is Displayed. "+Locators.LandingPage.Shopping_Cart(driver).getText().trim());
				
		} catch (NullPointerException e) {
			System.out.println("Null Poniter Exception: "+e.getStackTrace());
		}
	}
	
	public void HomePageDropDowns() {
		
		Utility.VerifyDropDowns(Locators.LandingPage.DROPDOWN(driver), "ddlsearch", "institutes");
		Locators.LandingPage.SearchBox(driver);
		Reporter.log("Search Box IS Present. "+Locators.LandingPage.SearchBox(driver).getAttribute("name"));
		Locators.LandingPage.SearchBox(driver).sendKeys("SOFTWARE DEVELOPMENT INSTITUTE");
			
	}		
	
	public void VerifyLearningNeeds() {
		
		try {
			action=new Actions(driver);
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", Locators.LandingPage.TypeOfCoursesText(driver));
		
			Reporter.log("FOR ALL YOUR LEARNING NEEDS Text: "
						+Locators.LandingPage.TypeOfCoursesText(driver).getText());	
			Locators.LandingPage.OneTOne(driver);
			Reporter.log(" 1-1 TUTORING SESSIONS: "
						+Locators.LandingPage.OneTOne(driver).getText());
			Locators.LandingPage.Instled(driver);
			Reporter.log("Instructor LED Live Courses Link Text IS Present. "
						+Locators.LandingPage.Instled(driver).getText());
			Locators.LandingPage.SelfCourse(driver);
			Reporter.log("Self Learning Courses Link is Present: "
					+Locators.LandingPage.SelfCourse(driver).getText());
		action.moveToElement(Locators.LandingPage.GetStartedbtn(driver)).build().perform();
		Reporter.log("Get Started Button Is present: "
					+Locators.LandingPage.GetStartedbtn(driver).getText());	
		Locators.LandingPage.GetStartedbtn(driver).click();
		
		driver.navigate().back();
		
	  } catch (NullPointerException e ) {
		  System.out.println(e.getStackTrace());
	  }
				
	}
	
	public void HomePageVideo() {
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", Locators.LandingPage.Video(driver));
		action.moveToElement(Locators.LandingPage.Video(driver)).build().perform();
		Locators.LandingPage.Video(driver);
		Reporter.log("Video Is Present On The Home Page. "
						+Locators.LandingPage.Video(driver).getAttribute("class"));
		action.moveToElement(Locators.LandingPage.VideoText(driver)).build().perform();
		Locators.LandingPage.VideoText(driver);
		Reporter.log("Video Text IS Visible."+Locators.LandingPage.VideoText(driver).getText());
			
	}
	
	public void VerifyPgae() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", Locators.LandingPage.MostPopularCourses(driver));
		Utility.Pause(2000);
		Locators.LandingPage.MostPopularCourses(driver);
		Reporter.log("Most Popular Courses Are Present :"
							+Locators.LandingPage.MostPopularCourses(driver).getText());
		jse.executeScript("arguments[0].scrollIntoView();", Locators.LandingPage.MostPopularTutors(driver));
		Utility.Pause(2000);
		Locators.LandingPage.MostPopularTutors(driver);
		Reporter.log("Most Popular Tutors Are Present :"
					       +Locators.LandingPage.MostPopularTutors(driver).getText());
		Utility.takescreesnshot("Most Popular Tutors");
		Utility.Pause(2000);
		jse.executeScript("arguments[0].scrollIntoView();", Locators.LandingPage.INNumbers(driver));
		Locators.LandingPage.INNumbers(driver);
		Reporter.log("IN Nmubers Layout Present :" + Locators.LandingPage.INNumbers(driver).getText());
		Utility.takescreesnshot("IN Numbers");
		jse.executeScript("arguments[0].scrollIntoView();",  Locators.LandingPage.HomePageFooter(driver));
		Utility.Pause(1000);
		Locators.LandingPage.HomePageFooter(driver);
		System.out.println("Footer Tab Is Present.");
		Reporter.log("HomePage Footer Elements Are: "
					+Locators.LandingPage.HomePageFooter(driver).getText());
		Utility.takescreesnshot("Home Page Footer");
			
			
	}
	
	 	
}	




