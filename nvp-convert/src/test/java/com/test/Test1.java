package com.test;

import org.junit.Test;

/**
 * Created by litong on 2017/12/27.
 */
public class Test1 {

    @Test
    public void test1(){
        String property = System.getProperty("os.name");
        System.out.println(property);
        String tempdir = System.getProperty("java.io.tmpdir");
        System.out.println(tempdir);
    }
}
