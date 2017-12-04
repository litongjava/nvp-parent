package com.recive.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by litong on 2017/12/1.
 */
public class ConfigUtil {
    private static Properties p;
    static{
        p= new Properties();
        FileInputStream fis = null;
        URL url = ConfigUtil.class.getClassLoader().getResource("application.properties");
        try {
            fis = new FileInputStream(url.getPath());
            p.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static String getConfig(String key) {
        return p.getProperty(key);
    }
}