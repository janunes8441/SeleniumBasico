package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestesIframe {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		testeIframe();

	}
	
	public static void testeIframe() {
		
		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:9292/iframe");
		driver.manage().window().maximize();
		
		WebElement texto = driver.findElement(By.xpath("//textarea[normalize-space()='Your content goes here.']"));
		texto.clear();
		texto.sendKeys("Eu consegui!");
		System.out.println("Deu certo");
		//driver.quit();

	}

}
