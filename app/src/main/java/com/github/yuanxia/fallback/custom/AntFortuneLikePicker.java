

package com.github.yuanxia.fallback.custom;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.yuanxia.dialog.DialogConfig;
import com.github.yuanxia.dialog.DialogStyle;
import com.github.yuanxia.fallback.R;
import com.github.yuanxia.wheelpicker.LinkagePicker;

public class AntFortuneLikePicker extends LinkagePicker {
    private int lastDialogStyle;

    public AntFortuneLikePicker(@NonNull Activity activity) {
        super(activity, R.style.DialogTheme_Sheet);
    }

    @Override
    public void onInit(@Nullable Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        lastDialogStyle = DialogConfig.getDialogStyle();
        DialogConfig.setDialogStyle(DialogStyle.Default);
        setWidth(activity.getResources().getDisplayMetrics().widthPixels);
        setGravity(Gravity.BOTTOM);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        DialogConfig.setDialogStyle(lastDialogStyle);
    }

    @Override
    protected void initData() {
        super.initData();
        setBackgroundColor(0xFFFFFFFF);
        cancelView.setText("取消");
        cancelView.setTextSize(16);
        cancelView.setTextColor(0xFF0081FF);
        okView.setTextColor(0xFF0081FF);
        okView.setText("确定");
        okView.setTextSize(16);
        titleView.setTextColor(0xFF333333);
        titleView.setText("定投周期");
        titleView.setTextSize(16);
        wheelLayout.setData(new AntFortuneLikeProvider());
        wheelLayout.setAtmosphericEnabled(true);
        wheelLayout.setVisibleItemCount(7);
        wheelLayout.setCyclicEnabled(false);
        wheelLayout.setIndicatorEnabled(true);
        wheelLayout.setIndicatorColor(0xFFDDDDDD);
        wheelLayout.setIndicatorSize((int) (contentView.getResources().getDisplayMetrics().density * 1));
        wheelLayout.setTextColor(0xFF999999);
        wheelLayout.setSelectedTextColor(0xFF333333);
        wheelLayout.setCurtainEnabled(false);
        wheelLayout.setCurvedEnabled(false);
    }

}
