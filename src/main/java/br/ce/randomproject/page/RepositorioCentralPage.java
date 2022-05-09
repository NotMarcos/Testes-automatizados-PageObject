package br.ce.randomproject.page;

import br.com.randomproject.core.BasePage;

public class RepositorioCentralPage extends BasePage{
	
	public final String repositorioCentral = "/html/body/div[1]/div/div[2]/div[1]/div/div/ul/div[6]/div/div/div/div/div/ul/li/div";
	public final String pastaValidacaoTeste = "/html/body/div[1]/div/div[2]/div[1]/div/div/ul/div[6]/div/div/div/div/div/ul/li/ul/div/div/li[3]/div/div[2]/div/p";
	
	public final String listaSubpastasValidacaoTeste = "/html/body/div[1]/div/div[2]/div[1]/div/div/ul/div[6]/div/div/div/div/div/ul/li/ul/div/div/li[3]/ul/div/div";
	public final String listaSubpastasValidacaoTesteUnidade = "./li//p";
	
	public final String listaSubpastasRepositorio = "/html/body/div[1]/div/div[2]/div[1]/div/div/ul/div[6]/div/div/div/div/div/ul/li/ul/div/div";
	public final String listaSubpastasRepositorioUnidade = "./li//p";
	
	public final String excluirEmMenuContexto = "/html/body/div[2]/div[3]/ul/li[3]"; 
	public final String renomearEmMenuContexto = "/html/body/div[2]/div[3]/ul/li[2]";
	
	public final String campoRenomearEmPopUp = "/html/body/div[3]/div[3]/div/div[2]/div[1]/div/textarea";
	public final String campoDescricaoEmPop = "/html/body/div[3]/div[3]/div/div[2]/div[3]/div/textarea";
	public final String excluirEmPopUp = "/html/body/div[3]/div[3]/div/div[3]/div/button[2]/span[1]";
	public final String clicarConfirmarPopUp = "/html/body/div[3]/div[3]/div/div[3]/div/button[2]/span[1]";
	
	public final String mensagemPopUpCriacaoPasta = "/html/body/div[1]/div/div[2]/main/div[2]/div/div[2]";
	public final String mensagemPopUpRenomeacaoPasta = "/html/body/div[1]/div/div[2]/main/div[2]/div/div[2]";
	
	public final Integer segundos = 5;

	public void expandirMenuRepositorioCentral() throws InterruptedException {
		esperaExplicitaEClica(repositorioCentral, segundos);
	}
	
	public void expandirPastaValidacaoTeste() throws InterruptedException {
		esperaExplicitaEClica(pastaValidacaoTeste, segundos);
		Thread.sleep(500);
	}
	
	public void retrairPastaValidacaoTeste() throws InterruptedException {
		esperaExplicitaEClica(pastaValidacaoTeste, segundos);
		Thread.sleep(500);
	}
	
	public void abrirMenuContextoDaSubpastaValidacaoTeste() throws InterruptedException {
		esperaExplicita(listaSubpastasValidacaoTeste, segundos);
		clicarBotaoDireitoIndiceLinha("CT06-", listaSubpastasValidacaoTeste, listaSubpastasValidacaoTesteUnidade);
	}
	
	public void abrirMenuContextoDaPastaNoRepositorio() throws InterruptedException {
		esperaExplicita(listaSubpastasRepositorio, segundos);
		clicarBotaoDireitoIndiceLinha("CT06-", listaSubpastasRepositorio, listaSubpastasRepositorioUnidade);
	}
	
	public void clicarExcluirEmMenuContexto() throws InterruptedException {
		esperaExplicitaEClica(excluirEmMenuContexto, segundos);
	}
	
	public void confirmarExclusaoEmPopUp() throws InterruptedException {
		esperaExplicitaEClica(excluirEmPopUp, segundos);
	}
	
	public void clicarRenomearEmMenuContexto() throws InterruptedException {
		esperaExplicitaEClica(renomearEmMenuContexto, segundos);
	}
	
	public void clicarCampoRenomearPopUp() throws InterruptedException {
		esperaExplicitaEClica(campoRenomearEmPopUp, segundos);
	}
	
	public void setNomePastaProtocolo(String tituloPasta) throws InterruptedException {
		esperaExplicitaEClica(campoRenomearEmPopUp, segundos);
		escreverNomeComProtocolo(campoRenomearEmPopUp, tituloPasta); 
	}
	
	public void setDescricaoPastaProtocolo(String tituloPasta) throws InterruptedException {
		esperaExplicitaEClica(campoDescricaoEmPop, segundos);
		escreverNomeComProtocolo(campoDescricaoEmPop, tituloPasta); 
	}
	
	public void setNomePasta(String tituloPasta) {
		escrever(campoRenomearEmPopUp, tituloPasta); 
	}	
	
	public void limparCampoRenomear() throws InterruptedException {
		Thread.sleep(1000);
		esperaExplicita(campoRenomearEmPopUp, segundos);
		limparCampo(campoRenomearEmPopUp);
	}
	
	public void limparCampoDescricao() throws InterruptedException {
		Thread.sleep(1000);
		esperaExplicita(campoDescricaoEmPop, segundos);
		limparCampo(campoDescricaoEmPop);
	}
	
	public void clicarConfirmarRenomearPopUp() throws InterruptedException {
		esperaExplicitaEClica(clicarConfirmarPopUp, segundos);
	}
	
	public String obterMensagemSucesso() throws InterruptedException {
		return esperaExplicitaEObterTexto(mensagemPopUpRenomeacaoPasta, segundos);
	}
}
