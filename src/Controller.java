public class Controller {

    static void dependency(int notificationCount, Phone phone, Notification... notification){
     while (notificationCount > 0 && phone.getBattery() >= 0) {

        if (phone.getBattery() > 30) {
            System.out.println(notification[1].getText());
            phone.setBattery(phone.getBattery() - notification[1].getExpenditure());
        }

        if (phone.getBattery() <= 30 && phone.getBattery() > 15) {
            System.out.println(notification[2].getText());
            phone.setBattery(phone.getBattery() - notification[2].getExpenditure());
        }
        if (phone.getBattery() <= 15 && phone.getBattery() > 0) {
            System.out.println(notification[3].getText());
            phone.setBattery(phone.getBattery() - notification[3].getExpenditure());
        }
        if (phone.getBattery() == 0) {
            System.out.println(notification[0].getText());
            phone.setBattery(phone.getBattery() - notification[0].getExpenditure());
        }
        notificationCount--;
        }
    }
}
