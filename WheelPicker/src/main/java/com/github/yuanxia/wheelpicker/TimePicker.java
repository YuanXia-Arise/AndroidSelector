

package com.github.yuanxia.wheelpicker;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

import com.github.yuanxia.dialog.ModalDialog;
import com.github.yuanxia.wheelpicker.contract.OnTimeMeridiemPickedListener;
import com.github.yuanxia.wheelpicker.contract.OnTimePickedListener;
import com.github.yuanxia.wheelpicker.widget.TimeWheelLayout;

/**
* Description :   时间选择器
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
@SuppressWarnings("unused")
public class TimePicker extends ModalDialog {
    protected TimeWheelLayout wheelLayout;
    private OnTimePickedListener onTimePickedListener;
    private OnTimeMeridiemPickedListener onTimeMeridiemPickedListener;

    public TimePicker(@NonNull Activity activity) {
        super(activity);
    }

    public TimePicker(@NonNull Activity activity, @StyleRes int themeResId) {
        super(activity, themeResId);
    }

    @NonNull
    @Override
    protected View createBodyView() {
        wheelLayout = new TimeWheelLayout(activity);
        return wheelLayout;
    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected void onOk() {
        int hour = wheelLayout.getSelectedHour();
        int minute = wheelLayout.getSelectedMinute();
        int second = wheelLayout.getSelectedSecond();
        if (onTimePickedListener != null) {
            onTimePickedListener.onTimePicked(hour, minute, second);
        }
        if (onTimeMeridiemPickedListener != null) {
            onTimeMeridiemPickedListener.onTimePicked(hour, minute, second, wheelLayout.isAnteMeridiem());
        }
    }

    public void setOnTimePickedListener(OnTimePickedListener onTimePickedListener) {
        this.onTimePickedListener = onTimePickedListener;
    }

    public void setOnTimeMeridiemPickedListener(OnTimeMeridiemPickedListener onTimeMeridiemPickedListener) {
        this.onTimeMeridiemPickedListener = onTimeMeridiemPickedListener;
    }

    public final TimeWheelLayout getWheelLayout() {
        return wheelLayout;
    }

}
