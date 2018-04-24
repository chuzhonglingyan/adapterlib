package com.yuntian.adapterexample.util.viewinject;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @explain 运行期注解
 *
 * @author guangleilei
 *
 * @time  2018/3/30 15:00
 */
@Retention(RetentionPolicy.RUNTIME) //生命周期
@Target(ElementType.FIELD)  //作用范围
public @interface InjectView {

    int value()  default (int) -1;

}
