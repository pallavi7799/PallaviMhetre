package Test_classes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Redbus_Test_Class { 
	 WebDriver driver;
	
  @BeforeClass
  public void LaunchBrowser() 
  {
	   System.setProperty("webdriver.chrome.driver", "G:\\chromedriver101\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
  }
  @Test
  public void SearchBus()
  {
	  WebElement Source = driver.findElement(By.id("src"));
	  Source.sendKeys("Mumbai");
	  driver.findElement(By.xpath("//li[@select-id='results[0]']")).click();
	  WebElement Destination = driver.findElement(By.id("dest"));
	  Destination.sendKeys("Pune");
	  driver.findElement(By.xpath("//li[@select-id='results[0]']")).click();
	  driver.findElement(By.id("onward_cal")).click();
	  driver.findElement(By.xpath("//td[@class='current day']")).click();
	  driver.findElement(By.id("search_btn")).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
  }
  
  @Test
  public void CaptureAllBusDetails() throws InterruptedException
  {
	  Thread.sleep(1500);
	 // driver.findElement(By.xpath("//div[@class='close-primo']")).click();
	  driver.findElement(By.xpath("(//span[@class='d-color'])[1]")).click();
	  Thread.sleep(100);
	  driver.findElement(By.xpath("//a[text()='Ratings']")).click();
	  WebElement rating = driver.findElement(By.xpath("//div[@class='column-six p-right-10 w-10 fl']"));
	  rating.getText();
  }
  
}
