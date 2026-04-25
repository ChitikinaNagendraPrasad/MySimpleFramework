package com.test.Utilities;

import java.util.ResourceBundle;

public final class ConfigReader
{
    private static final ResourceBundle bundle = ResourceBundle.getBundle("config");

    ConfigReader()
    {
    }

    public static String get(String key)
    {
        return bundle.getString(key);
    }
}