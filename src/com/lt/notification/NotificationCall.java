package com.lt.notification;

import com.lt.phone.Phone;

public class NotificationCall implements NotificationService {

    @Override
    public void issueNotification(int notificationCount, Phone phone, Notification... notification){
        while (notificationCount > 0 && phone.getBatteryCharge() >= 0) {

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

            notificationCount--;
        }
    }
}