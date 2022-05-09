package br.ce.randomproject.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.randomproject.page.EngrenagemPage;
import br.ce.randomproject.page.FormulariosPage;
import br.ce.randomproject.page.telaCriacaoFormulariosPage;
import br.com.randomproject.core.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CT029IntegracaoEntreFormulariosEMetadados extends BaseTest{


	public final String formularios = "forms";
	
	public final String IdAleatorio = "CT25-Criado";
	public final String CT25Criado = IdAleatorio;

	EngrenagemPage configuracoes = new EngrenagemPage();
	FormulariosPage telaFormulario = new FormulariosPage();
	telaCriacaoFormulariosPage telaCriacaoFormularios = new telaCriacaoFormulariosPage();
	
	@Test
	public void teste1_InsercaoDeMetadadosDentroDoFormulario() throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(formularios);
		configuracoes.abrirEntitulado();
		
		telaFormulario.clicarBotaoNovo();
		
		telaCriacaoFormularios.arrastarTextoCampos();
		telaCriacaoFormularios.selecionarMetadadoCadastrado();
		telaCriacaoFormularios.clicarBotaoSelecionarPopUp();
		
		Assert.assertTrue("Nenhum metadado foi inserido ao formulario", telaCriacaoFormularios.seNaoHouverMetadadoInserido());
	}
}
