package com.lt.notification;

import com.lt.phone.Phone;

public interface NotificationService {

    void issueNotification(int notificationCount, Phone phone, Notification... notification);

}
