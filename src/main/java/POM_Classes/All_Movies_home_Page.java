package POM_Classes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class All_Movies_home_Page 
{
	WebDriver driver;
	@FindBy(xpath = "//input[@type='search']")private WebElement searchbox;
	@FindBy(xpath = "//input[@type='submit']")private WebElement Searchbutton;
	@FindBy(xpath = "//h1[contains(text(), 'search result')]")private WebElement ResultText;
	@FindBy(xpath = "//div[@class='title']") private WebElement movieName;
	 
	public All_Movies_home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendMovieName()
	{
		searchbox.click();
		searchbox.sendKeys("The Godfather");
	}
	
	public void CliconSearchbutton()
	{
		Searchbutton.click();
	}
	
	public String printResult()
	{
		
		 return ResultText.getText();
	}
	
	public String PrintMovieResults() throws InterruptedException
	{ 
		
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        
        js.executeScript("window.scrollBy(50,500)");
        
        return movieName.getText();
		
		}
	}

