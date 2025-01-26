package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.test.ioc.factory.config.BeanDefinition;
import org.springframework.test.ioc.factory.support.DefaultListableBeanFactory;

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
