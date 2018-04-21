package com.lt.print;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputKeyboardService implements InputDataProvider {

    @Nullable
    private InputListener mListener;
    
    public InputKeyboardService(@Nullable InputListener listener) {
        mListener = listener;
    }

    @Override
    public void startListen() {
        
        if (mListener != null) {
            mListener.onStartListening();
        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputString;
        
        try {

            while ((inputString = br.readLine()) != null) {

                if (mListener != null) {
                    mListener.onNewMessage(inputString);
                }
            }

            if (mListener != null) {
                mListener.onError("Input String = null. This should not ever happen.");
            }
            
        } catch (IOException e) {
            if (mListener != null) {
                mListener.onError("IOException");
            }
        }
    }
    
}
