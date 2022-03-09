

package com.github.yuanxia.dialog;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
* Description :   弹窗样式枚举
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
@Retention(RetentionPolicy.SOURCE)
public @interface DialogStyle {
    int Default = 0;
    int One = 1;
    int Two = 2;
    int Three = 3;
}
