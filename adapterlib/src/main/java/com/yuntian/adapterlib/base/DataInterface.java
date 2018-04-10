package com.yuntian.adapterlib.base;

import java.util.List;

/**
 * @author guangleilei
 * @version 1.0 2018-03-27
 */
public interface DataInterface<T> {

    void add(T item);

    void remove(int position);

    void removes(int startPosition, int endPosition) ;

    void update(int index, T item);


    List<T> getData();

    void adds(List<T> items);


}
