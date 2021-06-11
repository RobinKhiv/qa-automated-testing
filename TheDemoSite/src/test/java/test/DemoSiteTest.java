package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pages.AddUser;
import pages.HomePage;

public class DemoSiteTest {

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
			driver.get(HomePage.getURL());
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
		String username = "username";
		String password = "password";
		HomePage nav = PageFactory.initElements(driver, HomePage.class);
		AddUser user = PageFactory.initElements(driver, AddUser.class);

		nav.navAddUser();
		user.info(username, password);
		Thread.sleep(3000);
		nav.navLogin();
		user.info(username, password);
		Thread.sleep(3000);

		assertEquals("**Successful Login**",
				driver.findElement(By.xpath("//b[contains(text(),'**Successful Login**')]")).getText());
	}
}
