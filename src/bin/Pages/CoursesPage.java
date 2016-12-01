package bin.Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import Locators.TutorsPage;
import bin.Utility.BrowserConfig;
import bin.Utility.Utility;

public class CoursesPage  extends  Utility {
	

	private static Actions action;
	
	public void VerifyPageTitle() {
		
		String PageTitle = driver.getTitle();
		System.out.println("Title OF The Courses Page: "+PageTitle);
		
	}
	
	public void VerifyPageURL(){
	
	String PageURL = driver.getCurrentUrl();
	System.out.println("Courses Page URL Is: "+PageURL);
	
	}

	public void VerifyPageBanner() {
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	Locators.CoursesPage.Banner(driver);
	Reporter.log("Banner Text Is: "
					+Locators.CoursesPage.Banner(driver).getText());
	}

	public void VerifyAllCourses() {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Locators.CoursesPage.AllCourses(driver);
	Reporter.log("TopTutors Sub Tab Elements :"
					+Locators.CoursesPage.AllCourses(driver).getText()
					+Locators.CoursesPage.AllCourses(driver).getAttribute("type"));
	}
	
	public void Subjectslist(){
	action=new Actions(driver);
	TutorsPage.Subjectlist(driver);
	action.moveToElement(TutorsPage.Subjectlist(driver)).build().perform();
	Pause(2000);
	String Text =driver.findElement(By.xpath(".//*[@id='amazon-menu']")).getText();
	System.out.println("------Text Lengh----"
											+Text.length());
	String s[]=Text.split("/n");
	for(int i=0;i<s.length;i++)
	{
		System.out.println("---- Subject's list -----"
											+s[i]);
	}
	
	WebElement EngineeringMenu=driver.findElement(By.linkText("Engineering"));
	System.out.println("Colour of the button :"
									+EngineeringMenu.getCssValue("color")
										+EngineeringMenu.getCssValue("font-size"));
	
	action.moveToElement(EngineeringMenu).moveToElement(driver.findElement
						(By.xpath(".//*[@id='submenu-Engineering']/div[5]"))).click().build().perform();
	Pause(3000);
	
	
}

	public void SelectCourse() {
	
	WebElement course=driver.findElement(By.cssSelector(".overlay-content>h2"));
	if(course.isEnabled() && course.isDisplayed()) {
		System.out.println("Course Is Present:"+course.getText());
		
	}
 }

}

