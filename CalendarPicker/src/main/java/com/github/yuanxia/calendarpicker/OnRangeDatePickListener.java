

package com.github.yuanxia.calendarpicker;

import androidx.annotation.NonNull;

import java.util.Date;


public interface OnRangeDatePickListener {

    void onRangeDatePicked(@NonNull Date startDate, @NonNull Date endDate);

}
