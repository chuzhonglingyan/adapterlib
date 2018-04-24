package com.yuntian.adapterexample.list.house;


import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.house.enity.Community;
import com.yuntian.adapterlib.imp.TypeInterfaceImp;

/**
 * description  .
 * Created by ChuYingYan on 2018/4/7.
 */
public class CommunityType extends TypeInterfaceImp<Community> {


    public CommunityType() {
    }

    public CommunityType(Community community) {
        super(community);
    }

    @Override
    public int getViewType() {
        return R.layout.item_commuty;
    }
}
