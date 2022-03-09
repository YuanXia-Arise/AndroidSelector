

package com.github.yuanxia.colorpicker;

import androidx.annotation.ColorInt;


public interface OnColorChangedListener {

    void onColorChanged(ColorGradientView gradientView, @ColorInt int color);

}
