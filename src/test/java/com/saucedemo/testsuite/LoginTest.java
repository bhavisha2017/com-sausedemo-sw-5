package com.saucedemo.testsuite;

import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    HomePage homePage;
    ProductsPage products;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        products = new ProductsPage();
    }



    @Test(groups = {"sanity","regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        homePage.enterUserName("standard_user");
        homePage.enterPassword("secret_sauce");
        homePage.clickOnLoginButton();
        String actualMessage = products.verifyText();
        String expectedMessage = "Products";
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatSixProductsAreDisplayedOnPage() {
        homePage.enterUserName("standard_user");
        homePage.enterPassword("secret_sauce");
        homePage.clickOnLoginButton();
        int actualNumber = products.verifyProductList();
        int expectedNumber = 6;
        Assert.assertEquals(actualNumber,expectedNumber);
    }
}
