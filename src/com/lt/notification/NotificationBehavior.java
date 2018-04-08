package com.lt.notification;

import com.lt.phone.Battery;
import java.util.List;

public interface NotificationBehavior {
    void issueNotification(int notificationCount, Battery phoneBattery, List<Notification> notificationList);
}
