package Test_classes;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base_Class.Base_class_Google_Map;
import POM_Classes.Google_map_Home_page;

public class Google_Map extends Base_class_Google_Map {

	Google_map_Home_page page1;
	
	@BeforeClass
	public void openBrowser()
	{
		LaunchBrowser();
		page1 = new Google_map_Home_page(driver);
	}
	
	@Test(priority = 0)
	public void searchLocation() throws InterruptedException, IOException
	{
		page1.sendText();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		page1.clickonsearchButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		takeScreenshot();
		int size = driver.findElements(By.tagName("iframe")).size();
	}
	
	@Test(priority = 1)
	public void verifyText()
	{
		String presentText = page1.VerifyText();
		presentText.contains("Stadium");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}
	
	@Test(priority = 2)
	public void VerifyTitle()
	{
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Wankhede Stadium - Google Maps";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}
	
	@Test(priority = 3)
	public void PrintReview_And_Ratings()
	{
		Reporter.log(page1.PrintRatings(),true);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		Reporter.log(page1.printReviews(),true);
	}
	
	@Test(priority = 4)
	public void VerifyLinkPresense()
	{
		WebElement link = page1.VerifyLink();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		link.isDisplayed();
	}
	
	@Test(priority = 5)
	public void printAddress()
	{
		Reporter.log(page1.print_address(),true);
	}
	
	@Test(priority = 6)
	public void VerifyPhoneNumber() throws IOException
	{
		String Actualnumber = page1.verifyNumber();
		String ExpectedNumber = "022 2279 5500";
		Assert.assertEquals(Actualnumber, ExpectedNumber);
		takeScreenshot();
	}
}
