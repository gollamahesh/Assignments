package common;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class common {

	WebDriver driver;
	Actions act;
	//start browser
	
	public void startchrome(String url)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Mahesh\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(url);
	}
	
	//start firefox browser
	
	public void startfirefox(String url)
	{
		driver=new FirefoxDriver();
		driver.navigate().to(url);
	}
	
	//maximize browser
	
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	
	//webelements for locators
	
	public WebElement webelementid(String identifier,String locator)
	{
		WebElement e=null;
		switch(identifier) {
		
		case "id":
			
			e=driver.findElement(By.id(locator));
			break;
case "className":
			
			e=driver.findElement(By.className(locator));
			break;
		
case "tagName":
	
	e=driver.findElement(By.tagName(locator));
	break;

case "name":
	
	e=driver.findElement(By.name(locator));
	break;

case "linkText":
	
	e=driver.findElement(By.linkText(locator));
	break;
	
case "xpath":
	
	e=driver.findElement(By.xpath(locator));
	break;
	
	default:
		System.out.println("locator not found");
e=null;
		}
		return e;
	}
	
	//sendkeys method
	
	public void sendKeys(String identifier,String locator,String content)
	{
		WebElement e=webelementid(identifier,locator);
		e.sendKeys(content);
	}
	
	//clear text field method
	
	public void clearText(String identifier,String locator)
	{
		
		WebElement e=webelementid(identifier,locator);
		e.clear();
	}
	
	//verify title of the page
	
	public void verifyTitle(String title)
	{
		if(driver.getTitle().equals(title))
		{
			System.out.println("title is" +title+  "is displayed ");
		}
		else
		{
			System.out.println("title is" +title+  "is not displayed ");
		}
	}
	
	//verify text
	
	public void verifyText(String identifier,String locator,String text)
	{
		WebElement e=webelementid(identifier,locator);
		if(e.getText().equals(text))
		{
			System.out.println(text+" is displayed");
		}
		else
		{
			System.out.println(text+" is not displayed");
		}
	}
	
	//verify element present
	
	public void verifyElementPresent(String identifier,String locator)
	{
		WebElement e=webelementid(identifier, locator);
		if(e.isDisplayed())
		{
			System.out.println("Element is present");
		}else
		{
			System.out.println("failed to display element");
		}
	}
	
	//thread sleep
	
	public void sleep(long sleeptime)
	{
		
		try {
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//wait for pagetoload
	public void waitForPage()
	{
		for(int i=0;i<50;)
		{
			if(driver.getTitle().length()!=0)
			{
				System.out.println("page loaded");
				i=51;
				break;
			}else
			{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}
		}
	}
	
	//select frame by id
	
	public void selectFrameById(String locator)
	{
		driver.switchTo().frame(locator);
	}
	
	//select default frame
	
	public void selectFrameDefault()
	{
		driver.switchTo().defaultContent();
	}
	
	//getting data from table and verifying with required text
	public void verifyElememtInTable(String locator,String text)
	{
		boolean a=false;
		
		List<WebElement> tdlist=driver.findElements(By.xpath(locator));
		for(WebElement el:tdlist)
		{
			if(el.getText().equals(text))
			{
				a=true;
				break;
			}
		}
		if(a==true)
		{
			System.out.println("element is verified");
		}else
		{
			System.out.println("element is not verified");
		}
	}
	
	//start action
	
	public void startAction()
	{
		act=new Actions(driver);
	}
	
	//move to element
	
	public void moveMouseOverToElement(String identifier,String locator)
	{
		WebElement e=webelementid(identifier, locator);
		act.moveToElement(e).perform();
	}
	
	//closing 
	
	public void close()
	{
		driver.close();
	}
	
	//quitting
	
	public void quit()
	{
		driver.quit();
	}
}


