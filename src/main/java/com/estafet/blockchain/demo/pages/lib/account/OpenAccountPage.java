package com.estafet.blockchain.demo.pages.lib.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.estafet.blockchain.demo.pages.lib.Page;

public class OpenAccountPage extends Page {

	@FindBy(id = "accountName" )
	@CacheLookup
	WebElement accountName;
	
	@FindBy(id = "openingDeposit" )
	@CacheLookup
	WebElement openingDeposit;
	
	@FindBy(id = "currency" )
	@CacheLookup
	WebElement currency;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/form/div[2]/div/button" )
	@CacheLookup
	WebElement openAccountButton;
	
	public OpenAccountPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String uri() {
		return "/newaccount";
	}

	public void setAccountName(String value) {
		accountName.sendKeys(value);
	}
	
	public void setOpeningDeposit(Double value) {
		openingDeposit.sendKeys(value.toString());
	}
	
	public void setCurrency(String value) {
		new Select(currency).selectByValue(value);
	}
	
	public AccountListPage clickOpenAccountButton() {
		return submit(openAccountButton, AccountListPage.class);
	}

}
