

package com.github.yuanxia.calendarpicker.core;

import androidx.annotation.NonNull;

import java.util.Date;

/**
 * Created by peng on 2017/8/4.
 */
public interface OnDateSelectedListener {

    void onSingleSelected(@NonNull Date date);

    void onRangeSelected(@NonNull Date start, @NonNull Date end);

}
