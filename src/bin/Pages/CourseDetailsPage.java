package bin.Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Locators.CoursesPage;
import bin.Utility.Utility;

public class CourseDetailsPage  extends Utility {


	public void VerifyCourseDetailsPage() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CoursesPage.CourseTitle(driver);
		Reporter.log("Course Title IS Present: "
							+CoursesPage.CourseTitle(driver).getText());
		CoursesPage.CourseImg(driver);
		Reporter.log("Course Image Present: "
							+CoursesPage.CourseImg(driver).getAttribute("alt"));
		CoursesPage.StarRating(driver);
	    Reporter.log("Star Rating IS Present: "
							+CoursesPage.StarRating(driver).getText());
		CoursesPage.Session_Cost(driver);
		Reporter.log("No.OF Sessions & Price Section IS Present:"
							+CoursesPage.Session_Cost(driver).getText());
		CoursesPage.Sharebtn(driver);
		Reporter.log("Share Button  Present: "
							+CoursesPage.Sharebtn(driver).getText());
		CoursesPage.Wishlist_btn(driver);		
		Reporter.log("WishList Button  Present: "
							+CoursesPage.Wishlist_btn(driver).getText());
		CoursesPage.EnrollNow(driver);
		Reporter.log("EnrollNow Button  Present: "
							+CoursesPage.EnrollNow(driver).getText());
		CoursesPage.AddtoCart(driver);
		Reporter.log("AddtoCart Button  Present: "
							+CoursesPage.AddtoCart(driver).getText());
		CoursesPage.CourseDescription(driver);
		Reporter.log("CourseDescription Button  Present:"
							+CoursesPage.CourseDescription(driver).getText());
		}
	
	
	}


