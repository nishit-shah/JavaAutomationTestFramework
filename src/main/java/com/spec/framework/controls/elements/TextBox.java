package com.spec.framework.controls.elements;

import com.spec.framework.controls.api.ImplementedBy;
import com.spec.framework.controls.internals.Control;
import com.spec.framework.controls.internals.ControlBase;

@ImplementedBy(TextBoxBase.class)
public interface TextBox extends Control{

	void EnterText(String text);
	String GetTextValue();
}
