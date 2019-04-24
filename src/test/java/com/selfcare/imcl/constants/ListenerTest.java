package com.selfcare.imcl.constants;

import com.relevantcodes.extentreports.LogStatus;
import com.selfcare.imcl.generics.Screenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ListenerTest extends BaseTest implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("\n\n"+result.getName() + " test case started");
        //generating two test cases in extent report one from start and from success/failure so commented
        /*test = report.startTest(result.getName().toString());
          test.log(LogStatus.PASS, result.getName() + " test case started");*/
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " test case success");
        test = report.startTest(result.getName());
        test.log(LogStatus.PASS, result.getName() + " test case success");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " test case failed");
        test.log(LogStatus.FAIL, result.getName() + " test case failed");
        test = report.startTest(result.getName());

        /*TakesScreenshot ts = (TakesScreenshot) driver;
        test.log(LogStatus.FAIL, test.addScreenCapture());*/

        /*try {
            Screenshot.getScreenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " test case skipped");
        test = report.startTest(result.getName());
        test.log(LogStatus.SKIP, result.getName() + " test case skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        float percentage = result.SUCCESS_PERCENTAGE_FAILURE;
        System.out.println(result.getName() + " test cases failed, success percentage is :" + percentage);
        System.out.println("onTestFailedButWithinSuccessPercentage for "+ result.getMethod().getMethodName());

    }
    public void onStart(ITestContext context) {
    }
    public void onFinish(ITestContext context) {
    }
}