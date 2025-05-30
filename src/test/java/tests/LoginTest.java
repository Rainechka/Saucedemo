package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;
import static utils.AllureUtils.takeScreenshot;

public class LoginTest extends BaseTest {
    @Epic("Модуль логина интернет-магазина")
    @Feature("Юридические лица")
    @Story("STG")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Noskova E. V. rainechka@gmail.com")
    @TmsLink("Rainechka")
    @Issue("1")
    @Test(description = "Проверка авторизации")
    @Flaky
    public void correctLogin() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.titleIsDisplayed());
        takeScreenshot(driver);
        assertEquals(productsPage.getTitle(), "Products");
    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] LoginData() {
        return new Object[][]{
                {withLockedUserPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {withoutLogin(), "Epic sadface: Username is required"},
                {withoutPassword(), "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "incorrectLoginData")
    public void incorrectLogin(User user, String errorMsg) {
        loginPage.open();
        loginPage.login(user);
        assertEquals(loginPage.getErrorMsg(), errorMsg);
    }
}
