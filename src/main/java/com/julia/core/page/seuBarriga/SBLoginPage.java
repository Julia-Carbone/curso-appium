package com.julia.core.page.seuBarriga;

import com.julia.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class SBLoginPage extends BasePage {

    public void setEmail(String email) throws MalformedURLException {
        digitar(By.xpath("//android.widget.EditText"), email);
    }

    public void setSenha(String senha) throws MalformedURLException {
        digitar(By.xpath("//android.widget.EditText[2]"), senha);
    }

    public void entrar() throws MalformedURLException {
        clicar(By.className("android.widget.TextView"));
        clicarPorTexto("ENTRAR");
    }

    public String validarLogin() throws MalformedURLException {
       return obterTexto(By.xpath("(//android.widget.TextView)[2]"));
    }


}
