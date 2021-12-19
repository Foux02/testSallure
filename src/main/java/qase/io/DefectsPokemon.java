package qase.io;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class DefectsPokemon {

    @FindBy(xpath = "//div[@class='d-flex']/h1[.='Defects']")
    public SelenideElement defectsPokemonProject;

    @FindBy(xpath = "//a[@href='/defect/POKEMON/create']")
    public SelenideElement createDefectLink;

    @FindBy(linkText = "Defect75")
    public SelenideElement nameNewDefect;

    @FindBy(xpath = "//td[8]/div/a/i")
    public SelenideElement choiceDelete;

    @FindBy(linkText = "Delete")
    public SelenideElement deleteDefect;

    @FindBy(xpath = "//button[.='Delete']")
    public SelenideElement deleteBtn;

    @Step
    public void checkDefectsPokemon () {

        defectsPokemonProject.shouldBe(Condition.visible);
    }

    @Step
    public CreateDefect openCreateNewDefect() {
        createDefectLink.click();
        return page (CreateDefect.class);
    }

    @Step
    public void checkCreateNewDefect (String defectName) {

        nameNewDefect.shouldBe(Condition.text(defectName));
    }

    @Step
    public void setDeleteDefect() {
        choiceDelete.click();
        deleteDefect.click();
        deleteBtn.click();
    }

    @Step
    public void checkDeleteDefect() {

        nameNewDefect.shouldBe(Condition.visible);
    }


}
