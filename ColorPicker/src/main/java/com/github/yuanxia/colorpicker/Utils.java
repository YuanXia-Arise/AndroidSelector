

package com.github.yuanxia.colorpicker;

import android.graphics.Color;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import com.github.yuanxia.dialog.DialogLog;


class Utils {

    @ColorInt
    public static int reverseColor(@ColorInt int color) {
        int alpha = Color.alpha(color);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, 255 - red, 255 - green, 255 - blue);
    }

    /**
     * 转换为6位十六进制颜色代码，不含“#”
     */
    @NonNull
    public static String toHexString(@ColorInt int color, boolean includeAlpha) {
        String alpha = Integer.toHexString(Color.alpha(color));
        String red = Integer.toHexString(Color.red(color));
        String green = Integer.toHexString(Color.green(color));
        String blue = Integer.toHexString(Color.blue(color));
        if (alpha.length() == 1) {
            alpha = "0" + alpha;
        }
        if (red.length() == 1) {
            red = "0" + red;
        }
        if (green.length() == 1) {
            green = "0" + green;
        }
        if (blue.length() == 1) {
            blue = "0" + blue;
        }
        String colorString;
        if (includeAlpha) {
            colorString = alpha + red + green + blue;
            DialogLog.print(String.format("%s to color string is %s", color, colorString));
        } else {
            colorString = red + green + blue;
            DialogLog.print(String.format("%s to color string is %s%s%s%s, exclude alpha is %s", color, alpha, red, green, blue, colorString));
        }
        return colorString;
    }

}
