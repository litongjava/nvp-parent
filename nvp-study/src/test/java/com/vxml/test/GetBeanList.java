package com.vxml.test;

import com.vxml.main.Start;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by zhouyangying on 2017/11/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Start.class)
@WebAppConfiguration
public class GetBeanList {
    @Autowired
    private ApplicationContext ac;

    @Test
    public void getBeanList(){
        int i=0;
        String[] beans = ac.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(++i+":"+bean);
        }
    }


}
