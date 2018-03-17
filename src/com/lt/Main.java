package com.lt;

import com.lt.notification.*;
import com.lt.phone.Phone;
import com.lt.print.PrintCall;

import java.util.ArrayList;
import java.util.List;

//TODO: Название коммитов должны быть конструктивны. История гита должна читаться как книга
// Мы немного изменим работу с гитхабом, потом расскажу.
public class Main {

    private static final int BATTERY_CHARGE = 100;
    private static final int EXPENDITURE_EMPTY_BATTERY_NOTIFICATION = 5;
    private static final int EXPENDITURE_FULL_BATTERY_NOTIFICATION = 5;
    private static final int EXPENDITURE_SAVE_BATTERY_NOTIFICATION = 5;
    private static final int EXPENDITURE_LOW_BATTERY_NOTIFICATION = 5;

    private static final String MESSAGE_EMPTY_BATTERY_NOTIFICATION = "Notifications disabled";
    private static final String MESSAGE_FULL_BATTERY_NOTIFICATION = "Бррр-бррр";
    private static final String MESSAGE_SAVE_BATTERY_NOTIFICATION = "Бррр";
    private static final String MESSAGE_LOW_BATTERY_NOTIFICATION = "Low battery";

    public static void main(String [] args) {

        // TODO: Убрать лишний код из мейна, должны лишь быть строки запуска того или иного функционала

        NotificationCall notificationCall = new NotificationCall();

        PrintCall printCall = new PrintCall();

        int notificationCount = printCall.enterValue();

        Phone phone = new Phone(BATTERY_CHARGE);

        Notification emptyBatteryNotification = new Notification(EXPENDITURE_EMPTY_BATTERY_NOTIFICATION, MESSAGE_EMPTY_BATTERY_NOTIFICATION);
        Notification fullBatteryNotification = new Notification(EXPENDITURE_FULL_BATTERY_NOTIFICATION, MESSAGE_FULL_BATTERY_NOTIFICATION);
        Notification saveBatteryNotification = new Notification(EXPENDITURE_SAVE_BATTERY_NOTIFICATION, MESSAGE_SAVE_BATTERY_NOTIFICATION);
        Notification lowBatteryNotification = new Notification(EXPENDITURE_LOW_BATTERY_NOTIFICATION, MESSAGE_LOW_BATTERY_NOTIFICATION);

        // TODO: в коллекцию
        List<Notification> notificationList = new ArrayList<>();

        notificationList.add(emptyBatteryNotification);
        notificationList.add(fullBatteryNotification);
        notificationList.add(saveBatteryNotification);
        notificationList.add(lowBatteryNotification);

        notificationCall.issueNotification(notificationCount, phone, notificationList);

    }

}