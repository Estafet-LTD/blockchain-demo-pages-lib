package com.estafet.blockchain.demo.pages.lib;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ListItem {
	
	protected final WebDriver driver;
	protected final WebElement webElement;
		
	public ListItem(WebDriver driver, WebElement webElement) {
		this.driver = driver;
		this.webElement = webElement;
	}
	
	public String getTitle() {
		return webElement.findElement(By.xpath(".//div/h4")).getText();
	}
	
	public String getSubTitle() {
		return webElement.findElement(By.xpath(".//div/h5")).getText();
	}
	
	public String getText() {
		return webElement.findElement(By.xpath(".//div/p")).getText();
	}

	protected <T extends Page> T click(WebElement element, Class<T> clazz) {
		try {
			element.click();
			Constructor<T> constructor = clazz.getConstructor(WebDriver.class);
			return constructor.newInstance(driver);
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
	
}
