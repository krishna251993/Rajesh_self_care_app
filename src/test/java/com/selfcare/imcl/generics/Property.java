package com.selfcare.imcl.generics;

import com.selfcare.imcl.constants.AutomationConstants;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class Property implements AutomationConstants {
    public static String un;
    public static String pw;
    public static String newpassword;
    public static String register;
    public static String mobilenumber;
    public static String email;

    public static String getPropertyValue(String filePath, String key) {
        String value = "";

        Properties ppt = new Properties();
        try {
            File file = new File(filePath);
            ppt.load(new FileInputStream(file));
            value = ppt.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public String enterUsername() {
        return Property.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "UN");
    }

    public String enterPwd() {
        return Property.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "PW");

    }

    public String enterNewPassword() {
        return Property.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "NEWPASSWORD");
    }

    public String registerCustomer() {
        return Property.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "REGISTERCAN");
    }

    public String mobileNumber() {
        return Property.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "MOBILENUMBER");
    }

    public String email_id() {
        return Property.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "EMAIL");
    }
}