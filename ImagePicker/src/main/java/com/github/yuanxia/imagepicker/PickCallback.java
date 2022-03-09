package com.github.yuanxia.imagepicker;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public abstract class PickCallback {

    /**
     * 用户取消回调
     */
    public void onCanceled() {

    }

    /**
     * 用户拒绝授权回调
     */
    public void onPermissionDenied(String[] permissions, String message) {

    }

    /**
     * 图片选择回调
     */
    public void onPickImage(@Nullable Uri imageUri) {

    }

    /**
     * 图片裁剪配置
     */
    public void cropConfig(ActivityBuilder builder) {
        builder.setMultiTouchEnabled(false)
                .setCropShape(CropImageView.CropShape.OVAL)
                .setRequestedSize(640, 640)
                .setAspectRatio(5, 5);
    }

    /**
     * 图片裁剪回调
     */
    public void onCropImage(@Nullable Uri imageUri) {

    }

    /**
     * 图片裁剪出错
     */
    public void onCropError(@NonNull Exception error) {

    }

}
