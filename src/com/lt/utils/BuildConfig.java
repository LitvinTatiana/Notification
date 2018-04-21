package com.lt.utils;

public class BuildConfig {

    public static String BUILD_TYPE;

    public static boolean isDebugBuild() {
        return BUILD_TYPE.equals("debug");
    }
}
