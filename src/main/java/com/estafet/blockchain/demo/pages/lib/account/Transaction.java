package com.estafet.blockchain.demo.pages.lib.account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Transaction {

	protected final WebDriver driver;
	protected final WebElement webElement;

	Pattern amountPattern = Pattern.compile("(\\d+\\.\\d+)(\\s+)([A-Z]{3})");
	
	public Transaction(WebDriver driver, WebElement webElement) {
		this.driver = driver;
		this.webElement = webElement;
	}
	
	public int getTransactionId() {
		return Integer.parseInt(webElement.findElement(By.id("transaction_id")).getText());
	}
	
	public double getAmount() {
		String amount = webElement.findElement(By.id("amount")).getText();
		Matcher matcher = amountPattern.matcher(amount);
		matcher.find();
		return Double.valueOf(matcher.group(1));
	}
	
	public String getCurrency() {
		String amount = webElement.findElement(By.id("amount")).getText();
		Matcher matcher = amountPattern.matcher(amount);
		matcher.find();
		return matcher.group(3);
	}
	
	public String getStatus() {
		return webElement.findElement(By.id("status")).getText();
	}
	
}
