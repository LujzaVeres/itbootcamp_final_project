package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest{

    @Test
    public void forbidsHomeUrl(){
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains("/login"));
    }

    @Test
    public void forbidsProfileUrl(){
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains("/login"));
    }

    @Test
    public void forbidsAdminCities() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains("/login"));
    }

    @Test
    public void forbidsAdminUsers(){
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains("/login"));
    }
}
