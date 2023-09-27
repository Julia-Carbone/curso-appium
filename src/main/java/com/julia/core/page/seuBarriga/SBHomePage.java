package com.julia.core.page.seuBarriga;

import com.julia.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class SBHomePage extends BasePage {

    public String obterSaldoConta() throws MalformedURLException {
        return obterTexto(By.xpath("//*[@text='534.00']"));
    }

    public String obterSaldoContaFinal() throws MalformedURLException {
        return obterTexto(By.xpath("//*[@text='-1000.00']"));
    }

}
