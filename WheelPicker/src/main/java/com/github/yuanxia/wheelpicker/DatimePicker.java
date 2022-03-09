

package com.github.yuanxia.wheelpicker;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

import com.github.yuanxia.dialog.ModalDialog;
import com.github.yuanxia.wheelpicker.contract.OnDatimePickedListener;
import com.github.yuanxia.wheelpicker.widget.DatimeWheelLayout;

/**
* Description :   日期时间选择器
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
@SuppressWarnings({"unused", "WeakerAccess"})
public class DatimePicker extends ModalDialog {
    protected DatimeWheelLayout wheelLayout;
    private OnDatimePickedListener onDatimePickedListener;

    public DatimePicker(@NonNull Activity activity) {
        super(activity);
    }

    public DatimePicker(@NonNull Activity activity, @StyleRes int themeResId) {
        super(activity, themeResId);
    }

    @NonNull
    @Override
    protected View createBodyView() {
        wheelLayout = new DatimeWheelLayout(activity);
        return wheelLayout;
    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected void onOk() {
        if (onDatimePickedListener != null) {
            int year = wheelLayout.getSelectedYear();
            int month = wheelLayout.getSelectedMonth();
            int day = wheelLayout.getSelectedDay();
            int hour = wheelLayout.getSelectedHour();
            int minute = wheelLayout.getSelectedMinute();
            int second = wheelLayout.getSelectedSecond();
            onDatimePickedListener.onDatimePicked(year, month, day, hour, minute, second);
        }
    }

    public void setOnDatimePickedListener(OnDatimePickedListener onDatimePickedListener) {
        this.onDatimePickedListener = onDatimePickedListener;
    }

    public final DatimeWheelLayout getWheelLayout() {
        return wheelLayout;
    }

}
