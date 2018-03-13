package com.lt.phone;

/**
 * First design principle:
 * Take what varies and encapsulate it so it won't affect the rest of your code
 **
 * TODO: создаём объекты Battery + Notification service и композируем в Phone
 * *
 * Another principle: Program to an interface, not an implementation.
 * *
 * Для Notification service у нас есть интерфейс, создаим ещё для батерейки.
 * Phone Оставляем пока без интерфейса, это мейн класс нашей программы.
 * Мы будем говорить Phone, что пришли новые нотификации, а он их уже Делегирует (Strategy pattern)
 * сервису. Тут меня на 2 часа отвлекли майксоном и я сбился с мысли, что мы делаем дальше
 */
public class Phone {
    private int batteryCharge;

    public Phone(int batteryCharge) {
        this.batteryCharge = batteryCharge;
    }

    public int getBatteryCharge() {
        return batteryCharge;
    }

    public void setBatteryCharge(int batteryCharge) {
        this.batteryCharge = batteryCharge;
    }

}
