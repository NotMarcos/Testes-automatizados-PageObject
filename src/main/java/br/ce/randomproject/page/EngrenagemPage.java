package br.ce.randomproject.page;

import br.com.randomproject.core.BasePage;

public class EngrenagemPage extends BasePage{
	
	public final String botaoEngrenagem = "/html/body/div/div/div[2]/header/div/div[2]/button[1]/span[1]";
	public final String campoLocalizarMenuLateral = "/html/body/div/div/div[2]/div[1]/div/div/ul/li/div/div[2]/input";
	public final String tituloFormularios = "/html/body/div/div/div[2]/div[1]/div/div/ul/div/li/div[2]/span";
	
	public final Integer segundos = 5;
	
	public void abrirTelaConfiguracoes() throws InterruptedException {
		esperaExplicitaEClica(botaoEngrenagem, segundos);
	}
	
	public void setCampoLocalizar(String nomeBusca) throws InterruptedException {
		esperaExplicita(campoLocalizarMenuLateral, segundos);
		escrever(campoLocalizarMenuLateral, nomeBusca); 
	}	
	
	public void abrirEntitulado() throws InterruptedException {
		esperaExplicitaEClica(tituloFormularios, segundos);
	}

}
