package com.julia.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();


    @AfterClass //executa apenas uma vez ao final de todos os metodos da classe
    public static void finalizarClasse(){
        DriverFactory.killDriver();
    }
    @After
    public void tearDown() throws MalformedURLException {
        gerarScreenShot();
        DriverFactory.getDriver().resetApp(); //deixa os testes mais rapidos
    }

    public void gerarScreenShot() {
        try {
            File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(imagem, new File("target/screenshots/"+testName.getMethodName()+".png"));
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    /* uma das formas de pedir para aguardar determinado tempo:

    public void esperar(long tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }*/
}
