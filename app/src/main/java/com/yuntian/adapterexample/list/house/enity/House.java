package com.yuntian.adapterexample.list.house.enity;

/**
 * description  .
 * Created by ChuYingYan on 2018/4/7.
 */
public class House {



    private String address;

    private String price;

    public House(String address, String price) {
        this.address = address;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
