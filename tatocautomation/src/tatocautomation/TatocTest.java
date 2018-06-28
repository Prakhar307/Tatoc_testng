package tatocautomation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TatocTest {

	WebDriver driver;
	String url = "http://10.0.1.86/tatoc";
			
	
		@BeforeTest
		public void launchbrowser()
			{
			driver= new ChromeDriver();
		driver.get(url);
		List<WebElement> res=driver.findElements(By.tagName("a"));
		res.get(0).click();
			}
		@Test(priority=0)
		public void getRed()
		{
			Box box =new Box(driver);
			box.clickredBox();
			Assert.assertTrue(box.getObstacleName().contains("Error"));
		}
		
		@Test(priority=1)
		public void getGreen()
		{
			Box box =new Box(driver);
			driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
			box.clickgreenBox();
			Assert.assertTrue(box.getObstacleName().contains("Frame Dungeon"));
		}
		
		@Test(priority=2)
		public void differentcolor()
		{
			Famedungeon fd=new Famedungeon(driver);
			fd.differentcolor();
			Assert.assertTrue(fd.getObstacleName().contains("Error"));
		}
		@Test(priority=3)
		public void samecolor()
		{
			driver.get("http://10.0.1.86/tatoc/basic/frame/dungeon");
			Famedungeon fd=new Famedungeon(driver);
			fd.samecolor();
			Assert.assertTrue(fd.getObstacleName().contains("Drag Around"));
		}
		@Test(priority=4)
		public void nodrag()
		{
			dragdrop dd=new dragdrop(driver);
			dd.proceed();
			Assert.assertTrue(dd.getObstacleName().contains("Error"));
			
		}
		@Test(priority=5)
		public void drag()
		{
			
			driver.get("http://10.0.1.86/tatoc/basic/drag");
			dragdrop dd=new dragdrop(driver);
			dd.drag();
			Assert.assertTrue(dd.getObstacleName().contains("Popup Window"));
		}
		
		
		@Test(priority=6)
		public void popUpNotOpen() {
			popup obj = new popup(driver);
			obj.proceed();
			Assert.assertFalse(obj.getObstacleName().contains("Cookie Handling"));
		}
		
	  	  @Test(priority=7)
		public void emptySubmitPopUp() {
			driver.get("http://10.0.1.86/tatoc/basic/windows");
			popup obj = new popup(driver);
			obj.emptySubmitPopUp();
			Assert.assertFalse(obj.getObstacleName().contains("Cookie Handling"));
		}
	    
	  	 @Test(priority=8)
		public void textSubmitPopUp() {
			driver.get("http://10.0.1.86/tatoc/basic/windows");
			popup obj = new popup(driver);
			obj.textSubmitPopUp();
			Assert.assertTrue(obj.getObstacleName().contains("Cookie Handling"));
		}
	  	 @Test(priority=9)
	  	 public void nocookiegenerated()
	  	 { driver.get("http://10.0.1.86/tatoc/basic/cookie#");
	  		 cookie c=new cookie(driver);
	  		 c.proceed();
	  		 Assert.assertFalse(c.getObstacleName().contains("End"));
	  	 }
	  		 

          @Test(priority=10)
          public void addwrongcookie(){
        	  driver.get("http://10.0.1.86/tatoc/basic/cookie#");
        	  cookie c=new cookie(driver);
        	  c.addWrongCookie();
        	  c.proceed();
        		 Assert.assertFalse(c.getObstacleName().contains("End"));
        	  
	
	
}
          @Test(priority=11)
          public void addcorrectcookie()
          {
        	  driver.get("http://10.0.1.86/tatoc/basic/cookie#");
          cookie c=new cookie(driver);
          c.addCorrectCookie();
          c.proceed();
     	 Assert.assertTrue(c.getObstacleName().contains("End"));;
          }
		
		
		

	  	 @AfterTest
		public void closeBrowser() throws InterruptedException {
			Thread.sleep(2000);
			driver.close();
		}
		
	}
