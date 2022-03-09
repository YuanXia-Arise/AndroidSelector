

package com.github.yuanxia.filepicker.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface FileSort {
    int BY_NAME_ASC = 0;
    int BY_NAME_DESC = 1;
    int BY_TIME_ASC = 2;
    int BY_TIME_DESC = 3;
    int BY_SIZE_ASC = 4;
    int BY_SIZE_DESC = 5;
    int BY_EXTENSION_ASC = 6;
    int BY_EXTENSION_DESC = 7;
}
