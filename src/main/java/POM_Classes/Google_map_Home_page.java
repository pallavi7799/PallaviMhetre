package POM_Classes;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google_map_Home_page {
	
	@FindBy(name = "q") private WebElement  searchbox;
	@FindBy(xpath = "//button[@id='searchbox-searchbutton']") private WebElement searchbutton;
	@FindBy(xpath = "//h1//span[text()='Wankhede Stadium']") private WebElement Text;
	@FindBy(xpath = "(//div[@class='LBgpqf']//span[@aria-hidden='true'])[1]") private WebElement ratings;
	@FindBy(xpath = "(//button[@class='DkEaL'])[1]")private WebElement reviews;
	@FindBy(xpath = "(//div[@class='rogA2c ITvuef'])") private WebElement Link;
	@FindBy(xpath = "(//div[@class='Io6YTe fontBodyMedium'])[1]") private WebElement Address;
	@FindBy(xpath = "(//div[@class='Io6YTe fontBodyMedium'])[3]")private WebElement PhoneNumber;
	public Google_map_Home_page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void sendText()
	{
		searchbox.sendKeys("Wankhede Stadium");
	}
	
	public void clickonsearchButton()
	{
		searchbutton.click();
	}
	
	public String VerifyText()
	{
		 return Text.getText();
	}
	
	public String PrintRatings()
	{
		String Ratings = ratings.getText();
		return Ratings;
	}
	
	public String printReviews()
	{
		String Reviews = reviews.getText();
		return Reviews;
	}
	 
	public WebElement VerifyLink()
	{
		 WebElement ActualLink = Link;
		return ActualLink;
	}
	
	public String print_address()
	{
		return Address.getText();
	}
	
	public String verifyNumber()
	{
		return PhoneNumber.getText();
	}

	
	
}
