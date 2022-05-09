package br.com.randomproject.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sun.tools.javac.jvm.Profile;

import br.com.randomproject.core.Propriedades.TipoExecucao;

public class DriverFactory {
	
	
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	private static String diretorioDownload = System.getProperty("user.dir") + File.separator + "target" + File.separator + "download de arquivos de teste";
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver(){
		WebDriver driver = null;
		if (Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {

			switch (Propriedades.browser) {
			case FIREFOX:
				FirefoxOptions options = new FirefoxOptions();
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("pdfjs.disabled", true);
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/json");
				profile.setPreference("browser.download.dir", diretorioDownload);
				profile.setPreference("browser.download.folderList", 2);
				options.setProfile(profile);

				driver = new FirefoxDriver(options); 

				break;

			case CHROME: driver = new ChromeDriver(); break;
			}
		}
		
		if (Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
			DesiredCapabilities cap = null;
			switch (Propriedades.browser) {
				case FIREFOX: cap = DesiredCapabilities.firefox(); break;
				case CHROME: cap = DesiredCapabilities.chrome(); break;
			}
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.1.79:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
					System.err.print("Falha na comunicação com o GRID");
				e.printStackTrace();
			}
		}
		driver.manage().window().maximize();
		//Para iniciar testes no modo janela sem estar maximizado
		//setSize(new Dimension(1200, 765) 
		return driver;
	}
	
	public static void killDriver(){
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		if (threadDriver != null) {
			threadDriver.remove();
		}
	}

//******************************************************************************************************************************************************************
	
//	private static WebDriver driver;
//	private static String diretorioDownload = System.getProperty("user.dir") + File.separator + "target" + File.separator + "download de arquivos de teste";
//	
//	private DriverFactory() {}
//	
//	public static WebDriver getDriver(){
//		System.setProperty("webdriver.gecko.driver", "/home/marcoscosta/drivers/geckodriver/geckodriver"); 
//		if(driver == null) {
//			switch (Propriedades.browser) {
//				case FIREFOX:
//					FirefoxOptions options = new FirefoxOptions();
//					FirefoxProfile profile = new FirefoxProfile();
//					profile.setPreference("pdfjs.disabled", true);
//					profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/json");
//					profile.setPreference("browser.download.dir", diretorioDownload);
//					profile.setPreference("browser.download.folderList", 2);
//					options.setProfile(profile);
//					
//					driver = new FirefoxDriver(options); 
//					
//					break;
//					
//				case CHROME: driver = new ChromeDriver(); break;
//			}
//			driver.manage().window().maximize();
//			//Para iniciar testes no modo janela sem estar maximizado
//			//setSize(new Dimension(1200, 765) 
//		}
//		return driver;
//	}
//	
//	public static void killDriver(){
//		if(driver != null) {
//			driver.quit();
//			driver = null;
//		}
//	}
}
