package com.estafet.blockchain.demo.pages.lib.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.estafet.blockchain.demo.pages.lib.ListItem;
import com.estafet.blockchain.demo.pages.lib.wallet.WalletPage;

public class AccountItem extends ListItem {

	public AccountItem(WebDriver driver, WebElement webElement) {
		super(driver, webElement);
	}

	public String getAccountName() {
		return getTitle().replaceAll("\\s+\\[0+\\d+\\]", "");
	}

	public AccountTransactionsPage clickTransactionsLink() {
		return click(webElement.findElement(By.linkText("Transactions")), AccountTransactionsPage.class);
	}

	public WalletPage clickWalletLink() {
		return click(webElement.findElement(By.linkText("Wallet")), WalletPage.class);
	}
	
}
