

package com.github.yuanxia.filepicker.contract;

import androidx.annotation.NonNull;

import java.io.File;


public interface OnFilePickedListener {

    void onFilePicked(@NonNull File file);

}
