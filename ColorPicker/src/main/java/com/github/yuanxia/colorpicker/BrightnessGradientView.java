

package com.github.yuanxia.colorpicker;

import android.content.Context;
import android.util.AttributeSet;


public class BrightnessGradientView extends ColorGradientView {

    public BrightnessGradientView(Context context) {
        super(context);
        asBrightnessGradient();
    }

    public BrightnessGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        asBrightnessGradient();
    }

    public BrightnessGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        asBrightnessGradient();
    }

}
