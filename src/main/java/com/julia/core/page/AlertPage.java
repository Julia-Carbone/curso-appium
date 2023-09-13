package com.julia.core.page;

import com.julia.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class AlertPage extends BasePage {

    public void clicarAlertaConfirm() throws MalformedURLException {
        clicarPorTexto("ALERTA CONFIRM");
    }

    public String obterTituloAlerta() throws MalformedURLException {
        return obterTexto(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlerta() throws MalformedURLException {
        return obterTexto(By.id("android:id/message"));
    }

    public void ConfirmarAlerta() throws MalformedURLException {
        clicar(By.id("android:id/button2"));
    }

    public String obterMensagemConfirmadoAlerta() throws MalformedURLException {
        return obterTexto(By.id("android:id/message"));
    }

    public void SairAlerta() throws MalformedURLException {
        clicar(By.id("android:id/button1"));
    }

    public void clicarAlertaSimples() throws MalformedURLException {
        clicarPorTexto("ALERTA SIMPLES");
    }

    public void clicarForaCaixa() throws MalformedURLException {
        tap(100, 150);
    }


}
