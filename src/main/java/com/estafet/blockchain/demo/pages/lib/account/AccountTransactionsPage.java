package com.estafet.blockchain.demo.pages.lib.account;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.estafet.blockchain.demo.pages.lib.Page;

public class AccountTransactionsPage extends Page {

	@FindBys({
	    @FindBy(xpath = "//*[@id='transaction']")
	})
	@CacheLookup
	List<WebElement> transactions;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/h3")
	@CacheLookup
	WebElement account;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/h3")
	@CacheLookup
	WebElement balance;
	
	Pattern balancePattern = Pattern.compile("(Balance\\s+)(\\d+\\.\\d+)(\\s+)([A-Z]{3})");
	
	Pattern accountPattern = Pattern.compile("(Account\\s+)((\\w+|\\s*)+)(\\s+)(\\[)(\\d+)(\\])");

	public AccountTransactionsPage(String accountId) {
		super(accountId);
	}

	public AccountTransactionsPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String uri() {
		return "/account/{1}";
	}
	
	public String getAccountName() {
		Matcher matcher = accountPattern.matcher(account.getText());
		matcher.find();
		return matcher.group(2);
	}
	
	public String getAccountNumber() {
		Matcher matcher = accountPattern.matcher(account.getText());
		matcher.find();
		return matcher.group(6);
	}
		
	public double getBalance() {
		Matcher matcher = balancePattern.matcher(balance.getText());
		matcher.find();
		return Double.valueOf(matcher.group(2));
	}
	
	public String getCurrency() {
		Matcher matcher = balancePattern.matcher(balance.getText());
		matcher.find();
		return matcher.group(4);
	}
	
	public List<Transaction> getTransactions() {
		List<Transaction> rows = new ArrayList<Transaction>();
		for (WebElement element : transactions) {
			rows.add(new Transaction(getDriver(), element));
		}
		return rows;
	}

}
