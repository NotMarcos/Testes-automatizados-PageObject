package br.ce.randomproject.page;

import br.com.randomproject.core.BasePage;

public class FormulariosPage extends BasePage{
	
	public final String tituloTelaFormularios = "/html/body/div[1]/div/div[2]/main/div[2]/div[1]/p";
	
	public final String botaoMais = "/html/body/div[1]/div/div[2]/main/div[2]/div[2]/div[1]/div/div[1]/div[3]/div/div/span/button[2]/span[1]";
	public final String campoProcurar = "/html/body/div[1]/div/div[2]/main/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/input";
	public final String inativarMenuAcoes = "/html/body/div[6]/div[3]/ul/li[5]/div[2]/span";
	public final String botaoImportar = "/html/body/div[1]/div/div[2]/main/div[2]/div[2]/div[1]/div/div[1]/div[3]/div/div/span/button[3]/span[1]/span";
	
	public final String ativarMenuAcoes = inativarMenuAcoes;
	public final String excluirEmMenuAcoes = "/html/body/div[6]/div[3]/ul/li[2]/div[2]/span";
	public final String exportarEmMenuAcoes = "/html/body/div[6]/div[3]/ul/li[4]/div[2]/span";
	
	public final String inativarPopUp = "/html/body/div[6]/div[3]/div/div[3]/div/button[2]/span[1]";
	public final String ativarPopUp = inativarPopUp;
	public final String botaoConfirmarExclusaoPopUp = "/html/body/div[6]/div[3]/div/div[3]/button[1]/span[1]";
	public final String campoIdPopUp = "/html/body/div[6]/div[3]/div/div[2]/div[1]/div/input";
	public final String campoUploadPopUp = "/html/body/div[6]/div[3]/div/div[2]/div[2]/input";
	public final String botaoImportarPopUp = "/html/body/div[6]/div[3]/div/div[3]/div/button[2]";
	
	public final String gridTelaFormularios = "/html/body/div[1]/div/div[2]/main/div[2]/div[2]/div[1]/div/div[2]/div/div/div/table/tbody";
	public final String indiceGridTelaFormularios = ".//p";
	
	public final String mensagemSucesso = "/html/body/div[1]/div/div[2]/main/div[2]/div[3]/div/div[2]";
	public final String mensagemSucessoImportacaoFormulario = "//*[@id=\"client-snackbar\"]";
	
	public final Integer segundos = 5;
	
	public Integer quantidadeArquivosAntes = null;
	public Integer quantidadeArquivosDepois = null;

	telaCriacaoFormulariosPage telaCriacaoFormularios = new telaCriacaoFormulariosPage();
	
	public String obterTituloTelaFormularios() throws InterruptedException {
		return esperaExplicitaEObterTexto(tituloTelaFormularios, segundos);
	}
	
	public void clicarBotaoNovo() throws InterruptedException {
		esperaExplicitaEClica(botaoMais, segundos);
	}
	
	public void clicarBotaoImportar() throws InterruptedException {
		esperaExplicitaEClica(botaoImportar, segundos);
	}
	
	public void clicarBotaoConfirmarImportarPopUP() throws InterruptedException {
		esperaExplicitaEClica(botaoImportarPopUp, segundos);
	}
	
	public void setCampoProcurar(String nomeFormulario) throws InterruptedException {
		esperaExplicita(campoProcurar, segundos);
		escrever(campoProcurar, nomeFormulario);
		Thread.sleep(1000);
	}
	
	public void abrirAcoesFormularioAtivo() throws InterruptedException {
		esperaExplicita(gridTelaFormularios, segundos);
		clicarIndiceLinha("Active", gridTelaFormularios, indiceGridTelaFormularios);
	}
	
	public void abrirAcoesFormularioInativo() throws InterruptedException {
		esperaExplicita(gridTelaFormularios, segundos);
		clicarIndiceLinha("Inactive" , gridTelaFormularios, indiceGridTelaFormularios);
	}
	
	public void confirmarExclusaoFormulario() throws InterruptedException {
		esperaExplicitaEClica(botaoConfirmarExclusaoPopUp, segundos);
	}
	
	public void clicarBotaoInativarMenuAcoes() throws InterruptedException {
		esperaExplicitaEClica(inativarMenuAcoes, segundos);
	}
	
	public void clicarBotaoAtivarMenuAcoes() throws InterruptedException {
		esperaExplicitaEClica(ativarMenuAcoes, segundos);
	}
	
	public void clicarBotaoExcluirMenuAcoes() throws InterruptedException {
		esperaExplicitaEClica(excluirEmMenuAcoes, segundos);
	}
	
	public void clicarBotaoExportarMenuAcoes() throws InterruptedException {
		esperaExplicitaEClica(exportarEmMenuAcoes, segundos);
		Thread.sleep(1000);
	}
	
	public void confirmarInativacaoPopUP() throws InterruptedException {
		esperaExplicitaEClica(inativarPopUp, segundos);
	}
	
	public void confirmarAtivacaoPopUP() throws InterruptedException {
		esperaExplicitaEClica(ativarPopUp, segundos);
	}
	
	public void escreverIdNaoRepetidoPopUp(String nomeID) throws InterruptedException {
		esperaExplicita(campoIdPopUp, segundos);
		escreverNomeComProtocolo(campoIdPopUp, nomeID);
	}
	
	public void escreverIdRepetidoPopUp(String nomeID) throws InterruptedException {
		esperaExplicita(campoIdPopUp, segundos);
		escrever(campoIdPopUp, nomeID);
	}
	
	public void importarArquivoJSONPopUp() throws InterruptedException {
		uploadArquivoJSON(campoUploadPopUp);
	}
	
	public void importarArquivoPDFPopUp() throws InterruptedException {
		uploadArquivoPDF(campoUploadPopUp);
	}
	
	public void contarArquivosDiretorioAntes() {
		quantidadeArquivosAntes = getQuantidadeArquivosDiretorio();
	}
	
	public void contarArquivosDiretorioDepois() {
		quantidadeArquivosDepois = getQuantidadeArquivosDiretorio();
	}
	
	public Boolean seNaoBaixouArquivo() {
		if(quantidadeArquivosAntes<quantidadeArquivosDepois) {
			return true;
		} else {
		return false;
		}
	}
	
	public String obterMensagemSucesso() throws InterruptedException {
		return esperaExplicitaEObterTexto(mensagemSucesso, segundos);
	}
	
	public String obterMensagemSucessoImportacaoFormulario() throws InterruptedException {
		return esperaExplicitaEObterTexto(mensagemSucessoImportacaoFormulario, segundos);
	}
}
