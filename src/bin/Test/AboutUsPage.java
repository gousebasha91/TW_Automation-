
package bin.Test;

import org.testng.annotations.Test;

import bin.Pages.Homepage_1;
import bin.Utility.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class AboutUsPage extends Utility {
	
	private Actions action;
	
	@Test
	public void test02() {
		String PageTitle = driver.getTitle();
		System.out.println("Title OF The About Us Page: "+PageTitle);
	}
	
	@Test
	public void test03() {
		String PageURL=driver.getCurrentUrl();
		System.out.println("URL Of The Page Is :"+PageURL);
	}
	
	@Test
	public void test04() {
		
		Homepage_1 Homepage = new Homepage_1();
		Homepage.HeaderTab();
	}
	
  @Test
  public void test01() {
	  
	  action=new Actions(driver);
	  WebElement Aboutuslnk = driver.findElement(By.partialLinkText("About Us"));
	  ((JavascriptExecutor) driver).executeScript(
				                     "arguments[0].scrollIntoView();", Aboutuslnk);
	  Aboutuslnk.click();
	  
	  
	  
  }

  
  
  @BeforeTest
  public void beforeTest() {
	  
	  Homepage_1 HomePage = new Homepage_1();
	 
	  
  }

}
