package com.julia;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstalarApk {

	@Test 
    public void deveInstalarApk() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Zeus\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\CTAppium_1_2.apk");
        //desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
       // desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
                              
	}
}