package org.springframework.test.beans;

import org.junit.Test;
import org.springframework.test.beans.factory.config.BeanDefinition;
import org.springframework.test.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.beans.service.HelloService;

public class BeanDefinitionAndBeanDefinitionRegistryTes {

    @Test
    public void testBeanFactory() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.sayHello();
    }
}
