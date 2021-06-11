package com.qa.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.webpage.Homepage;
import com.qa.webpage.Searchbar;

public class WebsiteTest {

	static WebDriver driver;

	@BeforeAll
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
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

	@Test
	public void test() throws InterruptedException {
		String searchkey = "dress";
		Searchbar search = PageFactory.initElements(driver, Searchbar.class);
		
		search.find(searchkey);
		Thread.sleep(3000);
		
		List<WebElement> products = driver.findElements(By.className("ajax_block_product"));
		for (WebElement product : products) {
			String productName = product.findElement(By.className("product-name")).getText().toLowerCase();

			if (!productName.contains(searchkey)) {
				fail("Non-relevant item returned");
			}
		}
	}
}
