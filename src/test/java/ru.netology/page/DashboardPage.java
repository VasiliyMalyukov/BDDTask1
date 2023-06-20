package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private SelenideElement firstCard = $$("[data-test-id=action-deposit]").first();
    private SelenideElement secondCard = $$("[data-test-id=action-deposit]").last();
    private SelenideElement firstBalance = $("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
    private SelenideElement secondBalance = $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");

    public TransferPage firstCard() {
        firstCard.click();
        return new TransferPage();
    }

    public TransferPage secondCard() {
        secondCard.click();
        return new TransferPage();
    }

    public int getCurrentBalanceOfFirstCard() {
        String selectedValue = firstBalance.getText();
        String balanceOfFirstCard = selectedValue.substring(29, selectedValue.indexOf(" ", 29));
        return Integer.parseInt(balanceOfFirstCard);
    }

    public int getCurrentBalanceOfSecondCard() {
        String selectedValue = secondBalance.getText();
        String balanceOfFirstCard = selectedValue.substring(29, selectedValue.indexOf(" ", 29));
        return Integer.parseInt(balanceOfFirstCard);
    }
}
