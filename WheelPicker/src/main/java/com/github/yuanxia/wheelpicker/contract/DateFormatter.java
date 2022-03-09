

package com.github.yuanxia.wheelpicker.contract;

/**
* Description :   日期显示文本格式化接口
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public interface DateFormatter {

    /**
     * 格式化年份
     *
     * @param year 年份数字
     * @return 格式化后最终显示的年份字符串
     */
    String formatYear(int year);

    /**
     * 格式化月份
     *
     * @param month 月份数字
     * @return 格式化后最终显示的月份字符串
     */
    String formatMonth(int month);

    /**
     * 格式化日子
     *
     * @param day 日子数字
     * @return 格式化后最终显示的日子字符串
     */
    String formatDay(int day);

}

