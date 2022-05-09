package br.ce.randomproject.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.randomproject.page.RepositorioCentralPage;
import br.com.randomproject.core.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CT009ListarPastasCriadas extends BaseTest{
	
	RepositorioCentralPage repositorioCentral = new RepositorioCentralPage();
	
	@Test
	public void teste1_ListarPastas() throws InterruptedException {
		repositorioCentral.expandirMenuRepositorioCentral();
		repositorioCentral.expandirPastaValidacaoTeste();
		repositorioCentral.retrairPastaValidacaoTeste();
	}

}
