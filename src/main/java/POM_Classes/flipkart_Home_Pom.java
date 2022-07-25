package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class flipkart_Home_Pom{
	@FindBy (xpath ="//button[@class='_2KpZ6l _2doB4z']")private WebElement X_button;
	@FindBy (className="xtXmba")private WebElement Electronics;
	@FindBy (xpath="//span[@class='_2I9KP_']")public WebElement ElectronicsButton;
	@FindBy (xpath="(//a[@class='_3QN6WI'])[1]")private WebElement MiText;
	@FindBy (xpath="//div[text()='Newest First']")private WebElement NewestText;
 
public flipkart_Home_Pom(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void CancelLoginPopup() {
	X_button.click();
}
public void ClickonElectronics() throws InterruptedException {
	Electronics.click();
	Thread.sleep(1000);
}

public void clickonmiText() {
	MiText.click();

}
public String NewestMI() {
	String value = NewestText.getText();
	return value;
	
}

}
