package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bin.Utility.Utility;

public class CoursesPage {
	
	private static WebElement element=null;
	
	
	public static  WebElement CourseTitle (WebDriver driver) {
		element = driver.findElement(By.cssSelector(".banner-sec.blog-banner-sec.text-center>h1"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement CourseImg(WebDriver driver) {
		element=driver.findElement(By.cssSelector(".img-wdt100"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement StarRating (WebDriver driver) {
		element=driver.findElement(By.cssSelector(".rating-stars"));
		Utility.verifyelement(element);
		return element;
		
	}
	
	public static WebElement Session_Cost(WebDriver driver) {
		
		element=driver.findElement(By.cssSelector(".size-14.grey-636"));
		Utility.verifyelement(element);
		return element;
		
	}
		
	public static WebElement Sharebtn (WebDriver driver) {
		element=driver.findElement(By.cssSelector("label.btn.btn-info > span"));
		Utility.verifyelement(element);
		return element;
		
	}
	
	public static WebElement Wishlist_btn (WebDriver driver) {
		element=driver.findElement(By.cssSelector(".btn.btn-info.bold.contact-button"));
		Utility.verifyelement(element);
		return element;
		
	}
	
	public static WebElement EnrollNow (WebDriver driver) {
		element=driver.findElement(By.partialLinkText("Enroll Now"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement AddtoCart(WebDriver driver) {
		element=driver.findElement(By.partialLinkText("Add to cart"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement CourseDescription(WebDriver driver) {
		element=driver.findElement(By.xpath(".//*[@id='container-fluid']/div[4]/div/div[2]"));
		Utility.verifyelement(element);
		return element;
	}
	
	
	public static WebElement Banner (WebDriver driver) {
		element=driver.findElement(By.xpath(".//*[@id='main']/div"));
		Utility.verifyelement(element);
		return element;
		
	}
	
	public static WebElement AllCourses (WebDriver driver) {
		element=driver.findElement(By.cssSelector(".cont-stylss"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement Course (WebDriver driver) {
		element=driver.findElement(By.cssSelector(".overlay-content>h2"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement ReviewLabel (WebDriver driver) {
		element =driver.findElement(By.xpath(".//*[@id='payment-form']/div[1]/div[1]"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement PersonalInfo (WebDriver driver) {
		element = driver.findElement(By.xpath(".//*[@id='payment-form']/div[1]/div[2]"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement Payment (WebDriver driver) {
		element=driver.findElement(By.xpath(".//*[@id='payment-form']/div[1]/div[3]"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement AmountLayout (WebDriver driver) {
		element=driver.findElement(By.xpath(".//*[@id='payment-form']/div[2]"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement Removelnk (WebDriver driver) {
		element=driver.findElement(By.partialLinkText("Remove"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement Previous (WebDriver driver) {
		element=driver.findElement(By.partialLinkText("Previous"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement Nextbtn (WebDriver driver) {
		element = driver.findElement(By.cssSelector(".nexbut"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement ShoppingCart(WebDriver driver) {
		element=driver.findElement(By.xpath("//a[@href='/shopping_carts/8136']"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement Proccedtocheckout(WebDriver driver) {
		element=driver.findElement(By.xpath(".//*[@id='navigation']/li/ul"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement Shoppingcartlist(WebDriver driver) {
		element=driver.findElement(By.xpath("//*[@class='sub_navigation']"));
		Utility.verifyelement(element);
		return element;
	}
	
	
	
}
