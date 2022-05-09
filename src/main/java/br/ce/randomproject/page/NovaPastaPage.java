package br.ce.randomproject.page;

import br.com.randomproject.core.BasePage;

public class NovaPastaPage extends BasePage{

	public final String campoTituloPasta = "/html/body/div[1]/div/div[2]/main/div[2]/div[3]/div[1]/div/textarea";
	public final String localWorkspace = "/html/body/div[1]/div/div[2]/main/div[2]/div[2]/ul/li/div/div[2]/div/p";
	public final String localPasta = "/html/body/div[1]/div/div[2]/main/div[2]/div[2]/ul/li/ul/div/div/li[3]/div/div[2]/div/p";
	public final String campoDescricaoPasta = "/html/body/div[1]/div/div[2]/main/div[2]/div[3]/div[3]/div/textarea";
	public final String botaoSalvar = "/html/body/div[1]/div/div[2]/main/div[2]/div[3]/div[5]/button[2]/span[1]";
	public final String popUpMensagem = "/html/body/div[1]/div/div[2]/main/div[2]/div[4]/div/div[2]";
	
	public final String divMuiPopOver = "/html/body/div[3]";
	
	public final Integer segundos = 4;
	
	public void esperaSumir() throws InterruptedException {
		esperaExplicitaSumir(divMuiPopOver, segundos);
	}
	
	public void setNomePasta(String tituloPasta) {
		escrever(campoTituloPasta, tituloPasta); 
	}
	
	public void EsperaCampoEEscreveNomePastaProtocolo(String tituloPasta) throws InterruptedException {
		esperaExplicitaEEscreveAleatorio(campoTituloPasta, tituloPasta, segundos); 
	}
	
	
	public void setNomePastaProtocolo(String tituloPasta) {
		escreverNomeComProtocolo(campoTituloPasta, tituloPasta); 
	}
	
	public void selecionarLocalWorkspace() throws InterruptedException {
		esperaSumir();
		esperaExplicitaEClica(localWorkspace, segundos);
	}
	
	public void selecionarLocalPasta() throws InterruptedException {
		esperaExplicitaEClica(localPasta, segundos);
	}
	
	public void setDescricaoPasta(String descricaoPasta) {
		escrever(campoDescricaoPasta, descricaoPasta);
	}
	
	public void setDescricaoPastaProtocolo(String descricaoPasta) {
		escreverNomeComProtocolo(campoDescricaoPasta, descricaoPasta);
	}
	
	public void salvarPasta() {
		clicarBotao(botaoSalvar);
	}
	
	public String obterMensagemSucesso() throws InterruptedException {
		return esperaExplicitaEObterTexto(popUpMensagem, segundos);
	}
	
	public String obterMensagemFalha() throws InterruptedException {
		return esperaExplicitaEObterTexto(popUpMensagem, segundos);
	}
}
