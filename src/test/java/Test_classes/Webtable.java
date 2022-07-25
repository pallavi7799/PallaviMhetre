package Test_classes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Webtable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver101\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	    WebElement dropbox = driver.findElement(By.xpath("//select[@name='example_length']"));
	    Select s= new Select(dropbox);
	    s.selectByValue("25");
	    driver.findElement(By.xpath("(//th[text()='Age'])[1]")).click();
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Software Engineer");
	    
	   List<WebElement> Heading = driver.findElements(By.xpath("//div//table//thead//tr//th"));
	   int totalheadings = Heading.size();
	   System.out.println("Total headings= "+totalheadings);
	   for(int i=1;i<=totalheadings;i++)
	   {
		   WebElement heading = driver.findElement(By.xpath("//div//table//thead//tr//th["+i+"]"));
		   System.out.print( heading.getText()+" ");
	   }
	   System.out.println();
	  List<WebElement> row = driver.findElements(By.xpath("//table//tbody//tr"));
	  int totalrows = row.size();
	  
	  List<WebElement> column = driver.findElements(By.xpath("//table//thead//tr//th"));
	  int totalcolumn = column.size();
	   
	  WebElement age = driver.findElement(By.xpath("//td[@class='dt-body-right sorting_1']"));
	  String Age1 = age.getText();
	  
	   for(int j=1;j<=2;j++) 
		{
			for(int k=1;k<=totalcolumn;k++)
			{
				WebElement tabledata = driver.findElement(By.xpath("//div[@id='example_wrapper']//table//tbody//tr["+j+"]//td["+k+"]"));
				String data = tabledata.getText();
				System.out.print(data+" ");
			}
			System.out.println();
		}
	    

	}

}
