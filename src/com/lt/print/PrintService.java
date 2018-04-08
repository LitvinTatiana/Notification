package com.lt.print;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintService implements PrintBehavior {

    @Override @Nullable
    public String initInputListener() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = null;
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public boolean isNumber(@NotNull String str) throws NumberFormatException {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
