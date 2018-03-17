package com.lt.print;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintCall implements PrintService {

    @Override
    public int enterValue() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = null;
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int n;

        if (str == null || !isNumber(str))
            throw new NumberFormatException("invalid input");
        else n = Integer.parseInt(str);

        return n;
    }

    @Override
    public boolean isNumber(String str) throws NumberFormatException {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
