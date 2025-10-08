package framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteComandosBrowser {

	WebDriver driver;

	public static void main(String[] args) {
		comandosBrowser();
	}

	public static void comandosBrowser() {
		// Configura automaticamente o ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Configura opções do Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // abre maximizado
        // options.addArguments("--incognito"); // opcional

		// Inicializa o Chrome
		WebDriver driver = new ChromeDriver(options);

		// Navega para o Google
		driver.get("https://www.facebook.com");

		// Mostra o título no console
		System.out.println("Título da página: " + driver.getTitle());

		// Mostra a URL no console
		System.out.println("URL: " + driver.getCurrentUrl());

		// Mostra codigo fonte no console
		// System.out.println("Codigo Fonte: " + driver.getPageSource());

		// Fecha aba
		//driver.close();

		// Fecha o navegador
		// driver.quit();
	}

}
