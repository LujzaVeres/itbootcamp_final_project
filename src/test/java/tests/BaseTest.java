package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SignUpPage signUpPage;
    protected AdminCitiesPage adminCitiesPage;
    protected LocalePage localePage;
    protected ProfilePage profilePage;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "/Users/macbook/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage = new HomePage(driver,driverWait);
        loginPage = new LoginPage(driver,driverWait);
        signUpPage = new SignUpPage(driver,driverWait);
        adminCitiesPage = new AdminCitiesPage(driver,driverWait);
        localePage = new LocalePage(driver,driverWait);
        profilePage = new ProfilePage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://vue-demo.daniel-avellaneda.com");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
