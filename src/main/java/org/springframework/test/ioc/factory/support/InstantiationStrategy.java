package org.springframework.test.ioc.factory.support;

import org.springframework.test.ioc.BeansException;
import org.springframework.test.ioc.factory.config.BeanDefinition;

public interface
InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
