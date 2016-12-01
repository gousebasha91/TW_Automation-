package bin.Tutor;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bin.Pages.SignInPage;
import bin.Student.StudentDashBoardPage;
import bin.Utility.Utility;

public class TutorDashBoardTest {
	
	Utility utility = new Utility();
	SignInPage page = new SignInPage();
	TutorDashBoardPage tutor = new TutorDashBoardPage();
	TutorDashBoard dashboard = new TutorDashBoard();
	
	
	@Test
	public void test01() {
		
		utility.ClickOnlinks("SIGNIN");
		page.EnterMail("gousebasha.tutor@yopmail.com");
		page.EnterPassWord("Dev@912210");
		page.ClickSubmitButton();
		Utility.Pause(2000);
		tutor.VerifyTutorsDashBoard();

		
	}
	

    @Test(description="Validate All Links")
	public void test02() {
		dashboard.VerifyDashBoardButton();
		dashboard.UpdateAvailabity();
			
	}
	
	/*@Test
	public void test03() {
		utility.ValidateBrokenlinks();
	}
	*/
	
	
	
	
	@BeforeTest
	public void beforetest() {
		utility.VerifyPageTitle();
		utility.VerifyPageURL();
		Utility.Pause(2000);
		utility.VerifyPageHeader();
	}
	
	@AfterTest
	public void ShutDown() {
		utility.driverShutDown();
	}

}
