package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteLocator {

	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TesteFacebookIdEName();
		// TesteTagName();
		//TesteClassName();
		TesteTex();
	}

	public static void TesteFacebookIdEName() {

		// Configura automaticamente o ChromeDriver
		WebDriverManager.chromedriver().setup();
		// Configura opções do Chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // abre maximizado
		// options.addArguments("--incognito"); // opcional
		// Inicializa o Chrome
		WebDriver driver = new ChromeDriver(options);
		System.out.println("---------- FIM LOCATOR ID E NAME ----------");
		// Navega para o Facebook
		driver.get("https://www.facebook.com");
		System.out.println("Abriu o navegador e foi pro site");
		driver.findElement(By.id("email")).sendKeys("teste@teste.com");
		System.out.println("1-by.id");
		driver.findElement(By.id("pass")).sendKeys("123456789");
		System.out.println("2-by.id");
		driver.findElement(By.name("login")).click();
		System.out.println("3-by.name");
		driver.quit();
		System.out.println("4-fechar");
		System.out.println("---------- FIM LOCATOR ID E NAME ----------");
	}

	public static void TesteTagName() {
		// Configura automaticamente o ChromeDriver
		WebDriverManager.chromedriver().setup();
		// Configura opções do Chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // abre maximizado
		// options.addArguments("--incognito"); // opcional
		// Inicializa o Chrome
		WebDriver driver = new ChromeDriver(options);
		System.out.println("---------- INICIO LOCATOR TAGNAME ----------");
		// Navega para o Facebook
		driver.get("https://www.facebook.com");
		System.out.println("Abriu o navegador e foi pro site");
		// Lista de links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("1-Qnt de links - TagName: " + links.size());
		/*
		 * for (WebElement webElement :links) {
		 * System.out.println(webElement.getText());
		 * 
		 * }
		 */

		// Fechar
		driver.quit();
		System.out.println("Fechar");
		System.out.println("---------- FIM LOCATOR TAGNAME ----------");
	}

	public static void TesteClassName() throws InterruptedException {
		// Configura automaticamente o ChromeDriver
		WebDriverManager.chromedriver().setup();
		// Configura opções do Chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // abre maximizado
		// options.addArguments("--incognito"); // opcional
		// Inicializa o Chrome
		WebDriver driver = new ChromeDriver(options);
		System.out.println("---------- INICIO LOCATOR CLASS ----------");
		// Navega para o Facebook
		driver.get("https://www.trivago.com.br");
		System.out.println("Abriu o navegador e foi pro site");
		//Thread.sleep(5000);
		
		//Tag Class
		driver.findElement(By.className("apRPgd")).click();
		System.out.println("1 - Fechar modal criar conta");
		driver.findElement(By.className("Ji89fk")).click();
		System.out.println("2 - clicar botão login");
		driver.findElement(By.className("bam52s")).click();
		System.out.println("3 - fechar modal logar com");
		// Fechar
		driver.quit();
		System.out.println("Fechar");
		System.out.println("---------- FIM LOCATOR CLASS ----------");
	}
	
	public static void TesteTex() throws InterruptedException {
			
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://facebook.com.br");
		
		driver.findElement(By.linkText("Esqueceu a senha?")).click();
		System.out.println("1-LinkText");
		Thread.sleep(2000);
		
		driver.findElement(By.partialLinkText("Esqueceu")).click();
		System.out.println("2-PartialLinkText");
		
		driver.quit();
		System.out.println("Fechar");
		
		
		
	}
	
}
