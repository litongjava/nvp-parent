package com.recive.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import com.recive.utils.WebServiceUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Created by zhouyangying on 2017/9/26. 接收vxml提交过来参数
 */
@RestController
@RequestMapping("recive")
public class ReciveController {
    @Autowired
    private FreeMarkerConfig fConf;

    private Log log = LogFactory.getLog(this.getClass());

    /**
     * 对接电力系统 接受vxml提交上来的参数, qName:传递的代码的参数在request包中的名称 xxx:传递的代码
     * filename:需要跳转的文件名 formid:需要调整的form名
     */
    @RequestMapping(value = "recive", produces = "text/xml;charset=utf-8", method = RequestMethod.POST)
    public String getAnswer(String qname, String filename, String formidSuccess, String formidFail, HttpServletRequest request) {
        //1.输出请求信息
        log.info("得到一个新的请求");
        String addr = request.getRemoteAddr();
        log.info("请求来自:" + addr);
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> e : parameterMap.entrySet()) {
            log.info("接收到的参数有:" + e.getKey() + ":" + "接收到的值是:" + Arrays.toString(e.getValue()));
        }
        //2.判断问题代码
        String query = request.getParameter(qname);
        log.info("得到的问题代码是:" + query);

        String ans = "";
        // 请求知识平台
        //如果以数字开头,说明输入是合同账号
        if (query.matches("^(\\d+)")) {
            //3.请求知识库
            //查询电费
            ans = WebServiceUtil.getAnswer("find:" + query);
        }

        log.info("请求完毕");
        log.info("请求的内容是:" + ans);
        log.info("请求字符串的长度是:" + ans.length());
        //4.判断结果
        Configuration conf = fConf.getConfiguration();
        Template t1 = null;
        Map<String, String> map = new HashMap();
        // 拼接url,formid中本就包含#
        String desEle = null;
        //得到的正确回答如下
        //100|[ff8080815e996830015eeb48978302bb]
        //验证是否以数字开头
        if (ans.matches("^(\\d+)(.*)")) {
            ans = ans.substring(0, ans.lastIndexOf('|'));
            try {
                t1 = conf.getTemplate("correct.ftl");
                String finalAns = "截止到上月,您电费余额是 " + ans + " 元";
                desEle = "http://" + addr + ":8090" + filename + formidSuccess;
                map.put("prompt", finalAns);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else {
            try {
                t1 = conf.getTemplate("fail.ftl");
                desEle = "http://" + addr + ":8090" + filename + formidFail;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        log.info("目标descEle是:" + desEle);
        map.put("desEle", desEle);
        //5.返回文本
        StringWriter out = new StringWriter();
        try {
            t1.process(map, out);
        } catch (TemplateException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String result = out.toString();
        //拼接成最终的回答
        log.info("返回的vxml信息如下:+\n" + result);
        try {
            out.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return result;
    }
}
