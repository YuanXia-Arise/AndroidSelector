

package com.github.yuanxia.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.yuanxia.wheelpicker.R;
import com.github.yuanxia.wheelpicker.contract.OnOptionSelectedListener;
import com.github.yuanxia.wheelview.widget.WheelView;

import java.util.Collections;
import java.util.List;

/**
* Description :   单项滚轮控件
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
@SuppressWarnings("unused")
public class OptionWheelLayout extends BaseWheelLayout {
    private WheelView wheelView;
    private TextView labelView;
    private OnOptionSelectedListener onOptionSelectedListener;

    public OptionWheelLayout(Context context) {
        super(context);
    }

    public OptionWheelLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OptionWheelLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public OptionWheelLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int provideLayoutRes() {
        return R.layout.wheel_picker_option;
    }

    @CallSuper
    @Override
    protected List<WheelView> provideWheelViews() {
        return Collections.singletonList(wheelView);
    }

    @CallSuper
    @Override
    protected void onInit(@NonNull Context context) {
        wheelView = findViewById(R.id.wheel_picker_option_wheel);
        labelView = findViewById(R.id.wheel_picker_option_label);
    }

    @CallSuper
    @Override
    protected void onAttributeSet(@NonNull Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OptionWheelLayout);
        labelView.setText(typedArray.getString(R.styleable.OptionWheelLayout_wheel_label));
        typedArray.recycle();
    }

    @CallSuper
    @Override
    public void onWheelSelected(WheelView view, int position) {
        if (onOptionSelectedListener != null) {
            onOptionSelectedListener.onOptionSelected(position, wheelView.getItem(position));
        }
    }

    public void setData(List<?> data) {
        wheelView.setData(data);
    }

    public void setDefaultValue(Object value) {
        wheelView.setDefaultValue(value);
    }

    public void setDefaultPosition(int position) {
        wheelView.setDefaultPosition(position);
    }

    public void setOnOptionSelectedListener(OnOptionSelectedListener onOptionSelectedListener) {
        this.onOptionSelectedListener = onOptionSelectedListener;
    }

    public final WheelView getWheelView() {
        return wheelView;
    }

    public final TextView getLabelView() {
        return labelView;
    }

}
