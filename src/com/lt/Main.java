package com.lt;

import com.lt.notification.Notification;
import com.lt.notification.NotificationService;
import com.lt.phone.Battery;
import com.lt.phone.Phone;
import com.lt.print.InputDataProvider;
import com.lt.print.InputKeyboardService;
import com.lt.utils.BuildConfig;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int enteredNumber;

    private Phone mPhone;

    public static void main(String [] args) {

        BuildConfig.BUILD_TYPE = args[0];

        Phone phone = new Phone(
                new NotificationService(initNotificationTypes(),
                new Battery(Phone.BATTERY_CHARGE)));

        Main main = new Main(phone);

        main.start();

    }

    Main(Phone phone){
        mPhone = phone;
    }

    private void start(){

        log("start()");

        InputDataProvider initInputKeyboard = new InputKeyboardService(mPhone);

        log("before start listen");

        initInputKeyboard.startListen();
    }

    private static List<Notification> initNotificationTypes() {
        List<Notification> notificationTypes = new ArrayList<>();

        Notification emptyBatteryNotification = new Notification(NotificationService.EXPENDITURE_EMPTY_BATTERY_NOTIFICATION, NotificationService.MESSAGE_EMPTY_BATTERY_NOTIFICATION);
        Notification fullBatteryNotification = new Notification(NotificationService.EXPENDITURE_FULL_BATTERY_NOTIFICATION, NotificationService.MESSAGE_FULL_BATTERY_NOTIFICATION);
        Notification saveBatteryNotification = new Notification(NotificationService.EXPENDITURE_SAVE_BATTERY_NOTIFICATION, NotificationService.MESSAGE_SAVE_BATTERY_NOTIFICATION);
        Notification lowBatteryNotification = new Notification(NotificationService.EXPENDITURE_LOW_BATTERY_NOTIFICATION, NotificationService.MESSAGE_LOW_BATTERY_NOTIFICATION);

        notificationTypes.add(emptyBatteryNotification);
        notificationTypes.add(fullBatteryNotification);
        notificationTypes.add(saveBatteryNotification);
        notificationTypes.add(lowBatteryNotification);

        return notificationTypes;
    }

    private void log(String text) {
        if (BuildConfig.isDebugBuild()) {
            System.out.println("Main -> " + text);
        }
    }
}