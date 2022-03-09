

package com.github.yuanxia.wheelview.contract;

import androidx.annotation.NonNull;

/**
* Description :   滚轮条目显示文本格式化接口
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public interface WheelFormatter {

    /**
     * 格式化滚轮条目显示文本
     *
     * @param item 滚轮条目的内容
     * @return 格式化后最终显示的文本
     */
    String formatItem(@NonNull Object item);

}
