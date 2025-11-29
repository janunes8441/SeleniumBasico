package actions;

import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;

public class LoginActions {

    private WebDriver driver;
    private LoginPage loginPage;

    public LoginActions(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    public void fazerLogin(String email, String senha) {
        loginPage.preencherEmail(email);
        loginPage.preencherSenha(senha);
        loginPage.clicarLogin();
    }
}
