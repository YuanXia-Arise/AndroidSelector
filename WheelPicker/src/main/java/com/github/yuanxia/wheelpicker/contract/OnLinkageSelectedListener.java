

package com.github.yuanxia.wheelpicker.contract;

/**
* Description :   联动选择接口
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public interface OnLinkageSelectedListener {

    /**
     * 联动选择回调
     *
     * @param first  选中项的第一级条目内容
     * @param second 选中项的第二级条目内容
     * @param third  选中项的第三级条目内容
     */
    void onLinkageSelected(Object first, Object second, Object third);

}
