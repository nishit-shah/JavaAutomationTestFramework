package com.spec.framework.controls.internals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;

public class ControlBase implements Control{

	private final WebElement element;
	
	public ControlBase(WebElement element) {
		// TODO Auto-generated constructor stub
		this.element = element;
	}
	
	public void click() {
		// TODO Auto-generated method stub
		element.click();
	}

	public void submit() {
		// TODO Auto-generated method stub
		element.submit();
	}

	public void sendKeys(CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		element.sendKeys(keysToSend);
	}

	public void clear() {
		// TODO Auto-generated method stub
		element.clear();
	}

	public String getTagName() {
		// TODO Auto-generated method stub
		return element.getTagName();
	}

	public String getAttribute(String name) {
		// TODO Auto-generated method stub
		return element.getAttribute(name);
	}

	public boolean isSelected() {
		// TODO Auto-generated method stub
		return element.isSelected();
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return element.isEnabled();
	}

	public String getText() {
		// TODO Auto-generated method stub
		return element.getText();
	}

	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return element.findElements(by);
	}

	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return element.findElement(by);
	}

	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return element.isDisplayed();
	}

	public Point getLocation() {
		// TODO Auto-generated method stub
		return element.getLocation();
	}

	public Dimension getSize() {
		// TODO Auto-generated method stub
		return element.getSize();
	}

	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return element.getRect();
	}

	public String getCssValue(String propertyName) {
		// TODO Auto-generated method stub
		return element.getCssValue(propertyName);
	}

	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		// TODO Auto-generated method stub
		return element.getScreenshotAs(target);
	}

	public WebElement getWrappedElement() {
		// TODO Auto-generated method stub
		return element;
	}

	public Coordinates getCoordinates() {
		// TODO Auto-generated method stub
		return null;
	}

}
