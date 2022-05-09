package br.ce.randomproject.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.randomproject.test.CT006CriarNovaPastaManualmente;
import br.ce.randomproject.test.CT007ExcluirPastaManualmente;
import br.ce.randomproject.test.CT008EditarPastaManualmente;
import br.ce.randomproject.test.CT009ListarPastasCriadas;
import br.ce.randomproject.test.CT010ListarRepositorioDePastasCriadas;
import br.ce.randomproject.test.CT025GestaoDeFormularios;
import br.ce.randomproject.test.CT026ImportacaoEExportacaoDeFormularios;
import br.ce.randomproject.test.CT027SelecaoDeFormulariosDoModeler;
import br.ce.randomproject.test.CT028PreviewDeFormulariosNoModeler;
import br.ce.randomproject.test.CT029IntegracaoEntreFormulariosEMetadados;
import br.ce.randomproject.test.CT030GestaoDeMetadados;

@RunWith(Suite.class)
@SuiteClasses({
	CT006CriarNovaPastaManualmente.class,
	CT007ExcluirPastaManualmente.class,
	CT008EditarPastaManualmente.class,
	CT009ListarPastasCriadas.class,
	CT010ListarRepositorioDePastasCriadas.class,
	CT025GestaoDeFormularios.class,
	CT026ImportacaoEExportacaoDeFormularios.class,
	CT027SelecaoDeFormulariosDoModeler.class,
	CT028PreviewDeFormulariosNoModeler.class,
	CT029IntegracaoEntreFormulariosEMetadados.class,
	CT030GestaoDeMetadados.class
})
public class SuiteGeral {

}
