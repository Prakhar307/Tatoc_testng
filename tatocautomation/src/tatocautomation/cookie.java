package tatocautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.Cookie;

public class cookie {

	WebDriver driver;
	String token, token_value;
	Cookie name;
	public cookie(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Generate Token")
	private WebElement generate_token;
	
	@FindBy(linkText="Proceed")
	private WebElement proceed;
	
	public void generateToken()
	{
		generate_token.click();
		
	}
	public void proceed()
	{
		proceed.click();
	}
	public void getToken()
	{
		token = driver.findElement(By.id("token")).getText();
	}
	public void getTokenValue() {
		token_value = token.substring(7, token.length());
	}
	
		
	public void generateCookie(String value) {
	    name = new Cookie("Token", value);
	}
	
	public void addWrongCookie() {
		generateToken();
		getToken();
		generateCookie(token);
		driver.manage().addCookie(name);
	}
	
	public void addCorrectCookie() {
		generateToken();
		getToken();
		getTokenValue();
		generateCookie(token_value);
		driver.manage().addCookie(name);
	}
	
	public String getObstacleName() {
		return driver.findElement(By.cssSelector("div.page > h1")).getText();
	}

}
