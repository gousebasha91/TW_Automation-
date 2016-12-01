package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bin.Utility.Utility;

public class TutorsPage {
	
	private static WebElement element=null;
	
	
	public static WebElement Banner(WebDriver driver){
		element=driver.findElement(By.xpath(".//*[@id='main']/div"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement TopTutors(WebDriver driver) {
		
		element=driver.findElement(By.xpath(".//*[@id='container-fluid']/div[4]/div/div/div"));
		Utility.verifyelement(element);
		return element;
		
	}
	
	public static WebElement Subjectlist (WebDriver driver) {
		element=driver.findElement(By.xpath(".//*[@id='ddmenu']/li[5]/a"));
		Utility.verifyelement(element);
		return element;
	}
	
	
	public static WebElement Subject(WebDriver driver) {
		
		element=driver.findElement(By.linkText("Math"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement SubCatergeory(WebDriver driver) {
		element=driver.findElement(By.xpath(".//*[@id='submenu-Math']"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement Science (WebDriver driver) {
		element=driver.findElement(By.linkText("Science"));
		Utility.verifyelement(element);
		return element;
	}
	
	public static WebElement SciencesubMenu (WebDriver driver) {
		element=driver.findElement(By.xpath(".//*[@id='submenu-Science']"));
		Utility.verifyelement(element);
		return element;
	}
	

	 public static WebElement Tutor (WebDriver driver) {
		 
		 element=driver.findElement(By.xpath(".//*[@id='tutors_review']/div[2]/div/a/div[5]/h2"));
		 Utility.verifyelement(element);
		 return element;
	 }
	 
	 public static WebElement HireNow(WebDriver driver) {
		 element=driver.findElement(By.cssSelector("#hire-btn"));
		 Utility.verifyelement(element);
		 return element;
	 }
	 
	
	
	
	

	

}
