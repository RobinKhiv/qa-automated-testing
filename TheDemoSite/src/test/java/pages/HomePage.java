package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	private static final String URL = "http://thedemosite.co.uk/";

	@FindBy(linkText="3. Add a User")
	private WebElement addUser;
	
	@FindBy(linkText="4. Login")
	private WebElement login;
	
	public static String getURL() {
		return URL;
	}
	
	public void navAddUser() {
		addUser.click();
	}
	
	public void navLogin() {
		login.click();
	}
}
