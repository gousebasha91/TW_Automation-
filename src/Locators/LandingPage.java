package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bin.Utility.Utility;

public class LandingPage {
	
	private static WebElement element=null;
	
	
	public static WebElement Logo_img (WebDriver driver) {
		
		element = driver.findElement(By.xpath(".//*[@id='header']/nav/div/div[1]/a/img"));
		Utility.verifyelement(element);
				
		return element;
		
		
	}
	
	public static WebElement Tutors_lnk(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[contains(text(),'TUTORS')]"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement Courses_lnk(WebDriver driver) {
		element= driver.findElement(By.xpath("//a[contains(text(),'COURSES')]"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement Institute_lnk(WebDriver driver) {
		element=driver.findElement(By.xpath("//a[contains(.,'INSTITUTES')]"));
		Utility.verifyelement(element);
		return element;
	}
	public static WebElement Questions_lnk(WebDriver driver){
		element=driver.findElement(By.xpath("//a[contains(.,'QUESTIONS')]"));
		Utility.verifyelement(element);
		return element;
	}
	public static WebElement Howitworks_lnk(WebDriver driver) {

		element=driver.findElement(By.xpath("//a[.='HOW IT WORKS']"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement SignIn_btn(WebDriver driver){
		element= driver.findElement(By.linkText("SIGNIN"));
		Utility.verifyelement(element);
		return element;
	}
	public static  WebElement Signup_btn(WebDriver driver) {
		element=driver.findElement(By.linkText("SIGNUP"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement DROPDOWN(WebDriver driver) {
		element=driver.findElement(By.id("ddlsearch"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement SearchBox(WebDriver driver) {
		element=driver.findElement(By.id("searchBox"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement TypeOfCoursesText(WebDriver driver){
		element=driver.findElement(By.xpath(".//*[@id='how-working']/div/div/div[2]"));
		Utility.verifyelement(element);
		return element;
		
	}
	
	public static WebElement OneTOne (WebDriver driver) {
		element=driver.findElement(By.xpath(".//*[@id='how-working']/div/div/div[2]/div[1]"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement Instled (WebDriver driver) {
		element =driver.findElement(By.xpath(".//*[@id='how-working']/div/div/div[2]/div[2]"));
		Utility.verifyelement(element);
		return element;
	}
	public static WebElement SelfCourse(WebDriver driver){
		element=driver.findElement(By.xpath(".//*[@id='how-working']/div/div/div[2]/div[3]"));
		Utility.verifyelement(element);
		return element;
		
	}
	
	public static WebElement GetStartedbtn(WebDriver driver){
		element=driver.findElement(By.xpath(".//*[@id='how-working']/div/a"));
		return element;
	}
	
	public static WebElement Video (WebDriver driver){
		element=driver.findElement(By.cssSelector(".content"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement VideoText(WebDriver driver) {
		element=driver.findElement(By.xpath(".//*[@id='754157']/div[1]/div/div[2]"));
		Utility.verifyelement(element);
		return element;
		
	}
	
	public static WebElement MostPopularCourses(WebDriver driver){
		element=driver.findElement(By.xpath(".//*[@id='main-wrap']/div[7]/div/div"));
		Utility.verifyelement(element);
		return element;
	}
	
	
	
	public static WebElement HomePageFooter(WebDriver driver) {
		element= driver.findElement(By.xpath(".//*[@id='main-wrap']/footer"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement INNumbers(WebDriver driver){
		element=driver.findElement(By.xpath(".//*[@id='main-wrap']/div[12]"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement MostPopularTutors(WebDriver driver){
		element=driver.findElement(By.xpath(".//*[@id='main-wrap']/div[8]/div/div"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement Shopping_Cart (WebDriver driver) {
		element=driver.findElement(By.xpath("//*[@id='zero_items'][@title='Shopping Cart']"));
		Utility.verifyelement(element);
		return element;
	}

	
}

