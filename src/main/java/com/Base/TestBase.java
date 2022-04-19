package com.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public String PropFile="C:\\Users\\rafri\\eclipse-workspace\\OnlineShopping\\src\\main\\java\\com\\Configuration\\config.properties";
	//Constructor
	public TestBase() throws IOException {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(PropFile);
			prop.load(file);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	//Initialization
	public static void initialization() {
		String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rafri\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\rafri\\Downloads\\Selenium\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	

}
