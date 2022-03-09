

package com.github.yuanxia.filepicker.sort;

import java.io.File;
import java.util.Comparator;


public class SortByTime implements Comparator<File> {

    @Override
    public int compare(File f1, File f2) {
        if (f1 == null || f2 == null) {
            if (f1 == null) {
                return -1;
            } else {
                return 1;
            }
        } else {
            if (f1.isDirectory() && f2.isFile()) {
                return -1;
            } else if (f1.isFile() && f2.isDirectory()) {
                return 1;
            } else {
                if (f1.lastModified() > f2.lastModified()) {
                    return -1;
                } else if (f1.lastModified() < f2.lastModified()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

}
