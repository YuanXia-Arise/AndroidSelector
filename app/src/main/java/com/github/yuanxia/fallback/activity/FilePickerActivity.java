

package com.github.yuanxia.fallback.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.yuanxia.fallback.R;
import com.github.yuanxia.filepicker.FileExplorer;
import com.github.yuanxia.filepicker.FilePicker;
import com.github.yuanxia.filepicker.annotation.ExplorerMode;
import com.github.yuanxia.filepicker.contract.OnFilePickedListener;

import java.io.File;

/**
* Description :   文件/目录选择器
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class FilePickerActivity extends BackAbleActivity implements OnFilePickedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_file);
        FileExplorer fileExplorer = findViewById(R.id.file_picker_explorer);
        fileExplorer.setInitDir(ExplorerMode.FILE, getExternalFilesDir(null));
    }

    @Override
    public void onFilePicked(@NonNull File file) {
        Toast.makeText(getApplicationContext(), file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
    }

    public void onFilePick(View view) {
        FilePicker picker = new FilePicker(this);
        picker.setInitDir(ExplorerMode.FILE, getExternalFilesDir(null));
        picker.setOnFilePickedListener(this);
        picker.show();
    }

    public void onDirPick(View view) {
        FilePicker picker = new FilePicker(this);
        picker.setInitDir(ExplorerMode.DIRECTORY, getFilesDir());
        picker.setOnFilePickedListener(this);
        picker.show();
    }

}
