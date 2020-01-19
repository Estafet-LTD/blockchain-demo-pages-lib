package com.estafet.blockchain.demo.pages.lib;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public abstract class ListPage<T extends ListItem> extends Page {

	@FindBys({
	    @FindBy(xpath = "//*[@id='item']")
	})
	@CacheLookup
	List<WebElement> items;
	
	public ListPage(WebDriver driver) {
		super(driver);
	}

	public List<T> getItems() {
		List<T> listItems = new ArrayList<T>();
		for (WebElement item : items) {
			listItems.add(createItem(getDriver(), item));
		}
		return listItems;
	}
	
	protected abstract T createItem(WebDriver driver, WebElement webElement);

}
