package com.yuntian.adapterexample.util.viewinject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author guangleilei
 * @version 1.0 2018-03-30
 */
public class InjectHelp {


    public static void inject(Object target) {
        Class cls = target.getClass();
        Field[] fields = cls.getDeclaredFields(); //获取该类的所有字段
        for (Field field : fields) {
            InjectView injectView = field.getAnnotation(InjectView.class);
            if (injectView!=null){
                int value = injectView.value();
                if (value != -1) {
                    try {
                        field.setAccessible(true);
                        field.set(target, getView(target, cls, value));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static Object getView(Object target, Class cls, int resId) {
        Object view = null;
        try {
            Method method = cls.getMethod("findViewById", Integer.TYPE);
            view = method.invoke(target, resId);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return view;
    }
}
