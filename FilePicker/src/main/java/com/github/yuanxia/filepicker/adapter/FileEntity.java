

package com.github.yuanxia.filepicker.adapter;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.Serializable;

/**
* Description :   文件项信息
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class FileEntity implements Serializable {
    private Drawable icon;
    private String name;
    private File file;

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @NonNull
    @Override
    public String toString() {
        return "FileEntity{" +
                "name='" + name + '\'' +
                ", file='" + file + '\'' +
                '}';
    }

}
