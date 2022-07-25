package Base_Class;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;

public class Base_class_Google_Map {
	protected static WebDriver driver;
	
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver101\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/maps/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	}

	    public void takeScreenshot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String random = RandomString.make(3);
		File dest = new File("G:\\Automation testing\\Selenium\\ScreenShots\\" +random+".png");
		FileHandler.copy(src, dest);
    }
	    
	    
}
