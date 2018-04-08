package com.lt.phone;

import com.lt.Main;
import com.lt.notification.Notification;
import com.lt.notification.NotificationService;
import java.util.ArrayList;
import java.util.List;

public class Phone {

    private static final int BATTERY_CHARGE = 100;

    private static final int EXPENDITURE_EMPTY_BATTERY_NOTIFICATION = 5;
    private static final int EXPENDITURE_FULL_BATTERY_NOTIFICATION = 5;
    private static final int EXPENDITURE_SAVE_BATTERY_NOTIFICATION = 5;
    private static final int EXPENDITURE_LOW_BATTERY_NOTIFICATION = 5;

    private static final String MESSAGE_EMPTY_BATTERY_NOTIFICATION = "Notifications disabled";
    private static final String MESSAGE_FULL_BATTERY_NOTIFICATION = "Бррр-бррр";
    private static final String MESSAGE_SAVE_BATTERY_NOTIFICATION = "Бррр";
    private static final String MESSAGE_LOW_BATTERY_NOTIFICATION = "Low battery";

    public void receiveMessage() {

        NotificationService notificationService = new NotificationService();

        int notificationCount = Main.enteredNumber;

        Battery phoneBattery = new Battery(BATTERY_CHARGE);

        Notification emptyBatteryNotification = new Notification(EXPENDITURE_EMPTY_BATTERY_NOTIFICATION, MESSAGE_EMPTY_BATTERY_NOTIFICATION);
        Notification fullBatteryNotification = new Notification(EXPENDITURE_FULL_BATTERY_NOTIFICATION, MESSAGE_FULL_BATTERY_NOTIFICATION);
        Notification saveBatteryNotification = new Notification(EXPENDITURE_SAVE_BATTERY_NOTIFICATION, MESSAGE_SAVE_BATTERY_NOTIFICATION);
        Notification lowBatteryNotification = new Notification(EXPENDITURE_LOW_BATTERY_NOTIFICATION, MESSAGE_LOW_BATTERY_NOTIFICATION);

        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(emptyBatteryNotification);
        notificationList.add(fullBatteryNotification);
        notificationList.add(saveBatteryNotification);
        notificationList.add(lowBatteryNotification);

        notificationService.issueNotification(notificationCount, phoneBattery, notificationList);
    }
}
