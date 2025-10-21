package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteCombobox {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		testeCombobox();

	}
	
	public static void testeCombobox() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dropdown");
		driver.manage().window().maximize();
		
		Select lista = new Select(driver.findElement(By.id("dropdown")));
		lista.selectByIndex(1);
		System.out.println("selecionou pelo index");
		Thread.sleep(2000);
		
		lista.selectByValue("2");
		System.out.println("selecionou pelo value");
		Thread.sleep(2000);
		
		lista.selectByVisibleText("Option 1");
		System.out.println("selecionou pelo texto");
		Thread.sleep(2000);
		
		driver.quit();
	}

}
