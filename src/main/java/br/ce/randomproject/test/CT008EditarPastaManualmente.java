package br.ce.randomproject.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.randomproject.page.RepositorioCentralPage;
import br.com.randomproject.core.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CT008EditarPastaManualmente extends BaseTest {
	
	public final String renomearComTituloNaoRepetido = "CT06-CT07-Renomeado";
	public final String renomearComTituloRepetido = "Validação de Testes";

RepositorioCentralPage repositorioCentral = new RepositorioCentralPage();
	
	@Test
	public void teste1_RenomearPastaNaoRepetido() throws InterruptedException {
		repositorioCentral.expandirMenuRepositorioCentral();
		repositorioCentral.expandirPastaValidacaoTeste();
		repositorioCentral.abrirMenuContextoDaSubpastaValidacaoTeste();
		repositorioCentral.clicarRenomearEmMenuContexto();
		repositorioCentral.limparCampoRenomear();
		repositorioCentral.clicarCampoRenomearPopUp();
		repositorioCentral.setNomePastaProtocolo(renomearComTituloNaoRepetido);
		repositorioCentral.clicarConfirmarRenomearPopUp();
		
		Assert.assertEquals("Folder renamed successfully!", repositorioCentral.obterMensagemSucesso());
	}
	
	@Test
	public void teste2_RenomearPastaRepetido() throws InterruptedException {
		repositorioCentral.expandirMenuRepositorioCentral();
		repositorioCentral.expandirPastaValidacaoTeste();
		repositorioCentral.abrirMenuContextoDaSubpastaValidacaoTeste();
		repositorioCentral.clicarRenomearEmMenuContexto();
		repositorioCentral.limparCampoRenomear();
		repositorioCentral.clicarCampoRenomearPopUp();
		repositorioCentral.setNomePasta(renomearComTituloRepetido);
		repositorioCentral.clicarConfirmarRenomearPopUp();
		
		Assert.assertEquals("O título da pasta é repetido", repositorioCentral.obterMensagemSucesso());
	}
	
	@Test
	public void teste3_RenomearPastaParaSemNome() throws InterruptedException {
		repositorioCentral.expandirMenuRepositorioCentral();
		repositorioCentral.expandirPastaValidacaoTeste();
		repositorioCentral.abrirMenuContextoDaSubpastaValidacaoTeste();
		repositorioCentral.clicarRenomearEmMenuContexto();
		repositorioCentral.limparCampoRenomear();
		repositorioCentral.clicarConfirmarRenomearPopUp();
		
		Assert.assertEquals("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.", repositorioCentral.obterMensagemSucesso());
	}
	
	@Test
	public void teste4_MudarDescricaoPasta() throws InterruptedException {
		repositorioCentral.expandirMenuRepositorioCentral();
		repositorioCentral.expandirPastaValidacaoTeste();
		repositorioCentral.abrirMenuContextoDaSubpastaValidacaoTeste();
		repositorioCentral.clicarRenomearEmMenuContexto();
		repositorioCentral.limparCampoDescricao();
		repositorioCentral.setDescricaoPastaProtocolo(renomearComTituloNaoRepetido);
		repositorioCentral.clicarConfirmarRenomearPopUp();
		
		Assert.assertEquals("Folder renamed successfully!", repositorioCentral.obterMensagemSucesso());
	}
	
	@Test
	public void teste5_SalvarPastaSemDescricao() throws InterruptedException {
		repositorioCentral.expandirMenuRepositorioCentral();
		repositorioCentral.expandirPastaValidacaoTeste();
		repositorioCentral.abrirMenuContextoDaSubpastaValidacaoTeste();
		repositorioCentral.clicarRenomearEmMenuContexto();
		repositorioCentral.limparCampoDescricao();
		repositorioCentral.clicarConfirmarRenomearPopUp();
		
		Assert.assertEquals("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.", repositorioCentral.obterMensagemSucesso());
	}
}
