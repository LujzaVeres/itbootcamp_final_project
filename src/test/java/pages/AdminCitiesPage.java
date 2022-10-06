package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage{
    protected By adminBtn = By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[1]/span");
    protected By cities = By.xpath("//*[@id='app']/div[3]/div[1]/a[1]");
    protected By newItem = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span/i");
    protected By nameCity = By.xpath("//*[@id='name']");
    protected By saveBtn = By.xpath("//*[@id='app']/div[5]/div/div/div[3]/button[2]/span");
    protected By editBtn = By.xpath("//*[@id='edit']/span/i");
    protected By editItem = By.xpath("//*[@id='name']");
    protected By saveEditItem = By.xpath("//*[@id='app']/div[5]/div/div/div[3]/button[2]/span");
    protected Faker faker = new Faker();
    private String city;

    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getAdminBtn() {
        return getDriver().findElement(adminBtn);
    }

    public WebElement getCities() {
        return getDriver().findElement(cities);
    }

    public WebElement getNewItem() {
        return getDriver().findElement(newItem);
    }

    public WebElement getNameCity() {
        return getDriver().findElement(nameCity);
    }

    public WebElement getSaveBtn() {
        return getDriver().findElement(saveBtn);
    }

    public WebElement getEditBtn() {
        return getDriver().findElement(editBtn);
    }

    public WebElement getEditItem() {
        return getDriver().findElement(editItem);
    }

    public WebElement getSaveEditItem() {
        return getDriver().findElement(saveEditItem);
    }

    public Faker getFaker() {
        return faker;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void clickAdminBtn(){
        getAdminBtn().click();
    }

    public void clickCitiesBtn(){
        getCities().click();
    }

    public void createCity() throws InterruptedException {
        getNewItem().click();
        Thread.sleep(3000);
        getNameCity().click();
        city = getFaker().address().city();
        getNameCity().sendKeys(city);
        getSaveBtn().click();

    }
    public void editCity(){
        getEditBtn().click();
        getEditItem().click();
        getEditItem().clear();
        getEditItem().sendKeys(city + "- edited");
        getSaveEditItem().click();
    }

    public void searchCity(){

    }
}

