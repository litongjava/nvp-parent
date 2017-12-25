package com.test.dom4j;

import com.vxml.utils.MyEntryResovler;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * Created by zhouyangying on 2017/12/4.
 */
public class TestDom4j {


    public static void main(String[] args) throws  IOException {
        String url="D:\\IdeaProjects\\nvp-parent\\nvp-panjianincubator\\src\\main\\webapp\\vxml\\index.vxml";
        SAXReader read = new SAXReader();
        read.setEntityResolver(new MyEntryResovler());
        Document doc = null;
        try {
            doc = read.read(url);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        String s = doc.asXML();
        System.out.println(s);
        String xpath;
        xpath = "//var[@name='page']";

        Node node = doc.selectSingleNode(xpath);
        Element element = (Element) node;

        element.attribute("name").setValue("page1");

        String s1 = doc.asXML();
        System.out.println(s1);

        XMLWriter l = new XMLWriter(new FileOutputStream("text.vxml"), OutputFormat.createPrettyPrint());
        l.write(doc);
        l.close();


//        Element rootElement = doc.getRootElement();
//        Element var = rootElement.element("var");


//        String text = rootElement.getText();
//        System.out.println(text);

    }
}
