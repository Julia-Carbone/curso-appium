package com.julia;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import com.julia.core.DSL;
import com.julia.core.DriverFactory;
import io.appium.java_client.MobileBy;


public class formularioDesafio {

	

	private DSL dsl = new DSL();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		
		//selecionar formulario
		dsl.clicarPorTexto("Formulário");
	}

	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {

		// escrever nome
		dsl.digitar(MobileBy.AccessibilityId("nome"), "Julia");

		// validar nome escrito
		String nome = dsl.obterTexto(MobileBy.AccessibilityId("nome"));
		assertEquals("Julia", nome);

	}
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		// clicar no combo
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");

		// verificar opção selecionada
		String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		assertEquals("Nintendo Switch", text);
	}
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {

		// verificar status dos elementos
		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("check")));
		Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

		// clicar nos elementos
		dsl.clicar(MobileBy.AccessibilityId("check"));
		dsl.clicar(MobileBy.AccessibilityId("switch"));

		// verificar estados alterados
		Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("check")));
		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {

		// preencher campos
		dsl.digitar(MobileBy.AccessibilityId("nome"), "Julia");
		dsl.clicar(MobileBy.AccessibilityId("check"));
		dsl.clicar(MobileBy.AccessibilityId("switch"));
		dsl.selecionarCombo(By.xpath("//android.widget.Spinner"), "Nintendo Switch");

		// salvar
		dsl.clicar(By.xpath("//android.widget.TextView[@text='SALVAR']"));

		// verificar campos preenchidos
		assertEquals("Nome: Julia", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Julia']")));

		assertEquals("Console: switch", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Console: switch']")));

		assertEquals("Switch: Off", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Switch: Off']")));
		assertEquals("Checkbox: Marcado", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']")));

	}

	

}
