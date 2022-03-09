

package com.github.yuanxia.wheelpicker.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
* Description :   地址模式
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
@Retention(RetentionPolicy.SOURCE)
public @interface AddressMode {
    /**
     * 省级、市级、县级
     */
    int PROVINCE_CITY_COUNTY = 0;
    /**
     * 省级、市级
     */
    int PROVINCE_CITY = 1;
    /**
     * 市级、县级
     */
    int CITY_COUNTY = 2;
}
