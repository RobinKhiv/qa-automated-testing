package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.webpage.Homepage;

public class WebsiteTest {
	
	static WebDriver driver;
	
	@BeforeAll 
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
	}
	
	@BeforeEach
	public void setup() {
		try {
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get(Homepage.getUrl());
		} catch (TimeoutException e) {
			System.out.println("Failed to load homepage");
		}
	}
	
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
	
}
