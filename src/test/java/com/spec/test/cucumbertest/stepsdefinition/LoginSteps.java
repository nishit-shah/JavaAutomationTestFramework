package com.spec.test.cucumbertest.stepsdefinition;

import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.spec.framework.base.Base;
import com.spec.framework.utilities.CucumberUtil;
import com.spec.test.cucumbertest.model.LoginModel;
import com.spec.test.pages.AdminPage;
import com.spec.test.pages.HomePage;
import com.spec.test.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


public class LoginSteps extends Base {

	@DataTableType
	public LoginModel convertLoginModel(Map<String,String> entry) {
		return LoginModel.createLoginModel(entry);
	}

	@Given("^I see application opened$")
	public void i_see_application_opened() throws Throwable {
		CurrentPage = GetInstance(HomePage.class);
		Assert.assertTrue(CurrentPage.As(HomePage.class).isLoginLink(),"Homepage is not loaded");
	}


	@When("^I click on Login Link$")
	public void i_click_on_login_link() throws Throwable {
		CurrentPage = CurrentPage.As(HomePage.class).clickLogin();
	}


	@Then("^I enter Username and Password And I click on Login Button$")
	public void i_enter_username_and_password_and_i_click_on_login_button(List<LoginModel> table ) throws Throwable {
		//Default way of accessting Table using index values
		//List<String> table = data.asList();
		//CurrentPage.As(LoginPage.class).Login(table.get(2),table.get(3));

		//Using Custom method developed for converting DataTable into Dictionary and retrieving data using column name
		//CucumberUtil.ConvertDataTableToDict(data);
		//CurrentPage =CurrentPage.As(LoginPage.class).Login(CucumberUtil.GetCellValueWithRowIndex("Username",2),CucumberUtil.GetCellValueWithRowIndex("Password",3));
		
		//Cucumber 6
		//CucumberUtil.ConvertDataTableToDict(table);
		CurrentPage =CurrentPage.As(LoginPage.class).LoginCuc(table.stream().findFirst().get());
	}
	

	@Then("I should see admin home page")
	public void i_should_see_admin_home_page() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Assert.assertEquals(CurrentPage.As(AdminPage.class).getLoggedinUser(), "NISHIT123","Logged in user is not same as expected");
	}






}
