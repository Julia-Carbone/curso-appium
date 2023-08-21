package com.julia.core.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class devePreencherCampoTexto {
	
	@Test 
    public void deveInstalarApk() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:appPackage", "com.ctappium");
        desiredCapabilities.setCapability("appium:appActivity", "com.ctappium.MainActivity");

        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //espera10s
        
        //selecionar formulario
        
        List<WebElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
        
       /* para listar os elementos com a mesma classe:
        * 
        	for(WebElement elemento: elementosEncontrados) {
        	System.out.println(elemento.getText());
        }
        */
        
        elementosEncontrados.get(1).click();        
        
        //escrever nome
        
        WebElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("julia"); //o elemento que ele achar vou chamar de campoNome e pedir pra o texto escrever nele
        
        
        //checar nome escrito
        String text = campoNome.getText();
        Assert.assertEquals("julia", text);
        
        driver.quit();
	}
	
}
