package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "pass")
    private WebElement inputSenha;

    @FindBy(name = "login")
    private WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void preencherEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void preencherSenha(String senha) {
        inputSenha.sendKeys(senha);
    }

    public void clicarLogin() {
        buttonLogin.click();
    }
}
