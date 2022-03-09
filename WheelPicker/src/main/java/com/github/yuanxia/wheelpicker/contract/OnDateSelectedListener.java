

package com.github.yuanxia.wheelpicker.contract;

/**
* Description :   日期选择接口
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public interface OnDateSelectedListener {

    /**
     * 已选择的日期
     *
     * @param year  年
     * @param month 月
     * @param day   日
     */
    void onDateSelected(int year, int month, int day);

}
