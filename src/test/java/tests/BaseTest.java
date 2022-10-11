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

    protected WebDriverWait wait;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected SignUpPage signUpPage;
    protected AdminCitiesPage adminCitiesPage;
    protected LocalePage localePage;
    protected ProfilePage profilePage;
    protected FakerClass fakerClass;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "/Users/macbook/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        homePage = new HomePage(driver,wait);
        loginPage = new LoginPage(driver,wait);
        signUpPage = new SignUpPage(driver,wait);
        adminCitiesPage = new AdminCitiesPage(driver,wait);
        localePage = new LocalePage(driver,wait);
        profilePage = new ProfilePage(driver, wait);
        fakerClass = new FakerClass(driver,wait);
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
