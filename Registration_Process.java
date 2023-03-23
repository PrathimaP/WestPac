package BuggyCar_Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Registration_Process 
{
	
	public static void main(String[] args) {

        
		//Initializing Chromedriver
		
		Generic_Attributes attr = new Generic_Attributes();
		WebDriver dr = attr.launchBrowser("Chrome");
		attr.launchURL("https://buggy.justtestit.org/");
		
		dr.manage().window().maximize();
		
		By registeration = By.linkText("Register");
		attr.doClick(registeration);
		
		
		//Scroll down the registration page
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("window.scrollBy(0,500)");
		
		//Filling Details in registration page
		By loginText = By.id("username");
		By firstname = By.id("firstName");
		By lastname = By.id("lastName");
		By pwd = By.id("password");
		By confirm_pwd = By.id("confirmPassword");
		By register_btn = By.xpath("//button[@class='btn btn-default']");
		
		attr.doSendKeys(loginText, "TestLogin2");
		attr.doSendKeys(firstname, "Testing");
		attr.doSendKeys(lastname, "dummy account");
		attr.doSendKeys(pwd, "Password@01");
		attr.doSendKeys(confirm_pwd, "Password@01");
		attr.doClick(register_btn);
		
		System.out.println("Registration is successful");
		
		dr.close();
	}

}
