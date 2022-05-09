package br.ce.randomproject.page;

import static br.com.randomproject.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.com.randomproject.core.BasePage;

public class LoginPage extends BasePage {

	public void acessarTelaInicial() throws InterruptedException {
		getDriver().get("www.umsitequalquer.com.br");
	}

	public void esperarLoadingDaPagina(Integer segundos) throws InterruptedException {
		esperaExplicita(By.name("email"), segundos);
	}

	public void setEmail(String email) {
		escrever(By.name("email"), email);
	}

	public void setSenha(String senha) {
		escrever(By.name("password"), senha);
	}

	public void entrar() {
		clicarBotao(By.xpath("//button[@type='submit']"));
	}
	
	public void loginSmartdocs() throws InterruptedException {
		acessarTelaInicial();
		esperarLoadingDaPagina(20);
		setEmail("umemailqualquer@random.com.br");
		setSenha("umasenhaqualquer");
		entrar();
	}
}