

package com.github.yuanxia.colorpicker;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

import com.github.yuanxia.dialog.DialogLog;
import com.github.yuanxia.dialog.ModalDialog;

import java.util.Locale;


@SuppressWarnings("unused")
public class ColorPicker extends ModalDialog implements OnColorChangedListener {
    protected ColorGradientView colorGradientView;
    protected BrightnessGradientView brightnessGradientView;
    private boolean initialized = false;
    private int initColor = Color.YELLOW;
    private OnColorPickedListener onColorPickedListener;

    public ColorPicker(@NonNull Activity activity) {
        super(activity);
    }

    public ColorPicker(@NonNull Activity activity, @StyleRes int themeResId) {
        super(activity, themeResId);
    }

    @NonNull
    @Override
    protected View createBodyView() {
        return View.inflate(activity, R.layout.color_picker_content, null);
    }

    @CallSuper
    @Override
    protected void initView() {
        super.initView();
        colorGradientView = contentView.findViewById(R.id.color_picker_panel);
        brightnessGradientView = contentView.findViewById(R.id.color_picker_bright);
    }

    @CallSuper
    @Override
    protected void initData() {
        super.initData();
        initialized = true;
        if (cancelView != null) {
            cancelView.setOnClickListener(this);
        }
        if (okView != null) {
            okView.setOnClickListener(this);
        }
        colorGradientView.setOnColorChangedListener(this);
        brightnessGradientView.setOnColorChangedListener(this);
        colorGradientView.setBrightnessGradientView(brightnessGradientView);
        //将触发onColorChanged，故必须先待其他控件初始化完成后才能调用
        colorGradientView.setColor(initColor);
    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected void onOk() {
        if (onColorPickedListener != null) {
            onColorPickedListener.onColorPicked(getCurrentColor());
        }
    }

    @Override
    public void onColorChanged(ColorGradientView gradientView, @ColorInt int color) {
        updateCurrentColor(color);
    }

    private void updateCurrentColor(@ColorInt int color) {
        titleView.setText(Utils.toHexString(color, false).toUpperCase(Locale.PRC));
        titleView.setTextColor(color);
        titleView.setShadowLayer(10, 5, 5, Utils.reverseColor(color));
    }

    /**
     * 设置初始默认颜色
     *
     * @param initColor 颜色值，如：0xFFFF00FF
     */
    public void setInitColor(@ColorInt int initColor) {
        this.initColor = initColor;
        if (initialized) {
            colorGradientView.setColor(initColor);
        }
    }

    public void setOnColorPickListener(OnColorPickedListener onColorPickedListener) {
        this.onColorPickedListener = onColorPickedListener;
    }

    @ColorInt
    public final int getCurrentColor() {
        try {
            return Color.parseColor("#" + titleView.getText());
        } catch (Exception e) {
            DialogLog.print(e);
            return initColor;
        }
    }

    public final TextView getHexView() {
        return getTitleView();
    }

    public final ColorGradientView getColorGradientView() {
        return colorGradientView;
    }

    public final BrightnessGradientView getBrightnessGradientView() {
        return brightnessGradientView;
    }

}
