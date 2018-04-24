package com.yuntian.adapterexample.list.house.enity;

import java.util.List;

/**
 * description  .
 * Created by ChuYingYan on 2018/4/7.
 */
public class Community {


    private String address;
    private String name;


    private List<House> houseList;


    public Community(String address, String name, List<House> houseList) {
        this.address = address;
        this.name = name;
        this.houseList = houseList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<House> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<House> houseList) {
        this.houseList = houseList;
    }
}
