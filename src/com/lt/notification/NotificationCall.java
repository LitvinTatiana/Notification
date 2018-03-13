package com.lt.notification;

import com.lt.phone.Phone;

public class NotificationCall implements NotificationService {

    @Override
    public void issueNotification(int notificationCount, Phone phone, Notification... notification){
        while (notificationCount > 0 && phone.getBatteryCharge() >= 0) {

            // TODO: я до сих пор вижу магические цифры. Что за 30?
            // Читая конкретно эту функцию, я пониятия не имею, что пришло в параметрах и волновать меня это не должно
            // Я не должен лезть туда, где вызывалась эта функция, чтобы понять под каким индексом что лежит
            if (phone.getBatteryCharge() > 30) {
                System.out.println(notification[1].getMessageText());
                phone.setBatteryCharge(phone.getBatteryCharge() - notification[1].getExpenditure());
            }
            else if (phone.getBatteryCharge() <= 30 && phone.getBatteryCharge() > 15) {
                System.out.println(notification[2].getMessageText());
                phone.setBatteryCharge(phone.getBatteryCharge() - notification[2].getExpenditure());
            }
            else if (phone.getBatteryCharge() <= 15 && phone.getBatteryCharge() > 0) {
                System.out.println(notification[3].getMessageText());
                phone.setBatteryCharge(phone.getBatteryCharge() - notification[3].getExpenditure());
            }
            else if (phone.getBatteryCharge() == 0) {
                System.out.println(notification[0].getMessageText());
                phone.setBatteryCharge(phone.getBatteryCharge() - notification[0].getExpenditure());
            }

            // TODO: ОЧень много повторяющегося кода. IF-ки идентичны. Сверху можно создать переменную
            // notifText + batteryUsage, В ифках её проинициализировать, а после всех ифов - вызывать операции
            // "else if" не переносится на другую строку

            notificationCount--;
        }
    }
}