package com.yuntian.adapterexample.list;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.yuntian.adapterexample.base.DataBindingActivity;
import com.yuntian.adapterexample.databinding.ActivityNestListBinding;
import com.yuntian.adapterexample.R;
import com.yuntian.adapterexample.list.house.CommunityType;
import com.yuntian.adapterexample.list.house.HouseType;
import com.yuntian.adapterexample.list.house.enity.Community;
import com.yuntian.adapterexample.list.house.enity.House;
import com.yuntian.adapterexample.list.house.enity.TestData;
import com.yuntian.adapterlib.base.BaseRvAdapter;
import com.yuntian.adapterlib.base.TypeInterface;
import com.yuntian.adapterlib.listener.OnItemClickListener;
import com.yuntian.adapterlib.util.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guangleilei
 * @version 1.0 2018-03-27
 */
public class NestnestDataListActivity extends DataBindingActivity<ActivityNestListBinding> {


    private BaseRvAdapter baseRvAdapter;
    private TestData testData;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_nest_list;
    }

    @Override
    protected void initView() {

        testData=getTestData();


        RecyclerViewUtil.initRecyclerViewV(this, mViewBinding.rv, true,
                baseRvAdapter = new BaseRvAdapter(getData()) {
                });

        baseRvAdapter.setOnItemClickListener(new OnItemClickListener<TypeInterface>() {
            @Override
            public void onItemClick(View view, TypeInterface t, int truePos, int relativePos) {

                Toast.makeText(NestnestDataListActivity.this, "truePos=" + truePos + ",位置relativePos=" + relativePos, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }



    public List<TypeInterface>   getData(){
        List<Community> communityList=testData.getCommunityList();
        List<TypeInterface> typeInterfaces=new ArrayList<>();

        for (int i = 0; i < communityList.size(); i++) {
            Community community=communityList.get(i);
            List<House> houseList=community.getHouseList();
            typeInterfaces.add(new CommunityType(community));
            for (int j = 0; j < houseList.size(); j++) {
                typeInterfaces.add(new HouseType(houseList.get(j)));
            }
        }
        return  typeInterfaces;
    }

    public TestData getTestData(){
        List<Community> communityList = new ArrayList<>();
        communityList.add(new Community("武汉市江汉区" ,"嘉园小区",getHoseList("嘉园小区",4)));
        communityList.add(new Community("武汉市江汉区" ,"神秀小区",getHoseList("神秀小区",8)));
        communityList.add(new Community("武汉市江汉区" ,"灵云小区",getHoseList("灵云小区",7)));
        communityList.add(new Community("武汉市江汉区" ,"秀英小区",getHoseList("秀英小区",2)));
        TestData testData=new TestData();
        testData.setCommunityList(communityList);
        return testData;
    }

    public List<House> getHoseList(String communityName,int size) {
        List<House> houseList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            houseList.add(new House(communityName + "00" + i + "号", 100 + i + "万元"));
        }
        return  houseList;
    }

}
