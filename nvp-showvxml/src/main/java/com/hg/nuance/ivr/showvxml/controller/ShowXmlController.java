package com.hg.nuance.ivr.showvxml.controller;

import com.hg.nuance.ivr.showvxml.utils.VxmlUtil;
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
public class ShowXmlController {

    private Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private ServletContext sc;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "XXX is prject name";
    }

    /**
     * 如果访问http://localhost:8081/nvp-study/vxml/index.vxml
     * 这name的值是index
     *
     * @param name
     * @param request
     * @param response
     * @throws java.io.IOException
     */
    //默认情况下匹配不到name中拓展名,:匹配表达式
    @RequestMapping(value = "/{suffix}/{name:.*}")
    public void readVxml(@PathVariable String suffix, @PathVariable String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //String accept = request.getHeader("accept");

        //UTF-8必须大写
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filename = "/" + suffix + "/" + name;
        log.info(filename);
        String realPath = sc.getRealPath(filename);
        log.info(realPath);
        String result=null;
        //替换xml文件
        if(name.endsWith(".xml")){
            result = VxmlUtil.replaceVarNname(realPath, name);
        }else{
            result=VxmlUtil.getContent(realPath);
        }
        out.println(result);
        //log.info(result);
    }
}
