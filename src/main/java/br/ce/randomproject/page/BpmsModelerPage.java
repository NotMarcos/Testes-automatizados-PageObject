package br.ce.randomproject.page;

import br.com.randomproject.core.BasePage;

public class BpmsModelerPage extends BasePage{

	public static String iconeCriarTarefa = "/html/body/div[1]/div/div[2]/main/div[2]/div/div/div/div[1]/div[2]/div/div/div[5]/div[1]/div[4]/div[1]";
	
	public static String CampoViewBPMN = "//*[@id=\"bpmnview\"]";
	
	public static String chaveDeBocaMiniMenuTarefa = "/html/body/div[1]/div/div[2]/main/div[2]/div/div/div/div[1]/div[2]/div/div/div[2]/div/div/div/div[2]/div[1]";

	public static String tarefaUsuarioChaveDeBocaMenu = "/html/body/div[1]/div/div[2]/main/div[2]/div/div/div/div[1]/div[2]/div/div/div[6]/div[2]/div[3]";
	
	public static String abaFormularios = "/html/body/div[1]/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div/div[2]/ul/li[6]/a";
	public static String selecionarFormularios = "/html/body/div[1]/div/div[2]/main/div[2]/div/div/div/div[2]/div/div/div/div[3]/div[6]/div/div[3]/div/div/div[2]/button/span";
	public static String camposFormularioTabela = "//*[@id=\"cam-extensionElements-form-fields\"]";
	public static String elementosCamposFormulariosTabela = ".//option";
	public static String botaoPreviewDosFormularios = "//*[@id=\"cam-extensionElements-forms-preview-button\"]";
	
	public static String campoProcurarTelaDeFormularios = "/html/body/div[2]/div[3]/div/div[2]/div/div[2]/div[1]/div/div[1]/div[2]/div/input";
	public static String selecionarFormulariosTelaDeFormularios = "//*[@id=\"customized-dialog-title\"]/..//span/input";
	public static String botaoFinalizarSelecao = "//*[@id=\"customized-dialog-title\"]/../div[2]//button"; 
	
	public static Integer segundos = 100;
	
	public void arrastarTarefaParaViewBPMN() throws InterruptedException {
		esperaExplicita(iconeCriarTarefa, 5);
		dragAndDrop(iconeCriarTarefa, CampoViewBPMN);
	}
	
	public void clicarChaveDeBocaMiniMenuTarefa() throws InterruptedException {
		esperaExplicitaEClica(chaveDeBocaMiniMenuTarefa, segundos);
	}
	
	public void clicarTarefaUsuarioChaveDeBocaMenu() throws InterruptedException {
		esperaExplicitaEClica(tarefaUsuarioChaveDeBocaMenu, segundos);
	}
	
	public void clicarAbaTarefas() throws InterruptedException {
		esperaExplicitaEClica(abaFormularios, segundos);
	}
	
	public void clicarSelecionarFormularios() throws InterruptedException {
		esperaExplicitaEClica(selecionarFormularios, segundos);
	}
	
	public void setCampoProcurarEmTelaDeFormularios(String texto) throws InterruptedException {
//		Thread.sleep(1500);
		esperaExplicitaEEscreve(campoProcurarTelaDeFormularios, texto, segundos);
	}

	public void marcarFormularios() throws InterruptedException {
		Thread.sleep(1000);
		clicarBotao(selecionarFormulariosTelaDeFormularios);
	}
	
	public void clicarFinalizarSelecao() throws InterruptedException {
//		Thread.sleep(1000);
		esperaExplicitaEClica(botaoFinalizarSelecao, segundos);
	}
	
	public Boolean seFormulariosNaoForamSelecionados() {
		return obterQuantidadeElementosTabelaBoolean(camposFormularioTabela, elementosCamposFormulariosTabela);
	}
	
	public void cliclarPreviewDosFormulariosSelecionados() throws InterruptedException {
		esperaExplicitaEClica(botaoPreviewDosFormularios, segundos);
	}
}
