package bin.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.explodingpixels.data.Rating;

import bin.Utility.Utility;

public class TutorSchedulePage extends Utility {
	
	
	private Actions action;
	
	public void VerifySchedulePage() {
		
		 WebElement ScheduleToolBar = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/ol"));
		 WebElement TutorImage = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div/div[1]/div/div[1]/div[1]/img"));
		 //sssWebElement VerificationStatus = driver.findElement(By.cssSelector(".text-danger"));
		 WebElement Rating_Reviews = driver.findElement(By.cssSelector(".rating-stars"));
		 WebElement LastLogin = driver.findElement(By.cssSelector(".p-t.m-t.b-b-n"));
		 WebElement TeachingHours = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div/div[1]/div/div[1]/div[2]/div/div[1]/div/div/h2"));
		 WebElement Charge = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div/div[1]/div/div[1]/div[2]/div/div[2]/div/div/h2"));
		 WebElement MyAvaliablity = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div/div[1]/div/div[2]"));
		 WebElement ScheduleTite = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div/div[2]/div/div/h2"));
		 WebElement SchduleLayout = driver.findElement(By.xpath(".//*[@id='contents']/div[2]/div/div[2]/div/div"));
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(ScheduleToolBar .isDisplayed()) {
			System.out.println("Schedule Tool Bar Is Visible: "+ScheduleToolBar.getText());
			Reporter.log("Schedule Tool Bar Is Visible: "+ScheduleToolBar.getText());
			
		} else {
			System.out.println("Schedule Tool Bar Is Not Visible.");
			Reporter.log("Schedule Tool Bar Is Not Visible.");
		} if(TutorImage.isDisplayed()) {
			System.out.println("Tutors Profile Pic Is Present: "+TutorImage.getAttribute("alt"));
			Reporter.log("Tutors Profile Pic Is Present: "+TutorImage.getAttribute("alt"));
		} else {
			System.out.println("Tutors Profile Pic Not Avalialble");
			Reporter.log("Tutors Profile Pic Not Avalialble");
		}
		if(Rating_Reviews.isDisplayed()) {
			Reporter.log("Rating & Reviews are Present: "+Rating_Reviews.getText());
			System.out.println("Rating & Reviews are Present: "+Rating_Reviews.getText());
		} else {
			Reporter.log("rating & reviews are not visible.");
			System.out.println("rating & reviews are not displayed");
		}
	}
	
	public void ScheduleTutor() {
		action = new Actions(driver);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.id("datepicker")).click();
		 Pause(1000);
		 driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]")).click();
		 driver.findElement(By.linkText("29")).click();
		 driver.findElement(By.xpath("//textarea")).sendKeys("Hi");
		 
		
			
			Utility utility = new Utility();
			WebElement SessionsDropDown = driver.findElement(By.id("selected_sessions"));
			utility.VerifyDropDowns(SessionsDropDown, "selected_sessions", "3");
				Pause(1500);
			WebElement TimeSlotDropDown = driver.findElement(By.id("session_start_time"));
			utility.VerifyDropDowns(TimeSlotDropDown, "session_start_time", "9:00 AM IST to 10:00 AM IST");	
			Pause(2000);
			WebElement Checkbtn = driver.findElement(By.id("btn-admission-request"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(true);",Checkbtn);
			//action.moveToElement(Checkbtn).build().perform();
			if(Checkbtn.isDisplayed() && Checkbtn.isEnabled()) {
				System.out.println("CHECK TUTOR AVAILABILITY Button Is Present: "+Checkbtn.getAttribute("value"));
				Checkbtn.click();
				Pause(2000);
				
			} else {
				System.out.println("CHECK TUTOR AVAILABILITY Button Is Not Present:");
			} 
			
			WebElement Payment = driver.findElement(By.xpath(".//*[@id='show_here']/div/div"));
			action.moveToElement(Payment).build().perform();
			System.out.println("Success! Tutor is available for the selected slot: "+Payment.getText());
			WebElement Confirm_Procced_btn = driver.findElement(By.xpath(".//*[@id='show_here']/div/div/div/div[2]/a/button"));
			if(Confirm_Procced_btn .isDisplayed() && Confirm_Procced_btn.isEnabled()) {
				System.out.println("Confirm and procced Button Is Present: "+Confirm_Procced_btn.getText());
				Confirm_Procced_btn.click();
			}
			
	}
	

}
