package framework.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteComandoWebElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		webElement();

	}

	public static void webElement() throws InterruptedException {
		// Configura automaticamente o ChromeDriver
		WebDriverManager.chromedriver().setup();

		// Configura opções do Chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // abre maximizado
		options.addArguments("--incognito"); // opcional

		// Inicializa o Chrome
		WebDriver driver = new ChromeDriver(options);

		// Navega para o Facebook
		driver.get("https://www.facebook.com");
		System.out.println("1-Abriu navegador e entrou no site do facebook.");
		Thread.sleep(1000);

		// Localizar campo e preencher email
		driver.findElement(By.id("email")).sendKeys("teste@teste.com");
		System.out.println("2-Localizou o campo email e preencheu.");
		Thread.sleep(1000);

		// Limpar campo
		driver.findElement(By.id("email")).clear();
		System.out.println("3-Limpou o campo email.");

		// Verifica se apareceu em tela
		boolean apareceu;
		apareceu = driver.findElement(By.id("email")).isDisplayed();
		System.out.println("4-Resultado do apareceu: " + apareceu);

		// Verifica se esta habilitado em tela
		boolean habilitado;
		habilitado = driver.findElement(By.id("email")).isEnabled();
		System.out.println("5-Resultado do habilitado: " + habilitado);

		// Cria Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
		// Espera até que o botão "Criar nova conta" esteja clicável e clica nele
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("[data-testid='open-registration-form-button']"))).click();
		// Opcional: imprime mensagem de confirmação
		System.out.println("6-Botão 'Criar nova conta' clicado com sucesso!");
		Thread.sleep(1000);
		
		// Seleciona gênero Masculino
		boolean genero;
		genero = driver.findElement(By.name("sex")).isSelected();
		System.out.println("7-Genero está selecionado? " + genero);
		Thread.sleep(1000);
		
		// Clicar no botão Cadastre-se
		driver.findElement(By.name("websubmit")).submit();
		System.out.println("8-Clicou no botão Cadastre-se.");
		Thread.sleep(1000);
		
		//Texto do link
		String texto;
		texto = driver.findElement(By.cssSelector("a._9bq5")).getText();
		System.out.println("9-Texto do link: " + texto );
		
		// Fechar
		driver.quit();
		System.out.println("Fechou o navegador");

	}

}
