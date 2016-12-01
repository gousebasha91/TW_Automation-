package bin.Tutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import bin.Utility.Utility;

public class TutorDashBoard  extends Utility {
	
	Utility utility = new Utility();
	
	
	
	
	public void VerifyDashBoardButton() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//selenium.setSpeed("3000");
			WebElement DashBoard = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[1]/a"));
			if(DashBoard.isDisplayed()) {
				System.out.println("DashBoard Button Is Displayed");
				utility.takescreesnshot("DashBoard");
				DashBoard.click();
			} else {
				System.out.println("DashBoard Not Visible");
			} 
			
			String ExpectedText = driver.findElement(By.xpath(".//*[@id='contents']/div/div/div[1]/div[1]/div/h1")).getText();
			Assert.assertEquals("Dashboard", ExpectedText);
			System.out.println(ExpectedText);
			
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
			
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void UpdateAvailabity() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement Update = driver.findElement(By.linkText("UPDATE AVAILABILITY"));
			if(Update.isDisplayed()||Update.isEnabled()) {
				Reporter.log("Update Availbilty Link IS Present: "+Update.getText());
				Update.click();
				Utility.Pause(2000);
				utility.takescreesnshot("Update Availbilty");
			} else {
				System.err.println("Update Availbilty Not Present.");
			}
		
			
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	
	
}
