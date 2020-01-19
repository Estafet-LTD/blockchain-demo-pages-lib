package com.estafet.blockchain.demo.pages.lib.wallet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.estafet.blockchain.demo.pages.lib.ListItem;

public class WalletItem extends ListItem {

	public WalletItem(WebDriver driver, WebElement webElement) {
		super(driver, webElement);
	}

	public WalletPage clickManageLink() {
		return click(webElement.findElement(By.linkText("Manage")), WalletPage.class);
	}
	
}
