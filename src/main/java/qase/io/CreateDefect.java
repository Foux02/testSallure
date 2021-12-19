package qase.io;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class CreateDefect {

    @FindBy(xpath = "//div[@id='react-app']/div[@class='app']/div//h1")
    public SelenideElement createNewDefect;

    @FindBy(id = "title")
    public SelenideElement defectTitle;

    @FindBy(xpath = "//div[@id='undefinedGroup']/div/div/div/div[2]/div/div[2]/div/div")
    public SelenideElement actualResult;

    @FindBy(id = "severityGroup")
    public SelenideElement severity;


    @FindBy(xpath = "//div[@id='react-select-3-option-0']")
    public SelenideElement severityNotSet;
    @FindBy(xpath = "//div[@id='react-select-3-option-1']")
    public SelenideElement severityBlocker;
    @FindBy(xpath = "//div[@id='react-select-3-option-2']")
    public SelenideElement severityCritical;
    @FindBy(xpath = "//div[@id='react-select-3-option-3']")
    public SelenideElement severityMajor;
    @FindBy(xpath = "//div[@id='react-select-3-option-4']")
    public SelenideElement severityNormal;
    @FindBy(xpath = "//div[@id='react-select-3-option-5']")
    public SelenideElement severityMinor;
    @FindBy(xpath = "//div[@id='react-select-3-option-6']")
    public SelenideElement severityTrivial;


    @FindBy(xpath = "//div[@id='react-app']/div/div/div/div/form/div[5]/div/div/div/div[2]/div")
    public SelenideElement assignee;

    @FindBy(xpath = "//div[@id='react-select-4-option-1']")
    public SelenideElement assigneeProf;

    @FindBy(xpath = "//button[.='Create defect']")
    public SelenideElement saveDefectBtn;


    @Step
    public void checkCreateDefect () {

        createNewDefect.shouldBe(Condition.visible);
    }

    @Step
    public void setSeverityCritical(String usura) {
        severity.click();
        getPriorityDefect(usura);
    }

    @Step
    public void setAssigneeProf() {
        assignee.click();
        assigneeProf.click();
    }

    @Step
    public void addCreateNewDefect (String defectName, String resultText, String usura) {
        defectTitle.click();
        defectTitle.sendKeys(defectName);
        actualResult.click();
        actualResult.sendKeys(resultText);
        setSeverityCritical(usura);
        setAssigneeProf();
        saveDefectBtn.click();
    }

    @Step
    public void getPriorityDefect(String usura) {

        switch (usura) {
            case "0": severityNotSet.click();
                break;
            case "1": severityBlocker.click();
                break;
            case "2": severityCritical.click();
                break;
            case "3": severityMajor.click();
                break;
            case "4": severityNormal.click();
                break;
            case "6": severityMinor.click();
                break;
            case "7": severityTrivial.click();
                break;
        }
    }
}
