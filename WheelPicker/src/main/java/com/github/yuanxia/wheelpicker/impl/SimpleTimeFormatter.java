

package com.github.yuanxia.wheelpicker.impl;

import com.github.yuanxia.wheelpicker.contract.TimeFormatter;
import com.github.yuanxia.wheelpicker.widget.TimeWheelLayout;

/**
* Description :   简单的时间格式化
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class SimpleTimeFormatter implements TimeFormatter {
    private final TimeWheelLayout wheelLayout;

    public SimpleTimeFormatter(TimeWheelLayout wheelLayout) {
        this.wheelLayout = wheelLayout;
    }

    @Override
    public String formatHour(int hour) {
        if (wheelLayout.isHour12Mode()) {
            if (hour == 0) {
                hour = 24;
            }
            if (hour > 12) {
                hour = hour - 12;
            }
        }
        return hour < 10 ? "0" + hour : "" + hour;
    }

    @Override
    public String formatMinute(int minute) {
        return minute < 10 ? "0" + minute : "" + minute;
    }

    @Override
    public String formatSecond(int second) {
        return second < 10 ? "0" + second : "" + second;
    }

}
