package BuggyCar_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Generic_Attributes {

	WebDriver driver;
	
	public Generic_Attributes()
	{
		this.driver = driver;
	}
	
	public WebDriver launchBrowser(String browserName)
	{

		//To handle Websocket connection failure with Chrome v111.xxx
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		return driver;
	}
	
	public void launchURL(String url)
	{
		driver.get(url);
	}
	
	public WebElement getElement(By locator)
	{
		return driver.findElement(locator); 
	}
	

	//Generic function for sendKeys()
	public void doSendKeys(By locator, String input_value)
	{
		getElement(locator).sendKeys(input_value);
		
	}
	
	//Generic function for click()
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	
	//Generic function to get element text
	public String doGetElementText(By locator)
	{
		return getElement(locator).getText();
	}

	//Generic function to get attribute
	public String doGetAttributeValue(By locator, String attrName)
	{
		return getElement(locator).getAttribute(attrName);
	}
}
