package com.recive.utils;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * Created by zhouyangying on 2017/11/10.
 * 处理文件的工具类
 */
public class FileUtil {
    private static Properties prop=new Properties();
    private static String filename="mapSemantic.properties";
    static{
        InputStream stream = FileUtil.class.getClassLoader().getResourceAsStream(filename);
        try {
            prop.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Properties getProperties(){
        return prop;
    }

    /**
     *
     * @param key 属性
     * @return 对应的属性值
     */
    public static String getValue(String key){
        return (String)prop.get(key);
    }
}
