package br.ce.randomproject.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.randomproject.page.RepositorioCentralPage;
import jdk.nashorn.internal.ir.annotations.Ignore;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CT010ListarRepositorioDePastasCriadas {

	RepositorioCentralPage repositorioCentral = new RepositorioCentralPage();
	
	@org.junit.Ignore
	@Test
	public void teste1_RepositorioCentral() throws InterruptedException {
		repositorioCentral.expandirMenuRepositorioCentral();
	}
	
}
