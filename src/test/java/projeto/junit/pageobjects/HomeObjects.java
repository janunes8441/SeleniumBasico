package projeto.junit.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeObjects {
	// private WebDriver driver ;
	public WebDriver driver;
	@FindBy(id = "email")
	private WebElement inputEmail;
	@FindBy(id = "pass")
	private WebElement inputSenha;
	@FindBy(name = "login")
	private WebElement buttonLogin;
	@FindBy(linkText = "Esqueceu a senha?")
	private WebElement linkEsqueceuSenha;
	@FindBy(id = "identify_email")
	private WebElement emailRecuperar;
	@FindBy(id = "did_submit")
	private WebElement buttonRecuperarPesquisar;
	@FindBy(xpath = "//span[contains(normalize-space(), 'Entrar como')]")
	private WebElement validacaoPagina;

	public HomeObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getlinkEsqueceuSenha() {
		return linkEsqueceuSenha;
	}

	public void setlinkEsqueceuSenha(WebElement linkEsqueceuSenha) {
		this.linkEsqueceuSenha = linkEsqueceuSenha;
	}

	public WebElement getButtonLogin() {
		return buttonLogin;
	}

	public void setButtonLogin(WebElement buttonLogin) {
		this.buttonLogin = buttonLogin;
	}

	public WebElement getInputSenha() {
		return inputSenha;
	}

	public void setInputSenha(WebElement inputSenha) {
		this.inputSenha = inputSenha;
	}

	public WebElement getInputEmail() {
		return inputEmail;
	}

	public void setInputEmail(WebElement inputEmail) {
		this.inputEmail = inputEmail;
	}

	public WebElement getemailRecuperar() {
		return emailRecuperar;
	}

	public void setemailRecuperar(WebElement emailRecuperar) {
		this.inputEmail = emailRecuperar;
	}

	public WebElement getbuttonRecuperarPesquisar() {
		return buttonRecuperarPesquisar;
	}

	public void setbuttonRecuperarPesquisar(WebElement buttonRecuperarPesquisar) {
		this.buttonRecuperarPesquisar = buttonRecuperarPesquisar;
	}
	
	public WebElement getvalidacaoPagina() {
		return validacaoPagina;
	}

	public void setvalidacaoPagina(WebElement validacaoPagina) {
		this.validacaoPagina = validacaoPagina;
	}
	
}
