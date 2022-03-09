

package com.github.yuanxia.wheelview.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
* Description :   滚轮条目文本对齐方式
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
@Retention(RetentionPolicy.SOURCE)
public @interface ItemTextAlign {
    int CENTER = 0;
    int LEFT = 1;
    int RIGHT = 2;
}
