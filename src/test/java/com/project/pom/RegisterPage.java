package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class RegisterPage extends Base {
	
	//Elementos de la página de registro
	
		By registerLinkLocator = By.linkText("REGISTER");
		By registerPageLocator = By.xpath("//img[@src=\"/images/masts/mast_register.gif\"]");
		
		By useridLocator = By.id("email");
		By userPasswordLocator = By.name("password");
		By confirmPasswordLocator =By.cssSelector("input[name='confirmPassword']");
		
		By registerBtnLocator = By.name("register");
		
		By registeredMessage = By.tagName("font");

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Method rigister user, llamar al method click de la clase base
	public void registerUser() throws InterruptedException {
		click(registerLinkLocator);
		Thread.sleep(2000);
		//method de la clase base
		if(isDisplayed(registerPageLocator)) {
			type("DavidAdmin", useridLocator);
			type("123456", userPasswordLocator);
			type("123456", confirmPasswordLocator);
			Thread.sleep(2000);
			click(registerBtnLocator);
			
		}else {
			System.out.println("Register page not Found");
		}
	}
	
		public String registeredMessage() {

		List<WebElement> fonts = findElements(registeredMessage);
		return getText(fonts.get(5));
	}

}
