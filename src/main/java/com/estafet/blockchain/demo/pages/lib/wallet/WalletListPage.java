package com.estafet.blockchain.demo.pages.lib.wallet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.estafet.blockchain.demo.pages.lib.ListPage;

public class WalletListPage extends ListPage<WalletItem> {

	public WalletListPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected WalletItem createItem(WebDriver driver, WebElement webElement) {
		return new WalletItem(driver, webElement);
	}

	@Override
	public String uri() {
		return "/wallets";
	}

}
