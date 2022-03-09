

package com.github.yuanxia.wheelpicker.impl;

import com.github.yuanxia.wheelpicker.contract.TimeFormatter;

/**
* Description :   带单位的时间格式化
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class UnitTimeFormatter implements TimeFormatter {

    @Override
    public String formatHour(int hour) {
        return hour + "点";
    }

    @Override
    public String formatMinute(int minute) {
        return minute + "分";
    }

    @Override
    public String formatSecond(int second) {
        return second + "秒";
    }

}

