

package com.github.yuanxia.wheelpicker.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.yuanxia.wheelpicker.impl.CarPlateProvider;


public class CarPlateWheelLayout extends LinkageWheelLayout {
    private CarPlateProvider provider;

    public CarPlateWheelLayout(Context context) {
        super(context);
    }

    public CarPlateWheelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CarPlateWheelLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CarPlateWheelLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onInit(@NonNull Context context) {
        super.onInit(context);
        provider = new CarPlateProvider();
        setData(provider);
    }

    @Override
    protected void onAttributeSet(@NonNull Context context, @Nullable AttributeSet attrs) {
        super.onAttributeSet(context, attrs);
        setFirstVisible(provider.firstLevelVisible());
        setThirdVisible(provider.thirdLevelVisible());
    }

}
