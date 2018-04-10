package com.yuntian.adapterlib.util;

import com.yuntian.adapterlib.imp.TypeInterfaceImp;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * description  .
 * Created by ChuYingYan on 2018/4/6.
 */
public class TypeUitl<K, V extends TypeInterfaceImp> {


    public TypeInterfaceImp convert(K d, TypeInterfaceImp typeInterfaceImp) {
        if (d != null && typeInterfaceImp != null) {
            typeInterfaceImp.setK(d);
            return typeInterfaceImp;
        }
        return null;
    }

    public List<V> convert(List<K> list, Class<? extends TypeInterfaceImp> typeInterfaceImpClass) {
        long startTime = System.nanoTime();
        if (list != null && typeInterfaceImpClass != null) {
            List<V> typeInterfaces = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                try {
                    Constructor c = typeInterfaceImpClass.getConstructor(list.get(i).getClass());//获取有参构造
                    typeInterfaces.add((V) c.newInstance(list.get(i)));
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("耗时间 微秒：" + (System.nanoTime() - startTime) / 1000);
            return typeInterfaces;
        }
        return null;
    }


}
