package com.example.complexeSportif.entities.Enum;

public enum PaymentType {
    CREDIT_CARD("Credit Card"),
    BANK_TRANSFER("Bank Transfer"),
    CASH("Cash");

    private final String displayName;

    PaymentType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
