package com.julia.core.page.seuBarriga;

import com.julia.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class SBMovPage extends BasePage {

    public void salvar() throws MalformedURLException {
        clicarPorTexto("SALVAR");
    }

    public void setDescricao(String desc) throws MalformedURLException {
        digitar(By.className("android.widget.EditText"), desc);
    }

    public void setInteressado(String interessado) throws MalformedURLException {
        digitar(By.xpath("//android.widget.EditText[2]"), interessado);
    }

    public void setValor(String valor) throws MalformedURLException {
        digitar(By.xpath("//android.widget.EditText[3]"), valor);
    }

   public void setConta(String conta) throws MalformedURLException {
        selecionarCombo(By.xpath("//android.widget.Spinner[2]"), conta);
   }

}
