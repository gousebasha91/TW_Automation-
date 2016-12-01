package bin.Tutor;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import bin.Utility.BrowserConfig;
import bin.Utility.Utility;

public class TutorDashBoardPage extends BrowserConfig {
	
	Utility utility = new Utility();
	
	private static Actions action;
	
	public void VerifyTutorsDashBoard() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement TutorProfile = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[7]/div/button"));
			WebElement DashBoard = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[1]/a"));
			WebElement Notification  = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[2]/a"));
			WebElement MyClassRoom = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[3]/a"));
			WebElement MyAvailibilty = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[4]/a"));
			WebElement MyCourses = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[5]/a"));
			WebElement MyQA = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[6]/a"));
			WebElement GetVerified = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[7]/a"));
			WebElement Requirements = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/ul/li[7]/a"));
			WebElement Account = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/div/a[1]"));
			WebElement Logout = driver.findElement(By.xpath(".//*[@id='sidebar']/div/div[2]/div/div/a[1]"));
			
			if(TutorProfile.isDisplayed()) {
				System.out.println("Tutor Loggeed In SucessFuly");
				Reporter.log("Tutor Profile Is Present: "+TutorProfile.getText());
				utility.takescreesnshot("Tutors DashBoard Page");
			} else {
				System.err.println("Profile Not Present.");
			} if(DashBoard.isDisplayed()||DashBoard.isEnabled()){
				Reporter.log("DashBoard Button Is Present.: "+DashBoard.getText());
			} else {
				System.err.println("DashBoard Button Not Present.");
			} if(Notification.isDisplayed()||Notification.isEnabled()) {
				Reporter.log("Notifications Button Is Present: "+Notification.getText());
			} else {
				System.err.println("Notifications Button Not Present.");
			} if(MyClassRoom.isDisplayed()) {
				Reporter.log("My Classroom Button IS Present: "+MyClassRoom.getText());
			} else {
				System.err.println("My Classroom button Not Present.");
			} if(MyAvailibilty.isDisplayed()) {
				Reporter.log("My Availibilty Button Is Present: "+MyAvailibilty.getText());
			} else {
				System.err.println("My Availbilty Button Is Not Present.");
			} if(MyCourses.isDisplayed()) {
				Reporter.log("My Courses Button IS Present.: "+MyCourses.getText());
			} else {
				System.err.println("My Courses Button Not present");
			} if(MyQA.isDisplayed()) {
				Reporter.log("My Q&A Button IS Present: "+MyQA.getText());
			} else {
				System.err.println("My QA Button Not Present.");
			} if(GetVerified.isDisplayed()) {
				Reporter.log("GetVerfied Button IS Present: "+GetVerified.getText());
			} else {
				System.err.println("Get Verified Button Not Pesent");
			} if(Requirements.isDisplayed()) {
				Reporter.log("Requirements Button IS Present: "+Requirements.getText());
			} else {
				System.err.println("Requirements Button Not Present.");
			} if(Account.isDisplayed()) {
				Reporter.log("Account Settings Button Is Present: "+Account.getAttribute("data-original-title"));
			} else {
				System.err.println("Account Settings Button not Present.");
			} if(Logout.isDisplayed()) {
				Reporter.log("Logout Button IS Present: "+Logout.getAttribute("href"));
			} else {
				System.err.println("Logout Button Not Preent");
			}
			
			
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
