package br.ce.randomproject.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.randomproject.page.EngrenagemPage;
import br.ce.randomproject.page.MetadadosPage;
import br.com.randomproject.core.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CT030GestaoDeMetadados extends BaseTest{

	public static String HTML = "html";
	public static String metadados = "Metadata";
	
	EngrenagemPage configuracoes = new EngrenagemPage();
	MetadadosPage telaMetadados = new MetadadosPage();
	
	@Test
	public void teste1_CriacaoDeNovosMetadados () throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(metadados);
		configuracoes.abrirEntitulado();
		
		telaMetadados.clicarBotaoNovo();
		telaMetadados.selecionarCampoComponenteBase();
		telaMetadados.selecionarPrimeiroComponenteBase();
		telaMetadados.clicarBotaoSelecionar();
		telaMetadados.clicarBotaoSalvar();
		
		Assert.assertEquals("Metadata successfully registered", telaMetadados.obterMensagemSucesso());
	}
	
	@Test
	public void teste2_ExclusaoDeMetadados () throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(metadados);
		configuracoes.abrirEntitulado();
		
		telaMetadados.pesquisarMetadado(HTML);
		telaMetadados.clicarAcoes();
		telaMetadados.clicarMenuAcoesExcluir();
		telaMetadados.confirmarExclusao();
		
		Assert.assertEquals("Metadata successfully deleted", telaMetadados.obterMensagemExcluidoSucesso());
	}
	
	@Test
	public void teste3_InativarMetadados () throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(metadados);
		configuracoes.abrirEntitulado();
		
		telaMetadados.pesquisarMetadado(HTML);
		telaMetadados.inativarMetadado();
		
		Assert.assertEquals("Metadata successfully deleted", telaMetadados.obterMensagemExcluidoSucesso());
	}
	
	
}
