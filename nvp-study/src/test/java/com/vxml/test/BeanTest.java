package com.vxml.test;

import com.vxml.controller.ReadVxmlController;
import com.vxml.main.Start;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by litong on 2017/11/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Start.class)
@WebAppConfiguration
public class BeanTest {
    @Autowired
    private ReadVxmlController rvC;

    @Test
    public void test1(){
        System.out.println(rvC);
    }

}
