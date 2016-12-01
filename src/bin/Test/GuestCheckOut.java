package bin.Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import bin.Pages.CourseDetailsPage;
import bin.Pages.CoursesPage;
import bin.Pages.GuestCheckOutPage;
import bin.Pages.Homepage_1;
import bin.Student.StudentDashBoardPage;
import bin.Utility.BrowserConfig;
import bin.Utility.Utility;

@Listeners(GenerateReport.class)
public class GuestCheckOut  {
	
	Utility  utility = new Utility();
	GuestCheckOutPage checkoutpage = new GuestCheckOutPage();
	StudentDashBoardPage dashboardpage =  new StudentDashBoardPage();
	
	 
	  @Test(description="Validate Course Page Details")
	  public void Test1() {  
	  Utility.ClickButtons("COURSES");
	  Utility.Pause(1000);
	  Utility.takescreesnshot("Courses Page");	 
	  }
	  
	  @Test(description="Select A Course")
	  public  void Test2() {  
		  
		  Utility.Pause(2000);
		  checkoutpage.SelectCourse();
	  } 
	  
	  @Test(description="Enroll a course & Add to cart functionality")
	  public void Test3() {
	 	
		  dashboardpage.EnrollCourse_AddtoCart("Add to cart");
		  dashboardpage.CheckOut();
	 	 
	  }
	  
	

	@BeforeTest
	public void StartBrowser() {
		BrowserConfig.StartBrowser("chrome");
		
	}
	 
	 
}
