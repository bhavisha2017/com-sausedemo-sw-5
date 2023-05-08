package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ProductsPage extends Utility {

    @CacheLookup
     @FindBy(className = "title")
     WebElement productsText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='inventory_item']" )
    WebElement productList;



    public String verifyText(){
        Reporter.log("Verify text"+ productsText);
        CustomListeners.test.log(Status.PASS, "verify text products");
        return getTextFromElement(productsText);
    }

    public int verifyProductList(){
        Reporter.log("Verify product list"+ productList);
        CustomListeners.test.log(Status.PASS, "productList");
        List<WebElement> number = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        return number.size();
    }
}
