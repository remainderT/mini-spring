package org.springframework.test.beans;

import org.junit.Test;
import org.springframework.test.beans.bean.Person;
import org.springframework.test.beans.factory.config.BeanDefinition;
import org.springframework.test.beans.factory.support.DefaultListableBeanFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PopulateBeanWithPropertyValuesTest {

    @Test
    public void testPopulateBeanWithPropertyValues() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "derek"));
        propertyValues.addPropertyValue(new PropertyValue("age", 18));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        beanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        assertThat(person.getName()).isEqualTo("derek");
        assertThat(person.getAge()).isEqualTo(18);
    }
}
