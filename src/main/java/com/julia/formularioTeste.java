package com.julia;

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
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class formularioTeste {

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
		desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
		desiredCapabilities.setCapability("appium:appPackage", "com.ctappium");
		desiredCapabilities.setCapability("appium:appActivity", "com.ctappium.MainActivity");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // espera10s

		//selecionar formulario		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		//clicar no combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		//selecionar opção desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
		//verificar opção selecionada
		
		String nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nintendo Switch']")).getText();
		Assert.assertEquals("Nintendo Switch", nome);
	}
		//outra forma de verificar a opcao selecionada
		
		/*String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView[@text='Nintendo Switch']")).getText();
		Assert.assertEquals("Nintendo Switch", text);*/
		
		@Test
		public void deveInteragirSwitchCheckbox() throws MalformedURLException {
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
			desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
			desiredCapabilities.setCapability("appium:appPackage", "com.ctappium");
			desiredCapabilities.setCapability("appium:appActivity", "com.ctappium.MainActivity");

			AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // espera10s

			//selecionar formulario		
			driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
			
			//verificar status dos elementos
			WebElement check = driver.findElement(By.className("android.widget.CheckBox"));
			Assert.assertTrue(check.getAttribute("checked").equals("false"));
			
			WebElement switchh = driver.findElement(MobileBy.AccessibilityId("switch"));
			Assert.assertTrue(switchh.getAttribute("checked").equals("true"));
			
			//clicar nos elementos
			
			check.click();
			switchh.click();
			
			//verificar estados alterados
			Assert.assertTrue(check.getAttribute("checked").equals("true"));
			Assert.assertTrue(switchh.getAttribute("checked").equals("false"));
			
			//driver.quit();
	}

}
