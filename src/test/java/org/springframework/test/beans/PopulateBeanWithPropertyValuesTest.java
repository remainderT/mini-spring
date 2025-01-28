package org.springframework.test.beans;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.test.beans.bean.Car;
import org.springframework.test.beans.bean.Person;
import org.springframework.test.beans.factory.config.BeanDefinition;
import org.springframework.test.beans.factory.config.BeanReference;
import org.springframework.test.beans.factory.support.DefaultListableBeanFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PopulateBeanWithPropertyValuesTest {

    /**
     * 为bean注入属性
     */
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


    /**
     * 为bean注入bean
     */
    @Test
    public void testPopulateBeanWithBean() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册Car实例
        PropertyValues propertyValuesForCar = new PropertyValues();
        propertyValuesForCar.addPropertyValue(new PropertyValue("brand", "porsche"));
        BeanDefinition carBeanDefinition = new BeanDefinition(Car.class, propertyValuesForCar);
        beanFactory.registerBeanDefinition("car", carBeanDefinition);

        //注册Person实例
        PropertyValues propertyValuesForPerson = new PropertyValues();
        propertyValuesForPerson.addPropertyValue(new PropertyValue("name", "derek"));
        propertyValuesForPerson.addPropertyValue(new PropertyValue("age", 18));
        //Person实例依赖Car实例
        propertyValuesForPerson.addPropertyValue(new PropertyValue("car", new BeanReference("car")));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValuesForPerson);
        beanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        Assertions.assertThat(person.getName()).isEqualTo("derek");
        Assertions.assertThat(person.getAge()).isEqualTo(18);
        Car car = person.getCar();
        Assertions.assertThat(car).isNotNull();
        Assertions.assertThat(car.getBrand()).isEqualTo("porsche");
    }
}
