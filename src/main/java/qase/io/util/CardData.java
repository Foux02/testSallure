package qase.io.util;

import io.qameta.allure.Step;

public class CardData {
    private String cardName;
    private String cardDiscription;

    public CardData(String cardName, String cardDiscription) {
        this.cardName = cardName;
        this.cardDiscription = cardDiscription;
    }

    @Step
    public String getCardName() {
        return this.cardName;
    }

    @Step
    public String getCardDiscription() {
        return this.cardDiscription;
    }
}
