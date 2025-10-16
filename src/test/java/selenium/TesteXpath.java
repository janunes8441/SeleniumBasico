package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteXpath {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {		
		//xpathAbsoluto();
		xpathRelativo();
	}

	public static void xpathAbsoluto() throws InterruptedException {
		
		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://magazineluiza.com.br/");
		driver.manage().window().maximize();
		WebElement busca = driver.findElement(By.xpath("//*[@id='suggestion-input']"));
		busca.sendKeys("celular");
		busca.sendKeys(Keys.ENTER);
	
		Thread.sleep(2000);		
		
		driver.findElement(By.xpath("//div[@class='sc-fqkvVR ixLpDw sc-gsFSXq llwSSf sc-jXbUNg bqEEpg sc-eXJwJG dRihwl sc-eXJwJG dRihwl sc-jXbUNg bqEEpg sc-eXJwJG dRihwl sc-eXJwJG dRihwl']//li[3]//div[1]//input[1]"))
		.click();
		Thread.sleep(2000);
		WebElement motog15 = driver.findElement(By.xpath("/html/body/div[1]/div/main/section[4]/div[5]/div/ul/li[4]/a/div[2]/img"));
		motog15.click();
	
	}
	
	public static void xpathRelativo() throws InterruptedException {
		
		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://magazineluiza.com.br/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='suggestion-input']")).sendKeys("celular");
		driver.findElement(By.xpath("//i[@data-testid='input-icon-end']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300);");		
		driver.findElement(By.xpath("//p[normalize-space()='samsung']")).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300);");
		driver.findElement(By.xpath("//*[contains(text(),'Smartphone Samsung Galaxy A06 128GB 4GB RAM Azul Escuro')]")).click();
		
		
		
		
		
	}
}
