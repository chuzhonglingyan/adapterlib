package com.yuntian.adapterlib.base;

import android.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * description  .
 * Created by ChuYingYan on 2018/4/6.
 */
public class ViewHolderManager {


    //维护一个ClassMode下所有自定义类型集合
    public static Map<Class<? extends TypeInterface>, Map<Integer, ModeViewHolder>> mapMap = new HashMap<>();


    public static void registerTypeClass(Class<? extends TypeInterface> typeClass, Map<Integer, ModeViewHolder> viewTypeByCustomKey) {
        mapMap.put(typeClass, viewTypeByCustomKey);
    }

    public static Map<Class<? extends TypeInterface>, Map<Integer, ModeViewHolder>> getMapMap() {
        return mapMap;
    }



    //    //维持实体和类型之间关系
    //   private static Map<Class<? extends TypeInterface>, Integer> viewTypeByDataClass = new HashMap<>();

    public static int getViewType(Class<? extends TypeInterface> classData, int customKey) {
        Map<Integer, ModeViewHolder> viewTypeByCustomKey = mapMap.get(classData);
        return viewTypeByCustomKey.get(customKey).getViewType();
    }


    public static BaseViewHolder getViewHolder(int viewType, View itemView) {

        Class<? extends BaseViewHolder> viewHolderClass = getViewHolderClass(viewType);
        if (viewHolderClass == null) {
            return null;
        }
        Constructor c = null;
        try {
            c = viewHolderClass.getConstructor(View.class);
            return (BaseViewHolder) c.newInstance(itemView);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Class<? extends BaseViewHolder> getViewHolderClass(int viewType) {

        Class<? extends BaseViewHolder> viewHolderClass = ModeViewHolder.getViewHolderClassByType().get(viewType);
        return viewHolderClass;
    }


}
