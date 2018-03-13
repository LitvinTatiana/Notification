package com.lt;

import com.lt.notification.*;
import com.lt.phone.Phone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//TODO: Название коммитов должны быть конструктивны. История гита должна читаться как книга
// Мы немного изменим работу с гитхабом, потом расскажу.
public class Main {

    private static final int BATTERY_CHARGE = 100,
            EXPENDITURE_EMPTY_BATTERY_NOTIFICATION = 5,
            EXPENDITURE_FULL_BATTERY_NOTIFICATION = 5,
            EXPENDITURE_SAVE_BATTERY_NOTIFICATION = 5,
            EXPENDITURE_LOW_BATTERY_NOTIFICATION = 5;

    public static final String
            MESSAGE_EMPTY_BATTERY_NOTIFICATION = "Notifications disabled",
            MESSAGE_FULL_BATTERY_NOTIFICATION = "Бррр-бррр",
            MESSAGE_SAVE_BATTERY_NOTIFICATION = "Бррр",
            MESSAGE_LOW_BATTERY_NOTIFICATION = "Low battery";

    public static void main(String [] args) {

        // TODO: Убрать лишний код из мейна, должны лишь быть строки запуска того или иного функционала
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = null;
        try {
           n = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int notificationCount = Integer.parseInt(n);

        Phone phone = new Phone(BATTERY_CHARGE);

        Notification emptyBatteryNotification = new Notification(EXPENDITURE_EMPTY_BATTERY_NOTIFICATION, MESSAGE_EMPTY_BATTERY_NOTIFICATION);
        Notification fullBatteryNotification = new Notification(EXPENDITURE_FULL_BATTERY_NOTIFICATION, MESSAGE_FULL_BATTERY_NOTIFICATION);
        Notification saveBatteryNotification = new Notification(EXPENDITURE_SAVE_BATTERY_NOTIFICATION, MESSAGE_SAVE_BATTERY_NOTIFICATION);
        Notification lowBatteryNotification = new Notification(EXPENDITURE_LOW_BATTERY_NOTIFICATION, MESSAGE_LOW_BATTERY_NOTIFICATION);

        NotificationCall notificationCall = new NotificationCall();

        // TODO: в коллекцию
        List<Notification> notificationList = new ArrayList<>();
        notificationCall.issueNotification(notificationCount, phone, emptyBatteryNotification, fullBatteryNotification, saveBatteryNotification, lowBatteryNotification);

    }

}