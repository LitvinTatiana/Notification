package com.lt.notification;

import com.lt.Main;
import com.lt.phone.Battery;
import com.lt.phone.Phone;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements NotificationBehavior {

    public static final int EXPENDITURE_EMPTY_BATTERY_NOTIFICATION = 5;
    public static final int EXPENDITURE_FULL_BATTERY_NOTIFICATION = 5;
    public static final int EXPENDITURE_SAVE_BATTERY_NOTIFICATION = 5;
    public static final int EXPENDITURE_LOW_BATTERY_NOTIFICATION = 5;

    public static final String MESSAGE_EMPTY_BATTERY_NOTIFICATION = "Notifications disabled";
    public static final String MESSAGE_FULL_BATTERY_NOTIFICATION = "Бррр-бррр";
    public static final String MESSAGE_SAVE_BATTERY_NOTIFICATION = "Бррр";
    public static final String MESSAGE_LOW_BATTERY_NOTIFICATION = "Low battery";

    private List<Notification> mNotificationTypes = new ArrayList<>();

    private Battery mPhoneBattery;

    public NotificationService(List<Notification> notificationList, Battery phoneBattery){

        mNotificationTypes = notificationList;

        int notificationCount = Main.enteredNumber;

        mPhoneBattery = phoneBattery;
    }

    @Override
    public void issueNotification(int notificationCount){

        Notification emptyBatteryNotification = mNotificationTypes.get(0);
        Notification fullBatteryNotification = mNotificationTypes.get(1);
        Notification saveBatteryNotification = mNotificationTypes.get(2);
        Notification lowBatteryNotification = mNotificationTypes.get(3);

        int saveBatteryValue = 30;
        int lowBatteryValue = 15;
        int emptyBatteryValue = 0;

        String notifText = "";
        int batteryUsage = 0;

        while (notificationCount > 0 && mPhoneBattery.getBatteryCharge() >= 0) {

            if (mPhoneBattery.getBatteryCharge() > saveBatteryValue) {
                notifText = fullBatteryNotification.getMessageText();
                batteryUsage = mPhoneBattery.getBatteryCharge() - fullBatteryNotification.getExpenditure();
            } else if (mPhoneBattery.getBatteryCharge() <= saveBatteryValue && mPhoneBattery.getBatteryCharge() > lowBatteryValue) {
                notifText = saveBatteryNotification.getMessageText();
                batteryUsage = mPhoneBattery.getBatteryCharge() - saveBatteryNotification.getExpenditure();
            } else if (mPhoneBattery.getBatteryCharge() <= lowBatteryValue && mPhoneBattery.getBatteryCharge() > emptyBatteryValue) {
                notifText = lowBatteryNotification.getMessageText();
                batteryUsage = mPhoneBattery.getBatteryCharge() - lowBatteryNotification.getExpenditure();
            } else if (mPhoneBattery.getBatteryCharge() == emptyBatteryValue) {
                notifText = emptyBatteryNotification.getMessageText();
                batteryUsage = mPhoneBattery.getBatteryCharge() - emptyBatteryNotification.getExpenditure();
            }

            System.out.println(notifText);
            mPhoneBattery.setBatteryCharge(batteryUsage);

            notificationCount--;
        }
    }
}