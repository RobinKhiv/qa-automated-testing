package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUser {

	@FindBy(name = "username")
	private WebElement userInput;

	@FindBy(name = "password")
	private WebElement passInput;

	public void info(String username, String password) {
		userInput.sendKeys(username);
		passInput.sendKeys(password);
		passInput.submit();
	}
}
