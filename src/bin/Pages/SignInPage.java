package bin.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import bin.Utility.BrowserConfig;
import bin.Utility.Utility;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class SignInPage extends Utility {
	
	private File file;
	private FileInputStream inputstream;
	private Workbook workbook;
	private Sheet sheet;
	
	public void SignIn() {
		
		
		try {
			file  = new File(System.getProperty("user.dir")+"\\Test Data\\Login Test Data.xls");
			inputstream = new FileInputStream(file);
			workbook = Workbook.getWorkbook(inputstream);
			sheet = workbook.getSheet("Login");
			/*
			WebElement Email = driver.findElement(By.id("exampleInputEmail1"));
			WebElement Password = driver.findElement(By.id("exampleInputPass1"));*/
			//WebElement Submit_btn = driver.findElement(By.className("submit-btn-edge"));
			
			for(int i=1;i<sheet.getRows();i++)
			{
				
				driver.findElement(By.id("exampleInputEmail1")).sendKeys(sheet.getCell(0, i).getContents());
				driver.findElement(By.id("exampleInputPass1")).sendKeys(sheet.getCell(1, i).getContents());
				driver.findElement(By.className("submit-btn-edge")).click();	

			}
				
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (BiffException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	public void EnterMail (String Mail) {
		
		WebElement Email = driver.findElement(By.id("exampleInputEmail1"));

		if(Email.isDisplayed() && Email.isEnabled()) {
			Reporter.log("Email Text Box Is Present: "+Email.getAttribute("type"));

			System.out.println("Email Text Box Is Present: "
								+Email.getAttribute("type"));
			Email.sendKeys(Mail);
			
		} else {
			
			System.out.println("Email Text Box Not Present");
		}
		
		
	}
	
	public void EnterPassWord (String PassWord) {
		
		WebElement Password = driver.findElement(By.id("exampleInputPass1"));
		

		if(Password.isDisplayed()) {
			Reporter.log("Pass Word Text Box Is Present: "+Password.getAttribute("type"));
			System.out.println("Pass Word Text Box Is Present: "
									+Password.getAttribute("type"));
			
			Password.sendKeys(PassWord);
			
			
		} else {
			System.out.println("PassWord Text Box Not Present");
		}
		
		
	}
	
	
	public void ClickSubmitButton () {
		
		WebElement Submit_btn = driver.findElement(By.xpath(".//*[@class='submit-btn-edge']"));
		
		if(Submit_btn.isDisplayed()) {
			Reporter.log("Submit Button IS Present: "+Submit_btn.getAttribute("type"));
			
			System.out.println("Take Me In Button Present"
					 				+Submit_btn.getAttribute("type"));
			 
			 Submit_btn.click();
				
		} else {
			System.out.println("Take Me In Button Not Present");
		}
		
		}
	
	public void VerifySignINPage() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*WebElement Facebookbutton = driver.findElement(By.xpath("//div[@id='container-fluid']/div[3]/div/div/div/div/div/div/a"));
			
		if(Facebookbutton.isDisplayed()) {
			Reporter.log("Facebook Tab Is Present: "+Facebookbutton.getText());
			
			System.out.println("Conncet with Facebook Button IS Present:"
									+Facebookbutton.getText());
		} else {
			System.out.println("Conncet with Facebook Button Not Present");
		}
		*/
		WebElement ForGetPassword_lnk = driver.findElement(By.xpath("//a[contains(text(),'forgot your password?')]"));
		
		if(ForGetPassword_lnk.isDisplayed()) {
			
			Reporter.log("Forget Password link Is Present: "+ForGetPassword_lnk.getText());
			System.out.println("ForGet Your Password Link Is Present :"
					 				+ForGetPassword_lnk.getText());
		} else {
			System.out.println("ForGet Your Password link Is Not Present");
		}
		
		WebElement CheckBox = driver.findElement(By.xpath(".//*[@id='signin-form-horizontal']/div[4]/div/div"));
		boolean CheckBoxPresence = CheckBox.isDisplayed();
		boolean CheckBoxEnabled = CheckBox.isEnabled();
		if(CheckBoxEnabled==true && CheckBoxPresence ==true)
		{
			System.out.println("Check Box Is Present: "+CheckBox.getAttribute("span"));
			Reporter.log(CheckBox.getAttribute("span"));
			CheckBox.click();
		} else {
			System.out.println("Check Box Not Present");
			Reporter.log("Check Box Not Present");
		}
		
		WebElement CreateAc = driver.findElement(By.linkText("Create an account"));
		boolean CreateAclinkPresence=CreateAc.isDisplayed();
		boolean CreateAclinkEnabled=CreateAc.isEnabled();
		if(CreateAclinkPresence==true && CreateAclinkEnabled==true) {
			System.out.println("Create A/c Link Present."+CreateAc.getText());
			
		} else {
			System.err.println("Create A/c Link Not Visible");
		}
		
		WebElement GuestUserCheckout =  driver.findElement(By.linkText("Checkout as a Guest"));

		  boolean Checkoutlinkpresence=GuestUserCheckout.isDisplayed();
		  boolean CheckoutlinkEnabled=GuestUserCheckout.isEnabled();  
		  if(Checkoutlinkpresence==true && CheckoutlinkEnabled==true) {
			  
			  System.out.println("Check Out As GuestUser Link Is Present:"
					  								+GuestUserCheckout.getText());
		  } else 
		  {
			  System.out.println("Checkout As Guest User link Not Present When Hire A Tutor");
		  }
		
	}
	
}
