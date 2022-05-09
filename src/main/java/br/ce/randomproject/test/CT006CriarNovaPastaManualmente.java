package br.ce.randomproject.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.randomproject.page.MenuMaisPage;
import br.ce.randomproject.page.NovaPastaPage;
import br.com.randomproject.core.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CT006CriarNovaPastaManualmente extends BaseTest {
	
	private String tituloPastaNaoRepetido = "CT06- Criado";
	private String descricaoPastaNaoRepetida = "Descrição CT06";
	private String tituloPastaRepetido = "Validação de Testes";
	private String descricaoPastaRepetido = "Validação de Testes";
	
	MenuMaisPage maisMenuPage = new MenuMaisPage();
	NovaPastaPage novaPastaPage = new NovaPastaPage();
	
	@Test
	public void teste1_CriarNovaPastaSemSelecionarWorkspace() throws InterruptedException {
		maisMenuPage.acessarTelaNovaPasta();
		
		novaPastaPage.EsperaCampoEEscreveNomePastaProtocolo(tituloPastaNaoRepetido);
		novaPastaPage.setDescricaoPastaProtocolo(descricaoPastaNaoRepetida);
		novaPastaPage.salvarPasta();
		
		Assert.assertEquals("O corpo da requisição está inválido. Verifique erro de sintaxe.", novaPastaPage.obterMensagemFalha());
	}

	@Test
	public void teste2_CriarNovaPastaNaArvoreDePastas() throws InterruptedException {
		maisMenuPage.acessarTelaNovaPasta();
		
		novaPastaPage.selecionarLocalWorkspace();
		novaPastaPage.setNomePastaProtocolo(tituloPastaNaoRepetido);
		novaPastaPage.setDescricaoPastaProtocolo(descricaoPastaNaoRepetida);
		novaPastaPage.salvarPasta();
		
		Assert.assertEquals("Folder created successfully!", novaPastaPage.obterMensagemSucesso());
	}
			
	@Test
	public void teste3_CriarNovaPastaComTituloRepetidoNaArvoreDePastas() throws InterruptedException {
		maisMenuPage.acessarTelaNovaPasta();
		
		novaPastaPage.selecionarLocalWorkspace();
		novaPastaPage.setNomePasta(tituloPastaRepetido);
		novaPastaPage.setDescricaoPastaProtocolo(descricaoPastaNaoRepetida);
		novaPastaPage.salvarPasta();
		
		Assert.assertEquals("O título da pasta é repetido", novaPastaPage.obterMensagemFalha());
	}
	
	@Test
	public void teste4_CriarNovaPastaComDescricaoRepetidaNaArvoreDePastas() throws InterruptedException {
		maisMenuPage.acessarTelaNovaPasta();
		
		novaPastaPage.selecionarLocalWorkspace();
		novaPastaPage.setNomePastaProtocolo(tituloPastaNaoRepetido);
		novaPastaPage.setDescricaoPasta(descricaoPastaRepetido);
		novaPastaPage.salvarPasta();
		
		Assert.assertEquals("Folder created successfully!", novaPastaPage.obterMensagemSucesso());
	}
	
	@Test
	public void teste5_CriarNovaPastaComDescricaoETituloRepetidoNaArvoreDePastas() throws InterruptedException {
		maisMenuPage.acessarTelaNovaPasta();
		
		novaPastaPage.selecionarLocalWorkspace();
		novaPastaPage.setNomePasta(tituloPastaRepetido);
		novaPastaPage.setDescricaoPasta(descricaoPastaRepetido);
		novaPastaPage.salvarPasta();
		
		Assert.assertEquals("O título da pasta é repetido", novaPastaPage.obterMensagemFalha());
	}
	
	@Test
	public void teste6_CriarNovaSubpasta() throws InterruptedException {
		maisMenuPage.acessarTelaNovaPasta();
		
		novaPastaPage.selecionarLocalWorkspace();
		novaPastaPage.selecionarLocalPasta();
		novaPastaPage.setNomePastaProtocolo(tituloPastaNaoRepetido);
		novaPastaPage.setDescricaoPastaProtocolo(descricaoPastaNaoRepetida);
		novaPastaPage.salvarPasta();
		
		Assert.assertEquals("Folder created successfully!", novaPastaPage.obterMensagemSucesso());
	}
	
	
	@Test
	public void teste7_CriarSubpastaComTituloRepetido() throws InterruptedException {
		maisMenuPage.acessarTelaNovaPasta();
		
		novaPastaPage.selecionarLocalWorkspace();
		novaPastaPage.selecionarLocalPasta();
		novaPastaPage.setNomePasta(tituloPastaRepetido);
		novaPastaPage.setDescricaoPastaProtocolo(descricaoPastaNaoRepetida);
		novaPastaPage.salvarPasta();
		
		Assert.assertEquals("O título da pasta é repetido", novaPastaPage.obterMensagemFalha());
	}
	
	@Test
	public void teste8_CriarNovaSubpastaComDescricaoRepetida() throws InterruptedException {
		maisMenuPage.acessarTelaNovaPasta();
		
		novaPastaPage.selecionarLocalWorkspace();
		novaPastaPage.selecionarLocalPasta();
		novaPastaPage.setNomePastaProtocolo(tituloPastaNaoRepetido);
		novaPastaPage.setDescricaoPasta(descricaoPastaRepetido);
		novaPastaPage.salvarPasta();
		
		Assert.assertEquals("Folder created successfully!", novaPastaPage.obterMensagemSucesso());
	}
	
}
