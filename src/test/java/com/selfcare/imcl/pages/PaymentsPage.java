package com.selfcare.imcl.pages;

import com.selfcare.imcl.constants.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentsPage extends BasePage {
    @FindBy(className = "android.webkit.WebView")
    private WebElement paytmpage;

    @FindBy(xpath = "//android.widget.FrameLayout")
    private WebElement CancelTransactionLayout;

    @FindBy(xpath = "//android.widget.Button[@resource-id'android:id/button1']")
    private WebElement cancelTransactionYES;

    @FindBy(xpath = "//android.widget.Button[@resource-id'android:id/button1'][0]")
    private WebElement cancelTransactionNO;

    public PaymentsPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void payment() {
        System.out.println("Paytm Page....!!!" + "\n");
/*		if (paytmpage.isDisplayed()) {
			System.out.println("Paytm Page....!!!");
		
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			if (CancelTransactionLayout.isDisplayed()) 
			{
				cancelTransactionYES.click();
			}
		}
*/
    }
}