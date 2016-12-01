package bin.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import bin.Utility.Utility;

public class InstitutePage extends Utility {
	
	private static Actions action;

public void VerifyPageTitle() {
		
		String PageTitle = driver.getTitle();
		System.out.println("Title OF The Institute Page: "+PageTitle);
		
	}
	
	public void VerifyPageURL(){
		
		String PageURL = driver.getCurrentUrl();
		System.out.println("Institute Page URL Is: "+PageURL);
	}


	
	public void VerifyPageBanner() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement Banner = driver.findElement(By.xpath(".//*[@id='main']/div"));
		if(Banner.isDisplayed() && Banner.isEnabled()) {
			System.out.println("Banner Text Is :"
										+Banner.getText());
		}else {
			System.out.println("Banner Not Displayed ");
		}
	}
	
	public void VerifyInstituteTab() {
		WebElement InstituteTab=driver.findElement(By.cssSelector(".cont-stylss"));
		if(InstituteTab.isDisplayed() && InstituteTab.isEnabled()) {
			System.out.println("All Institute Tab Elements :"
								+InstituteTab.getText()+InstituteTab.getAttribute("type"));
			
		}else {
			System.out.println("All Institute Tab No Present");
		}
		
	}
	
	public void RatingFilter() {
		action=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement Rating = driver.findElement(By.xpath(".//*[@id='ddmenu']/li[3]/a"));
		WebElement Subrating=driver.findElement(By.xpath(".//*[@id='ddmenu']/li[3]/ul"));
		if(Rating.isDisplayed()) {
			action.moveToElement(Rating).build().perform();
			Pause(1000);
			System.out.println("Rating: "+Rating.getText());
			System.out.println("Subratng :"+Subrating.getAttribute("data-value"));
		} else {
			System.out.println("Rating Filter Categories Not Present");
		}
	}
	
	public void SelectInstitute() {
		action=new Actions(driver);
		WebElement Institute=driver.findElement(By.xpath(".//*[@id='filtered_companies1']/div[4]/div/a/div[6]/p"));
		action.moveToElement(Institute).build().perform();
		Pause(1000);
		if(Institute.isDisplayed() && Institute.isEnabled()) {
			System.out.println("Selected Institute:"+Institute.getText());
			Institute.click();
		} else {
			Reporter.log("No Institute & Unable To Click");
		}
	}
}
