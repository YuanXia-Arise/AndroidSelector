

package com.github.yuanxia.wheelpicker.impl;

import com.github.yuanxia.wheelpicker.contract.DateFormatter;

/**
* Description :   简单的日期格式化
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class SimpleDateFormatter implements DateFormatter {

    @Override
    public String formatYear(int year) {
        if (year < 1000) {
            year += 1000;
        }
        return "" + year;
    }

    @Override
    public String formatMonth(int month) {
        return month < 10 ? "0" + month : "" + month;
    }

    @Override
    public String formatDay(int day) {
        return day < 10 ? "0" + day : "" + day;
    }

}
