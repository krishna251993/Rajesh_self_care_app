package com.selfcare.imcl.constants;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.NetworkMode;
import com.selfcare.imcl.generics.Screenshot;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Listeners(ListenerTest.class)

public class BaseTest implements AutomationConstants {
    public static AndroidDriver<MobileElement> driver;

    public static ExtentReports report;
    public static ExtentTest test;
    //public static int CustomerType;

    @BeforeSuite
    public void initialisation() throws MalformedURLException, InterruptedException {
        File f = new File(AppPath);
        File fs = new File(f, AppName);

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto E");

        // cap.setCapability("appPackage", "mobiotics.com.lcoselfcareimpl");
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        /*cap.setCapability("autoAcceptAlerts", true);*/
        cap.setCapability("autoGrantPermissions", "true");
        cap.setCapability("autoAcceptAlerts", "true");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        /*Thread.sleep(1000);
        LoginPage login = new LoginPage(driver);
        login.login();*/
    }

    @AfterSuite()
    public void closeFrameWork() {
        /*LogoutPage logout = new LogoutPage(driver);
        logout.logoutApp();*/
    }

    @AfterMethod
    public void failedScreenshot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            Screenshot.getScreenshot(result.getName());
        }
    }

    @BeforeTest
    public void extent() {
        report = new ExtentReports(
                System.getProperty("user.dir")+/IMCL_Selfcare_Android_App/ExtendReports.html", true,
                DisplayOrder.OLDEST_FIRST, NetworkMode.OFFLINE);
    }

    @AfterTest
    public void test() {
        report.flush();
        //   report.close();
    }
}