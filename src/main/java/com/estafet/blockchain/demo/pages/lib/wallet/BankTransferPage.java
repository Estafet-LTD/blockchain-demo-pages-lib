package com.estafet.blockchain.demo.pages.lib.wallet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.estafet.blockchain.demo.pages.lib.Page;

public class BankTransferPage extends Page {

	@FindBy(id = "transferAmount")
	@CacheLookup
	WebElement transferAmount;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div/form/button")
	@CacheLookup
	WebElement button;
		
	public BankTransferPage(String currency) {
		super(currency);
	}

	public BankTransferPage(WebDriver driver) {
		super(driver);
	}


	public void setTransferAmount(double value) {
		transferAmount.sendKeys(Double.toString(value));
	}
	
	public WalletPage clickTransferButton() {
		return click(button, WalletPage.class);
	}
	
	@Override
	public String uri() {
		return "/banktransfer/{1}";
	}

}
