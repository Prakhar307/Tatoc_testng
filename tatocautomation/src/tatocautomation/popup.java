package tatocautomation;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class popup {
	WebDriver driver;
	
	public popup(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Launch Popup Window")
	private WebElement launchPopUp;
	
	@FindBy(linkText="Proceed")
	private WebElement proceed;
	
	public void proceed() {
		proceed.click();
	}
	
	public void emptySubmitPopUp() {
		launchPopUp.click();
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		driver.findElement(By.id("submit")).click();
		driver.switchTo().window(windowHandles.get(0));
		proceed.click();
		
	}
	
	public void textSubmitPopUp() {
		launchPopUp.click();
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
    	driver.findElement(By.id("name")).sendKeys("Prakhar");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().window(windowHandles.get(0));
		proceed.click();
	}
	
	public String getObstacleName() {
		return driver.findElement(By.cssSelector("div.page > h1")).getText();
	}
	

}
