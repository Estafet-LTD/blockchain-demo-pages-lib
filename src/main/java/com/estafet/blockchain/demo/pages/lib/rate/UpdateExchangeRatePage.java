package com.estafet.blockchain.demo.pages.lib.rate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.estafet.blockchain.demo.pages.lib.Page;

public class UpdateExchangeRatePage extends Page {

	@FindBy(id = "currency")
	@CacheLookup
	WebElement currency;
	
	@FindBy(id = "rate")
	@CacheLookup
	WebElement rate;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div/div/form/button")
	@CacheLookup
	WebElement button;
		
	public UpdateExchangeRatePage(String currency) {
		super(currency);
	}

	public UpdateExchangeRatePage(WebDriver driver) {
		super(driver);
	}

	public String getCurrency() {
		return currency.getAttribute("value");
	}
	
	public double getRate() {
		return Double.parseDouble(rate.getAttribute("value"));
	}

	public void setRate(double value) {
		rate.sendKeys(Double.toString(value));
	}
	
	public ExchangeRateListPage clickSaveButton() {
		return submit(button, ExchangeRateListPage.class);
	}
	
	@Override
	public String uri() {
		return "/rate/{1}";
	}

}
