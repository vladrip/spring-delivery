package com.exam.spring_delivery.model.delivery;

public enum DeliveryStatus {
    PROCESSING("P"),
    ACCEPTED("A"),
    IN_TRANSIT("I_T"),
    DELIVERED("D"),
    PICKED_UP("P_U"),
    CANCELED("C"),
    UNKNOWN("U");

    private final String dbCode;

    DeliveryStatus(String dbCode) {
        this.dbCode = dbCode;
    }

    public String getDbCode() {
        return dbCode;
    }
}