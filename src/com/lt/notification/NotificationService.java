package com.lt.notification;

import com.lt.Main;
import com.lt.phone.Battery;
import com.lt.phone.Phone;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements NotificationBehavior {

    private static final int EXPENDITURE_EMPTY_BATTERY_NOTIFICATION = 5;
    private static final int EXPENDITURE_FULL_BATTERY_NOTIFICATION = 5;
    private static final int EXPENDITURE_SAVE_BATTERY_NOTIFICATION = 5;
    private static final int EXPENDITURE_LOW_BATTERY_NOTIFICATION = 5;

    private static final String MESSAGE_EMPTY_BATTERY_NOTIFICATION = "Notifications disabled";
    private static final String MESSAGE_FULL_BATTERY_NOTIFICATION = "Бррр-бррр";
    private static final String MESSAGE_SAVE_BATTERY_NOTIFICATION = "Бррр";
    private static final String MESSAGE_LOW_BATTERY_NOTIFICATION = "Low battery";

    public NotificationService(){
        Notification emptyBatteryNotification = new Notification(EXPENDITURE_EMPTY_BATTERY_NOTIFICATION, MESSAGE_EMPTY_BATTERY_NOTIFICATION);
        Notification fullBatteryNotification = new Notification(EXPENDITURE_FULL_BATTERY_NOTIFICATION, MESSAGE_FULL_BATTERY_NOTIFICATION);
        Notification saveBatteryNotification = new Notification(EXPENDITURE_SAVE_BATTERY_NOTIFICATION, MESSAGE_SAVE_BATTERY_NOTIFICATION);
        Notification lowBatteryNotification = new Notification(EXPENDITURE_LOW_BATTERY_NOTIFICATION, MESSAGE_LOW_BATTERY_NOTIFICATION);

        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(emptyBatteryNotification);
        notificationList.add(fullBatteryNotification);
        notificationList.add(saveBatteryNotification);
        notificationList.add(lowBatteryNotification);

        int notificationCount = Main.enteredNumber;

        Battery phoneBattery = new Battery(Phone.BATTERY_CHARGE);

        issueNotification(notificationCount, phoneBattery, notificationList);
    }

    @Override
    public void issueNotification(int notificationCount, @NotNull Battery phoneBattery, @NotNull List<Notification> notificationList){

        Notification emptyBatteryNotification = notificationList.get(0);
        Notification fullBatteryNotification = notificationList.get(1);
        Notification saveBatteryNotification = notificationList.get(2);
        Notification lowBatteryNotification = notificationList.get(3);

        int saveBatteryValue = 30;
        int lowBatteryValue = 15;
        int emptyBatteryValue = 0;

        String notifText = "";
        int batteryUsage = 0;

        while (notificationCount > 0 && phoneBattery.getBatteryCharge() >= 0) {

            if (phoneBattery.getBatteryCharge() > saveBatteryValue) {
                notifText = fullBatteryNotification.getMessageText();
                batteryUsage = phoneBattery.getBatteryCharge() - fullBatteryNotification.getExpenditure();
            } else if (phoneBattery.getBatteryCharge() <= saveBatteryValue && phoneBattery.getBatteryCharge() > lowBatteryValue) {
                notifText = saveBatteryNotification.getMessageText();
                batteryUsage = phoneBattery.getBatteryCharge() - saveBatteryNotification.getExpenditure();
            } else if (phoneBattery.getBatteryCharge() <= lowBatteryValue && phoneBattery.getBatteryCharge() > emptyBatteryValue) {
                notifText = lowBatteryNotification.getMessageText();
                batteryUsage = phoneBattery.getBatteryCharge() - lowBatteryNotification.getExpenditure();
            } else if (phoneBattery.getBatteryCharge() == emptyBatteryValue) {
                notifText = emptyBatteryNotification.getMessageText();
                batteryUsage = phoneBattery.getBatteryCharge() - emptyBatteryNotification.getExpenditure();
            }

            System.out.println(notifText);
            phoneBattery.setBatteryCharge(batteryUsage);

            notificationCount--;
        }
    }
}