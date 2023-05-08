package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(id = "user-name")
    WebElement userNameField;

    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "login-button")
    WebElement loginButton;


    public void enterUserName(String userName){
        Reporter.log("Enter user name" + userName);
        sendTextToElement(userNameField,userName);
        CustomListeners.test.log(Status.PASS, "Enter username " + userName);


    }
    public void enterPassword(String password){
        Reporter.log("Enter password" + password);
        sendTextToElement(passwordField,password);
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);

    }
    public void clickOnLoginButton(){
        Reporter.log("Clicking on Login button "+ loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "login button"+ loginButton);

    }


}
