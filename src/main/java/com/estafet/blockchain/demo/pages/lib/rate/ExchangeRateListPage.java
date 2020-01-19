package com.estafet.blockchain.demo.pages.lib.rate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.estafet.blockchain.demo.pages.lib.ListPage;

public class ExchangeRateListPage extends ListPage<ExchangeRateItem> {

	public ExchangeRateListPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected ExchangeRateItem createItem(WebDriver driver, WebElement webElement) {
		return new ExchangeRateItem(driver, webElement);
	}

	@Override
	public String uri() {
		return "/rates";
	}

	
	
}
