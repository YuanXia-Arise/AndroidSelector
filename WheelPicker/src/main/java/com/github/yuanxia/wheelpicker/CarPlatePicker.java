

package com.github.yuanxia.wheelpicker;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

import com.github.yuanxia.wheelpicker.contract.LinkageProvider;
import com.github.yuanxia.wheelpicker.contract.OnCarPlatePickedListener;
import com.github.yuanxia.wheelpicker.contract.OnLinkagePickedListener;
import com.github.yuanxia.wheelpicker.widget.CarPlateWheelLayout;

/**
* Description :   中国大陆车牌号滚轮选择
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
@SuppressWarnings({"unused"})
public class CarPlatePicker extends LinkagePicker {
    private OnCarPlatePickedListener onCarPlatePickedListener;

    public CarPlatePicker(@NonNull Activity activity) {
        super(activity);
    }

    public CarPlatePicker(@NonNull Activity activity, @StyleRes int themeResId) {
        super(activity, themeResId);
    }

    @Deprecated
    @Override
    public void setData(@NonNull LinkageProvider data) {
        throw new UnsupportedOperationException("Data already preset");
    }

    @Deprecated
    @Override
    public void setOnLinkagePickedListener(OnLinkagePickedListener onLinkagePickedListener) {
        throw new UnsupportedOperationException("Use setOnCarPlatePickedListener instead");
    }

    @NonNull
    @Override
    protected View createBodyView() {
        wheelLayout = new CarPlateWheelLayout(activity);
        return wheelLayout;
    }

    @Override
    protected void onOk() {
        if (onCarPlatePickedListener != null) {
            String province = wheelLayout.getFirstWheelView().getCurrentItem();
            String letter = wheelLayout.getSecondWheelView().getCurrentItem();
            onCarPlatePickedListener.onCarNumberPicked(province, letter);
        }
    }


    public void setOnCarPlatePickedListener(OnCarPlatePickedListener onCarPlatePickedListener) {
        this.onCarPlatePickedListener = onCarPlatePickedListener;
    }

}
