package com.yuntian.adapterexample.list.typemode;

import com.yuntian.adapterexample.R;
import com.yuntian.adapterlib.base.TypeInterface;


/**
 * @author guangleilei
 * @version 1.0 2018-03-22
 */
public class TestType02 implements TypeInterface {

    private String title;
    private String content;

    public TestType02() {
    }

    public TestType02(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getViewType() {
        return R.layout.item_test02;
    }


}
