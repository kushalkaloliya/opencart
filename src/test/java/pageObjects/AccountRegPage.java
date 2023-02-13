package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class AccountRegPage 
{
	WebDriver driver;
	
	public AccountRegPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Locators
	@FindBy(name="firstname")
	WebElement fname;
	@FindBy(name="lastname")
	WebElement lname;
	@FindBy(name="email")
	WebElement email;
	@FindBy(name="password")
	WebElement pwd;
	@FindBy(name="agree")
	WebElement pri;
	@FindBy(xpath="//button[@type='submit']")
	WebElement con;
	//@FindBy(xpath="")
	//WebElement conf;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement conf;
	
	public void setFirstName(String fnm)
	{
		fname.sendKeys(fnm);
	}
	public void setLastName(String lnm)
	{
		lname.sendKeys(lnm);
	}
	public void setEmail(String mail)
	{
		email.sendKeys(mail);
	}
	public void setPassword(String pasw)
	{
		pwd.sendKeys(pasw);
	}
	public void setPrivacyPolicy()
	{
		pri.click();
	}
	public void clickContinue()
	{
		con.click();
	}
	public String getConMsg()
	{
		try
		{
			return(conf.getText());
		}
		catch (Exception e) 
		{
			return(e.getMessage());
		}
	}
	



}
