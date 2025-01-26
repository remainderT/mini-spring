package org.springframework.test.beans.factory.support;

import org.springframework.test.beans.BeansException;
import org.springframework.test.beans.factory.config.BeanDefinition;

public interface
InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
