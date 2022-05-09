package br.ce.randomproject.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.randomproject.page.BpmsModelerPage;
import br.ce.randomproject.page.EngrenagemPage;
import br.com.randomproject.core.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CT027SelecaoDeFormulariosDoModeler extends BaseTest{

	public final String BPMS = "BPMS";
	public final String Criado = "Criado";
	
	EngrenagemPage configuracoes = new EngrenagemPage();
	BpmsModelerPage modeler = new BpmsModelerPage();
	
	@Test
	public void teste1_selecionarFormularios () throws InterruptedException {
		configuracoes.abrirTelaConfiguracoes();
		configuracoes.setCampoLocalizar(BPMS);
		configuracoes.abrirEntitulado();
		
		modeler.arrastarTarefaParaViewBPMN();
		modeler.clicarChaveDeBocaMiniMenuTarefa();
		modeler.clicarTarefaUsuarioChaveDeBocaMenu();
		modeler.clicarAbaTarefas();
		modeler.clicarSelecionarFormularios();
		modeler.setCampoProcurarEmTelaDeFormularios(Criado);
		modeler.marcarFormularios();
		modeler.clicarFinalizarSelecao();
		
		Assert.assertTrue("Os formularios não foram selecionados", modeler.seFormulariosNaoForamSelecionados());
	}
}
