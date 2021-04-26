package com.spec.framework.controls.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;

import com.spec.framework.controls.internals.ControlBase;

public class TextBoxBase extends ControlBase implements TextBox {

	public TextBoxBase(WebElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	public void EnterText(String text) {
		// TODO Auto-generated method stub
		getWrappedElement().sendKeys(text);
	}

	public String GetTextValue() {
		// TODO Auto-generated method stub
		return getWrappedElement().getText();
	}

}
