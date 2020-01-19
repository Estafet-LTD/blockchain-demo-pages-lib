package com.estafet.blockchain.demo.pages.lib.wallet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.estafet.blockchain.demo.pages.lib.Page;

public class WalletTransferPage extends Page {

	@FindBy(id = "transferAmount")
	@CacheLookup
	WebElement transferAmount;
	
	@FindBy(id = "toAddress")
	@CacheLookup
	WebElement toAddress;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/form/div[2]/div/button")
	@CacheLookup
	WebElement button;
		
	public WalletTransferPage(String currency) {
		super(currency);
	}

	public WalletTransferPage(WebDriver driver) {
		super(driver);
	}

	public void setTransferAmount(double value) {
		transferAmount.sendKeys(Double.toString(value));
	}
	
	public void setToAddress(String value) {
		new Select(toAddress).selectByValue(value);
	}
	
	public WalletPage clickTransferButton() {
		return click(button, WalletPage.class);
	}
	
	@Override
	public String uri() {
		return "/wallettransfer/{1}";
	}

}
