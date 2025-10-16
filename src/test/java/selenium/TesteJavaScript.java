package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteJavaScript {

	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		//testeJS();
		testeJS2();
	}

	public static void testeJS() throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		// options.addArguments("start-maximized");
		WebDriver driver = new FirefoxDriver(options);

		driver.get("https://www.amazon.com.br/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Digita livros na caixa de pesquisa e clica
		js.executeScript("document.getElementById('twotabsearchtextbox').value='livros';");
		js.executeScript("document.getElementById('nav-search-submit-button').click();");

		Thread.sleep(2000);

		// Localiza o elemento pelo título do livro
		WebElement livro = driver.findElement(By.xpath("//*[text()='O Senhor dos Anéis: A Sociedade do Anel']"));

		// Rola a página até o elemento
		js.executeScript("arguments[0].scrollIntoView(true);", livro);
		js.executeScript("alert('Rolou a pagina até o livro');");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		// Clica no elemento via Javascript
		js.executeScript("arguments[0].click();", livro);
		Thread.sleep(2000);

		driver.get("https://www.amazon.com.br/");
		Thread.sleep(2000);

		// Digita livros na caixa de pesquisa e clica
		js.executeScript("document.getElementById('twotabsearchtextbox').value='livros';");
		js.executeScript("document.getElementById('nav-search-submit-button').click();");
		Thread.sleep(2000);

		// Localiza o elemento pelo título do livro
		WebElement livro1 = driver.findElement(By.xpath("//*[text()='O Senhor dos Anéis: A Sociedade do Anel']"));

		// Rola a página até o elemento
		js.executeScript("arguments[0].scrollIntoView(true);", livro1);
		js.executeScript("alert('rolou até o livro novamente');");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		// rola até o topo
		js.executeScript("window.scrollTo(0, 0);");
		js.executeScript("alert('rolou até o topo');");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		// Msg fim
		js.executeScript("alert('FIM DO TESTE');");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		driver.quit();
	}

	public static void testeJS2() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://the-internet.herokuapp.com/checkboxes");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Marcar o checkbox 1
		WebElement checkbox1 = driver.findElement(By.cssSelector("input[type='checkbox']"));
		js.executeScript("arguments[0].click();",checkbox1);
		js.executeScript("alert('Checkbox 1 marcado');");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		// Desabilitar o checkbox 2
		// Localizando o segundo checkbox dentro do container com id 'checkboxes'
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
		js.executeScript("arguments[0].click();",checkbox2);
		js.executeScript("alert('Checkbox 2 desabilitado');");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		// Atualiza/recarrega a página usando JavascriptExecutor
		js.executeScript("location.reload();");
		js.executeScript("alert('F5 Pagina atualizada');");
		Thread.sleep(2000);
		
		
		driver.quit();
	}
}
