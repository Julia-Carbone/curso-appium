package com.julia.core.page;

import com.julia.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static com.julia.core.DriverFactory.getDriver;

public class SplashPage extends BasePage {

    public boolean isTelaSplashVisivel() throws MalformedURLException {
        return existeElementoPorTexto("Splash!");
    }

    public void aguardarSplashSumir() throws MalformedURLException {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']"))); //aguarda até que o elemento 'Splash!' não esteja mais visível na tela

    }
}
