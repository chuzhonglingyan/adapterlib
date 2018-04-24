package com.yuntian.adapterexample.list.house;


import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.house.enity.House;
import com.yuntian.adapterlib.imp.TypeInterfaceImp;

/**
 * description  .
 * Created by ChuYingYan on 2018/4/7.
 */
public class HouseType extends TypeInterfaceImp<House> {


    public HouseType() {
    }

    public HouseType(House house) {
        super(house);
    }

    @Override
    public int getViewType() {
        return R.layout.item_house;
    }
}
