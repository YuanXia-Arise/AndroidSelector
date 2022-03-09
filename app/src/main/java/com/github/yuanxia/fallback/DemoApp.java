

package com.github.yuanxia.fallback;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.github.yuanxia.dialog.DialogColor;
import com.github.yuanxia.dialog.DialogConfig;
import com.github.yuanxia.dialog.DialogLog;
import com.github.yuanxia.dialog.DialogStyle;

import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;

/**
* Description :   应用全局上下文
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class DemoApp extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DialogLog.enable();
        DialogConfig.setDialogStyle(DialogStyle.Default);
        DialogConfig.setDialogColor(new DialogColor()
                .cancelTextColor(0xFF999999)
                .okTextColor(0xFF0099CC));
        initXCrash(this);
    }

    private static void initXCrash(Application application) {
        try {
            // debugRuntimeOnly "com.iqiyi.xcrash:xcrash-android-lib:x.x.x"，调试运行才集成xCrash
            // compileOnly "com.iqiyi.xcrash:xcrash-android-lib:x.x.x"，编译模式才集成xCrash
            Class.forName("xcrash.XCrash");
            System.out.println("xCrash SDK dependency was found");
            File logDir = application.getExternalFilesDir("xcrash");
            if (logDir == null) {
                logDir = new File(application.getFilesDir(), "xcrash");
                //noinspection ResultOfMethodCallIgnored
                logDir.mkdir();
            }
            System.out.println("xCrash SDK init start: logDir=" + logDir);
            xcrash.ICrashCallback callback = new xcrash.ICrashCallback() {
                @Override
                public void onCrash(String logPath, String emergency) {
                    System.out.println("xCrash SDK: logPath=" + logPath + ", emergency=" + emergency);
                    if (logPath == null || emergency == null) {
                        return;
                    }
                    FileWriter writer = null;
                    try {
                        File file = new File(xcrash.XCrash.getLogDir(), "crash.json");
                        //noinspection ResultOfMethodCallIgnored
                        file.createNewFile();
                        writer = new FileWriter(file, false);
                        writer.write(new JSONObject(xcrash.TombstoneParser.parse(logPath, emergency)).toString());
                    } catch (Exception e) {
                        System.err.println("xCrash SDK failed to export the crash to a JSON file: " + e);
                    } finally {
                        if (writer != null) {
                            try {
                                writer.close();
                            } catch (Exception ignored) {
                            }
                        }
                    }
                }
            };
            xcrash.XCrash.init(application, new xcrash.XCrash.InitParameters()
                    .setJavaRethrow(true)
                    .setJavaLogCountMax(10)
                    .setJavaDumpAllThreadsWhiteList(new String[]{"^main$", "^Binder:.*", ".*Finalizer.*"})
                    .setJavaDumpAllThreadsCountMax(10)
                    .setJavaCallback(callback)
                    .setNativeRethrow(true)
                    .setNativeLogCountMax(10)
                    .setNativeDumpAllThreadsWhiteList(new String[]{"^xcrash\\.sample$", "^Signal Catcher$", "^Jit thread pool$", ".*(R|r)ender.*", ".*Chrome.*"})
                    .setNativeDumpAllThreadsCountMax(10)
                    .setNativeCallback(callback)
                    .setAnrRethrow(true)
                    .setAnrLogCountMax(10)
                    .setAnrCallback(callback)
                    .setPlaceholderCountMax(3)
                    .setPlaceholderSizeKb(512)
                    .setLogDir(logDir.getAbsolutePath())
                    .setLogFileMaintainDelayMs(1000));
            System.out.println("xCrash SDK init end");
        } catch (Exception e) {
            System.out.println("xCrash SDK dependency not found");
        }
    }

}
