package bin.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import bin.Pages.Homepage_1;
<<<<<<< HEAD
=======
import bin.Pages.LandingPage;
>>>>>>> tw_regression
import bin.Pages.TutorsPage;
import bin.Pages.TutorsProfilePage;
import bin.Utility.BrowserConfig;

import bin.Utility.Utility;

<<<<<<< HEAD
public class HireTutor extends Homepage_1 {
=======
public class HireTutor {
	
	Utility utility = new Utility();
	TutorsPage tutorpage = new TutorsPage();
	LandingPage page=new LandingPage();
>>>>>>> tw_regression
	
	

	@Test
	public void test01() {
		
	utility.ClickOnlinks("TUTORS");
		
	}


	@Test
	public void test02() {
	page.VerifyPageHeader();
		
	}	
	
	@Test
	public void test03() {

	tutorpage.VerifyPageBanner();
	tutorpage.VerifyTopTutorsTab();
		
	}
	
	 
	@Test(description = "Validate Subjects Categeroy")
	public void test04() {

	tutorpage.Subjectslist();
	tutorpage.subjects();
	  
	}
	  

	@Test(description="Select a Tutor From The List")
	public void test05() {

	tutorpage.SelectTutor();
	}

<<<<<<< HEAD
/*@BeforeMethod
public void beforeMethod() {
	Homepage_1 Homepage = new Homepage_1();
	Homepage.ValidateBrokenlinks();
}*/

@BeforeTest
public void StartBrowser() {
 Homepage_1 Homepage = new Homepage_1(); 
 Homepage.intDriver("chrome");
 CaptureScreenShot("Home Page");
 Homepage.ClickOnlinks("TUTORS");
 CaptureScreenShot("Tutors Page");
		
}

@AfterTest
public void tearDown() {
	if(driver!=null) {
		
		driver.close();
=======
	@Test(description = "Hire A Tutor")
	public void test06() {	 
	 
	 tutorpage.HireTutor();
	}


	@BeforeMethod
	public void BeforeMethod() {
	utility.VerifyPageTitle();
	utility.VerifyPageURL();
>>>>>>> tw_regression
	}
	
	
	@BeforeTest
	public void StartBrowser() {
	 BrowserConfig.StartBrowser("chrome");
	}


}
