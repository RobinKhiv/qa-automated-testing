package com.qa.webpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {

	private final static String URL = "http://automationpractice.com/index.php";

	@FindBy(linkText = "Dresses")
	private WebElement dresses;
	
	public static String getUrl() {
		return URL;
	} 

	public void navDresses() {
		dresses.click();
	}
}
