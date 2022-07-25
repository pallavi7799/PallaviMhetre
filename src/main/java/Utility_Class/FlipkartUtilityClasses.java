package Utility_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FlipkartUtilityClasses {
	WebDriver driver;
	public void actions(WebElement element) {
		
		Actions act= new Actions(driver);
      act.moveToElement(element).perform();
			}
	
}
