package com.yuntian.adapterlib.imp;

import com.yuntian.adapterlib.base.TypeInterface;

/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public abstract class TypeInterfaceImp<K> implements TypeInterface {


    protected int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private K k;

    public TypeInterfaceImp() {
    }

    public TypeInterfaceImp(K k) {
        this.k = k;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }
}
