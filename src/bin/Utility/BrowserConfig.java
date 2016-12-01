package bin.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BrowserConfig extends Utility {
	
	private static String URL = "http://www.tutorsweb.com";
	private static Properties Property;
	private static final String ChromeDriverPath = System.getProperty("user.dir")+"\\bin\\bin\\Jar Files\\chromedriver.exe"; 
	private static final String IEDriverPath = System.getProperty("user.dir")+"\\bin\\bin\\Jar Files\\IEDriverServer.exe";
	private static File chrome; 
	private static File IE;
	
	public static void StartBrowser(String Browser) {
		
		chrome =  new File(ChromeDriverPath);	
		IE=new File(IEDriverPath);
		
		if(driver==null) {
			
			if(Browser.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
				driver = new ChromeDriver();
				System.out.println("=====Browser Launched Sucessfully=====");
			}
			else if(Browser.equalsIgnoreCase("firefox")) {
				
				driver = new FirefoxDriver();
								
			} else if(Browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",IE.getAbsolutePath());
				driver=new InternetExplorerDriver();
				
			}
			driver.navigate().to(URL);
			driver.manage().window().maximize();	
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			
		}
	
				
	}

}
		
		
	
