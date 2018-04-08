package com.lt;

import com.lt.phone.Phone;
import com.lt.print.PrintService;

public class Main {
    public static int enteredNumber;
    public static void main(String [] args) {
        initInputKeyboardListener();
    }

    private static void initInputKeyboardListener(){
        boolean condition = true;

        while (condition == true){
            PrintService initInputKeyboard = new PrintService();
            String str = initInputKeyboard.initInputListener();
            if (str.equals("break")){
                condition = false;
            } else if (str == null || !initInputKeyboard.isNumber(str)){
                throw new NumberFormatException("Invalid input ");
            } else {
                System.out.println("notifications amount = " + str);
                enteredNumber = Integer.parseInt(str);
                Phone phone = new Phone();
                phone.receiveMessage();
            }
        }
    }
}