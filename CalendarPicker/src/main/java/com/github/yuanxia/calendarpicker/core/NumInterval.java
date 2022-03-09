

package com.github.yuanxia.calendarpicker.core;

/**
 * Created by peng on 2017/8/4.
 */
public class NumInterval extends Interval<Integer> {

    public NumInterval() {
        left(-1);
        lBound(-1);
        right(-1);
        rBound(-1);
    }

    public boolean contain(int index) {
        return index >= left() && index <= right();
    }
}