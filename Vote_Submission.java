package BuggyCar_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Vote_Submission {

	public static void main(String[] args) {
		
		
		//Initializing Chromedriver
		Generic_Attributes attr = new Generic_Attributes();
		WebDriver dr = attr.launchBrowser("Chrome");
		attr.launchURL("https://buggy.justtestit.org/");
		dr.manage().window().maximize();
		
		
		By login_name = By.xpath("//input[@name='login']");
		By pwd = By.xpath("//input[@name='password']");
		By login_btn = By.xpath("//button[@class='btn btn-success']");
		
		attr.doSendKeys(login_name, "TestLogin");
		attr.doSendKeys(pwd, "Password@01");
		attr.doClick(login_btn);
		
		By img = By.xpath("//img[@src='/img/cars/giulia.png']");
		attr.doClick(img);
		
		//Scroll down the registration page
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("window.scrollBy(0,500)");
				
		//Entering text message in comments section		
		By comment_field = By.id("comment");
		
		attr.doSendKeys(comment_field, "Dummy message");
		
		//Clicking 'Vote' button
		By vote_btn = By.linkText("Vote!");
		attr.doClick(vote_btn);
		
		By success_msg = By.linkText("Thank you for your vote!");
		
		String msg = attr.doGetElementText(success_msg);
		
		if(msg.contains("Thank you"))
		{
			System.out.println("Voting is successful");
		}
		
		else
		{
			System.out.println("Voting is unsuccessful");
		}

		dr.close();

	}

}
