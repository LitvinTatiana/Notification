package com.lt.notification;

import com.lt.phone.Battery;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NotificationService implements NotificationBehavior {

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