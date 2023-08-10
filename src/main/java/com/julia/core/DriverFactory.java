package com.julia.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {

	private static AndroidDriver<WebElement> driver; // variavel global

	public static AndroidDriver<WebElement> getDriver() throws MalformedURLException {
		if (driver == null) { //
			createDriver();
		}
		// se o driver for nulo, o método "createDriver" é chamado para criar uma nova
		// instância do driver e armazená-la na variável "driver"

		return driver;
		// se o driver já existir, ele é simplesmente retornado
	}

	private static void createDriver() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
		desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
		desiredCapabilities.setCapability("appium:appPackage", "com.ctappium");
		desiredCapabilities.setCapability("appium:appActivity", "com.ctappium.MainActivity");

		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // espera10s

		// clicar no formulario

		// driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		// return driver;
	}

	public static void killDriver() { // usado para fechar e finalizar a instância do AndroidDriver quando não for //
										// mais necessário
		if (driver != null) {
			driver.quit();
		} // fecha a sessão do driver 
		driver = null;
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
