package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestesWaits {
	WebDriver driver;

	public static void main(String[] args) {
		// testeWaitImplicito();
		testeWaitImplicito2();
	}

	public static void testeWaitImplicito() {

		WebDriverManager.chromedriver();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("https://the-internet.herokuapp.com/dynamic_loading");

		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("a[href='/dynamic_loading/2']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();

		WebElement finishDiv = driver.findElement(By.id("finish"));

		// Verifica se o elemento está visível
		boolean isDisplayed = finishDiv.isDisplayed();

		if (isDisplayed) {
			System.out.println("O elemento está visível!");
		} else {
			System.out.println("O elemento não está visível!");
		}

		driver.quit();
	}

	public static void testeWaitImplicito2() {

		WebDriverManager.chromedriver().setup(); // ✅ corrigido para .setup()

		WebDriver driver = new ChromeDriver();

		// Define o tempo máximo de espera
		int tempoEspera = 6; // altere aqui (ex: 3 ou 6 segundos)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(tempoEspera));

		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("a[href='/dynamic_loading/2']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();

		WebElement finishDiv = null;
		try {
			// tenta localizar o elemento (pode não existir ainda)
			finishDiv = driver.findElement(By.id("finish"));
		} catch (Exception e) {
			System.out.println("Elemento #finish ainda não está presente no DOM.");
		}

		boolean isDisplayed = false;
		long inicio = System.currentTimeMillis();

		// Só entra no loop se o elemento foi encontrado
		if (finishDiv != null) {
			while ((System.currentTimeMillis() - inicio) < (tempoEspera * 1000)) {
				try {
					if (finishDiv.isDisplayed()) {
						isDisplayed = true;
						break;
					}
				} catch (Exception e) {
					// Ignora exceções enquanto ainda não está visível
				}
			}
		}

		if (isDisplayed) {
			System.out.println("O elemento está visível!");
		} else {
			System.out.println("O elemento não está visível!");
		}

		driver.quit();
	}

}
