package bin.Utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.Reporter;


import bin.Pages.CoursesPage;
import bin.Pages.InstitutePage;
import bin.Pages.SignInPage;
import bin.Pages.TutorsPage;

public class Utility {
	
	public static  WebDriver driver=null;
	private static Alert alert;
	private static final String URL = "https://www.tutorsweb.com/";
	private static final String ChromeDriverPath = "D:\\Library\\chromedriver.exe"; 
	private static File chrome = new File(ChromeDriverPath);
	private static final String IEDriverPath = "D:\\Library\\IEDriverServer.exe";
	private static File IE = new File(IEDriverPath);
	
	 
	
	public void VerifyPageTitle() {
		
		String PageTitle = driver.getTitle();
		Reporter.log("Page Title Is: "+PageTitle);
		System.out.println("Page Title Is: "+PageTitle);
		
		
	}
	
	public void VerifyPageURL() {
		String ActualPageURL = driver.getCurrentUrl();
		Reporter.log("Page URL Is: "+ActualPageURL);
		System.out.println("Launched Page URL Is. "+ActualPageURL );
	}
	
	public void VerifyPageHeader() {
		
		 WebElement Logo = driver.findElement(By.xpath(".//*[@id='header']/nav/div/div[1]/a/img"));
		 WebElement Tutors = driver.findElement(By.linkText("TUTORS"));
		 WebElement Courses = driver.findElement(By.linkText("COURSES"));
		 WebElement Institute_btn = driver.findElement(By.linkText("INSTITUTES"));
		 WebElement Questions_btn = driver.findElement(By.linkText("QUESTIONS"));
		 WebElement HowItWorks_btn = driver.findElement(By.linkText("HOW IT WORKS"));
		 WebElement SignIn_btn = driver.findElement(By.linkText("SIGNIN"));
		 WebElement Signup_btn = driver.findElement(By.linkText("SIGNUP"));
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(Logo.isDisplayed()) {
			
			Logo.getSize();
			
			System.out.println("Logo Is Prsenet."
											+Logo.getAttribute("src"));
			System.out.println("Logo Size: "
											+Logo.getSize().getHeight()+Logo.getSize().getWidth());
			Reporter.log("Logo Is Present :"+Logo.getAttribute("src"));
			
		} else 
			{
				System.out.println("Logo Is Not Present. ");
				Reporter.log("Logo Not Present");
			}
		
		if(Tutors.isDisplayed() && Tutors.isEnabled()) {
			//CapturePartialScreenShots("TUTORS");
			Reporter.log("Tutors Button Is Present."
											+Tutors.getText());
			System.out.println("Tutors Button IS Present"
												+Tutors.getText());
		} else {
					System.out.println("Tutors Link Not Present.");
					Reporter.log("Tutors Button Not Present");
				}
		if(Courses.isDisplayed()) {
			//CapturePartialScreenShots("COURSES");
			Reporter.log("Courses Button Is Present."
											+Courses.getText());
			System.out.println("Courses Button Is Present: "
										+Courses.getText());
		} else {
			Reporter.log("Courses Button Not Present.");
			System.out.println("Courses Button Not Present");
		}
		if(Institute_btn.isDisplayed()) {
			Reporter.log("Institute Button IS Present. "
										+Institute_btn.getText());
			System.out.println("Institute Button Is Present: "
											+Institute_btn.getText());
		} else {
			Reporter.log("Courses Button Not Present");
			System.out.println("Institute Button Not Present");
		}
		if(Questions_btn.isDisplayed()) {
			Reporter.log("Questions Button Is Present."+
											Questions_btn.getText());
			System.out.println("Questions Button IS Present:" 
						+Questions_btn.getText());
		} else {
			Reporter.log("Questions Button Not Present");
			System.out.println("Questions Button Not Present");
		}
		if(HowItWorks_btn.isDisplayed()) {
			Reporter.log("How It Works Button Is Present. "
					    				+HowItWorks_btn.getText());
			System.out.println("How It Works Button Is Present. "
					    				+HowItWorks_btn.getText());
		} else {
			Reporter.log("How It Works Button Not Present");
			System.out.println("How It Works Button Not Present");
		}
		if(SignIn_btn.isDisplayed()) {
			Reporter.log("SignIn Button Is Present."+
					SignIn_btn.getText());
			System.out.println("SignIn Button Is Displayed:"+SignIn_btn.getText());
		} else {
			System.out.println("SignIn Button  Not Displayed");
		}
		if(Signup_btn.isDisplayed()) {
			System.out.println("SignUp Button IS Dispalyed:"
									+Signup_btn.getText() );		
		} else {
			System.out.println("Signup button not present");
		}
	}
	
	
			
	public void Printlinks() {
		List<WebElement>AllLinks=driver.findElements(By.tagName("href"));
		System.out.println("Total No.oF Links: "+AllLinks.size());
		
		for(int i=0;i<AllLinks.size();i++)
		{
			
			String LinkText=AllLinks.get(i).getAttribute("a");
			Reporter.log("Available Link Are: " +LinkText);
			System.out.println("Available Link Are: "+LinkText);
		}
	}
	
	
	public void ValidateBrokenlinks() {

		List<WebElement> link=driver.findElements(By.tagName("a"));
		System.out.println("Number of Links:"+link.size());
		boolean isValidlink=false;
		for(int i=0;i<link.size();i++)
		{
			String url=link.get(i).getAttribute("href");
			if(url !=null)
			{
				isValidlink=getHttpResponseCode(url);
				if(isValidlink)
				{
					System.out.println("ValidLinks:"+url);
					Reporter.log("ValidLinks: "+url);
				}
				else
				{
					Reporter.log("Broken Links:"+url);
					System.out.println("BrokenLinks:"+url);	
				}
			}
				else
				{
					Reporter.log("Broken Links: "+url);
					System.out.println("BrokenLinks:"+url);	
					continue;
				}
			
		}
	}
	
