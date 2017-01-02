/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myexercises.myservice;

import java.util.Properties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Acer
 */
public class MyExampleContextLoader {
    private final ApplicationContext ctx;
    
    public MyExampleContextLoader() {
        ctx = new FileSystemXmlApplicationContext(System.getProperty("MyExampleContextLoader.contextPath"));
    }

    public ApplicationContext getCtx() {
        return ctx;
    }
    
    
    
    public static void main(String[] args) {
        System.setProperty("MyProps.path", "classpath:/com/myexercises/myservice/config/myprops.properties");
        System.setProperty("MyExampleContextLoader.contextPath", "classpath:/com/myexercises/myservice/config/context.xml");
        MyExampleContextLoader loader = new MyExampleContextLoader();
        
        ApplicationContext ctx = loader.getCtx();
        Properties myprops = ctx.getBean("myprops", Properties.class);
        System.out.println(myprops.getProperty("MyService.name"));
    }
}
