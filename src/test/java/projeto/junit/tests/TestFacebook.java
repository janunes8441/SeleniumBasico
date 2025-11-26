package projeto.junit.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import projeto.junit.actions.HomeActions;
import projeto.junit.pageobjects.HomeObjects;

import static org.junit.jupiter.api.Assertions.*;

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
    @AfterEach
    void fechar(){
        driver.quit();
    }

}