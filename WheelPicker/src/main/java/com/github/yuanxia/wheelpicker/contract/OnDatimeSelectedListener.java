
package com.github.yuanxia.wheelpicker.contract;

/**
* Description :   日期时间选择接口
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public interface OnDatimeSelectedListener {

    /**
     * 日期时间选择回调
     *
     * @param year   年
     * @param month  月
     * @param day    日
     * @param hour   时
     * @param minute 分
     * @param second 秒
     */
    void onDatimeSelected(int year, int month, int day, int hour, int minute, int second);

}
