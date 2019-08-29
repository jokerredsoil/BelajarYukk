package com.mustova.belajaryukk;

import android.content.SharedPreferences;
import android.os.Environment;

public class Common {
    public static String extStorage = Environment.getExternalStorageDirectory().toString();
    public static String directory = Environment.getExternalStorageDirectory().toString() + "/vsga";

    public static String username;
}
