package com.julia.core.page.seuBarriga;

import com.julia.core.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static com.julia.core.DriverFactory.getDriver;

public class SBResumoPage extends BasePage {

    public void excluirMov(String desc) throws MalformedURLException {
        MobileElement el = (MobileElement) getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
        swipeElement(el, 0.8, 0.3);
        clicarPorTexto("Del");
    }


}
