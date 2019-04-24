package com.selfcare.imcl.generics;

import com.selfcare.imcl.constants.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Screenshot extends BaseTest {
    //if fails need to take screenshot
    public static void getScreenshot(String Screenshot) throws IOException {
        TakesScreenshot ts = driver;
        //object of take screenshot, we cant take object of an interface so typecast the webdriver instance.

        File source = ts.getScreenshotAs(OutputType.FILE);
        //which will capture the screenshot

        FileUtils.copyFile(source, new File("./Screenshots/" + Screenshot + timestamp() + ".png"));
    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}