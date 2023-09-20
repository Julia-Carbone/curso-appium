package com.julia.core.page;

import com.julia.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

import static com.julia.core.DriverFactory.getDriver;

public class DragAndDropPage extends BasePage {

    public void arrastar(String origem, String destino) throws MalformedURLException, InterruptedException {
        WebElement inicio = (MobileElement) getDriver().findElement(By.xpath("//*[@text='" + origem + "']"));
        WebElement fim = (MobileElement) getDriver().findElement(By.xpath("//*[@text='" + destino + "']"));

        TouchAction press = new TouchAction(getDriver());

        press.longPress(ElementOption.element(inicio)).moveTo(ElementOption.element(fim)).release().perform();
    }

        public String[] obterLista() throws MalformedURLException {
        List<WebElement> elements = (List<WebElement>) getDriver().findElements(By.className("android.widget.TextView"));
        String[] retorno = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            retorno[i] = elements.get(i).getText();
            //System.out.println("\"" + retorno[i] + "\", "); //apenas usado para pegar o estadoInicial da lista
        }
        return retorno;
    }
}
