package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {
	
	private WebDriver driver;
	//Elementos de la página de registro
	
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src=\"/images/masts/mast_register.gif\"]");
	
	By useridLocator = By.id("email");
	By userPasswordLocator = By.name("password");
	By confirmPasswordLocator =By.cssSelector("input[name='confirmPassword']");
	
	By registerBtnLocator = By.name("register");
	
	//Elementos de la pagin Sign In
	By userLocator = By.name ("userName");
	By passLocator = By.name ("password");
	By signInBtnLocator = By.name("login"); 
	
	By homePageLocator = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void registerUser() throws Exception {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(useridLocator).sendKeys("DavidAdmin");
			driver.findElement(userPasswordLocator).sendKeys("123456");
			driver.findElement(confirmPasswordLocator).sendKeys("123456");
			
			driver.findElement(registerBtnLocator).click();			
		}
		else {
			
			System.out.print("Register page not found");
		}
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
		assertEquals("Note: Your user name is DavidAdmin.",fonts.get(5).getText());
	}
	
	
	@Test
	public void signIn() throws InterruptedException {
		
		if(driver.findElement(userLocator).isDisplayed()){
			driver.findElement(userLocator).sendKeys("DavidAdmin");
			driver.findElement(passLocator).sendKeys("123456");
			driver.findElement(signInBtnLocator).click();
			Thread.sleep(2000);
			
			assertTrue(driver.findElement(homePageLocator).isDisplayed());
		}
			else
				System.out.println("user name tect box nos found");
        	}	
				
	

}
