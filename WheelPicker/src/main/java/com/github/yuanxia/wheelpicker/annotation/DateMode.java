

package com.github.yuanxia.wheelpicker.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
* Description :   日期模式
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
@Retention(RetentionPolicy.SOURCE)
public @interface DateMode {
    /**
     * 不显示
     */
    int NONE = -1;
    /**
     * 年月日
     */
    int YEAR_MONTH_DAY = 0;
    /**
     * 年月
     */
    int YEAR_MONTH = 1;
    /**
     * 月日
     */
    int MONTH_DAY = 2;
}
