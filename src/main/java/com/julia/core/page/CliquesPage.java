package com.julia.core.page;

import com.julia.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static com.julia.core.DriverFactory.driver;
import static com.julia.core.DriverFactory.getDriver;

public class CliquesPage extends BasePage {


    public void cliqueLongo() throws MalformedURLException {

        cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
    }

    public String validarCampoTexto() throws MalformedURLException {
        return obterTexto(By.xpath("//(android.widget.TextView)[2]"));

    }

    public void deveDarCliqueDuplo() throws MalformedURLException {

        WebElement element = getDriver().findElement(By.xpath("//*[@text='Clique duplo']"));
        TouchAction action = new TouchAction(driver);
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(element)).withTapsCount(2)).perform();
    }

    public String deveVerificarCampoTexto() throws MalformedURLException {
        //return obterTexto(By.xpath("//*[@text='Duplo Clique']"));
        return obterTexto(By.xpath("(//android.widget.TextView)[3]"));
    }

}

