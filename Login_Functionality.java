package BuggyCar_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Functionality {

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
				
		By logout_btn = By.linkText("Logout");
		
		String btn_text = attr.doGetElementText(logout_btn);
		
		if (btn_text.equals("Logout"))
		{
			System.out.println("Login is SUCCESSFUL");
		}

		else
		{
			System.out.println("Login is UNSUCCESSFUL");
		}
		
		dr.close();
	}

}
