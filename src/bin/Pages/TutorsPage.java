package bin.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.google.common.collect.ImmutableBiMap.Builder;
import bin.Utility.BrowserConfig;
import bin.Utility.Utility;

public class TutorsPage extends Utility {
	
	

	private static  Actions action;
	private static  WebDriverWait wait;

	

	public void VerifyPageBanner() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Locators.TutorsPage.Banner(driver);
		Reporter.log("Banner Text Is: "
						+Locators.TutorsPage.Banner(driver).getText());
	}
	
	public void VerifyTopTutorsTab() {
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Locators.TutorsPage.TopTutors(driver);
		Reporter.log("TopTutors Sub Tab Elements: "
					+Locators.TutorsPage.TopTutors(driver).getText()
					+Locators.TutorsPage.TopTutors(driver).getAttribute("type"));
		
	}
	
	public void Subjectslist(){
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	action=new Actions(driver);
	Locators.TutorsPage.Subjectlist(driver);
	action.moveToElement(Locators.TutorsPage.Subjectlist(driver)).build().perform();
	Pause(3000);
	String Text =driver.findElement(By.xpath(".//*[@id='amazon-menu']")).getText();
	System.out.println("------Text Lengh----"+Text.length());
	String s[]=Text.split("/n");
	for(int i=0;i<s.length;i++)
		{
			Reporter.log("----- Subject's list ----  "+s[i]);
			System.out.println("---- Subject's list -----  "+s[i]);
		}
	}
	
	
	public static void SubjectsSubCatergeoryList(WebElement Subject, WebElement SubCatergeory) {
		
	wait=new WebDriverWait(driver, 25);
	wait.until(ExpectedConditions.visibilityOf(Subject));
	action.moveToElement(Subject).build().perform();
	Pause(2000);
	System.out.println("Subcatergeory SubJects Are:  "+SubCatergeory.getText());
	Reporter.log("Subcatergeory SubJects Are:  "+SubCatergeory.getText());
	System.out.println(SubCatergeory.getText());
		
	}
		
	
	public void subjects() {
			
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Locators.TutorsPage.Subject(driver);
		Locators.TutorsPage.SubCatergeory(driver);
		SubjectsSubCatergeoryList(Locators.TutorsPage.Subject(driver), Locators.TutorsPage.Subject(driver));
		Locators.TutorsPage.Science(driver);
		Locators.TutorsPage.SciencesubMenu(driver);
		SubjectsSubCatergeoryList(Locators.TutorsPage.Science(driver), Locators.TutorsPage.SciencesubMenu(driver));
			
			
		}
		
		
		
		/*
		
		wait.until(ExpectedConditions.visibilityOf(Science));
		
		action.moveToElement(Science).moveToElement(SciencesubMenu).build().perform();
		System.out.println("------Science SubMenu Catergeory SubJects List-----");
		Reporter.log("Science Subject Sub Catergeory list Is: "+SciencesubMenu.getText());
		System.out.println(SciencesubMenu.getText());
		
		WebElement English=driver.findElement(By.linkText("English"));
		wait.until(ExpectedConditions.visibilityOf(English));
		WebElement EnglishSubMenu = driver.findElement(By.xpath(".//*[@id='submenu-English']"));
		action.moveToElement(English).moveToElement(EnglishSubMenu).build().perform();
		System.out.println("------English SubMenu Catergeory SubJects List-----");
		Reporter.log("English Subject Sub Catergeory list Is: "+EnglishSubMenu.getText());
		System.out.println(EnglishSubMenu.getText());
		
		WebElement Social=driver.findElement(By.linkText("Social Studies"));
		wait.until(ExpectedConditions.visibilityOf(English));
		WebElement SocialSubMenu = driver.findElement(By.xpath(".//*[@id='submenu-SocialStudies']"));
		action.moveToElement(Social).moveToElement(SocialSubMenu).build().perform();
		System.out.println("------Social Studies SubMenu Catergeory SubJects List-----");
		Reporter.log("Social Subject Sub Catergeory list Is: "+SocialSubMenu.getText());
		System.out.println(SocialSubMenu.getText());
		
		WebElement ForeignLang = driver.findElement(By.linkText("Foreign Languages"));
		wait.until(ExpectedConditions.visibilityOf(ForeignLang));
		WebElement ForeignLangSubMenu = driver.findElement(By.xpath(".//*[@id='submenu-ForeignLanguages']"));
		action.moveToElement(ForeignLang).moveToElement(ForeignLangSubMenu).build().perform();
		System.out.println("------Foreign Languages SubMenu Catergeory SubJects List-----");
		Reporter.log("Foreign Language Subject Sub Catergeory list Is: "+ForeignLangSubMenu.getText());
		System.out.println(ForeignLangSubMenu.getText());	
		
}	*/
		
	
	public void SelectTutor() {
	action=new Actions(driver);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Locators.TutorsPage.Tutor(driver);
	action.moveToElement(Locators.TutorsPage.Tutor(driver)).build().perform();
	Pause(3000);
	Reporter.log("Tutor is Avaliable:"+Locators.TutorsPage.Tutor(driver).getText());
	Locators.TutorsPage.Tutor(driver).click();  
		 	
	}
	
	public void HireTutor() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Locators.TutorsPage.HireNow(driver);
		String Fontcolor=Locators.TutorsPage.HireNow(driver).getCssValue("color");
		System.out.println("Color Before Mouse Hover:"+Fontcolor);
		action.moveToElement(Locators.TutorsPage.HireNow(driver)).build().perform();
		Reporter.log("Aftere Mouse Hover: "+Fontcolor);
		Locators.TutorsPage.HireNow(driver).click(); 
	}
}

