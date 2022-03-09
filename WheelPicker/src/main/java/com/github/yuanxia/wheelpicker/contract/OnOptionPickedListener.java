

package com.github.yuanxia.wheelpicker.contract;

/**
* Description :   单项条目选择接口
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public interface OnOptionPickedListener {

    /**
     * 单项条目选择回调
     *
     * @param position 选中项的索引
     * @param item     选中项的内容
     */
    void onOptionPicked(int position, Object item);

}

