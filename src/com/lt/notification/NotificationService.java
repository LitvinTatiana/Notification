package com.lt.notification;

import com.lt.phone.Phone;
import java.util.List;

public interface NotificationService {

    void issueNotification(int notificationCount, Phone phone, List<Notification> notificationList);

}
