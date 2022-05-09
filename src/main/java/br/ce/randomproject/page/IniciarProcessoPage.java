package br.ce.randomproject.page;

import br.com.randomproject.core.BasePage;

public class IniciarProcessoPage extends BasePage{

	public final String processoAssinaturaDigital = "//td[@value='Assinatura Digital']/..//button[1]";
	
	public final Integer segundos = 5;
	
	public void executarProcessoAssinaturaEletronica() throws InterruptedException{
		esperaExplicitaEClica(processoAssinaturaDigital, segundos);
	}
}
