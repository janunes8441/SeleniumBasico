package tests;

import base.BaseTest;
import actions.LoginActions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class LoginTest extends BaseTest {

    @Test
    void testLogin() {
        driver.get("https://facebook.com");
        LoginActions login = new LoginActions(driver);
        login.fazerLogin("email_teste", "senha_teste");
        Assertions.assertTrue(driver.getTitle().contains("Facebook"));
    }
}
