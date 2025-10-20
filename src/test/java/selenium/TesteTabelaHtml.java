package selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteTabelaHtml {

	public static void main(String[] args) throws InterruptedException {
		testeHtml();
	}

	public static void testeHtml() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://scrud.whirlwind.nl/");
		driver.manage().window().maximize();

		// Captura todas as linhas da tabela
		List<WebElement> todasLinhas = driver.findElements(By.xpath("//table[@id='table_companies']/tbody/tr"));
		System.out.println("Contem: " + todasLinhas.size() + " linhas\n");
		System.out.println("imprimiu as linhas");

		// Captura todas as colunas da tabela (somente para contar total de células)
		List<WebElement> todasColunas = driver.findElements(By.xpath("//table[@id='table_companies']/tbody/tr/td"));
		System.out.println("Contem: " + todasColunas.size() + " colunas\n");
		System.out.println("imprimiu as colunas");

		// Percorre cada linha
		for (int i = 0; i < todasLinhas.size(); i++) {
			WebElement linha = todasLinhas.get(i);
			List<WebElement> colunas = linha.findElements(By.tagName("td"));
			System.out.println("Linha " + (i + 1));

			// Percorre cada coluna da linha
			for (int j = 0; j < colunas.size(); j++) {
				System.out.print(colunas.get(j).getText() + "\t");
			}
			System.out.println("\n");
		}
		System.out.println("imprimiu a lista");

		String empresaEditar = "HP";
		System.out.println("mapeou o nome da empresa");

		boolean empresaEncontrada = false; // controle de saída do loop

		for (int a = 0; a < todasLinhas.size(); a++) {
			WebElement linha = todasLinhas.get(a);
			List<WebElement> colunas = linha.findElements(By.tagName("td"));

			for (int b = 0; b < colunas.size(); b++) {
				if (colunas.get(b).getText().equalsIgnoreCase(empresaEditar)) {

					// Clica no botão editar correspondente
					driver.findElement(By.xpath(
							"//tr[td[text()='" + empresaEditar + "']]//li[@class='function_edit']/a"))
							.click();
					System.out.println("clicou no editar");

					Thread.sleep(1000);

					// Preenche o campo Industries
					WebElement campoIndustries = driver.findElement(By.id("industries"));
					campoIndustries.clear();
					campoIndustries.sendKeys("TesteAJR");
					System.out.println("preencheu o campo");

					// Clica em salvar
					driver.findElement(By.xpath("//button[@type='submit']")).click();
					System.out.println("clicou no salvar");

					empresaEncontrada = true;
					break; // sai do loop interno
				}
			}

			if (empresaEncontrada) {
				break; // sai do loop externo também (evita stale elements)
			}
		}

		driver.quit();
		System.out.println("fechou");
	}
}
