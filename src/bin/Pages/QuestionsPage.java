package bin.Pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import bin.Utility.Utility;

public class QuestionsPage extends Utility  {
	
	public void popuphandle() {
		try 
		{
			
			WebElement QuestionDescription = driver.findElement(By.id("question_description"));
			WebElement submitbtn = driver.findElement(By.xpath(".//*[@id='new_question']/div/div/input"));
			
		/*	Alert alert;
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());*/
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			WebElement Headertext = driver.findElement(By.cssSelector(".popup-rating-top>h2>span"));
			if(Headertext.isDisplayed()) {
				System.out.println("Popup Header Is: "+Headertext.getText());
				Reporter.log("Popup Header Is: "+Headertext.getText());
			} else {
				System.err.println("Header Is Not Viible.");
			}
			
			WebElement SubjectDropdown = driver.findElement(By.id("question_sub_category_id"));
			Utility.VerifyDropDowns(SubjectDropdown, "question_sub_category_id", "3");
			
			WebElement QuestiontextBox_1 = driver.findElement(By.id("question_question"));
			
			if(QuestiontextBox_1.isDisplayed() && QuestiontextBox_1.isEnabled()) {
				Reporter.log("Text Is Present:" +QuestiontextBox_1.getAttribute("placeholder"));
				QuestiontextBox_1.sendKeys("Regression Testing");
			} else {
				System.err.println("Text Box IS Not Present.");
			} if(QuestionDescription.isDisplayed() || QuestionDescription.isEnabled()) {
				Reporter.log("Description Text Box IS Present: "+QuestionDescription.getAttribute("placeholder"));
				QuestionDescription.sendKeys("ficbdbceqdjvbficnduvbefwojnvbecnvuehvhwjdnve8w9dc");
			} else {
				System.err.println("Text Box not preent");
			} if(submitbtn.isDisplayed() && submitbtn.isEnabled()) {
				Reporter.log("Submit Button Is Present: "+submitbtn.getAttribute("value"));
				submitbtn.click();
			}
			
			
			
			
		} catch (NoSuchElementException e) {
			
			System.out.println(e.getMessage());
		}
	
		
	}
	

}
