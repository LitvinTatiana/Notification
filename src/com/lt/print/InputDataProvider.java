package com.lt.print;

import java.io.IOException;

public interface InputDataProvider {

    interface InputListener {

        void onStartListening();

        void onNewMessage(String inputString);

        void onError(String errorMessage);

    }

    void startListen();
}