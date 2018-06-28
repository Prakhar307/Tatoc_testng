package tatocautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Famedungeon {
	WebDriver driver;
	private WebElement box1,box2;
	String box1color, box2color;
	boolean check=true;
	
	public Famedungeon(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void box1color()
	{
		box1=driver.findElement(By.id("answer"));
		box1color=box1.getAttribute("class");
		
	}
	
	public void box2color() {
		
		driver.switchTo().frame("child");
		box2=driver.findElement(By.id("answer"));
		box2color=box2.getAttribute("class");
		driver.switchTo().parentFrame();
		
	}
	public void repaint() 
	
	{
		driver.findElement(By.linkText("Repaint Box 2")).click();
	}
	
	public void proceed() {
		
		driver.findElement(By.linkText("Proceed")).click();
	}
	
	public void differentcolor()
	{
		driver.switchTo().frame("main");
		proceed();
	}
	public void samecolor()
	{
		driver.switchTo().frame("main");
		box1color();
		box2color();
		while(check)
		{
			if(box1color.equals(box2color))
			{
				check=false;
			}
			else
			{
				repaint();
			box2color();
			
		}}
		proceed();
	}
	
	public String getObstacleName() {
		driver.switchTo().parentFrame();
		return driver.findElement(By.xpath("/html/body/div[1]/div[2]/h1")).getText();
	}

}
