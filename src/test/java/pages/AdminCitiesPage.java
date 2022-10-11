package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AdminCitiesPage extends BasePage {
    protected By adminBtn = By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[1]/span");
    protected By cities = By.xpath("//*[@id='app']/div[3]/div[1]/a[1]");
    protected By newItem = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span/i");
    protected By nameCity = By.xpath("//*[@id='name']");
    protected By saveBtn = By.xpath("//*[@id='app']/div[5]/div/div/div[3]/button[2]/span");
    protected By editBtn = By.xpath("//*[@id='edit']/span/i");
    protected By editItem = By.xpath("//*[@id='name']");
    protected By saveEditItem = By.xpath("//*[@id='app']/div[5]/div/div/div[3]/button[2]/span");
    protected By searchBox = By.xpath("//*[@id='search']");
    protected By searchBtn = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/div[3]/div/i");
    protected By deleteBtn = By.id("delete");
    protected By finalDelete = By.xpath("//*[@id='app']/div[5]/div/div/div[2]/button[2]");
    protected By actualRes = By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[2]/span");
    protected By actualResult = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]");
    protected By firstRow = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[3]/div[2]");
    protected By actualResultForDeletedCity = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]");
    protected By messageBox = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");

    public AdminCitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
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

    public WebElement getSearchBox() {
        return getDriver().findElement(searchBox);
    }

    public WebElement getSearchBtn() {
        return getDriver().findElement(searchBtn);
    }

    public WebElement getActualRes() {
        return getDriver().findElement(actualRes);
    }

    public WebElement getActualResult() {
        return getDriver().findElement(actualResult);
    }

    public WebElement getFirstRow() {
        return getDriver().findElement(firstRow);
    }

    public WebElement getActualResultForDeletedCity() {
        return getDriver().findElement(actualResultForDeletedCity);
    }

    public WebElement getMessageBox() {
        return getDriver().findElement(messageBox);
    }

    public void clickAdminBtn() {
        getAdminBtn().click();
    }

    public void clickCitiesBtn() {
        getCities().click();
    }

    public WebElement getDeleteBtn() {
        return getDriver().findElement(deleteBtn);
    }

    public WebElement getFinalDelete() {
        return getDriver().findElement(finalDelete);
    }

    public void createCity(String name) {
        getNewItem().click();
        getNameCity().click();
        getNameCity().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getNameCity().sendKeys(name);
        getSaveBtn().click();
    }

    public void editCity(String name) {
        getEditBtn().click();
        getEditItem().click();
        getNameCity().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        getEditItem().sendKeys(name);
        getSaveEditItem().click();
    }

    public void searchCity(String name) {
        getSearchBox().click();
        getSearchBox().sendKeys(name);
        getSearchBtn().click();
    }

    public WebElement getFirstCityText() {
        return getDriver().findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]"));
    }

    public WebElement getSearchedText() {
        return getDriver().findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));
    }

    public void deleteCity(){
        getDeleteBtn().click();
    }

    public void finalDelete(){
        getFinalDelete().click();
    }

    public void saveMsg(){
        WebElement actualResult = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(actualResult.getText().contains("Saved successfully"));
    }
}


