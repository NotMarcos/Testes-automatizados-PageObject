package br.ce.randomproject.page;

import br.com.randomproject.core.BasePage;

public class MetadadosPage extends BasePage{
	
	public static String botaoMais = "//button[contains(@class, 'MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit') and contains(@type, 'button')][2]";
	public static String campoProcurar = "//main[@id='contentData']//input[@type='text']";
	public static String botaoAcoes = "/html/body/div[1]/div/div[2]/main/div[2]/div[2]/div[1]/div/div[2]/div/div/div/table/tbody/tr[1]/td[6]/div/button";
	
	public static String menuAcoesExcluir = "//span[contains(text(),'Remove')]"; //renomear para 'Excluir'
	public static String campoAtivoInativo = "//body/div[@id='root']/div/div[@class='MuiGrid-root']/main[@id='contentData']/div[@class='MuiGrid-root']/div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12']/div[@style='padding-bottom: 3%;']/div[@class='MuiPaper-root MuiPaper-elevation2 MuiPaper-rounded']/div[@class='jss224']/div/div[@style='overflow-y: auto;']/div/table[@class='MuiTable-root']/tbody[@class='MuiTableBody-root']/tr[1]/td[5]";
	public static String ativoInativoAcoes = "./following-sibling::td//button";
	
	public static String botaoConfirmarExclusao = menuAcoesExcluir;
	
	public static String popUpSelecionarComponente = "//div[@id='component-select']";
	
	public static String componentesBaseCampo = "//ul[@class='MuiList-root MuiMenu-list MuiList-padding']";
	public static String componentesBaseCampoElementos = ".//li";
	public static String botaoConfirmarComponenteSelecionado = "//span[contains(text(),'Select')]";
	
	public static String botaoSalvar = "//span[@class='MuiButton-label']";
	
	public static String mensagemSucesso = "/html/body/div/div/div[2]/main/div[2]/div[4]/div/div[2]";
	public static String mensagemExcluidoSucesso = "/html/body/div[1]/div/div[2]/main/div[2]/div[3]/div/div[2]";
	
	public static Integer segundos = 5;
	
	public void clicarBotaoNovo() throws InterruptedException {
		esperaExplicitaEClica(botaoMais, segundos);
	}
	
	public void selecionarCampoComponenteBase() throws InterruptedException {
		esperaExplicitaEClica(popUpSelecionarComponente, segundos);
	}

	public void selecionarPrimeiroComponenteBase() throws InterruptedException {
		Thread.sleep(500);
		clicarPrimeiraOpcaoCombo(componentesBaseCampo, componentesBaseCampoElementos);
	}
	
	public void clicarBotaoSelecionar() throws InterruptedException {
		Thread.sleep(500);
		esperaExplicitaEClica(botaoConfirmarComponenteSelecionado, segundos);
	}
	
	public void clicarBotaoSalvar() throws InterruptedException {
		esperaExplicitaEClica(botaoSalvar, segundos);
	}
	
	public void pesquisarMetadado(String texto) throws InterruptedException {
		esperaExplicitaEEscreve(campoProcurar, texto, segundos);
		Thread.sleep(1000);
	}
	
	public void clicarAcoes() throws InterruptedException {
		esperaExplicitaEClica(botaoAcoes, segundos);
	}
	
	public void clicarMenuAcoesExcluir() throws InterruptedException {
		esperaExplicitaEClica(menuAcoesExcluir, segundos);
	}
	
	public void confirmarExclusao() throws InterruptedException {
		esperaExplicitaEClica(botaoConfirmarExclusao, segundos);
	}
	
	public String obterMensagemSucesso() throws InterruptedException {
		return esperaExplicitaEObterTexto(mensagemSucesso, segundos);
	}
	public String obterMensagemExcluidoSucesso() throws InterruptedException {
		return esperaExplicitaEObterTexto(mensagemExcluidoSucesso, segundos);
	}
	
	public void inativarMetadado() {
		clicarIndiceLinha2("Active", campoAtivoInativo, ativoInativoAcoes);
	}
}
