package com.spec.framework.controls.elements;

import org.openqa.selenium.WebElement;

import com.spec.framework.controls.internals.ControlBase;

public class ButtonBase extends ControlBase implements Button {

	public ButtonBase(WebElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	public void performClick() {
		// TODO Auto-generated method stub
		getWrappedElement().click();
	}

	public String GetButtonText() {
		// TODO Auto-generated method stub
		return getWrappedElement().getText();
	}

	public void performSubmit() {
		// TODO Auto-generated method stub
		getWrappedElement().submit();
	}

}
