package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteRadiobutton {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		deveSelecionarRadioButton();

	}

	public static void deveSelecionarRadioButton() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/radiobutton");

		driver.findElement(By.xpath("//input[@value='option2']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@value='option3']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@id='radio-button-1']")).click();
		Thread.sleep(1500);
		driver.quit();
	}
}
