

package com.github.yuanxia.wheelpicker.impl;

import androidx.annotation.NonNull;

import com.github.yuanxia.wheelview.contract.WheelFormatter;


public class SimpleWheelFormatter implements WheelFormatter {

    @Override
    public String formatItem(@NonNull Object item) {
        return item.toString();
    }

}
