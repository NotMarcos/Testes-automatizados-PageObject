package br.ce.randomproject.page;

import br.com.randomproject.core.BasePage;

public class MenuMaisPage extends BasePage{
	
	public final String botaoMenuMais = "/html/body/div[1]/div/div[2]/div[1]/div/div/ul/li/div[1]/button";
	public final String botaoNovaPasta = "//html/body/div[3]/div[3]/ul/li[1]/div[2]/span";
	public final String botaoIniciarProcesso = "/html/body/div[3]/div[3]/ul/li[3]";
	
	public final Integer segundos = 5;

	public void acessarTelaNovaPasta() throws InterruptedException {
		esperaExplicitaEClica(botaoMenuMais, segundos);
		esperaExplicitaEClica(botaoNovaPasta, segundos);
	}
	
	public void acessarTelaIniciarProcesso() throws InterruptedException {
		esperaExplicitaEClica(botaoMenuMais, segundos);
		esperaExplicitaEClica(botaoIniciarProcesso, segundos);
	}
}
