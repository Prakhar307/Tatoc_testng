package tatocautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Box {
	WebDriver driver;
	public Box (WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
        @FindBy(className="redbox")
        WebElement redbox;
        
        @FindBy(className="greenbox")
        WebElement greenbox;
	
	public void clickgreenBox()
	{
		greenbox.click();
		
	}
	public void clickredBox()
	{
		redbox.click();
	}
	  public String getObstacleName() {
		return driver.findElement(By.xpath("/html/body/div[1]/div[2]/h1")).getText();
	}
}
