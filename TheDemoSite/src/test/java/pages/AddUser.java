package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUser {

	@FindBy(xpath = "//tbody/tr[1]/td[2]/p[1]/input[1]")
	private WebElement userInput;

	@FindBy(xpath = "//tbody/tr[1]/td[2]/p[1]/input[1]")
	private WebElement passInput;

	public void signUp(String username, String password) {
		userInput.sendKeys(username);
		passInput.sendKeys(password);
		passInput.submit();
	}
}
