package com.estafet.blockchain.demo.pages.lib.rate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.estafet.blockchain.demo.pages.lib.Page;

public class NewExchangeRatePage extends Page {

	@FindBy(id = "currency")
	@CacheLookup
	WebElement currency;
	
	@FindBy(id = "rate")
	@CacheLookup
	WebElement rate;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div/form/button")
	@CacheLookup
	WebElement button;
		
	public NewExchangeRatePage(String currency) {
		super(currency);
	}

	public NewExchangeRatePage(WebDriver driver) {
		super(driver);
	}

	public void setCurrency(String value) {
		currency.sendKeys(value);
	}

	public void setRate(double value) {
		rate.sendKeys(Double.toString(value));
	}
	
	public ExchangeRateListPage clickCreateRateButton() {
		return submit(button, ExchangeRateListPage.class);
	}
	
	@Override
	public String uri() {
		return "/newrate";
	}

}
