package POM_Classes;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlipkartMiPagePOM{
	@FindBy (className ="_3FdLqY")public WebElement PriceSlider;
	@FindBy (xpath = "(//div[@class='_1ftpgI'])[3]")public WebElement MaxPrice;
    @FindBy (className="_2YxCDZ")private WebElement MaxPriceDropBox;
    @FindBy (name="q")private WebElement Searchbox; 
    @FindBy (className = "_4rR01T")private WebElement RedmiPhone;
    @FindBy (className = "_30jeq3 _16Jk6d")private WebElement Price;
    @FindBy (xpath="//div[@class='_2usHgU']")private WebElement videothumbnails;
    @FindBy (className = "_1JqCrR")private WebElement Videoframe;
    @FindBy (className = "_1BweB8")private WebElement Playvideo;
public FlipkartMiPagePOM(WebDriver driver){
	PageFactory.initElements(driver,this);}
public void Select3rdMaxPrice() {
	Select s= new Select(MaxPriceDropBox);
	s.selectByIndex(2);
	
}
public void sendSearchText() {
	Searchbox.sendKeys("redmi go(black,8 gb)"+Keys.ENTER);
}
public void CLickon1stDisplayedProduct() {
	RedmiPhone.click();
	
}
public void switchtoPhonePage(WebDriver driver) {
	Set<String> handles = driver.getWindowHandles();
	System.out.println(handles);
	ArrayList<String> ar=new ArrayList<String>(handles);
	String ParentPageid = ar.get(0);
	String childPageid = ar.get(1);
	driver.switchTo().window(childPageid);
	
	
}
public String getPrice() {
	String Value = Price.getText();
	return Value;
}
public void ClickOnvideoIframe(WebDriver driver) {
	driver.switchTo().frame(Videoframe);
	Playvideo.click();	
}
}
