package qase.io.util;

import io.qameta.allure.Step;

public class PriorityData {
    private String priorityNumber;

    public PriorityData(String priorityNumber) {
        this.priorityNumber = priorityNumber;
    }

    @Step
    public String getPriorityData() {
        return this.priorityNumber;
    }
}
