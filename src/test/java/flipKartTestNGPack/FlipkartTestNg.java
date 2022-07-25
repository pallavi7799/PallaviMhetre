package flipKartTestNGPack;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base_Class.BaseClasses;
import POM_Classes.FlipkartMiPagePOM;
import POM_Classes.flipkart_Home_Pom;
import Utility_Class.FlipkartUtilityClasses;

public class FlipkartTestNg extends BaseClasses {
	flipkart_Home_Pom home;
	FlipkartUtilityClasses util;
	FlipkartMiPagePOM Mipage;
	Actions act;
	@BeforeClass
	 public void launchbrowser() {
		  openbrowser();
		  home=new flipkart_Home_Pom(driver);
		  util=new FlipkartUtilityClasses();
		  Mipage=new FlipkartMiPagePOM(driver);
		  act=new Actions(driver);
	  }
	@BeforeMethod
	public void beforeTest() throws InterruptedException {
		Thread.sleep(1000);
		home.CancelLoginPopup();
		home.ClickonElectronics();
		Thread.sleep(1000);
		act.moveToElement(home.ElectronicsButton).clickAndHold().build().perform();
		home.clickonmiText();}
  @Test
  public void VerifyText() throws InterruptedException {
	  Thread.sleep(1000);
    String ActualText = home.NewestMI();
    String ExpectedText = "Newest First";
    Assert.assertEquals(ActualText, ExpectedText,"TC failed Text didn't matched ");
    Reporter.log("TC passed Text Matched",true);
  //Changing Price filter Using actions class and Selecting 3rd Highest Price
    act.moveToElement(Mipage.PriceSlider).clickAndHold().moveToElement(Mipage.MaxPrice).build().perform();
    Thread.sleep(1000);
  //selecting 3rd max price from dropbox
	  Mipage.Select3rdMaxPrice();
	  //send keys
	 Thread.sleep(1000);
	  Mipage.sendSearchText();
	  //click on 1st product
	  Mipage.CLickon1stDisplayedProduct();
	  //Switchto childepage
	  Mipage.switchtoPhonePage(driver);
	  String Actualprice = Mipage.getPrice();
	  String ExpectedPrice="5999";
	  Assert.assertEquals(Actualprice, ExpectedPrice,"TC failed Price didn't matched");
	  Reporter.log("TC Passed Price Matched",true);
  }
  @AfterMethod
  public void CloseBrowser() {
	  driver.quit();
	  
  }
}
