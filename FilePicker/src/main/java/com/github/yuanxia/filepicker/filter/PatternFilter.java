

package com.github.yuanxia.filepicker.filter;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;


public class PatternFilter implements FileFilter {
    private final Pattern pattern;

    public PatternFilter(@NonNull Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean accept(File pathname) {
        if (pathname == null) {
            return false;
        }
        return pattern.matcher(pathname.getName()).find();
    }

}
