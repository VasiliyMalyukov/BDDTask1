package ru.netology.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    public static VerificationCode getVerificationCode(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardInfo {
        String cardNumber;
        String cardBalance;
    }

    public static CardInfo getFirstCardInfo() {
        return new CardInfo("5559000000000001", "10000");
    }

    public static CardInfo getSecondCardInfo() {
        return new CardInfo("5559000000000002", "10000");
    }


    public static int balanceOfFirstCardAfterTransfer(int balance, int amount) {
        int newBalance = balance - amount;
        return newBalance;

    }

    public static int balanceOfSecondCardAfterTransfer(int balance, int amount) {
        int newBalance = balance + amount;
        return newBalance;
    }

}

