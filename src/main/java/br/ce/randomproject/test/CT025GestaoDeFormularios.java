package br.ce.randomproject.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.randomproject.page.EngrenagemPage;
import br.ce.randomproject.page.FormulariosPage;
import br.ce.randomproject.page.telaCriacaoFormulariosPage;
import br.com.randomproject.core.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CT025GestaoDeFormularios extends BaseTest{
	
	public final String formularios = "forms";
	
	public final String IdAleatorio = "CT25-Criado";
	public final String CT25Criado = IdAleatorio;

	EngrenagemPage configuracoes = new EngrenagemPage();
	FormulariosPage telaFormulario = new FormulariosPage();
	telaCriacaoFormulariosPage telaCriacaoFormularios = new telaCriacaoFormulariosPage();
	
	@Test
	public void teste1_CriacaoDeRascunhoDeFormularios() throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(formularios);
		configuracoes.abrirEntitulado();
		
		telaFormulario.clicarBotaoNovo();
		
		telaCriacaoFormularios.arrastarGridLayout();
		telaCriacaoFormularios.salvarFormulario();
		telaCriacaoFormularios.configurarDadosFormulario(IdAleatorio);
		
		Assert.assertEquals("Rascunho salvo", telaCriacaoFormularios.obterMensagemSucessoSalvarRascunhoFormulario());
	}
	
	@Test
	public void teste2_CriacaoDeRascunhoDeFormulariosSemLayoutComponenteOuCampo() throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(formularios);
		configuracoes.abrirEntitulado();
		
		telaFormulario.clicarBotaoNovo();
		
		telaCriacaoFormularios.salvarFormulario();
		telaCriacaoFormularios.configurarDadosFormulario(IdAleatorio);
		
		Assert.assertEquals("Required form", telaCriacaoFormularios.obterMensagemSucessoPublicarFormulario());
	}
	
	@Test
	public void teste3_PublicacaoDeDeFormularios() throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(formularios);
		configuracoes.abrirEntitulado();
		
		telaFormulario.clicarBotaoNovo();
		
		telaCriacaoFormularios.arrastarGridLayout();
		telaCriacaoFormularios.salvarFormulario();
		telaCriacaoFormularios.configurarDadosFormulario(IdAleatorio);
        telaCriacaoFormularios.publicarFormulario();
		
		Assert.assertEquals("Formulário publicado", telaCriacaoFormularios.obterMensagemSucessoPublicarFormulario());
	}
	
	@Test
	public void teste4_InativarFormularios() throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(formularios);
		configuracoes.abrirEntitulado();
		
		telaFormulario.setCampoProcurar(CT25Criado);
		telaFormulario.abrirAcoesFormularioAtivo();
		telaFormulario.clicarBotaoInativarMenuAcoes();
		telaFormulario.confirmarInativacaoPopUP();
		
		Assert.assertEquals("Formulário inativado", telaFormulario.obterMensagemSucesso());
	}
	
	@Test
	public void teste5_AtivarFormularios() throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(formularios);
		configuracoes.abrirEntitulado();
		
		telaFormulario.setCampoProcurar(CT25Criado);
		telaFormulario.abrirAcoesFormularioInativo();
		telaFormulario.clicarBotaoAtivarMenuAcoes();
		telaFormulario.confirmarAtivacaoPopUP();
		
		Assert.assertEquals("Form activated", telaFormulario.obterMensagemSucesso());
	}
	
	@Test
	public void teste6_ExcluirFormularios () throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(formularios);
		configuracoes.abrirEntitulado();
		
		telaFormulario.setCampoProcurar(CT25Criado);
		telaFormulario.abrirAcoesFormularioInativo();
		telaFormulario.clicarBotaoExcluirMenuAcoes();
		telaFormulario.confirmarExclusaoFormulario();
		
		Assert.assertEquals("Form successfully deleted", telaFormulario.obterMensagemSucesso());
	}
	
	@Ignore
	@Test
	public void teste7_ExcluirFormulariosVinculados() {
		
	}
	
	@Ignore
	@Test
	public void teste8_editarFormulario() {
		
	}
	
	@Ignore
	@Test
	public void teste9_CriarNovaVersaoDeFormulario() {
		
	}
	
}
