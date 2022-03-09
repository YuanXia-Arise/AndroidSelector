

package com.github.yuanxia.filepicker.filter;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;


public class SimpleFilter implements FileFilter {
    private final boolean isOnlyDir;
    private final String[] allowExtensions;

    public SimpleFilter(boolean isOnlyDir, @Nullable String[] allowExtensions) {
        this.isOnlyDir = isOnlyDir;
        this.allowExtensions = allowExtensions;
    }

    @Override
    public boolean accept(File pathname) {
        if (pathname == null) {
            return false;
        }
        if (isOnlyDir && pathname.isFile()) {
            return false;
        }
        if (allowExtensions == null || allowExtensions.length == 0) {
            return true;
        }
        //返回当前目录所有以某些扩展名结尾的文件
        String extension = getExtension(pathname.getPath());
        return Arrays.toString(allowExtensions).contains(extension);
    }

    private String getExtension(String path) {
        if (path == null) {
            return "";
        }
        int slashPos = path.lastIndexOf(File.separator);
        if (slashPos != -1) {
            path = path.substring(slashPos);
        }
        int dotPos = path.lastIndexOf('.');
        if (0 <= dotPos) {
            return path.substring(dotPos + 1);
        } else {
            return "";
        }
    }

}
