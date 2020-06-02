package com.project.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SignIn_Test {

	private WebDriver driver;
	SignInPage sigInPage;
	
	
	@Before
	public void setUp() throws Exception {
		sigInPage = new SignInPage(driver);
		driver = sigInPage.chromeDriverConnection();
		sigInPage.visit("http://newtours.demoaut.com/mercurywelcome.php");
	}

	@After
	public void tearDown() throws Exception {
		//return quit();
	}

	@Test
	public void test() throws InterruptedException {
		sigInPage.SignIn();
		Thread.sleep(4000);
		assertTrue(sigInPage.isHomePageDisplayed());
	}

}
