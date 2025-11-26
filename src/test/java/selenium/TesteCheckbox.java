package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteCheckbox {

	static WebDriver driver;

	public static void main(String[] args) {
		//testeCheckbox();
		testeCheckbox1();

	}

	public static void testeCheckbox() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/checkbox");
		driver.manage().window().maximize();

		driver.findElement(By.id("checkbox-1")).click();
		driver.findElement(By.id("checkbox-2")).click();
		driver.findElement(By.id("checkbox-3")).click();
		System.out.println("Habilitou");
		driver.findElement(By.id("checkbox-1")).click();
		driver.findElement(By.id("checkbox-2")).click();
		driver.findElement(By.id("checkbox-3")).click();
		System.out.println("Desabilitou");
		driver.quit();

	}
	public static void testeCheckbox1() {

	    System.out.println("🚀 Iniciando teste de checkboxes...");

	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();

	    System.out.println("🌐 Abrindo o site...");
	    driver.get("https://the-internet.herokuapp.com/checkboxes");

	    System.out.println("🖥️  Maximizando janela...");
	    driver.manage().window().maximize();

	    // Mapeando o formulário
	    System.out.println("🔍 Mapeando o formulário de checkboxes...");
	    WebElement form = driver.findElement(By.id("checkboxes"));

	    // Mapeando todos os checkboxes dentro do form
	    System.out.println("📋 Coletando todos os checkboxes do formulário...");
	    List<WebElement> checkboxes = form.findElements(By.cssSelector("input[type='checkbox']"));

	    // Exemplo: iterando sobre eles
	    System.out.println("🔎 Verificando estado inicial dos checkboxes:");
	    for (int i = 0; i < checkboxes.size(); i++) {
	        WebElement checkbox = checkboxes.get(i);
	        System.out.println("   ➤ Checkbox " + (i + 1) + " está selecionado? " + checkbox.isSelected());
	    }

	    // Checkbox 1 -> deve ser marcadogit
	    WebElement checkbox1 = checkboxes.get(0);
	    if (!checkbox1.isSelected()) {
	        checkbox1.click();
	        System.out.println("✅ Ação: Checkbox 1 foi marcado.");
	    } else {
	        System.out.println("ℹ️  Checkbox 1 já estava marcado — nenhuma ação necessária.");
	    }

	    // Checkbox 2 -> deve ser desmarcado
	    // (Ajuste: antes estava pegando novamente o índice 0, agora usamos índice 1)
	    WebElement checkbox2 = checkboxes.get(1);
	    if (checkbox2.isSelected()) {
	        checkbox2.click();
	        System.out.println("✅ Ação: Checkbox 2 foi desmarcado.");
	    } else {
	        System.out.println("ℹ️  Checkbox 2 já estava desmarcado — nenhuma ação necessária.");
	    }

	    System.out.println("🧾 Estado final dos checkboxes após as ações:");
	    for (int i = 0; i < checkboxes.size(); i++) {
	        WebElement checkbox = checkboxes.get(i);
	        System.out.println("   ➤ Checkbox " + (i + 1) + " agora está selecionado? " + checkbox.isSelected());
	    }

	    System.out.println("🏁 Encerrando o teste e fechando o navegador...");
	    driver.quit();
	}

}
