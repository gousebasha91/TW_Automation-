package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bin.Utility.BrowserConfig;

public class SigInPage extends BrowserConfig {
	
	@FindBy(id="exampleInputEmail1")
	private WebElement Email=driver.findElement(By.id("exampleInputEmail1"));
	
	@FindBy(id="exampleInputPass1")
	private WebElement Password;
	
	@FindBy(className="submit-btn-edge")
	private WebElement SubmitButton;
	
	@FindBy(xpath="//a[contains(text(),'forgot your password?')]")
	private WebElement ForGetPassword_lnk;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement CheckBox;
	
	@FindBy(linkText="Create an account")
	private WebElement CreateAC;
	
	@FindBy(partialLinkText="Checkout as a Guest")
	private WebElement ChecKoutlink;
	
	
public void EnterMail(String UserName){
		
		this.Email.sendKeys(UserName);
	}
	
	public void EnterPassWord(String PassWord) {
		this.Password.sendKeys(PassWord);
	}
	
	
	public void ClickButton() {
		
		this.SubmitButton.click();
	}

}
