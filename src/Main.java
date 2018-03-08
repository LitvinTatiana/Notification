import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO: Разделить по пакетам.
// Убрать выбрасывание экспешена в мейне. Он должен выбрасываться точечно
public class Main {

    private static final int EXPENDITURE_LOW_BATTERY_NOTIFICATION = 5;

    public static void main(String [] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = reader.readLine();

        int notificationCount = Integer.parseInt(n);

        Phone phone = new Phone(100);

        // TODO: за переменные 1,2,3 можно отбивать руки. Rename по смыслу.
        // TODO: никаких магических цифр и строк не должно быть в коде. Использовать константы
        Notification notification = new Notification(5, "Notifications disabled");
        Notification notification1 = new Notification(5, "Бррр-бррр");
        Notification saveBatteryNotification = new Notification(5, "Бррр");
        Notification lowBatteryNotification = new Notification(EXPENDITURE_LOW_BATTERY_NOTIFICATION, "Low battery");

        // TODO: не должно быть статического вызова. Как мы будем писать программу? Сделать некий модуль, типа NotificationService
        // который будет реализовать интерфейс (а да, помним, что программируем через интерфейс, а не через реализацию), в котором будет метод
        // issueNotification(notification), в который будут передаваться заходящие нотификации.
        Controller.dependency(notificationCount, phone, notification, notification1, saveBatteryNotification, lowBatteryNotification);

    }

}
