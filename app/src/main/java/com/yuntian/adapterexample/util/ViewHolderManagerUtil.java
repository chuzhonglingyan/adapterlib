package com.yuntian.adapterexample.util;

import android.view.View;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.good.GoodType;
import com.yuntian.adapterexample.list.good.GoodViewHolder01;
import com.yuntian.adapterexample.list.good.GoodViewHolder02;
import com.yuntian.adapterexample.list.house.CommunityType;
import com.yuntian.adapterexample.list.house.CommunityViewHolder;
import com.yuntian.adapterexample.list.house.HouseHolder;
import com.yuntian.adapterexample.list.house.HouseType;
import com.yuntian.adapterexample.list.main.MainType;
import com.yuntian.adapterexample.list.main.MainTypeViewHolder;
import com.yuntian.adapterexample.list.typemode.FootType01;
import com.yuntian.adapterexample.list.typemode.HeadType01;
import com.yuntian.adapterexample.list.typemode.RvItemType;
import com.yuntian.adapterexample.list.typemode.RvType;
import com.yuntian.adapterexample.list.typemode.TestType01;
import com.yuntian.adapterexample.list.typemode.TestType02;
import com.yuntian.adapterexample.list.viewholder.FootViewHolder01;
import com.yuntian.adapterexample.list.viewholder.HeadViewHolder01;
import com.yuntian.adapterexample.list.viewholder.RvItemViewHolder;
import com.yuntian.adapterexample.list.viewholder.RvViewHolder;
import com.yuntian.adapterexample.list.viewholder.TestViewHolder01;
import com.yuntian.adapterexample.list.viewholder.TestViewHolder02;
import com.yuntian.adapterlib.base.BaseViewHolder;
import com.yuntian.adapterlib.base.ModeViewHolder;
import com.yuntian.adapterlib.base.TypeInterface;
import com.yuntian.adapterlib.base.ViewHolderManager;

import java.util.HashMap;
import java.util.Map;

/**
 * description  注册管理.
 * Created by ChuYingYan on 2018/4/6.
 */
public class ViewHolderManagerUtil {


    static {

        Map<Integer, ModeViewHolder> goodMap = new HashMap<>();
        goodMap.put(0, new ModeViewHolder(R.layout.item_good01, GoodViewHolder01.class));
        goodMap.put(1, new ModeViewHolder(R.layout.item_good02, GoodViewHolder02.class));
        registerTypeClass(GoodType.class, goodMap);



        registerTypeClass(CommunityType.class, R.layout.item_commuty, CommunityViewHolder.class);
        registerTypeClass(HouseType.class, R.layout.item_house, HouseHolder.class);


        registerTypeClass(MainType.class, R.layout.item_main_item, MainTypeViewHolder.class);

        registerTypeClass(TestType01.class, R.layout.item_test01, TestViewHolder01.class);
        registerTypeClass(TestType02.class, R.layout.item_test02, TestViewHolder02.class);

        registerTypeClass(HeadType01.class, R.layout.item_head_01, HeadViewHolder01.class);
        registerTypeClass(FootType01.class, R.layout.item_foot_01, FootViewHolder01.class);


        registerTypeClass(RvType.class, R.layout.item_rv, RvViewHolder.class);
        registerTypeClass(RvItemType.class, R.layout.item_rv_item, RvItemViewHolder.class);

    }


    public static void registerTypeClass(Class<? extends TypeInterface> typeClass, Map<Integer, ModeViewHolder> viewTypeByCustomKey) {
        ViewHolderManager.registerTypeClass(typeClass, viewTypeByCustomKey);
    }


    public static void registerTypeClass(Class<? extends TypeInterface> typeClass, int vietype, Class<? extends BaseViewHolder> viewClassHodler) {
        Map<Integer, ModeViewHolder> singleMap = new HashMap<>();
        singleMap.put(0, new ModeViewHolder(vietype, viewClassHodler));
        ViewHolderManager.registerTypeClass(typeClass, singleMap);
    }


    public static int getViewType(Class<? extends TypeInterface> classData, int customKey) {
        return ViewHolderManager.getViewType(classData, customKey);
    }

    public static BaseViewHolder getViewHolder(int viewType, View itemView) {
        return ViewHolderManager.getViewHolder( viewType, itemView);
    }

}
