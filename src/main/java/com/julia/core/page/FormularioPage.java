package com.julia.core.page;

import com.julia.core.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import java.net.MalformedURLException;

//classe page herdou toda dsl
public class FormularioPage extends BasePage {
    public void escreverNome(String nome) throws MalformedURLException {
        digitar(MobileBy.AccessibilityId("nome"), nome);
    }

    public String obterNome() throws MalformedURLException {
        return obterTexto(MobileBy.AccessibilityId("nome"));
    }

    public void selecionarCombo(String valor) throws MalformedURLException {
        selecionarCombo(MobileBy.AccessibilityId("console"), valor);
    }

    public String obterValorCombo() throws MalformedURLException {
        return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarCheck() throws MalformedURLException {
        clicar(MobileBy.AccessibilityId("check"));
    }

    public void clicarSwitch() throws MalformedURLException {
        clicar(MobileBy.AccessibilityId("switch"));
    }

    public boolean isCheckMarcado() throws MalformedURLException {
        return isCheckMarcado(MobileBy.AccessibilityId("check"));

    }

    public boolean isSwitchMarcado() throws MalformedURLException {
        return isCheckMarcado(MobileBy.AccessibilityId("switch"));
    }

    public void salvar() throws MalformedURLException {
        clicarPorTexto("SALVAR");
    }

    public String obterNomeCadastrado() throws MalformedURLException {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome')]"));
    }

    public String obterConsoleCadastrado() throws MalformedURLException {
       return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console')]"));
    }

    public String obterCheckCadastrado() throws MalformedURLException {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox')]"));
    }

    public String obterSwitchCadastrado() throws MalformedURLException {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch')]"));
    }

}




