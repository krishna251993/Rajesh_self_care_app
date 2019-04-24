package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//android.widget.Spinner[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/useraccount']")
    private WebElement authenticateDropDown;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/username']")
    private WebElement username;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/userPassword']")
    private WebElement password;

    @FindBy(xpath = "//android.widget.Button[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/button_login']")
    private WebElement loginButton;

    @FindBy(xpath = "//[@resource-id='mobiotics.com.lcoselfcareimpl:id/textview_forgotpassword' and text()='Forgot Password?']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//[@resource-id='mobiotics.com.lcoselfcareimpl:id/noaccount' and text()='Sign up here']")
    private WebElement signupLink;

    public LoginPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login() throws InterruptedException {
        System.out.println("Login" + "\n");
        String userName = enterUsername();
        waitTillElementIsVisible(authenticateDropDown);
        authenticateDropDown.click();
//		driver.findElementByName(getUserLoginType(userName)).click();
//		authenticateDropDown.findElement(By.name(getUserLoginType(userName))).click();

        getUserLoginType(userName).click();

//		Select select = new Select(authenticateDropDown);
//		select.selectByVisibleText(getUserLoginType(userName));

        Thread.sleep(1000);
        username.sendKeys(userName);
        Thread.sleep(1000);
        password.sendKeys(enterPwd());
        Thread.sleep(1000);
        driver.hideKeyboard();
        loginButton.click();
        Thread.sleep(1000);
        errorMgs();
        Thread.sleep(1000);
    }

    public void forgotpassword_click() {
        System.out.println("ForgotPassword");
        forgotPasswordLink.click();
    }

    public void signup_click() {
        System.out.println("SignUp");
        signupLink.click();
    }
}