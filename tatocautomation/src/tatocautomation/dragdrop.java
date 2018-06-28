package tatocautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dragdrop {
	WebDriver driver;
	
	public dragdrop(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dragbox")
	private WebElement source;
	
	@FindBy(id="dropbox")
	private WebElement target;
	
public void proceed() {
		
		driver.findElement(By.linkText("Proceed")).click();
	}
 public void nodrag()
 {
	 proceed();
 }
  public void drag()
  {
	  Actions a=new Actions(driver);
	  a.dragAndDrop(source,target).build().perform();
	  proceed();
	  
  }
  public String getObstacleName() {
		return driver.findElement(By.cssSelector("div.page>h1")).getText();
	}

}
