package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login(user, password);

        assertTrue(productsPage.titleIsDisplayed());
        assertEquals(productsPage.getTitle(), "Products");
    }

    @DataProvider(name="incorrectLoginData")
    public Object[][] LoginData() {
        return new Object[][] {
                {"locked_out_user", password, "Epic sadface: Sorry, this user has been locked out."},
                {"", password, "Epic sadface: Username is required"},
                {user, "", "Epic sadface: Password is required"}
        };
        }

    @Test(dataProvider = "incorrectLoginData")
    public void incorrectLogin(String user, String pass, String errorMsg) {
        loginPage.open();
        loginPage.login(user, pass);
        assertEquals(loginPage.getErrorMsg(), errorMsg);
    }
}
