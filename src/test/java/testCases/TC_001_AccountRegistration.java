package testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountRegPage;
import testBase.BaseClass;

@Test(groups= {"regression","master"})
public class TC_001_AccountRegistration extends BaseClass
{
	
	public void test_acc_reg() throws IOException
	{
		driver.get("https://demo.opencart.com/");
		logger.info("Homepage Displayed");
		driver.manage().window().maximize();
		
		AccountRegPage regPage=new AccountRegPage(driver);
		regPage.setFirstName("kushal");
		logger.info("Provided First Name");
		 
		regPage.setLastName("soni");
		regPage.setEmail(randomeString()+"@gmail.com");
		regPage.setPassword("Kushal@987");
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		String conmsg=regPage.getConMsg();
		if(conmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"Test_account_registration");
			Assert.assertTrue(false);
		}
		
	}

}
