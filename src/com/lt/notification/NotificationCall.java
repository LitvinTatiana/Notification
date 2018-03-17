package com.lt.notification;

import com.lt.phone.Phone;
import java.util.List;

public class NotificationCall implements NotificationService {

    @Override
    public void issueNotification(int notificationCount, Phone phone, List<Notification> notificationList){

        Notification emptyBatteryNotification = notificationList.get(0);
        Notification fullBatteryNotification = notificationList.get(1);
        Notification saveBatteryNotification = notificationList.get(2);
        Notification lowBatteryNotification = notificationList.get(3);

        int saveBatteryValue = 30;
        int lowBatteryValue = 15;
        int emptyBatteryValue = 0;

        String notifText = "";
        int batteryUsage = 0;

        while (notificationCount > 0 && phone.getBatteryCharge() >= 0) {

            // TODO: я до сих пор вижу магические цифры. Что за 30?
            // Читая конкретно эту функцию, я пониятия не имею, что пришло в параметрах и волновать меня это не должно
            // Я не должен лезть туда, где вызывалась эта функция, чтобы понять под каким индексом что лежит

            if (phone.getBatteryCharge() > saveBatteryValue) {
                notifText = fullBatteryNotification.getMessageText();
                batteryUsage = phone.getBatteryCharge() - fullBatteryNotification.getExpenditure();
            }
            else if (phone.getBatteryCharge() <= saveBatteryValue && phone.getBatteryCharge() > lowBatteryValue) {
                notifText = saveBatteryNotification.getMessageText();
                batteryUsage = phone.getBatteryCharge() - saveBatteryNotification.getExpenditure();
            }
            else if (phone.getBatteryCharge() <= lowBatteryValue && phone.getBatteryCharge() > emptyBatteryValue) {
                notifText = lowBatteryNotification.getMessageText();
                batteryUsage = phone.getBatteryCharge() - lowBatteryNotification.getExpenditure();
            }
            else if (phone.getBatteryCharge() == emptyBatteryValue) {
                notifText = emptyBatteryNotification.getMessageText();
                batteryUsage = phone.getBatteryCharge() - emptyBatteryNotification.getExpenditure();
            }

            System.out.println(notifText);
            phone.setBatteryCharge(batteryUsage);

            // TODO: ОЧень много повторяющегося кода. IF-ки идентичны. Сверху можно создать переменную
            // notifText + batteryUsage, В ифках её проинициализировать, а после всех ифов - вызывать операции
            // "else if" не переносится на другую строку

            notificationCount--;
        }
    }
}