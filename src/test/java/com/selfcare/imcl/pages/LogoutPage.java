package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BasePage {
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    private WebElement moreoptions;

    @FindBy(xpath = "//android.widget.LinearLayout")
    private WebElement logoutbutton;

    public LogoutPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void logoutApp() {
        System.out.println("Logout" + "\n");
        moreoptions.click();
        logoutbutton.click();
        System.out.println("logout");
    }
}