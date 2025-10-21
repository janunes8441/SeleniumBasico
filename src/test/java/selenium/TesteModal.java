package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteModal {

	static WebDriver driver;

	public static void main(String[] args) {
		testeModal();

	}

	public static void testeModal() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/modal");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement openmodal = driver.findElement(By.id("modal-button"));
		System.out.println("1-mapeou o botão open modal");
		openmodal.click();
		System.out.println("2-clicou no botão open modal");
		WebElement botaok = driver.findElement(By.id("ok-button"));
		System.out.println("3-mapeou o botão ok");
		WebElement botaoclose = driver.findElement(By.id("close-button"));
		System.out.println("4-mapeou o botão close");
		
		botaok.click();
		System.out.println("5-clicou no botão ok");
		botaoclose.click();
		System.out.println("6-clicou no botão close");
		openmodal.click();
		System.out.println("7-clicou no botão open modal");
		WebElement botaox = driver.findElement(By.cssSelector("span[aria-hidden='true']"));
		System.out.println("8-mapeou o x");
		botaox.click();
		System.out.println("9-clicou no X");
		driver.quit();

	}

}