	public static boolean getHttpResponseCode(String urlstring){
		boolean isBool=false;
		try{
			HttpResponse resp=new DefaultHttpClient().execute(new HttpGet(urlstring));
			int status=resp.getStatusLine().getStatusCode();
			System.out.println(status);
			if((status==404)||(status==505))
			{
				isBool=false;
			}
			else
			{
				isBool=true;
			}
		}catch(Exception e){
			
		}
	return isBool;
}
	
	
	public static void takescreesnshot(String ScreenShotName) {
		try {
			
			DateFormat fd=new SimpleDateFormat("YYYY_MMM_dd HH_mm_ss");
			Date date=new Date();
			String time=fd.format(date);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File ScreenShot=ts.getScreenshotAs(OutputType.FILE);		
			FileUtils.copyFile(ScreenShot, new File("./ScreenShots/"
														+time+ScreenShotName+".jpg"));
			System.out.println("----ScreenShot Captured----");
			
			}	catch (IOException e) {
				
					System.out.println("Exception While Taking ScreenShots"
														+e.getMessage());
			}
	}
	
	public void CapturePartialScreenShots(String Locator){
		
		try {
		
		WebElement ele = driver.findElement(By.xpath(Locator));  
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);
		Point point = ele.getLocation();
		
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(),
											point.getY(), eleWidth,eleHeight);
		
			ImageIO.write(eleScreenshot, "png", screenshot);
			File screenshotLocation = new File("./Images/"+Locator+".png");
			FileUtils.copyFile(screenshot, screenshotLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void ClickButtons(String Locator) {
		
		 WebElement element = driver.findElement(By.linkText(Locator));
		 element.click();
	}
 
	public void ClickOnlinks(String buttontype) {
	
		WebElement link= driver.findElement(By.partialLinkText(buttontype));
		
		if(buttontype.equalsIgnoreCase("TUTORS")) {
			link.click();
			
		} else if(buttontype.equalsIgnoreCase("COURSES")) {
			link.click();
			CoursesPage coursepage=new CoursesPage();
			
		} else if(buttontype.equalsIgnoreCase("INSTITUTES")) {
			link.click();
			 InstitutePage institutepage = new InstitutePage();
			 
		} else if(buttontype.equalsIgnoreCase("questions")) {
			
		}else if(buttontype.equalsIgnoreCase("how it works")) {
			
		}else if(buttontype.equalsIgnoreCase("SIGNIN")) {
			link.click();
			
		}
		
	}

 public void GetFrames() {
	List<WebElement>Frames=driver.findElements(By.tagName("//iframes"));
	System.out.println("No.Of Frames:"+Frames.size());
	for(WebElement iframes:Frames)
	{
		System.out.println("Frames Id: "+iframes.getAttribute("id"));
		System.out.println("Frames name: "+iframes.getAttribute("name"));
	}
}


 public static void VerifyDropDowns(WebElement Element, String Locator, String DropDownVaue) {
	
	  Element = driver.findElement(By.id(Locator));
	  
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	List<WebElement>DropDownValues = new Select(Element).getOptions();
	System.out.println("No.of Values In DropDown: "+DropDownValues.size());
	for(int i=0;i<DropDownValues.size();i++) 
	{
		System.out.println("DropDown Vaules Are :"+DropDownValues.get(i).getText());
		new Select(Element).selectByIndex(2);
		
	}
		
}

 public void Fulentwait() {
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(30, TimeUnit.SECONDS) 
						.pollingEvery(5, TimeUnit.SECONDS) 
							.ignoring(NoSuchElementException.class);
}


public static void ScrollToElement(WebElement Element) {
	
	JavascriptExecutor jse= ((JavascriptExecutor)driver);
	jse.executeScript("arguments[0].scrollIntoView(true);",Element);
 }



  public static void verifyelement(WebElement element) {
	
	try {
		
		if(element.isDisplayed() && element.isEnabled()) {
			
			System.out.println("Element Is Displayed:"+element);
			Reporter.log("Element Is Displayed:"+element);
		} else {
			System.out.println("Element Not present"+element);
			Reporter.log("Element Not present"+element);
		}
	} catch(NullPointerException e) {
		
		System.out.println(element+ "Element Not Clickable:"+e.getStackTrace());
		Reporter.log(element+  "Element Not Clickable:"+e.getStackTrace());
		
	} catch (StaleElementReferenceException ex) {
		System.out.println(element+ "Not Attached to the page document");
		Reporter.log(element+ "ELement Not Attached to the page document");
		
	} catch (NoSuchElementException EX) {
		System.out.println(element+ "Element was not found in DOM: "+EX.getStackTrace()); 
		Reporter.log("Element" +element+ "Not clickable");
	}
	
}

public static void Pause(final int iTimeInMillis) {
	
	try 
		{
			Thread.sleep(2000);
		}
	catch (InterruptedException ex)
		{
			System.out.println(ex.getMessage());
			
	}
}




/*public  void POPUP() {
	try {
		if(selenium.isAlertPresent()) {
			alert = driver.switchTo().alert();
			
	}
	
		
		
	} catch(NoAlertPresentException e)  {
		System.out.println(e.getMessage());
	}
}*/


public static void StartBrowser() {
	
	
}
	
	
public  WebDriver driverShutDown() {
	if(driver!=null) {
		
		driver.quit();
		
	} return driver;
	
}

}
