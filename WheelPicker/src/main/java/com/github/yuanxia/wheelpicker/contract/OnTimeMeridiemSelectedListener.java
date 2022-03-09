

package com.github.yuanxia.wheelpicker.contract;

/**
* Description :   时间选择接口
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public interface OnTimeMeridiemSelectedListener {

    /**
     * 时间选择回调
     *
     * @param hour           时
     * @param minute         分
     * @param second         秒
     * @param isAnteMeridiem 是否上午
     */
    void onTimeSelected(int hour, int minute, int second, boolean isAnteMeridiem);

}
