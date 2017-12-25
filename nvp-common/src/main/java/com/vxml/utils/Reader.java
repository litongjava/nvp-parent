package com.vxml.utils;

import org.dom4j.io.SAXReader;

/**
 * Created by litong on 2017/12/4.
 */
public class Reader {
    private static SAXReader reader=null;

    /**
     * 单例模式
     */
    public static SAXReader getInstance(){
        if(reader==null){
            reader=new SAXReader();
            //防止dtd文件不存在而产生的网络错误
            reader.setEntityResolver(new MyEntryResovler());
            return reader;
        }else{
            return reader;
        }
    }
}
