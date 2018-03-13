package com.lt.notification;

public class Notification {
    private int expenditure;
    private String message;

    public Notification(int expenditure, String messageText) {
        this.expenditure = expenditure;
        this.message = messageText;
    }

    int getExpenditure(){
        return expenditure;
    }

    String getMessageText(){
        return message;
    }

}
