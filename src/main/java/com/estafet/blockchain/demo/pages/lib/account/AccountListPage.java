package com.estafet.blockchain.demo.pages.lib.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.estafet.blockchain.demo.pages.lib.ListPage;

public class AccountListPage extends ListPage<AccountItem> {

	@FindBy(linkText = "Open Account" )
	@CacheLookup
	WebElement openAccountLink;
	
	public AccountListPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected AccountItem createItem(WebDriver driver, WebElement webElement) {
		return new AccountItem(driver, webElement);
	}

	@Override
	public String uri() {
		return "/accounts";
	}

	public OpenAccountPage clickOpenAccountLink() {
		return click(openAccountLink, OpenAccountPage.class);
	}
	
}
