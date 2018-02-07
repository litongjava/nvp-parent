package com.hg.nuance.ivr.showvxml.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by litong on 2017/12/4.
 */
public class VxmlUtil {
    private static Logger log = LoggerFactory.getLogger(VxmlUtil.class);
    private static SAXReader instance = com.hg.nuance.ivr.showvxml.utils.Reader.getInstance();

    /**
     * 替换var变量的name值为xml的文件名
     *
     * 将<var name="formname" expr="page+'#main'"/>
     * 替换为 <var name="formname" expr="name+'#main'"/>
     * name是变量name
     *
     * main是一个vxml的主入口,方便与在其他from跳转到main
     *
     * @param filename vxml文件全路径
     * @param name 文件名
     * @return
     */
    public static String replaceVarNname(String filename,String name){

        int i=0;
        log.info(i+"");
        i++;

        Document doc=null;
        try {
            doc= instance.read(filename);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        String xpath = "//var[@name='page']";

        Element ele= (Element)doc.selectSingleNode(xpath);
        ele.attribute("expr").setValue("'"+name+"'");
        //返回xml文本
        return doc.asXML();
    }
    public static String getContent(String filename){
        Document doc=null;
        try {
            doc= instance.read(filename);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return doc.asXML();
    }
}
