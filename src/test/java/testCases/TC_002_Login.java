package testCases;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass
{
	@Test(groups= {"sanity","master"})
	public void test_Login() throws IOException
	{
		logger.info("Starting TC_002_Login");
		
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		logger.info("Provided Email and Password");
		lp.clickLogin();
		boolean targetPage=lp.isMyAccPageExists();
		if(targetPage)
		{
			Assert.assertTrue(true);
			logger.info("Login Successful");
		}
		else
		{
			logger.error("Login Failed");
			captureScreen(driver,"test_Login");
			Assert.assertTrue(false);
		}
		logger.info("Finished TC_002_Login");
	}
	
	

}
