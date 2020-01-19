package com.estafet.blockchain.demo.pages.lib.wallet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.estafet.blockchain.demo.pages.lib.Page;

public class WalletPage extends Page {

	@FindBy(xpath = "/html/body/div/div/div[2]/div/h2")
	@CacheLookup
	WebElement header;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div/h3")
	@CacheLookup
	WebElement title;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div/p")
	@CacheLookup
	WebElement text;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div/a[1]")
	@CacheLookup
	WebElement bankTransferButton;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div/a[2]")
	@CacheLookup
	WebElement walletTransferButton;
	
	Pattern headerPattern = Pattern.compile("(Wallet)(\\s+)((\\w+|\\s*)+)");
	
	Pattern titlePattern = Pattern.compile("(Balance\\s+of\\s+)(\\d+)(\\s+Estacoin)");
	
	public WalletPage(String walletAddress) {
		super(walletAddress);
	}

	public WalletPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String uri() {
		return "/wallet/{1}";
	}
	
	public String getWalletName() {
		Matcher matcher = headerPattern.matcher(header.getText());
		matcher.find();
		return matcher.group(3);
	}
	
	public int getBalance() {
		Matcher matcher = titlePattern.matcher(title.getText());
		matcher.find();
		return Integer.parseInt(matcher.group(2));
	}
	
	public String getWalletAddress() {
		return text.getText();
	}
	
	public BankTransferPage clickBankTransferLink() {
		return click(bankTransferButton, BankTransferPage.class);
	}
	
	public WalletTransferPage clickWalletTransferLink() {
		return click(walletTransferButton, WalletTransferPage.class);
	}
	
	

}
