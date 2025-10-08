package framework.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteComandosNavegacao {

	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		navegacao();

	}

	public static void navegacao() throws InterruptedException {

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
		System.out.println("1-Acessado Facebook " + driver.getCurrentUrl()); 
		
		// Navega para o Bing
		driver.navigate().to("https://www.bing.com/");
		System.out.println("2-Acessado Bing " + driver.getCurrentUrl());
		
		// Localiza o campo de pesquisa pelo ID
		WebElement searchBox = driver.findElement(By.id("sb_form_q"));

		// Digita "Junior" e envia a pesquisa
		searchBox.sendKeys("Junior");
		searchBox.submit(); // ou searchBox.sendKeys(Keys.ENTER);

		// Aguarda alguns segundos para o resultado carregar
		Thread.sleep(3000);

		// Mostra o título da página de resultados
		System.out.println("3-Título da página: " + driver.getTitle());
		
		// Voltar para o Facebook
		driver.navigate().back();
		System.out.println("4-Voltou para Facebook " + driver.getCurrentUrl());
		
		// Avançar para o Bing
		driver.navigate().forward();
		System.out.println("5-Avançou para Bing " + driver.getCurrentUrl());
		
		// Refresh
		driver.navigate().refresh();
		System.out.println("6-Atualizou pagina " + driver.getCurrentUrl());
		
		// Fechar navegador
		driver.quit();
		System.out.println("7-Fechou Navegador");

	}

}
