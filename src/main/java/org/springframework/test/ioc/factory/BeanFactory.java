package org.springframework.test.ioc.factory;

import org.springframework.test.ioc.BeansException;

public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

}
