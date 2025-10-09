package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class TestesActions {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		TesteTeclado();
	}

	public static void TesteTeclado() throws InterruptedException {

		// Configuração automática do driver e inicialização do Chrome
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // abre o navegador maximizado
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.facebook.com");
		System.out.println("Acessado Facebook com sucesso");

		// Mapeia os campos de e-mail e senha da tela de login
		WebElement email = driver.findElement(By.id("email"));
		WebElement senha = driver.findElement(By.id("pass"));
		System.out.println("1 - Mapeado campos de e-mail e senha");

		// Cria instância de Actions para simular ações de teclado e mouse
		Actions act = new Actions(driver);

		// Preenche e-mail e senha usando sendKeys
		act.sendKeys(email, "teste@teste.com").build().perform();
		act.sendKeys(senha, "1234567890").build().perform();
		System.out.println("2 - Preenchido e-mail e senha");

		// Clica no botão "Criar nova conta"
		driver.findElement(By.cssSelector("[data-testid='open-registration-form-button']")).click();
		System.out.println("3 - Clique no botão 'Criar nova conta'");

		// Espera até que o formulário de cadastro esteja visível (substitui o Thread.sleep)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement nome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
		WebElement sobrenome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastname")));
		System.out.println("4 - Mapeado campos de nome e sobrenome");

		// === DIGITA O NOME ===
		// Usa sequência encadeada para garantir que as ações sejam contínuas
		act.click(nome) // garante foco no campo
		   .keyDown(Keys.SHIFT) // pressiona SHIFT
		   .sendKeys("e") // digita 'E' maiúsculo
		   .keyUp(Keys.SHIFT) // solta SHIFT
		   .sendKeys("rick") // digita o restante em minúsculo
		   .build()
		   .perform();
		System.out.println("5 - Preenchido nome com a primeira letra maiúscula");

		// === DIGITA O SOBRENOME ===
		act.click(sobrenome) // garante foco no campo
		   .keyDown(Keys.SHIFT) // pressiona SHIFT
		   .sendKeys("v") // digita 'V' maiúsculo
		   .keyUp(Keys.SHIFT) // solta SHIFT
		   .sendKeys("alentin") // digita o restante em minúsculo
		   .build()
		   .perform();
		System.out.println("6 - Preenchido sobrenome com a primeira letra maiúscula");

		// Pausa apenas para visualizar o resultado (opcional)
		Thread.sleep(3000);

		// Fecha o navegador
		driver.quit();
		System.out.println("7 - Teste finalizado e navegador fechado");
	}
}
