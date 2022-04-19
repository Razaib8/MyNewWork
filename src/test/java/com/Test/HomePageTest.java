package com.Test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Page.HomePage;

public class HomePageTest extends TestBase {
	
	HomePage  homePage;
	
	public HomePageTest() throws IOException {
		super();

	}
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		homePage= new HomePage();
	}
	@Test
	public void pageTitleTest() {
		homePage.pageTitle();
	}
	@Test
	public void clickAboutUsTest() {
		homePage.ClickOnAboutUs();
	}
	@Test
	public void ClickOnContactUs() {
		homePage.ClickOnContactUs();
	}
	@Test
	public void getCurrencyListTest() {
		homePage.getCurrencyList();
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	

}
