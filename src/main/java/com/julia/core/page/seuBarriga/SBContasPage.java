package com.julia.core.page.seuBarriga;

import com.julia.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class SBContasPage extends BasePage {

    public void setConta(String nome) throws MalformedURLException {
        digitar(By.className("android.widget.EditText"), nome);
    }

    public void salvar() throws MalformedURLException {
        clicarPorTexto("SALVAR");
    }

}
