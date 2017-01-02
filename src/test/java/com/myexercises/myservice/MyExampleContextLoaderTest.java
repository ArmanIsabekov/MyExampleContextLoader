/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myexercises.myservice;

import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Acer
 */
public class MyExampleContextLoaderTest {
    
    public MyExampleContextLoaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("MyProps.path", "classpath:/com/myexercises/myservice/config/myprops.properties");
        System.setProperty("MyExampleContextLoader.contextPath", "classpath:/com/myexercises/myservice/config/context.xml");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @org.junit.Test
    public void testMain() {
        MyExampleContextLoader loader = new MyExampleContextLoader();
        
        ApplicationContext ctx = loader.getCtx();
        Properties myprops = ctx.getBean("myprops", Properties.class);
        System.out.println(myprops.getProperty("MyService.name"));
    }
    
}
