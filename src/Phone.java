public class Phone {

    // TODO: название переменной звучит так, будто это объект батереи, в котором есть разные методы и поля. Переименовать.
    private int battery;

    public Phone(int battery) {
        this.battery = battery;
    }

    int getBattery(){
        return battery;
    }

    void setBattery(int battery){
        this.battery = battery;
    }

}
