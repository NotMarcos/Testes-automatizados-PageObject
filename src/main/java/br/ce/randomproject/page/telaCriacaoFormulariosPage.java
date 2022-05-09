package br.ce.randomproject.page;

import br.com.randomproject.core.BasePage;

public class telaCriacaoFormulariosPage extends BasePage{

	public final String gridLayout = "/html/body/div[2]/div[3]/div/div/div/div[1]/nav/div[1]/div[2]/div/div/div[1]/div/div";
	public final String textoCampos = "//span[text()='Text']";
	
	public final String campoRecebeDrops = "/html/body/div[2]/div[3]/div/div/div/div[2]/div";
	public final String campoRecebeDropsElementos = ".//div";
	public final String botaoSalvarDadosFormulario = "/html/body/div[2]/div[3]/div/div/header/div/div/button[2]";
	
	public final String metadadoCadastrado = "//h6[text()='Choose the component base']/../following-sibling::div[1]/child::div";
	public final String botaoCriarNovoComponente = "/html/body/div[3]/div[3]/div/div[3]/div/button[1]/span[1]";
	public final String botaoSelecionar = "//span[text()='Select']/..";
	
	public final String popUpCriacaoBotaoOk = "/html/body/div[3]/div[3]/div/div[3]/div/div[2]/div";
	
	public final String popUpCriacaoGridLayoutNumeroDeLinhas = "/html/body/div[3]/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div[3]/div/div";
	public final String popUpCriacaoGridLayoutNumeroDeColunas = "/html/body/div[3]/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div[4]/div/div";
	
	public final String popUpSalvarFormularioCampoId = "/html/body/div[3]/div[3]/div/div/div/div/div/div/div[1]/div/div/input";
	public final String popUpSalvarFormularioCampoNome = "/html/body/div[3]/div[3]/div/div/div/div/div/div/div[2]/div/div/input";
	public final String popUpSalvarFormularioCampoDescricao = "/html/body/div[3]/div[3]/div/div/div/div/div/div/div[3]/div/div/input";
	public final String popUpSalvarFormularioCampoCategoria = "/html/body/div[3]/div[3]/div/div/div/div/div/div/div[4]/div/div/input";
	public final String popUpBotaoSalvarFormulario= "/html/body/div[3]/div[3]/div/div/header/div/div[2]/button[1]";	
	public final String popUpBotaoFechar = "/html/body/div[3]/div[3]/div/div/header/div/div[2]/button[2]";	
	
	public final String botaoPublicarFormulario= "/html/body/div[2]/div[3]/div/div/header/div/div/button[3]/span[1]";	
		
	public final String mensagemSucessoSalvarRascunhoFormulario = "/html/body/div[1]/div/div[2]/main/div[2]/div/div[2]";	
	
	public final Integer segundos = 5;
	
	public void arrastarGridLayout() throws InterruptedException {
		dragAndDrop(gridLayout, campoRecebeDrops);
		
		esperaExplicitaEClica(botaoCriarNovoComponente, segundos);
		
		/*Thread.sleep(1000);
		esperaExplicita(popUpCriacaoGridLayoutNumeroDeLinhas, segundos);
		escrever(popUpCriacaoGridLayoutNumeroDeLinhas, "r");
		
		Thread.sleep(1000);
		esperaExplicita(popUpCriacaoGridLayoutNumeroDeColunas, segundos);
		escrever(popUpCriacaoGridLayoutNumeroDeColunas, "r");*/
		
		esperaExplicitaEClica(popUpCriacaoBotaoOk, segundos);
	}
	
	public void arrastarTextoCampos() throws InterruptedException {
		Thread.sleep(500);
		dragAndDrop(textoCampos, campoRecebeDrops);
	}
	
	public void salvarFormulario() throws InterruptedException {
		esperaExplicitaEClica(botaoSalvarDadosFormulario, segundos);
	}
	
	public void publicarFormulario() throws InterruptedException {
		Thread.sleep(1000);
		esperaExplicitaEClica(popUpBotaoFechar, segundos);
		esperaExplicitaEClica(botaoPublicarFormulario, segundos);
	}
	
	public void configurarDadosFormulario(String texto) throws InterruptedException {
		Thread.sleep(1000);
		esperaExplicitaEClica(popUpSalvarFormularioCampoId, segundos);
		escreverNomeComProtocolo(popUpSalvarFormularioCampoId, texto);
		escrever(popUpSalvarFormularioCampoNome, texto);
		escrever(popUpSalvarFormularioCampoDescricao, texto);
		escrever(popUpSalvarFormularioCampoCategoria, texto);
		
		esperaExplicitaEClica(popUpBotaoSalvarFormulario, segundos);
	}
	
	public String obterMensagemSucessoSalvarRascunhoFormulario() throws InterruptedException {
		return esperaExplicitaEObterTexto(mensagemSucessoSalvarRascunhoFormulario, segundos);
	}
	public String obterMensagemSucessoPublicarFormulario() throws InterruptedException {
		return esperaExplicitaEObterTexto(mensagemSucessoSalvarRascunhoFormulario, segundos);
	}
	
	public void selecionarMetadadoCadastrado() throws InterruptedException {
		esperaExplicitaEClica(metadadoCadastrado, segundos);
	}
	
	public void clicarBotaoSelecionarPopUp() throws InterruptedException {
		esperaExplicitaEClica(botaoSelecionar, segundos);
	}
	
	public Boolean seNaoHouverMetadadoInserido() {
		return obterQuantidadeElementosTabelaBoolean(campoRecebeDrops, campoRecebeDropsElementos);
	}
}
