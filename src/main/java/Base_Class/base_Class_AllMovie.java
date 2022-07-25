package Base_Class;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class base_Class_AllMovie
{
	protected static WebDriver driver;
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver101\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.allmovie.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	}
	
	

}
