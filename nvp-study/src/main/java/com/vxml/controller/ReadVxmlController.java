package com.vxml.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by litong on 2017/11/28.
 */
@Controller
public class ReadVxmlController {
    @Autowired
    private ServletContext sc;

    Log log = LogFactory.getLog(this.getClass());


    /**
     * 如果访问http://localhost:8081/nvp-study/vxml/index.vxml
     * 这name的值是index
     * @param name
     * @param request
     * @param response
     * @throws IOException
     */
    //默认情况下匹配不到name中拓展名,:匹配表达式
    //@RequestMapping(value = "/nvp-study/{suffix}/{name:.*}")
    public void readVxml(@PathVariable String suffix,@PathVariable String name,HttpServletRequest request,HttpServletResponse response) throws IOException {
        //String accept = request.getHeader("accept");

        //UTF-8必须大写
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out=null;
        try {
             out= response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filename="/"+suffix+"/" + name;
        log.info(filename);
        String realPath = sc.getRealPath(filename);
        log.info(realPath);
        FileInputStream fileInS=null;
        try {
             fileInS= new FileInputStream(realPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        InputStreamReader inSR=null;
        try {
             inSR= new InputStreamReader(fileInS, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BufferedReader bufRed = new BufferedReader(inSR);
        StringBuffer sb=new StringBuffer();
        String textLine=null;
        while((textLine=bufRed.readLine())!=null){
            sb.append(textLine);
        }
        bufRed.close();


        out.println(sb.toString());

    }
}
