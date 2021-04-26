package com.spec.framework.controls.internals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.internal.WrapsElement;

import com.spec.framework.controls.api.ImplementedBy;

@ImplementedBy(ControlBase.class)
public interface Control extends WebElement,WrapsElement,Locatable {

}
