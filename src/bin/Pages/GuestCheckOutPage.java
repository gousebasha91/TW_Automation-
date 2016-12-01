package bin.Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import bin.Utility.Utility;

public class GuestCheckOutPage extends Utility {

	private static Actions action;
	
	
	CoursesPage coursepage = new CoursesPage();
	
	
	public void SelectCourse() {
		
		try {
			
		  driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		  action=new Actions(driver);
		  //coursepage.Subjectslist();
		  //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  Locators.CoursesPage.Course(driver);
		  action.moveToElement(Locators.CoursesPage.Course(driver)).build().perform();
		  Pause(2000);
		  if(Locators.CoursesPage.Course(driver).isDisplayed() || Locators.CoursesPage.Course(driver).isEnabled()) {
			  System.out.println("Courses Are Avaliable:"+Locators.CoursesPage.Course(driver).getText());
			  Locators.CoursesPage.Course(driver).click();  
			  CourseDetailsPage detailspage = new CourseDetailsPage();
			  Pause(1000);
			  detailspage.VerifyPageTitle();
			  detailspage.VerifyPageURL();
			  detailspage.VerifyPageHeader();
			  detailspage.VerifyCourseDetailsPage();
			  
		  } else {
			  System.out.println("Not Present In Given Time");
		  }
		}catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void VerifyCheckoutPage() {
		
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		
		String HeaderText="ORDER CHECKOUT";
		String Text=driver.findElement(By.xpath(".//*[@id='container-fluid']/div[3]/div/h1")).getText();
		if(HeaderText.contains(Text)) {
			Reporter.log("Both Text Matched");
			System.err.println("Header Text Is:"+Text);
			
		} else {
			Reporter.log("Text Not Visible");
		}
		
		String fontfamily=Locators.CoursesPage.ReviewLabel(driver).getCssValue("font-family");
		System.out.println("Font SIze: "+fontfamily);
		String fontcolor=Locators.CoursesPage.ReviewLabel(driver).getCssValue("background-color");
		System.out.println("Font Color:"+fontcolor);
		System.out.println("Review Label Text IS :"+Locators.CoursesPage.ReviewLabel(driver).getText());
		System.out.println("Personal Info Text Color: "
						+Locators.CoursesPage.PersonalInfo(driver).getCssValue("background-color"));
		System.out.println("PersonalInfo Visible :"
						+Locators.CoursesPage.PersonalInfo(driver).getText());
		System.out.println("Payment Text:"
						+Locators.CoursesPage.Payment(driver).getText());
		System.out.println("Payment Text Background Color: "
						+Locators.CoursesPage.Payment(driver).getCssValue("background-color"));
		System.out.println("Amount Text Is: "
						+Locators.CoursesPage.AmountLayout(driver).getText());
		Reporter.log(Locators.CoursesPage.AmountLayout(driver).getText());
		Locators.CoursesPage.Removelnk(driver);
		System.out.println("Remove Link Is Displayed: "
						+Locators.CoursesPage.Removelnk(driver).getText());
		boolean PreviousbtnPresence=Locators.CoursesPage.Previous(driver).isDisplayed();
		boolean previousbtnenabled=Locators.CoursesPage.Previous(driver).isEnabled();
		
		if(PreviousbtnPresence==true && previousbtnenabled==true) {
			Reporter.log("Previous ButtonSIze : "
						+Locators.CoursesPage.Previous(driver).getSize().getWidth());
			System.out.println("Previous Button IS Enabled: "
						+Locators.CoursesPage.Previous(driver).getText());
		} else {
			Reporter.log("Previous Button Not Visible");
		}
		boolean NextbtnPresence=Locators.CoursesPage.Nextbtn(driver).isDisplayed();
		boolean NextbtnEnabled=Locators.CoursesPage.Nextbtn(driver).isEnabled();
		System.out.println(NextbtnPresence);
		Locators.CoursesPage.Nextbtn(driver);		
		System.out.println("Next Button Is Present: "
						+Locators.CoursesPage.Nextbtn(driver).getText());
		Locators.CoursesPage.Nextbtn(driver).click();
	}
	
	public void GuestCheckOut() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Locators.CoursesPage.ShoppingCart(driver);
		Reporter.log("Shopping Cart Icon Presence: "
					+Locators.CoursesPage.ShoppingCart(driver).getText());
		Reporter.log("Shoppingcart list: "
					+Locators.CoursesPage.Shoppingcartlist(driver).getText());
		Locators.CoursesPage.Proccedtocheckout(driver);
		Reporter.log("ProccedToCheckOut Button: "
					+Locators.CoursesPage.Proccedtocheckout(driver));
		action.moveToElement(Locators.CoursesPage.ShoppingCart(driver))
		 			.moveToElement(Locators.CoursesPage.Proccedtocheckout(driver))
		 				.build().perform();
		
	} 
		 
	public static void VerifyGuestCheckout() {
		  
		  WebElement ChecKoutlink=driver.findElement(By.partialLinkText("Checkout as a Guest"));
		  boolean Checkoutlinkpresence=ChecKoutlink.isDisplayed();
		  boolean CheckoutlinkEnabled=ChecKoutlink.isEnabled();  
		  if(Checkoutlinkpresence==true && CheckoutlinkEnabled==true) {
			  
			  System.out.println("Check Out As GuestUser Link Is Present:"
					  								+ChecKoutlink.getText());
			  ChecKoutlink.click();
		  } else 
		  {
			  System.out.println("Checkout As Guest User link Not Present When Hire A Tutor");
		  }
		  
	  }
	 
	 public void EnrollCourse_AddtoCart(String ButtonType) {
		 WebElement Button=driver.findElement(By.partialLinkText(ButtonType));
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 if(ButtonType.equalsIgnoreCase("Enroll Now"))
		 {
			 Button.click();
			 Pause(1000);
			 String SucessText=driver.findElement(By.xpath("..//*[@id='flash']/div")).getText(); 
			 System.out.println("AcknowledgeMent Text Is :"+SucessText);
		 } else if(ButtonType.equalsIgnoreCase("add to cart")) 
		 {
			 Button.click();
			 Pause(1000);
			 String SucessText=driver.findElement(By.xpath(".//*[@id='flash']/div")).getText();
			 System.out.println("AcknowledgeMent Text Is :"+SucessText);
		 }
		
	 }
	
	

}
