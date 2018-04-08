package com.lt.notification;

import org.jetbrains.annotations.NotNull;

public class Notification {
    private int expenditure;
    private String message;

    @NotNull
    public Notification(int expenditure, @NotNull String messageText) {
        this.expenditure = expenditure;
        this.message = messageText;
    }

    int getExpenditure(){
        return expenditure;
    }

    @NotNull
    String getMessageText(){
        return message;
    }
}
