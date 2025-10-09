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
		// TesteTeclado();
		// TesteMouse();
		//TesteCliqueBotaoDireitoMouse();
		TesteClicarESegurar();
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

		// Espera até que o formulário de cadastro esteja visível (substitui o
		// Thread.sleep)
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
				.build().perform();
		System.out.println("5 - Preenchido nome com a primeira letra maiúscula");

		// === DIGITA O SOBRENOME ===
		act.click(sobrenome) // garante foco no campo
				.keyDown(Keys.SHIFT) // pressiona SHIFT
				.sendKeys("v") // digita 'V' maiúsculo
				.keyUp(Keys.SHIFT) // solta SHIFT
				.sendKeys("alentin") // digita o restante em minúsculo
				.build().perform();
		System.out.println("6 - Preenchido sobrenome com a primeira letra maiúscula");

		// Pausa apenas para visualizar o resultado (opcional)
		Thread.sleep(3000);

		// Fecha o navegador
		driver.quit();
		System.out.println("7 - Teste finalizado e navegador fechado");
	}

	// Método para testar interação com mouse e teclado no site The Internet
	public static void TesteMouse() throws InterruptedException {

		// 🔧 Configuração automática do driver e inicialização do Chrome
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // abre o navegador maximizado
		WebDriver driver = new ChromeDriver(options);

		// 🌐 Acessa o site principal
		driver.get("https://the-internet.herokuapp.com/");
		System.out.println("Acessado site com sucesso");

		// 🖱 Cria o objeto Actions (para simular interações de mouse/teclado)
		Actions act = new Actions(driver);

		// 🔍 Mapeia o link "Form Authentication" e clica nele
		WebElement form = driver.findElement(By.linkText("Form Authentication"));
		System.out.println("1 - Mapeou o link 'Form Authentication'");
		Thread.sleep(1000);

		act.click(form).build().perform();
		System.out.println("2 - Clicou no link do formulário");
		Thread.sleep(1000);

		// 🔍 Agora mapeia os elementos da tela de login (só existem depois do clique)
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));
		System.out.println("3 - Mapeou os elementos da tela de login");
		Thread.sleep(1000);

		// ⌨️ Preenche o campo de usuário
		act.sendKeys(username, "janun8441").build().perform();
		System.out.println("4 - Preencheu o username - incluso teste duploclique");

		// double clique
		act.doubleClick(username) // duplo clique
				.sendKeys("tomsmith") // digitou outro
				.build().perform();

		// ⌨️ Preenche o campo de senha
		act.sendKeys(password, "123456").build().perform();
		System.out.println("5 - Preencheu a senha - incluso teste duploclique");

		// double clique
		act.doubleClick(password) // duplo clique
				.sendKeys("SuperSecretPassword!") // digitou outro
				.build().perform();

		// 🖱 Clica no botão de login
		act.click(login).build().perform();
		System.out.println("6 - Clicou no botão Login");

		// ⏳ Espera alguns segundos para ver o resultado antes de fechar
		Thread.sleep(2000);

		// 🚪 Fecha o navegador completamente
		driver.quit();
		System.out.println("7 - Teste finalizado e navegador fechado");
	}

	public static void TesteCliqueBotaoDireitoMouse() throws InterruptedException {

		// 🔧 Configuração automática do driver e inicialização do Chrome
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // abre o navegador maximizado
		WebDriver driver = new ChromeDriver(options);

		// 🌐 Acessa o site principal
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		System.out.println("Acessado site com sucesso");

		Actions act = new Actions(driver);
		WebElement botao = driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));

		System.out.println("1 - Mapeou o elemento 'right click me'");

		act.contextClick(botao) // 👉 Realiza o clique com o botão direito
				.sendKeys(Keys.ARROW_DOWN) // setinha pra baixo
				.sendKeys(Keys.ENTER) // enter
				.build().perform();
		System.out.println("2 - Realizou o clique com o botão direito, seta pra baixo e enter");

		// 🕒 Aguarda para visualizar o resultado
		Thread.sleep(2000);

		// Fecha o navegador
		driver.quit();
	}

	public static void TesteClicarESegurar() throws InterruptedException {

		// 🔧 Configuração automática do driver e inicialização do Chrome
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // abre o navegador maximizado
		WebDriver driver = new ChromeDriver(options);

		// 🌐 Acessa o site principal
		driver.get("https://the-internet.herokuapp.com/");
		System.out.println("Acessado site com sucesso");

		// 🖱 Cria o objeto Actions (para simular interações de mouse/teclado)
		Actions act = new Actions(driver);

		// 🔍 Mapeia o link "Form Authentication" e clica nele
		WebElement form = driver.findElement(By.linkText("Form Authentication"));
		System.out.println("1 - Mapeou o link 'Form Authentication'");
		Thread.sleep(1000);

		act.click(form).build().perform();
		System.out.println("2 - Clicou no link do formulário");
		Thread.sleep(1000);

		// 🔍 Agora mapeia os elementos da tela de login (só existem depois do clique)
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));
		System.out.println("3 - Mapeou os elementos da tela de login");
		Thread.sleep(1000);

		// ⌨️ Preenche o campo de usuário
		act.sendKeys(username, "janun8441").build().perform();
		System.out.println("4 - Preencheu o username - incluso teste duploclique");

		// double clique
		act.doubleClick(username) // duplo clique
				.sendKeys("tomsmith") // digitou outro
				.build().perform();

		// ⌨️ Preenche o campo de senha
		act.sendKeys(password, "123456").build().perform();
		System.out.println("5 - Preencheu a senha - incluso teste duploclique");

		// double clique
		act.doubleClick(password) // duplo clique
				.sendKeys("SuperSecretPassword!") // digitou outro
				.build().perform();

		// 🖱 Clica no botão de login
		act.clickAndHold(login).build().perform();
		System.out.println("6 - Clicou no botão Login e segurou");

	}
}