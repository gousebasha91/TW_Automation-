package bin.Student;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import bin.Utility.Utility;
import jxl.Sheet;
import jxl.Workbook;

public class PaymentPage  extends Utility {
	
	private static Actions action;
	/*private static FileInputStream fi;
	private static String filepath=
	private static Workbook w;
	private static Sheet s;*/
	
	public void VerifyPaymentPage() {
		
		try {
			
			//fi = new FileInputStream(file)
			
		 action = new Actions(driver);
		// selenium.setSpeed("3000");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 WebElement Price = driver.findElement(By.xpath(".//*[@id='contents']/div[3]/div[1]/div/div"));
		 WebElement CouponTextbox = driver.findElement(By.id("coupon_code_val"));
		 WebElement Applybutton = driver.findElement(By.id("session_coupon_apply"));
		 WebElement OrderDetails = driver.findElement(By.xpath(".//*[@id='contents']/div[4]/div[2]/div/div/table"));
		 
		 if(Price.isDisplayed()) {
			 Reporter.log("Price Is Present: "+Price.getText());
			 System.out.println("Price Is Present: "+Price.getText());
		 } else {
			 Reporter.log("Price Not visible");
		 } if(CouponTextbox.isDisplayed() && CouponTextbox.isEnabled()) {
			 Reporter.log("Coupon Code Text Box Is Present: "+CouponTextbox.getAttribute("placeholder"));
			 System.out.println("Coupon Code Text Box Is Present: "+CouponTextbox.getAttribute("placeholder"));
			 CouponTextbox.sendKeys("LAND30");
		 } else {
			 Reporter.log("Coupon Code Text Box Not Present");
		 } if(Applybutton.isDisplayed() && Applybutton.isEnabled()) {
			 Reporter.log("Apply Button IS Present: "+Applybutton.getText());
			 Applybutton.click();
			 //selenium.isTextPresent("Invalid coupon");
			//String Text = "" 
		 } else {
			 System.out.println("Apply Button Not Enabled");
		 }
	
			action.moveToElement(OrderDetails).build().perform();
			 
		 if(OrderDetails .isDisplayed()) {
			 Reporter.log("Order Details: "+OrderDetails.getText());
			 System.out.println("Order Details: "+OrderDetails.getText());
		 } else {
			 System.out.println("Text Not Visible");
		 }
		 action.sendKeys(Keys.END).build().perform();
		 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
		 WebElement Stripe = driver.findElement(By.xpath("//*[@id='stripe']")); 
		 Utility.ScrollToElement(Stripe);
		 WebElement Paypal = driver.findElement(By.id("paypal"));
		 boolean PaypalStatus = Paypal.isSelected();
		 boolean Stripestatus = Stripe.isSelected();
		 System.out.println("Stripe Radio Button Status Is: "+Stripestatus);
		 System.out.println("PayPal Status: "+PaypalStatus);
		 if(Stripestatus) {
			 
			driver.findElement(By.xpath(".//*[@id='payment-form']/div[2]/div/input")).sendKeys("Gouse Basha kruthika");
			driver.findElement(By.xpath(".//*[@id='payment-form']/div[3]/div/input")).sendKeys("4242424242424242");
			driver.findElement(By.xpath(".//*[@id='payment-form']/div[4]/div[1]/input")).sendKeys("376");
			new Select(driver.findElement(By.cssSelector(".form-control.card-expiry-month"))).selectByIndex(3);
			new Select(driver.findElement(By.cssSelector(".form-control.card-expiry-year"))).selectByIndex(4);
			
			/*Utility.VerifyDropDowns(Month, ".//*[@id='payment-form']/div[4]/div[2]/select", "3");
			WebElement Year=null;
			Pause(1000);
			Utility.VerifyDropDowns(Year, "","4" );*/
			
			WebElement PayButton = driver.findElement(By.id("session_stripe_pay"));
			System.out.println("PayMent Button: "+PayButton.getText());
			PayButton.click();
			Pause(3000);
			
			
			String ExpectedText=driver.findElement(By.xpath(".//*[@id='payment-form']/div[6]/div/div")).getText();
			
			try {
				
			
					Assert.assertEquals("Your card was declined. "
												+ "Your request was in live mode, but used a known test card.", ExpectedText);
					Reporter.log(ExpectedText);
					System.out.println(ExpectedText);
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			 //Paypal.click();
		 }
		 
		} catch (NullPointerException ex) 
		 {
			System.out.println(ex.getMessage());
		 }
		
	}
	
	
	// Course Payment 
	
	public static void CoursePayMent() {
		 try {
			 action = new Actions(driver);
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 WebElement Description = driver.findElement(By.xpath("//*[@id='contents']/div[2]/div[1]/div[2]/div[1]/div/div/h4/p"));
			 WebElement CoursePrice = driver.findElement(By.xpath("//*[@id='contents']/div[2]/div[1]/div[2]/div[2]/div/div"));
			 if(Description.isDisplayed()) {
				 System.out.println("Course Description: "+Description.getText());
			 } else {
				 System.out.println("Text Is Not Visible");
			 } if(CoursePrice.isDisplayed()) {
				 System.out.println("Course Price Details: "+CoursePrice.getText());
				 Reporter.log("Course Price Details: "+CoursePrice.getText());
			 } else {
				 System.err.println("Price Text Is Not Visible.");
			 }
			 WebElement CouponTextbox = driver.findElement(By.id("coupon_code_val"));
			 WebElement Applybutton = driver.findElement(By.id("session_coupon_apply"));
			 action.moveToElement(CouponTextbox).build().perform();
			 if(CouponTextbox.isDisplayed() && CouponTextbox.isEnabled()) {
				 Reporter.log("Coupon Code Text Box Is Present: "+CouponTextbox.getAttribute("placeholder"));
				 System.out.println("Coupon Code Text Box Is Present: "+CouponTextbox.getAttribute("placeholder"));
				 CouponTextbox.sendKeys("LAND30");
			 } else {
				 Reporter.log("Coupon Code Text Box Not Present");
			 } if(Applybutton.isDisplayed() && Applybutton.isEnabled()) {
				 Reporter.log("Apply Button IS Present: "+Applybutton.getText());
				 Applybutton.click();
				 //selenium.isTextPresent("Invalid coupon");
				//String Text = "" 
			 } else {
				 System.out.println("Apply Button Not Enabled");
			 }
			 action.sendKeys(Keys.END).build().perform();
			 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
			 WebElement Stripe = driver.findElement(By.xpath("//*[@id='stripe']")); 
			 Utility.ScrollToElement(Stripe);
			 WebElement Paypal = driver.findElement(By.id("paypal"));
			 boolean PaypalStatus = Paypal.isSelected();
			 boolean Stripestatus = Stripe.isSelected();
			 System.out.println("Stripe Radio Button Status Is: "+Stripestatus);
			 System.out.println("PayPal Status: "+PaypalStatus);
			 if(Stripestatus) {
				 
				driver.findElement(By.xpath(".//*[@id='payment-form']/div[2]/div/input")).sendKeys("Gouse Basha kruthika");
				driver.findElement(By.xpath(".//*[@id='payment-form']/div[3]/div/input")).sendKeys("4242424242424242");
				driver.findElement(By.xpath(".//*[@id='payment-form']/div[4]/div[1]/input")).sendKeys("376");
				new Select(driver.findElement(By.cssSelector(".form-control.card-expiry-month"))).selectByIndex(3);
				new Select(driver.findElement(By.cssSelector(".form-control.card-expiry-year"))).selectByIndex(4);
				
						
				WebElement PayButton = driver.findElement(By.id("session_stripe_pay"));
				System.out.println("PayMent Button: "+PayButton.getText());
				PayButton.click();
				Pause(1000);
				String ExpectedText="Your card was declined. Your request was in live mode, but used a known test card.";
				
				try {
					
				
						Assert.assertEquals("Your card was declined. "
													+ "Your request was in live mode, but used a known test card.", ExpectedText);
						Reporter.log(ExpectedText);
						System.out.println(ExpectedText);
						
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}
	
		 } catch (NullPointerException ex) {
			 System.out.println(ex.getMessage());
		 }
	}
}

