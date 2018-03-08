import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = reader.readLine();

        int notificationCount = Integer.parseInt(n);

        Phone phone = new Phone(100);

        Notification notification = new Notification(5, "Notifications disabled");
        Notification notification1 = new Notification(5, "Бррр-бррр");
        Notification notification2 = new Notification(5, "Бррр");
        Notification notification3 = new Notification(5, "Low battery");

        Controller.dependency(notificationCount, phone, notification, notification1, notification2, notification3);

    }

}
