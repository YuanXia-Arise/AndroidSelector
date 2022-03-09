

package com.github.yuanxia.wheelpicker.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
* Description :   时间模式
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
@Retention(RetentionPolicy.SOURCE)
public @interface TimeMode {
    /**
     * 不显示
     */
    int NONE = -1;
    /**
     * 24小时制（不含秒）
     */
    int HOUR_24_NO_SECOND = 0;
    /**
     * 24小时制（包括秒）
     */
    int HOUR_24_HAS_SECOND = 1;
    /**
     * 12小时制（不含秒）
     */
    int HOUR_12_NO_SECOND = 2;
    /**
     * 12小时制（包括秒）
     */
    int HOUR_12_HAS_SECOND = 3;
}
