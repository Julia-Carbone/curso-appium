package com.julia.core.page;

import com.julia.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static com.julia.core.DriverFactory.getDriver;

public class CliqueLongoPage extends BasePage {


    public void longPress() throws MalformedURLException {

        WebElement element = getDriver().findElement(By.xpath("//*[@text='Clique Longo']"));

        new TouchAction(getDriver()).longPress(ElementOption.element(element)).release().perform();

    }

    public String validarCampoTexto() throws MalformedURLException {
        return obterTexto(By.xpath("//(android.widget.TextView)[2]"));

    }

}

