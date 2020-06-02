package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base {
	
	By userLocator = By.name ("userName");
	By passLocator = By.name ("password");
	By signInBtnLocator = By.name("login"); 
	
	By homePageLocator = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void SignIn() {
		if (isDisplayed(userLocator)) {
			type("DavidAdmin", userLocator);
			type("123456", passLocator);
			click(signInBtnLocator);
		} else {
			System.out.print("username textbox was npt found");
			}
			
			
		}
		
		
	public Boolean isHomePageDisplayed () {
		
		return isDisplayed(homePageLocator);
	}

}
