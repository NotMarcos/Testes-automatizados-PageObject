package br.ce.randomproject.test;

import org.junit.Test;

import br.ce.randomproject.page.IniciarProcessoPage;
import br.ce.randomproject.page.MenuMaisPage;
import br.com.randomproject.core.BaseTest;

public class CT064AssinarDocumentoAtravesdeAssinaturaEletronica extends BaseTest{

	MenuMaisPage menuMaisPage = new MenuMaisPage();
	IniciarProcessoPage iniciarProcessoPage = new IniciarProcessoPage();
	
	@Test
	public void teste1_ValidarAutoPreenchimentoCampoEmail() throws InterruptedException {
		menuMaisPage.acessarTelaIniciarProcesso();
		
		iniciarProcessoPage.executarProcessoAssinaturaEletronica();
	}
}
