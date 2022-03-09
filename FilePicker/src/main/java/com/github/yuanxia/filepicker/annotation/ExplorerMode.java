

package com.github.yuanxia.filepicker.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.SOURCE)
public @interface ExplorerMode {
    int DIRECTORY = 0;
    int FILE = 1;
}
