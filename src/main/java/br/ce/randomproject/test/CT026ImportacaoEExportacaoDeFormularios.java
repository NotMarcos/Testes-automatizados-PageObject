package br.ce.randomproject.test;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.Assert;

import br.ce.randomproject.page.EngrenagemPage;
import br.ce.randomproject.page.FormulariosPage;
import br.com.randomproject.core.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CT026ImportacaoEExportacaoDeFormularios extends BaseTest{

	public final String formularios = "forms";
	public final String CT026Criado = "CT026-Criado";
	public final String IdRepetido = "caso-teste-ct025";

	EngrenagemPage configuracoes = new EngrenagemPage();
	FormulariosPage telaFormulario = new FormulariosPage();

	@Test
	public void teste1_ImportacaoDeFormularioJSON() throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(formularios);
		configuracoes.abrirEntitulado();

		telaFormulario.clicarBotaoImportar();
		telaFormulario.escreverIdNaoRepetidoPopUp(CT026Criado);
		telaFormulario.importarArquivoJSONPopUp();

		Assert.assertEquals("File arquivoTeste.json successfully added.", telaFormulario.obterMensagemSucessoImportacaoFormulario());

		telaFormulario.clicarBotaoConfirmarImportarPopUP();

		Assert.assertEquals("Form successfully imported", telaFormulario.obterMensagemSucesso());
	}

	@Test
	public void teste2_ImportacaoDeFormularioJSONComIdRepetido() throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(formularios);
		configuracoes.abrirEntitulado();

		telaFormulario.clicarBotaoImportar();
		telaFormulario.escreverIdRepetidoPopUp(IdRepetido);
		telaFormulario.importarArquivoJSONPopUp();

		Assert.assertEquals("File arquivoTeste.json successfully added.", telaFormulario.obterMensagemSucessoImportacaoFormulario());

		telaFormulario.clicarBotaoConfirmarImportarPopUP();

		Assert.assertEquals("O id do formulário é repetido.", telaFormulario.obterMensagemSucesso());
	}

	@Test
	public void teste3_ImportacaoDeFormularioPDF() throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(formularios);
		configuracoes.abrirEntitulado();

		telaFormulario.clicarBotaoImportar();
		telaFormulario.escreverIdNaoRepetidoPopUp(CT026Criado);
		telaFormulario.importarArquivoPDFPopUp();

		Assert.assertEquals("File arquivoTeste.pdf was rejected. File type not supported.", telaFormulario.obterMensagemSucessoImportacaoFormulario());
	}

	@Ignore
	@Test
	public void teste4_ImportacaoDeFormularioSemArquivoAnexado() throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(formularios);
		configuracoes.abrirEntitulado();

		telaFormulario.clicarBotaoImportar();
		telaFormulario.escreverIdNaoRepetidoPopUp(CT026Criado);

		telaFormulario.clicarBotaoConfirmarImportarPopUP();

		Assert.assertEquals(" ", telaFormulario.obterMensagemSucesso());
	}

	@Test
	public void teste5_ExportacaoDeFormulario() throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(formularios);
		configuracoes.abrirEntitulado();

		telaFormulario.setCampoProcurar(CT026Criado);
		telaFormulario.abrirAcoesFormularioAtivo();
		telaFormulario.contarArquivosDiretorioAntes();
		telaFormulario.clicarBotaoExportarMenuAcoes();
		telaFormulario.contarArquivosDiretorioDepois();
		
		Assert.assertTrue("O arquivo não foi baixado", telaFormulario.seNaoBaixouArquivo());
	}
}
