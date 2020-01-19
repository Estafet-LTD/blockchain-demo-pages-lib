package com.estafet.blockchain.demo.pages.lib.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.estafet.blockchain.demo.pages.lib.Page;
import com.estafet.blockchain.demo.pages.lib.account.AccountListPage;
import com.estafet.blockchain.demo.pages.lib.rate.ExchangeRateListPage;
import com.estafet.blockchain.demo.pages.lib.wallet.WalletListPage;

public class HomePage extends Page {

	@FindBy(xpath = "//*[@id='accounts']")
	@CacheLookup
	WebElement accountsLink;
	
	@FindBy(xpath = "//*[@id='wallets']")
	@CacheLookup
	WebElement walletsLink;
	
	@FindBy(xpath = "//*[@id='rates']")
	@CacheLookup
	WebElement ratesLink;
	
	public AccountListPage clickAccountsMenuItem() {
		return click(accountsLink, AccountListPage.class);
	}
	
	public WalletListPage clickWalletsMenuItem() {
		return click(walletsLink, WalletListPage.class);
	}
	
	public ExchangeRateListPage clickExchangeRatesMenuItem() {
		return click(ratesLink, ExchangeRateListPage.class);
	}
	
	@Override
	public String uri() {
		return "/";
	}

}
