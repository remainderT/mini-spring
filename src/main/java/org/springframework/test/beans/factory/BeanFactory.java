package org.springframework.test.beans.factory;

import org.springframework.test.beans.BeansException;

public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

}
