

package com.github.yuanxia.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.yuanxia.wheelpicker.R;
import com.github.yuanxia.wheelpicker.contract.OnNumberSelectedListener;
import com.github.yuanxia.wheelpicker.contract.OnOptionSelectedListener;
import com.github.yuanxia.wheelview.widget.WheelView;

import java.util.ArrayList;
import java.util.List;

/**
* Description :   数字滚轮控件
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class NumberWheelLayout extends OptionWheelLayout {
    private OnNumberSelectedListener onNumberSelectedListener;

    public NumberWheelLayout(Context context) {
        super(context);
    }

    public NumberWheelLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NumberWheelLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NumberWheelLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onAttributeSet(@NonNull Context context, @Nullable AttributeSet attrs) {
        super.onAttributeSet(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NumberWheelLayout);
        float minNumber = typedArray.getFloat(R.styleable.NumberWheelLayout_wheel_minNumber, 0);
        float maxNumber = typedArray.getFloat(R.styleable.NumberWheelLayout_wheel_maxNumber, 10);
        float stepNumber = typedArray.getFloat(R.styleable.NumberWheelLayout_wheel_stepNumber, 1);
        boolean isDecimal = typedArray.getBoolean(R.styleable.NumberWheelLayout_wheel_isDecimal, false);
        typedArray.recycle();
        if (isDecimal) {
            setRange(minNumber, maxNumber, stepNumber);
        } else {
            setRange((int) minNumber, (int) maxNumber, (int) stepNumber);
        }
    }

    @Override
    public void onWheelSelected(WheelView view, int position) {
        super.onWheelSelected(view, position);
        if (onNumberSelectedListener != null) {
            Object item = getWheelView().getItem(position);
            onNumberSelectedListener.onNumberSelected(position, (Number) item);
        }
    }

    /**
     * @deprecated 使用 {@link #setRange} 代替
     */
    @Deprecated
    @Override
    public void setData(List<?> data) {
        throw new UnsupportedOperationException("Use setRange instead");
    }

    /**
     * @deprecated 使用 {@link #setOnNumberSelectedListener} 代替
     */
    @Deprecated
    @Override
    public void setOnOptionSelectedListener(OnOptionSelectedListener onOptionSelectedListener) {
        throw new UnsupportedOperationException("Use setOnNumberSelectedListener instead");
    }

    public void setOnNumberSelectedListener(OnNumberSelectedListener onNumberSelectedListener) {
        this.onNumberSelectedListener = onNumberSelectedListener;
    }

    public void setRange(int min, int max, int step) {
        int minValue = Math.min(min, max);
        int maxValue = Math.max(min, max);
        // 指定初始容量，避免OutOfMemory
        int capacity = (maxValue - minValue) / step;
        List<Integer> data = new ArrayList<>(capacity);
        for (int i = minValue; i <= maxValue; i = i + step) {
            data.add(i);
        }
        super.setData(data);
    }

    public void setRange(float min, float max, float step) {
        float minValue = Math.min(min, max);
        float maxValue = Math.max(min, max);
        // 指定初始容量，避免OutOfMemory
        int capacity = (int) ((maxValue - minValue) / step);
        List<Float> data = new ArrayList<>(capacity);
        for (float i = minValue; i <= maxValue; i = i + step) {
            data.add(i);
        }
        super.setData(data);
    }

}
