package com.julia.core.page;

import com.julia.core.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static com.julia.core.DriverFactory.getDriver;

public class SwipeListPage extends BasePage {

    public void swipeElementLeft(String opcao) throws MalformedURLException {
        swipeElement(getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.9, 0.1);
    }

    public void swipeElementRight(String opcao) throws MalformedURLException {
        swipeElement(getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.1, 0.9);
    }

    public void clicarBotaoMais() throws MalformedURLException {

        WebElement botao = getDriver().findElement(By.xpath("//*[@text='(+)']/.."));

        int x = botao.getLocation().getX() + botao.getSize().getWidth() / 2;
        int y = botao.getLocation().getY() + botao.getSize().getHeight() / 2;

        new TouchAction(getDriver()).tap(PointOption.point(x, y)).perform();
    }
}

