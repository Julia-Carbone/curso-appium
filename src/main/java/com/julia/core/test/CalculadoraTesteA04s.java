package com.julia.core.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class CalculadoraTesteA04s {

	@Test 
    public void deveSomarDoisValores() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:appPackage", "com.sec.android.app.popupcalculator");
        desiredCapabilities.setCapability("appium:appActivity", "com.sec.android.app.popupcalculator.Calculator");

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
                              
    

        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("2");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Mais");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("2");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Igual");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.sec.android.app.popupcalculator:id/calc_edt_formula");
        el5.click();
       
        System.out.println(el4.getText());
        
        Assert.assertEquals("5", el5.getText());
        
        driver.quit();
        
	
	}
	
}
