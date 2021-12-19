package qase.io;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class ProjectsPage {

    @FindBy(xpath = "//div[@class='nav-bottom-item nav-bottom-user']")
    public SelenideElement projectsLink;

    @FindBy(xpath = "//div[@id='react-app']/div[@class='app']/div[@class='container-fluid']//table/tbody/tr[3]/td[3]/div[1]/a[@href='/project/POKEMON']")
    public SelenideElement pokemonLink;

    @Step
    public void checkUserAuthorized() {

        projectsLink.shouldBe(Condition.visible);
    }

    @Step
    public PokemonPage openProjectPokemon() {
        pokemonLink.click();
        return page (PokemonPage.class);
    }
}
