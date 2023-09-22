package com.julia.core.page;

import com.julia.core.BasePage;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.Set;

import static com.julia.core.DriverFactory.getDriver;

public class WebViewPage extends BasePage {

    public void entrarContextoWeb() throws MalformedURLException {
        Set<String> contextHandles = getDriver().getContextHandles();
        /*for(String valor: contextHandles) {
            System.out.println(valor);
        }*/
        getDriver().context((String) contextHandles.toArray()[1]);
    }
    public void setEmail(String valor) throws MalformedURLException {
        getDriver().findElement(By.xpath("//*[@id='email']")).sendKeys(valor);
    }

    public void setPassword(String senha) throws MalformedURLException {
        getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(senha);
    }

    public void botaoEntrar() throws MalformedURLException {
        clicar(By.xpath("//button[@type='submit']"));
    }

    public String validarLogin() throws MalformedURLException {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public void sairContextoWeb() throws MalformedURLException {
        Set<String> contextHandles = getDriver().getContextHandles();
        getDriver().context((String) contextHandles.toArray()[0]);
    }
}
