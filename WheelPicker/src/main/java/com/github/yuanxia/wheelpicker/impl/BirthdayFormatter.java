

package com.github.yuanxia.wheelpicker.impl;

/**
* Description :   生日格式化
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class BirthdayFormatter extends SimpleDateFormatter {

    @Override
    public String formatYear(int year) {
        return super.formatYear(year) + "年";
    }

    @Override
    public String formatMonth(int month) {
        return super.formatMonth(month) + "月";
    }

    @Override
    public String formatDay(int day) {
        return super.formatDay(day) + "日";
    }

}
