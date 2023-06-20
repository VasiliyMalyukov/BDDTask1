package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private SelenideElement amountInput = $("[data-test-id='amount'] input");
    private SelenideElement fromInput = $("[data-test-id='from'] input");
    private SelenideElement transferHead = $(byText("Пополнение карты"));

    public TransferPage() {
        transferHead.shouldBe(visible);
    }

    public DashboardPage makeTransfer(int amountToTransfer, DataHelper.CardInfo cardInfo) {
        amountInput.setValue(String.valueOf(amountToTransfer));
        fromInput.setValue(cardInfo.getCardNumber());
        transferButton.click();
        return new DashboardPage();
    }

    public void successfulTransfer() {

        $(withText("Операция проведена успешно")).shouldBe(Condition.visible);
    }

    public void failedTransferFirst() {
        $(withText("Вы ввели сумму, превышающую остаток средств на Вашем счете." +
                " Пожалуйста, введите другую сумму")).shouldBe(Condition.visible);
    }

    public void failedTransferSecond() {
        $(withText("Пожалуйста, укажите сумму, которую необходимо ввести")).shouldBe(Condition.visible);
    }
}
