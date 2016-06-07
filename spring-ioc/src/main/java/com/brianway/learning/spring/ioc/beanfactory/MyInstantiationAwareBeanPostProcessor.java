package com.brianway.learning.spring.ioc.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Created by Brian on 2016/5/13.
 * InstantiationAwareBeanPostProcessor实现类
 * 该类通过扩展InstantiationAwareBeanPostProcessor适配器InstantiationAwareBeanPostProcessorAdapter提供实现
 * 在该类中,通过过滤条件只对car Bean进行处理,对其他Bean不管
 */
public class MyInstantiationAwareBeanPostProcessor  extends InstantiationAwareBeanPostProcessorAdapter{
    //接口方法:在实例化Bean前进行调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        //仅对car Bean进行处理
        if("car".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        }
        return null;
    }


    //接口方法:在实例化Bean后进行调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        //仅对car Bean进行处理
        if("car".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
        }
        return true;
    }

    //接口方法:在设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        //仅对car Bean进行处理,还可以通过pdst入参进行过滤
        //仅对car的某个特定属性时进行处理
        if("car".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessPropertyValues");
        }
        return pvs;
    }




}
