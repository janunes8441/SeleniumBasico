package framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteComandosBrowserGPT {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Por favor, informe o navegador: chrome, firefox ou edge");
            return;
        }

        String navegador = args[0].toLowerCase();
        WebDriver driver = null;

        try {
            switch (navegador) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--width=1920");
                    firefoxOptions.addArguments("--height=1080");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    System.out.println("Navegador inválido. Use: chrome, firefox ou edge");
                    return;
            }

            // --------------------------
            // Teste do navegador
            // --------------------------
            driver.get("https://www.google.com");

            System.out.println("=== Informações do navegador ===");
            System.out.println("Navegador: " + navegador.substring(0, 1).toUpperCase() + navegador.substring(1));
            System.out.println("Título da página: " + driver.getTitle());
            System.out.println("URL atual: " + driver.getCurrentUrl());
            System.out.println("Tamanho da janela: " + driver.manage().window().getSize());
            System.out.println("================================");

        } catch (Exception e) {
            System.out.println("Erro ao abrir o navegador: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit(); // garante que o navegador feche
            }
        }
    }
}
