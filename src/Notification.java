public class Notification {
    private int expenditure;
    private String text;

    public Notification(int expenditure, String text) {
        this.expenditure = expenditure;
        this.text = text;
    }

    int getExpenditure(){
        return expenditure;
    }

    String getText(){
        return text;
    }

}
