

package com.github.yuanxia.wheelpicker;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

import com.github.yuanxia.dialog.ModalDialog;
import com.github.yuanxia.wheelpicker.contract.OnDatePickedListener;
import com.github.yuanxia.wheelpicker.widget.DateWheelLayout;

/**
* Description :   日期选择器
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
@SuppressWarnings("unused")
public class DatePicker extends ModalDialog {
    protected DateWheelLayout wheelLayout;
    private OnDatePickedListener onDatePickedListener;

    public DatePicker(@NonNull Activity activity) {
        super(activity);
    }

    public DatePicker(@NonNull Activity activity, @StyleRes int themeResId) {
        super(activity, themeResId);
    }

    @NonNull
    @Override
    protected View createBodyView() {
        wheelLayout = new DateWheelLayout(activity);
        return wheelLayout;
    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected void onOk() {
        if (onDatePickedListener != null) {
            int year = wheelLayout.getSelectedYear();
            int month = wheelLayout.getSelectedMonth();
            int day = wheelLayout.getSelectedDay();
            onDatePickedListener.onDatePicked(year, month, day);
        }
    }

    public void setOnDatePickedListener(OnDatePickedListener onDatePickedListener) {
        this.onDatePickedListener = onDatePickedListener;
    }

    public final DateWheelLayout getWheelLayout() {
        return wheelLayout;
    }

}
