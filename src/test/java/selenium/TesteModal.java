package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteModal {

    static WebDriver driver;
    static WebDriverWait wait; // ✅ Adicionado para reaproveitamento

    public static void main(String[] args) {
        testeModal();
    }

    public static void testeModal() {
        WebDriverManager.chromedriver().setup();

        // ❌ Código original (sombreamento de variável)
        // WebDriver driver = new ChromeDriver();

        // ✅ Corrigido: usa o driver da classe
        driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/modal");
        driver.manage().window().maximize();

        // ✅ Cria o WebDriverWait uma única vez
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Código original:
            // WebElement openmodal = (new WebDriverWait(driver, Duration.ofSeconds(10)))
            //         .until(ExpectedConditions.elementToBeClickable(By.id("modal-button")));

            // ✅ Reutilizando wait existente
            WebElement openmodal = wait.until(ExpectedConditions.elementToBeClickable(By.id("modal-button")));
            System.out.println("1-mapeou o botão open modal");
            openmodal.click();
            System.out.println("2-clicou no botão open modal");

            // Código original:
            // WebElement botaok = new WebDriverWait(driver, Duration.ofSeconds(10))
            //         .until(ExpectedConditions.elementToBeClickable(By.id("ok-button")));
            // System.out.println("3-mapeou o botão ok");

            // ✅ Reutilizando wait e garantindo visibilidade antes do clique
            WebElement botaok = wait.until(ExpectedConditions.elementToBeClickable(By.id("ok-button")));
            System.out.println("3-mapeou o botão ok");

            // Código original:
            // WebElement botaoclose = new WebDriverWait(driver, Duration.ofSeconds(10))
            //         .until(ExpectedConditions.elementToBeClickable(By.id("close-button")));
            // System.out.println("4-mapeou o botão close");

            // ✅ Reutilizando wait
            WebElement botaoclose = wait.until(ExpectedConditions.elementToBeClickable(By.id("close-button")));
            System.out.println("4-mapeou o botão close");

            // Código original:
            // botaok.click();
            // System.out.println("5-clicou no botão ok");
            //
            // botaoclose.click();
            // System.out.println("6-clicou no botão close");

            // ✅ Ajuste funcional: botão OK não fecha o modal, então clica em Close logo após
            botaok.click();
            System.out.println("5-clicou no botão ok (modal ainda aberto)");

            botaoclose.click();
            System.out.println("6-clicou no botão close (modal fechado)");

            // Reabertura do modal
            openmodal.click();
            System.out.println("7-clicou no botão open modal");

            // Código original:
            // WebElement botaox = new WebDriverWait(driver, Duration.ofSeconds(10))
            //         .until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[aria-hidden='true']")));
            // System.out.println("8-mapeou o x");

            // ✅ Reutilizando wait existente
            WebElement botaox = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("span[aria-hidden='true']")));
            System.out.println("8-mapeou o x");

            botaox.click();
            System.out.println("9-clicou no X");

        } catch (Exception e) {
            System.err.println("⚠️ Erro durante o teste: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("10-fechou navegador");
        }
    }
}
