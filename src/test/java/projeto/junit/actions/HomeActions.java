package projeto.junit.actions;
import org.openqa.selenium.WebDriver;
import projeto.junit.pageobjects.HomeObjects;


public class HomeActions {

    static HomeObjects objHome;

    public HomeActions(WebDriver driver) {

        objHome = new HomeObjects(driver);
    }

    public void login(){
        objHome.getInputEmail().sendKeys("erick@erick.com");
        objHome.getInputSenha().sendKeys("123456");
        objHome.getButtonLogin().click();

    }
}
