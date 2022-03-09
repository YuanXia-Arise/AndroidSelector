

package com.github.yuanxia.wheelpicker.impl;

import com.github.yuanxia.wheelpicker.contract.DateFormatter;

/**
* Description :   带单位的日期格式化
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class UnitDateFormatter implements DateFormatter {

    @Override
    public String formatYear(int year) {
        return year + "年";
    }

    @Override
    public String formatMonth(int month) {
        return month + "月";
    }

    @Override
    public String formatDay(int day) {
        return day + "日";
    }

}
