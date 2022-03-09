

package com.github.yuanxia.dialog;

import android.graphics.Color;

import androidx.annotation.ColorInt;

import java.io.Serializable;


public class DialogColor implements Serializable {
    private int contentBackgroundColor = Color.WHITE;
    private int topLineColor = 0xFFDDDDDD;
    private int titleTextColor = 0xFF666666;
    private int cancelTextColor = 0xFF333333;
    private int okTextColor = 0xFF333333;
    private int cancelEllipseColor = 0xFFF4F4F4;
    private int okEllipseColor = 0xFF0081FF;

    public DialogColor contentBackgroundColor(@ColorInt int color) {
        this.contentBackgroundColor = color;
        return this;
    }

    @ColorInt
    public int contentBackgroundColor() {
        return contentBackgroundColor;
    }

    public DialogColor topLineColor(@ColorInt int color) {
        this.topLineColor = color;
        return this;
    }

    @ColorInt
    public int topLineColor() {
        return topLineColor;
    }

    public DialogColor titleTextColor(@ColorInt int color) {
        this.titleTextColor = color;
        return this;
    }

    @ColorInt
    public int titleTextColor() {
        return titleTextColor;
    }

    public DialogColor cancelTextColor(@ColorInt int color) {
        this.cancelTextColor = color;
        return this;
    }

    @ColorInt
    public int cancelTextColor() {
        return cancelTextColor;
    }

    public DialogColor okTextColor(@ColorInt int color) {
        this.okTextColor = color;
        return this;
    }

    @ColorInt
    public int okTextColor() {
        return okTextColor;
    }

    public DialogColor cancelEllipseColor(@ColorInt int color) {
        this.cancelEllipseColor = color;
        return this;
    }

    @ColorInt
    public int cancelEllipseColor() {
        return cancelEllipseColor;
    }

    public DialogColor okEllipseColor(@ColorInt int color) {
        this.okEllipseColor = color;
        return this;
    }

    @ColorInt
    public int okEllipseColor() {
        return okEllipseColor;
    }

}
