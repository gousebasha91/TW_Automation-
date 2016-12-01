package bin.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import bin.Pages.SignInPage;
import bin.Utility.Utility;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class SignInPageTest extends Utility {
	
	Utility utility = new Utility();
	
 
  
@BeforeMethod
public void beforemethod() {
	 
	  Pause(1000);
	  utility.Printlinks();
	  utility.ValidateBrokenlinks();
}
			
	@Test
	public void test04() {
			
		utility.ClickOnlinks("SIGNIN");
		utility.Pause(2000);
		utility.SignIn();
			
		  
	} 

		
}
	
	
	