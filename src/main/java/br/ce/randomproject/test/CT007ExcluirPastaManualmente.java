package br.ce.randomproject.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.randomproject.page.RepositorioCentralPage;
import br.com.randomproject.core.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CT007ExcluirPastaManualmente extends BaseTest{
	
	RepositorioCentralPage repositorioCentral = new RepositorioCentralPage();
	
	@Test
	public void teste1_ExcluirSubpasta() throws InterruptedException {
		repositorioCentral.expandirMenuRepositorioCentral();
		repositorioCentral.expandirPastaValidacaoTeste();
		repositorioCentral.abrirMenuContextoDaSubpastaValidacaoTeste();
		repositorioCentral.clicarExcluirEmMenuContexto();
		repositorioCentral.confirmarExclusaoEmPopUp();
		
		Assert.assertEquals("Folder successfully deleted!", repositorioCentral.obterMensagemSucesso());
	}
	
	@Test
	public void teste2_ExcluirPasta() throws InterruptedException {
		repositorioCentral.expandirMenuRepositorioCentral();
		repositorioCentral.abrirMenuContextoDaPastaNoRepositorio();
		repositorioCentral.clicarExcluirEmMenuContexto();
		repositorioCentral.confirmarExclusaoEmPopUp();
		
		Assert.assertEquals("Folder successfully deleted!", repositorioCentral.obterMensagemSucesso());
	}

}
