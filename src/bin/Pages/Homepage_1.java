package bin.Pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

public class  Homepage_1 implements HomePage {
	
	public static WebDriver driver;
	public static final String StagingURL = "http://hut7.in";
	private  static final String url="http://www.tutorsweb.com";
	private File file = new File("D:\\Library\\chromedriver.exe");
	//static String ChromeDriverPath="D:\\02_06_16\\twautomation\\bin\\bin\\Jar Files\\chromedriver.exe";


	ClassLoader loader = getClass().getClassLoader();
	
	@Override
	public void VerifyTitle() {
		
		
		String ActualTitle=driver.getTitle();
		
		Assert.assertEquals(ActualTitle, "Online tutoring services"
				+ "| Homework help online| Self learning courses", "Titles Match");
		System.out.println("----Title Of The Page----: "+ActualTitle);
		System.out.println("Title Lenght Is:"+ActualTitle.length());
		
	}

	@Override
	public void VerifyURL() {
		
		try
		{
		 String OpenedURL=driver.getCurrentUrl();
		/* Assert.assertEquals(OpenedURL, "http://hut7.in/", 
				 								"Both URl's Are Matched");*/
		 System.out.println("-----URL OF The Application----"+OpenedURL);

		} catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
	
		
	}
	

	@Parameters("Browser")
	public void intDriver(String Browser){
		
		if(Browser.equalsIgnoreCase("chrome"))
			{
				
				System.setProperty("webdriver.chrome.driver",
						file.getAbsolutePath());
				driver=new ChromeDriver();
				System.out.println("***** Chrome Browser Was Launched ******");
				
			} else if(Browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver",
						"D:\\Library\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			driver.navigate().to(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
					
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
	
	public void HandleAlerts() throws InterruptedException {
		
		Alert alert=driver.switchTo().alert();
		System.out.println("Popup Text:"+alert.getText());
		alert.accept();
	}
	
	public static void CaptureScreenShot(String Name) {
		
		try {
			DateFormat fd=new SimpleDateFormat("YYYY_MMM_dd HH_mm_ss");
			Date date=new Date();
			String time=fd.format(date);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File ScreenShot=ts.getScreenshotAs(OutputType.FILE);		
			FileUtils.copyFile(ScreenShot, new File("./ScreenShots/"
														+time+Name+".jpg"));
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
		//Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(),
											point.getY(), eleWidth,eleHeight);
		
			ImageIO.write(eleScreenshot, "png", screenshot);
			File screenshotLocation = new File("./ScreenShots/"+Locator+".png");
			FileUtils.copyFile(screenshot, screenshotLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Printlinks() {
		List<WebElement>AllLinks=driver.findElements(By.tagName("a"));
		System.out.println("Total No.oF Links:"+AllLinks.size());
		for(int i=0;i<AllLinks.size();i++)
		{
			String LinkText=AllLinks.get(i).getAttribute("href");
			System.out.println("Avaiable Link Are" 
											+LinkText);
		}
	}
	
	
	@Override
	public void ClickOnlinks(String buttontype) {
		
		WebElement link= driver.findElement(By.partialLinkText(buttontype)); 
		
		if(buttontype.equalsIgnoreCase("TUTORS")) {
			link.click();
			TutorsPage tutorPage=new TutorsPage();
			tutorPage.VerifyPageTitle();
		} else if(buttontype.equalsIgnoreCase("COURSES")) {
			link.click();
			CoursesPage coursepage=new CoursesPage();
			coursepage.VerifyPageTitle();
		} else if(buttontype.equalsIgnoreCase("INSTITUTES")) {
			link.click();
			 InstitutePage institutepage = new InstitutePage();
			 
		} else if(buttontype.equalsIgnoreCase("questions")) {
			
		}else if(buttontype.equalsIgnoreCase("how it works")) {
			
		}else if(buttontype.equalsIgnoreCase("signin")) {
			link.click();
			/*SignInPage signinpage = new SignInPage();
			signinpage.VerifyPageURL();*/
		}
		
		
		
		
	}

	@Override
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
					}
					else
					{
						System.out.println("BrokenLinks:"+url);	
					}
				}
					else
					{
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

		@Override
		public void DropDowns() {
			
			List<WebElement> DropDowns=driver.findElements(By.tagName("select"));
			System.out.println("No.of Drop Downs Present:"+DropDowns.size());
			for(int i=0;i<DropDowns.size();i++)
			{
				System.out.println(DropDowns.get(i).getAttribute("options"));
				
			}
		}
		
		public static void scrollingToBottomofAPage() {
			
		 ((JavascriptExecutor) driver)
	         .executeScript("window.scrollTo(0, document.body.scrollHeight)");

		}
		
	public  static void ScrollingOperation() throws Exception{
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		//robot.keyPress(KeyEvent.VK_PAGE_UP);
		
		
		
		
		
	}
	
	@Override
	public void HeaderTab() {
		WebElement Title_Img = driver.findElement(By.xpath(".//*[@id='header']/nav/div/div[1]/a/img"));
		WebElement Institute_btn = driver.findElement(By.linkText("INSTITUTES"));
		WebElement Questions_btn = driver.findElement(By.linkText("QUESTIONS"));
		WebElement HowItWorks_btn = driver.findElement(By.linkText("HOW IT WORKS"));
		WebElement SignIn_btn = driver.findElement(By.linkText("SIGNIN"));
		WebElement Signup_btn = driver.findElement(By.linkText("SIGNUP"));
		//WebElement Shoppingcart=driver.findElement(By.xpath(".//*[@id='navigation']/li"));
		
		if(Title_Img.isDisplayed() && Title_Img.isEnabled()) {
			
			System.out.println("Titel Image Is Present:"
										+Title_Img.getAttribute("img"));
		} else 
		 {
			System.out.println("Title Image Not Present");
		 }
		
		WebElement Tutor_btn = driver.findElement(By.linkText("TUTORS"));
		if(Tutor_btn.isDisplayed() && Tutor_btn.isEnabled()) {
			System.out.println("Tutors Button Is Preent: "
										+Tutor_btn.getText().toLowerCase());
		} else {
			System.out.println("Tutors Button Not Present");
		}
		
		WebElement Courses_btn = driver.findElement(By.linkText("COURSES"));
		if(Courses_btn.isDisplayed()) {
			System.out.println("Courses Button Is Present: "
										+Courses_btn.getText());
		} else {
			System.out.println("Courses Button Not Present");
		}
		if(Institute_btn.isDisplayed()) {
			System.out.println("Institute Button Is Present: "
											+Institute_btn.getText());
		} else {
			System.out.println("Institute Button Not Present");
		}
		if(Questions_btn.isDisplayed()) {
			System.out.println("Questions Button IS Present:" 
						+Questions_btn.getText());
		} else {
			System.out.println("Questions Button Not Present");
		}
		if(SignIn_btn.isDisplayed()) {
			System.out.println("SignIn Button Is Displayed:"+SignIn_btn.getText());
		} else {
			System.out.println("SignIn Button  Not Displayed");
		}
		if(Signup_btn.isDisplayed()) {
			System.out.println("SignUp Button IS Dispalyed:"
									+Signup_btn.getText() );		
		} else {
			Reporter.log("SignUp Not Not Visible:");
		}
		
	}

	@Override
	public void FooterTab() {
		
		WebElement Footer = driver.findElement(By.xpath(".//*[@id='main-wrap']/footer"));
		((JavascriptExecutor) driver).executeScript(
										"arguments[0].scrollIntoView();", Footer);
		Pause(1000);
		String FooterTabs = Footer.getText();
			System.out.println("Footer Tab Elements : "+FooterTabs);		
	}

	
	public void HomePageText() {
		String Text=driver.findElement(By.cssSelector(".container")).getText();
		System.out.println("Home Page text:"+Text);
	}
	
	

	@Override
	public void VerifyImage(WebElement Element) {
		
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", Element);
        if (!ImagePresent)
        {
             System.out.println("Image not displayed.");
        }
        else
        {
            System.out.println("Image displayed."+Element.getAttribute("alt"));
        }
	}
	
	public static void CrossBrowser() {
		String NodeURl="";
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WIN8_1);
		try {
			driver = new RemoteWebDriver(new URL(NodeURl),capability);
			driver.navigate().to(url);
			driver.manage().window().maximize();
		} catch (MalformedURLException e) {
		}
	}

	
	}

