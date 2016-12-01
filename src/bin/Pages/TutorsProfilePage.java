package bin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import bin.Utility.Utility;

public class TutorsProfilePage extends Utility {

	
	public void VerifyLinkText() {
		
		WebElement linktext=driver.findElement(By.xpath(".//*[@id='container-fluid']/div[3]/div/div/div"));
		if(linktext.isDisplayed()) {
			System.out.println("Link Text Is Present:"+linktext.getText());
		} else {
			 System.out.println("Link Text Not Present");
		}
	}
	
	public void verifyTutorsProfile() {
		WebElement Profile = driver.findElement(By.xpath(".//*[@id='container-fluid']/div[4]/div"));
		if(Profile.isDisplayed() && Profile.isEnabled()) {
			System.out.println("Tutors Profile: "+Profile.getText());
		}
		
	}

}

