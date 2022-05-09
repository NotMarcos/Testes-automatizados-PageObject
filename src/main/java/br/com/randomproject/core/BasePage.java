package br.com.randomproject.core;

import static br.com.randomproject.core.DriverFactory.getDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	/********* TextField e TextArea ************/
	
	public void escrever(By by, String texto){
		getDriver().findElement(by).click();
		getDriver().findElement(by).sendKeys(texto);
	}

	public void escrever(String name_campo, String texto){
		escrever(By.xpath(name_campo), texto);
	}
	
	public void escreverNomeComProtocolo(String name_campo, String texto){
		String protocolo = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
		escrever(By.xpath(name_campo), texto+"-"+protocolo);
	}
	
	public String obterNomeComProtocolo(String texto){
		String protocolo = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
		return texto+"-"+protocolo;
	}
	
	
	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	public void limparCampo(By by) {
		getDriver().findElement(by).clear();
	}
	
	public void limparCampo(String nomeCampo) {
		limparCampo(By.xpath(nomeCampo));
	}
	
	/********* Upload e download de arquivos ************/
	
	public void uploadArquivoPDF(By by) throws InterruptedException {
		Thread.sleep(200);
		WebElement input = getDriver().findElement(by);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		js.executeScript("arguments[0].style='display: block;'", input);
		
		input.sendKeys(System.getProperty("user.dir") + File.separator +"target" + File.separator +"arquivos de teste para upload" + File.separator + "arquivoTeste.pdf");
	}
	
	public void uploadArquivoPDF(String nomeCampo) throws InterruptedException {
		uploadArquivoPDF(By.xpath(nomeCampo));
	}
	
	public void uploadArquivoJSON(By by) throws InterruptedException {
		Thread.sleep(200);
		WebElement input = getDriver().findElement(by);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		js.executeScript("arguments[0].style='display: block;'", input);
		
		input.sendKeys(System.getProperty("user.dir") + File.separator +"target" + File.separator +"arquivos de teste para upload" + File.separator + "arquivoTeste.json");
	}
	
	public void uploadArquivoJSON(String nomeCampo) throws InterruptedException {
		uploadArquivoJSON(By.xpath(nomeCampo));
	}
	
	public void getNomeDoUltimoArquivoBaixado() {
	    File getLatestFile = getUltimoArquivoBaixado();
	    String fileName = getLatestFile.getName();
	}
	
	public File getUltimoArquivoBaixado() {
		File diretorioDownloads = new File(System.getProperty("user.dir") + File.separator +"target" + File.separator + "download de arquivos de teste");
		File[] files = diretorioDownloads.listFiles();
		
		if (files.length == 0) return null;
		
	    Arrays.sort(files, new Comparator<File>() {
	        public int compare(File o1, File o2) {
	            return Long.valueOf(o2.lastModified()).compareTo(o1.lastModified()); 
	        }});
	    
	    return files[0];
	}
	
	public int getQuantidadeArquivosDiretorio() {
		File diretorioDownloads = new File(System.getProperty("user.dir") + File.separator +"target" + File.separator + "download de arquivos de teste");
		File[] files = diretorioDownloads.listFiles();
		
		int quantidadeArquivos = files.length;
		return quantidadeArquivos;
	}

	/********* Drag and drop's ************/
	
	public void dragAndDrop(By localDrag, By localDrop) {
		WebElement drag = getDriver().findElement(localDrag);
		WebElement drop = getDriver().findElement(localDrop);
		
		Actions action = new Actions(getDriver());
		action.dragAndDrop(drag, drop).perform();
	}
	
	public void dragAndDrop(String localDrag, String localDrop) {
		dragAndDrop(By.xpath(localDrag), By.xpath(localDrop));
	}
	
	/********* Radio e Check ************/
	
	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarRadio(String id) {
		clicarRadio(By.id(id));
	}
	
	public boolean isRadioMarcado(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void clicarCheck(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public boolean isCheckMarcado(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	/********* Combo ************/
	
	public void clicarPrimeiraOpcaoCombo(String xpath, String xpathComplemento) {
		WebElement element =  getDriver().findElement(By.xpath(xpath));
		List<WebElement> elements = element.findElements(By.xpath(xpathComplemento));
		
		elements.get(1).click();
	}
	
	public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void deselecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public List<String> obterValoresCombo(String id) {
		WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	
	public int obterQuantidadeOpcoesCombo(String id){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	public boolean verificarOpcaoCombo(String id, String opcao){
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao)){
				return true;
			}
		}
		return false;
	}
	
	public void selecionarComboPrime(String radical, String valor) {
		clicarRadio(By.xpath("//*[@id='"+radical+"_input']/../..//span"));
		clicarRadio(By.xpath("//*[@id='"+radical+"_items']//li[.='"+valor+"']"));
	}
	
	/********* Botao ************/
	
	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarBotaoDireito(By by) {
		Actions action = new Actions(getDriver());
		action.contextClick(getDriver().findElement(by)).perform();
	}
	
	public void clicarBotaoDireito(WebElement titulo) {
		Actions action = new Actions(getDriver());
		action.contextClick(titulo).perform();
	}
	
	public void clicarBotaoDireito(String nomeCampo) {
		clicarBotaoDireito(By.xpath(nomeCampo));
	}
	
	public void clicarBotao(String id) {
		clicarBotao(By.xpath(id));
	}
	
	public String obterValueElemento(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	/********* Link ************/
	
	public void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	/********* Textos ************/
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.xpath(id));
	}
	
	/********* Alerts ************/
	
	public String alertaObterTexto(){
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoEAceita(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
		
	}
	
	public String alertaObterTextoENega(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
		
	}
	
	public void alertaEscrever(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}
	
	/********* Frames e Janelas ************/
	
	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}
	
	public void sairFrame(){
		getDriver().switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}
	
	/************** JS *********************/
	
	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
	}
	
	/************** Tabela *********************/
	
	protected void clicarBotaoDireitoIndiceLinha(String valor, String nomeCampoEscopo, String nomeCampoComplemento) {	
		//procurar pasta no menu
		WebElement lista = getDriver().findElement(By.xpath(nomeCampoEscopo));
		List<WebElement> linhas = lista.findElements(By.xpath(nomeCampoComplemento));
		
		//procurar a subpasta dentro da pasta
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().contains(valor)) {
				clicarBotaoDireito(linhas.get(i+1));
				break;
			}
		}
	}
	
	protected Boolean obterQuantidadeElementosTabelaBoolean(String nomeCampoEscopo, String nomeCampoComplemento) {	
		WebElement lista = getDriver().findElement(By.xpath(nomeCampoEscopo));
		List<WebElement> linhas = lista.findElements(By.xpath(nomeCampoComplemento));
		
		Integer quantidadeLinhas = linhas.size();
		
		if(quantidadeLinhas > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clicarIndiceLinha(String valor, String nomeCampoEscopo, String nomeCampoComplemento) {	
		WebElement lista = getDriver().findElement(By.xpath(nomeCampoEscopo));
		List<WebElement> linhas = lista.findElements(By.xpath(nomeCampoComplemento));
		
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().contains(valor)) {
				WebElement indice = linhas.get(i);
				indice.findElement(By.xpath("./../..//div")).click();
				break;
			}
		}
	}
	
	public void clicarIndiceLinha2(String valor, String nomeCampoEscopo, String nomeCampoComplemento) {	
		WebElement lista = getDriver().findElement(By.xpath(nomeCampoEscopo));
		List<WebElement> linhas = lista.findElements(By.xpath(nomeCampoComplemento));
		
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().contains(valor)) {
				WebElement indice = linhas.get(i);
				indice.findElement(By.xpath("./../..//div")).click();
				break;
			}
		}
	}
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		celula.findElement(By.xpath(".//input")).click();
		
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}
	
	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
	
		
	/********* Teste parametrizável *********/
	
	
	/********* Sincronismo *********/
	
	public void esperaImplicita () throws InterruptedException{
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
//	public static void esperaExplicita(String nomeElemento, Integer segundos) throws InterruptedException{
//		//WebElement element = getDriver().findElement(By.name(nomeElemento));
//		WebDriverWait wait = new WebDriverWait(getDriver(), segundos);
//		wait.until(ExpectedConditions.elementToBeClickable(By.name(nomeElemento)));
//	}
	
	public void esperaExplicitaSumir(By by, Integer segundos) throws InterruptedException{
		//WebElement element = getDriver().findElement(By.name(nomeElemento));
		WebDriverWait wait = new WebDriverWait(getDriver(), segundos);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public void esperaExplicitaSumir(String campoXpathsumir, Integer segundos) throws InterruptedException {
		esperaExplicitaSumir(By.xpath(campoXpathsumir), segundos);
	}
	
	public void esperaExplicita(By by, Integer segundos) throws InterruptedException{
		//WebElement element = getDriver().findElement(By.name(nomeElemento));
		WebDriverWait wait = new WebDriverWait(getDriver(), segundos);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public void esperaExplicita(String nomeCampo, Integer segundos) throws InterruptedException{
		esperaExplicita(By.xpath(nomeCampo), segundos);
	}
	
	public void esperaExplicitaEClica(String nomeCampo, Integer segundos) throws InterruptedException {
		esperaExplicita(nomeCampo, segundos);
		clicarBotao(nomeCampo);
	}
	
	
	public void esperaExplicitaEClica(By by, Integer segundos) throws InterruptedException {
		esperaExplicita(by, segundos);
		clicarBotao(by);
	}
	
	
	public void esperaExplicitaEEscreve(String nomeCampo, String texto, Integer segundos) throws InterruptedException {
		esperaExplicita(nomeCampo, segundos);
		escrever(nomeCampo, texto);
	}
	
	public void esperaExplicitaEEscreveAleatorio(String nomeCampo, String texto, Integer segundos) throws InterruptedException {
		esperaExplicita(nomeCampo, segundos);
		escreverNomeComProtocolo(nomeCampo, texto);
	}
	
	public String esperaExplicitaEObterTexto(String nomeCampo, Integer segundos) throws InterruptedException {
		esperaExplicita(nomeCampo, segundos);
		return obterTexto(nomeCampo);
	}
}
