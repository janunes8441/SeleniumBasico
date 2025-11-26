package projeto.junit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeObjects {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement inputEmail;
    @FindBy(id = "pass")
    private WebElement inputSenha;
    @FindBy(name = "login")
    private WebElement buttonLogin;

    public HomeObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
}
