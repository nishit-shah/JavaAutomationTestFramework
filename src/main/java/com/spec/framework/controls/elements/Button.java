package com.spec.framework.controls.elements;

import com.spec.framework.controls.api.ImplementedBy;
import com.spec.framework.controls.internals.Control;
import com.spec.framework.controls.internals.ControlBase;

@ImplementedBy(ButtonBase.class)
public interface Button extends Control {

	void performClick();
	String GetButtonText();
	void performSubmit();
}
