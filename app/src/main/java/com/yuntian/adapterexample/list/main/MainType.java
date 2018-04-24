package com.yuntian.adapterexample.list.main;


import com.yuntian.adapterexample.util.ViewHolderManagerUtil;
import com.yuntian.adapterlib.imp.TypeInterfaceImp;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class MainType extends TypeInterfaceImp<MainBean> {


    public MainType(MainBean mainBean) {
        super(mainBean);
    }


    @Override
    public int getViewType() {
        return ViewHolderManagerUtil.getViewType(this.getClass(),type);
    }

}
