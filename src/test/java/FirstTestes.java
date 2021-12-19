import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import qase.io.*;
import qase.io.util.CardData;
import qase.io.util.PriorityData;
import qase.io.util.UserData;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;


public class FirstTestes {

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = "chrome";

    }

    @Test
    public void openCreateDefect() {
        UserData openWeb = new UserData("Foux02@rambler.ru","Tr@velBG209+");
        CardData create = new CardData("Defect75", "Not Text");
        PriorityData number = new PriorityData("6");
        LoginPage loginPage = open("https://app.qase.io/login", LoginPage.class);
        loginPage.enterLogin(openWeb.getUserName());
        loginPage.enterPassword(openWeb.getUserPassword());
        ProjectsPage projectsPage = loginPage.clickLoginBtn();
        projectsPage.checkUserAuthorized();
        PokemonPage pokemonPage = projectsPage.openProjectPokemon();
        pokemonPage.checkPokemonPage();
        DefectsPokemon defectsPokemon = pokemonPage.openDefectsPokemonPage();
        defectsPokemon.checkDefectsPokemon();
        CreateDefect createDefect = defectsPokemon.openCreateNewDefect();
        createDefect.checkCreateDefect();
        createDefect.addCreateNewDefect(create.getCardName(), create.getCardDiscription(), number.getPriorityData());
        defectsPokemon.checkCreateNewDefect(create.getCardName());
        defectsPokemon.setDeleteDefect();
        defectsPokemon.checkDeleteDefect();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        closeWindow();
    }


}