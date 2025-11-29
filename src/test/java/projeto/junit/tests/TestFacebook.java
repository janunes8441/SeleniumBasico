package projeto.junit.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import projeto.junit.actions.HomeActions;

class TestFacebook {
	static WebDriver driver;
	static HomeActions actHome;

	@BeforeEach
	void abrirFacebook() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		actHome = new HomeActions(driver);
	}

	@Test
	void login() throws Exception {
		actHome.login();

	}

	@Test
	void esqueceuSenha() throws Exception {
		actHome.esqueceSenha();
		actHome.emailRecuperar();
		actHome.validarTextoEntrarComo();
		
	}
	

	@AfterEach
	void fechar() {
		driver.quit();
	}

}