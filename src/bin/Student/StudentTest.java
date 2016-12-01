package bin.Student;

import org.testng.annotations.Test;


import bin.Pages.QuestionsPage;
import bin.Pages.SignInPage;
import bin.Pages.TutorSchedulePage;
import bin.Utility.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class StudentTest {

	Utility utility = new Utility();
	SignInPage page = new SignInPage();
	StudentDashBoardPage dashboardpage = new StudentDashBoardPage();
	PaymentPage paymentpage = new PaymentPage();
	QuestionsPage question = new QuestionsPage();
	
	
	
	
	@Test(description="Sign In As Student")
	public void test01() {
		
		utility.ClickOnlinks("SIGNIN");
		page.SignIn();
		//page.EnterMail("gouse.shaik91@yopmail.com");
		//page.EnterPassWord("Dev@912210");
		//page.ClickSubmitButton();
		Utility.Pause(2000);
		dashboardpage.VerifyStudentProfile();
		
	}
	
	@Test(description="Validate All Links")
	public void test02() {
		utility.Printlinks();
			
	}
	/*
	@Test
	public void test03() {
		utility.ValidateBrokenlinks();
	}
	*/
	@Test(description="Verifying Student Dash Board Page")
	public void test04() {
		
		dashboardpage.VerifyStudentDashBoard();
		Utility.Pause(3000);
		
	}
	
	@Test(description="Selecting a Tutor For To Hire ")
	public void test05() {
		TutorSchedulePage SchedulePage = new TutorSchedulePage();		
		dashboardpage.HireTutor();
		Utility.Pause(3000);
		dashboardpage.SelectTutor();
		SchedulePage.VerifySchedulePage();
		SchedulePage.ScheduleTutor();
		
	}
	
	@Test(description= "Payment") 
	public void test06() {
		paymentpage .VerifyPaymentPage();
		
		
	}
	
	@Test(description = "Enroll A Course")
	public void test07() {
		
		Utility.Pause(3000);
		StudentDashBoardPage.ClickOnEnrollCourse();
		StudentDashBoardPage.SelectCourse();
		dashboardpage.EnrollCourse_AddtoCart("Add to cart");
		Utility.Pause(3000);
		dashboardpage.CheckOut();
		
	}
	
	
	/*@Test(description = "Verify Course Payment Page")
	public void test08() {
		dashboardpage.ASkQuestion();
		Utility.Pause(3000);
		question.popuphandle();
	}*/
	
	@BeforeMethod(description="Verifying Both Launched Page Titles & Page URL")
	public void BeforeMethod() {
		utility.VerifyPageTitle();
		utility.VerifyPageURL();
		//utility.VerifyPageHeader();
		
	}
	
	
	
	@AfterTest
	public void tearDown() {
		utility.driverShutDown();
		
		//driver.quit();
	}
	
}
