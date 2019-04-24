package com.selfcare.imcl.constants;

import com.selfcare.imcl.generics.Property;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage extends Property {
    public AndroidDriver<MobileElement> driver;
    /*public String frCAN;*/
    //int Flag = 0;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='mobiotics.com.lcoselfcareimpl.debug:id/snackbar_text']")
    private WebElement snackbar;
    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Smart Card Number']")
    private WebElement smartCardNumber;
    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Customer Account Number']")
    private WebElement customerAccountNumber;
    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='STB Number']")
    private WebElement stbNumber;
    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Aunthenticate Using']")
    private WebElement authenticateUsingSelect;
    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='android:id/body']")
    private WebElement loaderbox;

    public BasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    public void waitTillElementIsVisible(WebElement element) {
        new WebDriverWait(driver, 10000).until(ExpectedConditions.visibilityOf(element));
    }

    public void scroll(String element) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + element + "\"))");
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }

    public WebElement selectElement(WebElement element) {
        Select selectDropdown = new Select(element);
        List<WebElement> elements = selectDropdown.getOptions();
        int size = elements.size();

        for (int i = 0; i < size; i++) {
            String values = elements.get(i).getText();
            System.out.println(values);
        }

        Random random = new Random();
        WebElement selectedElements = elements.get(random.nextInt(size));
        System.out.println(selectedElements);
        return selectedElements;
    }

    public WebElement getUserLoginType(String un) {
        WebElement webelement = authenticateUsingSelect;
        if (un.length() == 8) {
            webelement = customerAccountNumber;
        } else if (un.length() == 12) {
            webelement = smartCardNumber;
        } else if (un.length() == 18) {
            webelement = stbNumber;
        }
        return webelement;
    }

    public void errorMgs() {
        try {
            if (snackbar.isDisplayed()) {
                System.out.println(snackbar.getText());
            }
        } catch (Exception e) {
        }
    }

    public void waitTilIsAlertPresent() {
        try {
            if (loaderbox.isEnabled()) {
                System.out.println("loader");
                new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(loaderbox));
            }
        } catch (Exception e) {
        }
    }
}