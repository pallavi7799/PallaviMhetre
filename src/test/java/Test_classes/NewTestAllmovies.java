package Test_classes;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTestAllmovies {
	WebDriver driver;
  @BeforeClass
  public void launchbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver101\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.allmovie.com");
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	}
  @Test(priority = 1)
  public void f() throws InterruptedException
  {
		WebElement Searchbox = driver.findElement(By.xpath("//input[@type='search']"));
		Searchbox.click();
		Searchbox.sendKeys("God Father");
		WebElement Searchbutton = driver.findElement(By.xpath("//input[@type='submit']"));
		Searchbutton.click();
		Thread.sleep(1000);
				
		WebElement searchresult1 = driver.findElement(By.xpath("//h1[contains(text(),'search results')]"));
		System.out.println(searchresult1.getText());
		
    	List<WebElement> searchresult = driver.findElements(By.xpath("//li[@class='movie']//div[@class='title']"));
		for(WebElement S:searchresult) 
		{
			System.out.println(S.getText());
		}
    	String ExpectedResult = "The Godfather (1972)";
		for(WebElement R:searchresult) 
		{
			String ActualResult = R.getText();
			WebElement thegodfatherimage = driver.findElement(By.xpath("(//img[@class='lazy'])[1]"));
			if(ActualResult.equals(ExpectedResult)) 
			{
				JavascriptExecutor js = ((JavascriptExecutor)driver);
		        js.executeScript("window.scrollBy(50,300)");
				thegodfatherimage.click();
				break;
			}
		}	
  }
  
  @Test(priority = 2)
  public void verifyMovieGener()
  {
	    WebElement moviegener = driver.findElement(By.xpath("//span[@class='header-movie-genres']"));
		System.out.println(moviegener.getText());
		String gener = moviegener.getText();
		System.out.println(gener.contains("Crime")+"  movie gener is crime");
  }
  
  @Test(priority = 3)
  public void verifyDirectorName() throws InterruptedException
  {   
	  driver.findElement(By.xpath("//li[@class='tab cast-crew']")).click();
	  Thread.sleep(1000);
	  String DrirectorName = "Francis Ford Coppola";
	  JavascriptExecutor js = ((JavascriptExecutor)driver);
      js.executeScript("window.scrollBy(50,300)");
	  WebElement ActaulDirectorName = driver.findElement(By.xpath("(//dt[@class='name artist-name'])[1]"));
	  Assert.assertEquals(DrirectorName, ActaulDirectorName.getText(),"TectCase is Failled,Director names are not matching");
	  Reporter.log("TC is passed");
  }
}

