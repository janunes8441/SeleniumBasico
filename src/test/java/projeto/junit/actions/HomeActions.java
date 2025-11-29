package projeto.junit.actions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import projeto.junit.pageobjects.HomeObjects;

public class HomeActions {

	static HomeObjects objHome;
	private WebDriver driver;

	public HomeActions(WebDriver driver) {

		objHome = new HomeObjects(driver);
	}

	public void login() {
		objHome.getInputEmail().sendKeys("erick@erick.com");
		objHome.getInputSenha().sendKeys("123456");
		objHome.getButtonLogin().click();

	}

	public void esqueceSenha() {
		objHome.getlinkEsqueceuSenha().click();

	}

	public void emailRecuperar() {
		objHome.getemailRecuperar().sendKeys("+5561985641444");
		objHome.getbuttonRecuperarPesquisar().click();

	}
	public void validarTextoEntrarComo() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    WebElement elemento =
	            wait.until(ExpectedConditions.visibilityOf(objHome.getvalidacaoPagina()));

	    String texto = elemento.getText();

	    Assertions.assertTrue(
	            texto.contains("Entrar como"),
	            "Texto esperado não encontrado. Texto atual: " + texto
	    );
	}

}
