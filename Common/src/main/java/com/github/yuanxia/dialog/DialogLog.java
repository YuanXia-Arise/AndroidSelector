

package com.github.yuanxia.dialog;

import android.util.Log;

import androidx.annotation.NonNull;

/**
* Description :   调试日志工具类
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public final class DialogLog {
    private static final String TAG = "AndroidPicker";
    private static boolean enable = false;

    private DialogLog() {
        super();
    }

    /**
     * 启用调试日志
     */
    public static void enable() {
        enable = true;
    }

    /**
     * 打印调试日志
     *
     * @param log 日志信息
     */
    public static void print(@NonNull Object log) {
        if (!enable) {
            return;
        }
        Log.d(TAG, log.toString());
    }

}
