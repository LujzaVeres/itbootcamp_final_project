package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest{

    @Test
    public void changeLanguageEs() {
        localePage.changeLanguage();
        localePage.languageEs();
        Assert.assertEquals(localePage.getActualResultEs().getText(), "Página de aterrizaje");
    }

    @Test
    public void changeLanguageEn() {
        localePage.changeLanguage();
        localePage.languageEn();
        Assert.assertEquals(localePage.getActualResultEn().getText(), "Landing");
    }

    @Test
    public void changeLanguageFr() {
        localePage.changeLanguage();
        localePage.languageFr();
        Assert.assertEquals(localePage.getActualResultFr().getText(), "Page d'atterrissage");
    }
}
