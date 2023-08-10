package com.julia.core;

import static com.julia.core.DriverFactory.getDriver;
import java.net.MalformedURLException;
import org.openqa.selenium.By;

public class DSL {
	
	/*public void reiniciarApp() throws MalformedURLException {
		DriverFactory.killDriver();
	    DriverFactory.getDriver();
	    // Aqui você pode adicionar qualquer configuração adicional após reiniciar o aplicativo
	}*/

	public void digitar(By by, String texto) throws MalformedURLException {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) throws MalformedURLException {
		return getDriver().findElement(by).getText();
	}

	public void clicar(By by) throws MalformedURLException {
		getDriver().findElement(by).click();
	}

	public void clicarPorTexto(String texto) throws MalformedURLException {
		clicar((By.xpath("//*[@text='" + texto + "']")));
	}

	public void selecionarCombo(By by, String valor) throws MalformedURLException {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
	}

	public boolean isCheckMarcado(By by) throws MalformedURLException {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
	

}