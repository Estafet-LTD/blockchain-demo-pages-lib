package com.estafet.blockchain.demo.pages.lib.rate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.estafet.blockchain.demo.pages.lib.ListItem;

public class ExchangeRateItem extends ListItem {

	public ExchangeRateItem(WebDriver driver, WebElement webElement) {
		super(driver, webElement);
	}

	public UpdateExchangeRatePage clickEditLink() {
		return click(webElement.findElement(By.linkText("Edit")), UpdateExchangeRatePage.class);
	}

	public NewExchangeRatePage clickNewExchangeRateLink() {
		return click(webElement.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/a")),
				NewExchangeRatePage.class);
	}

}
