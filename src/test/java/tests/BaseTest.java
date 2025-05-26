package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.PropertyReader;
import utils.TestListener;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    public WebDriver driver;
    ChromeOptions options;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    String user;
    String password;

    @Parameters({"browser"})
    @BeforeMethod
    @Step()
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            options = new ChromeOptions();
            options.addArguments("--guest");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.manage().window().maximize();
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        System.setProperty("BASE_URL", PropertyReader.getProperty("saucedemo.url"));
        user = PropertyReader.getProperty("saucedemo.user");
        password = PropertyReader.getProperty("saucedemo.password");

    }

    @AfterMethod
    @Step("Закрытие браузера")
    public void close() {
        driver.quit();
    }
}
