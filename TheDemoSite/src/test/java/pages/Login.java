package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	@FindBy(name = "username")
	private WebElement userInput;

	@FindBy(name = "password")
	private WebElement passInput;

	public void log(String username, String password) {
		userInput.sendKeys(username);
		passInput.sendKeys(password);
		passInput.submit();
	}
}
