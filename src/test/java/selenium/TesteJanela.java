package selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteJanela {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) {
        testeJanela();
    }

    public static void testeJanela() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/switch-window");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String janelaPrincipal = driver.getWindowHandle();

        WebElement opennewtab = wait.until(ExpectedConditions.elementToBeClickable(By.id("new-tab-button")));
        System.out.println("1 - Mapeou o botão opennewtab");
        opennewtab.click();
        System.out.println("2 - Clicou no botão opennewtab");

        // Alternar para a nova aba
        Set<String> janelas = driver.getWindowHandles();
        for (String janela : janelas) {
            if (!janela.equals(janelaPrincipal)) {
                driver.switchTo().window(janela);
                break;
            }
        }
        System.out.println("3 - Mudou para a nova aba");

        // Valida o texto da nova aba
        WebElement tituloNovaAba = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.display-3")));
        System.out.println("4 - Texto da nova aba: " + tituloNovaAba.getText());

        // Voltar para a janela principal
        driver.switchTo().window(janelaPrincipal);
        System.out.println("5 - Voltou para a janela principal");

        // Valida o texto da janela principal
        WebElement tituloPrincipal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        System.out.println("6 - Texto da janela principal: " + tituloPrincipal.getText());

        // Fecha o navegador
        driver.quit();
    }
}
