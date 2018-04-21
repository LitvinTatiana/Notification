package com.lt.phone;

import com.lt.notification.NotificationBehavior;
import com.lt.print.InputDataProvider;
import com.lt.utils.BuildConfig;
import org.jetbrains.annotations.NotNull;

public class Phone implements InputDataProvider.InputListener {

    public static final int BATTERY_CHARGE = 100;

    private NotificationBehavior mNotificationService;

    public Phone(NotificationBehavior notificationBehavior) {
        mNotificationService = notificationBehavior;
    }

    private void receiveMessage(int count) {

         mNotificationService.issueNotification(count);
    }

    @Override
    public void onStartListening() {
        log("onStartListening");
    }

    @Override
    public void onNewMessage(@NotNull String inputString) {

        if (isNumber(inputString)) {

            log("notifications amount = " + inputString);

            receiveMessage(Integer.valueOf(inputString));
        } else {
            log("not a number, inputString = " + inputString);
        }
    }

    @Override
    public void onError(String errorMessage) {
        log("onError() " + errorMessage);
    }


    private void log(String text) {
        if (BuildConfig.isDebugBuild()) {
            System.out.println("Phone -> " + text);
        }
    }

    private boolean isNumber(@NotNull String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
