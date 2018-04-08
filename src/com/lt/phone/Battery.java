package com.lt.phone;

public class Battery implements BatteryBehavior {

    private int batteryCharge;

    Battery(int batteryCharge) {
        this.batteryCharge = batteryCharge;
    }

    @Override
    public int getBatteryCharge() {
        return batteryCharge;
    }

    @Override
    public void setBatteryCharge(int batteryCharge) {
        this.batteryCharge = batteryCharge;
    }
}
