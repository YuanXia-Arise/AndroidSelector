

package com.github.yuanxia.filepicker.sort;

import java.io.File;
import java.util.Comparator;


public class SortByName implements Comparator<File> {
    private static final boolean CASE_SENSITIVE = false;

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
                String s1 = f1.getName();
                String s2 = f2.getName();
                if (CASE_SENSITIVE) {
                    return s1.compareTo(s2);
                } else {
                    return s1.compareToIgnoreCase(s2);
                }
            }
        }
    }

}
