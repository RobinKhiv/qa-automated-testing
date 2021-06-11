package com.qa.webpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searchbar {
	
	@FindBy(id = "search_query_top")
	private WebElement searchbar;
	
	public void find(String searchkey) {
		searchbar.sendKeys(searchkey);
		searchbar.submit();
	}
}
