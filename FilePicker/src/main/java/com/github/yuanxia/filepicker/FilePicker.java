

package com.github.yuanxia.filepicker;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.recyclerview.widget.RecyclerView;

import com.github.yuanxia.dialog.DialogLog;
import com.github.yuanxia.dialog.ModalDialog;
import com.github.yuanxia.filepicker.annotation.ExplorerMode;
import com.github.yuanxia.filepicker.contract.OnFileClickedListener;
import com.github.yuanxia.filepicker.contract.OnFilePickedListener;

import java.io.File;

/**
* Description :   文件目录选择器
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
@SuppressWarnings("unused")
public class FilePicker extends ModalDialog {
    private int explorerMode = ExplorerMode.FILE;
    private File initDir;
    private FileExplorer fileExplorer;
    private OnFilePickedListener onFilePickedListener;
    private boolean initialized = false;

    public FilePicker(Activity activity) {
        super(activity);
    }

    public FilePicker(@NonNull Activity activity, @StyleRes int themeResId) {
        super(activity, themeResId);
    }

    @NonNull
    @Override
    protected View createBodyView() {
        fileExplorer = new FileExplorer(activity);
        return fileExplorer;
    }

    @Override
    protected void initView() {
        super.initView();
        setHeight((int) (activity.getResources().getDisplayMetrics().heightPixels * 0.6f));
        if (explorerMode == ExplorerMode.FILE) {
            okView.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initData() {
        super.initData();
        initialized = true;
        setInitDir(explorerMode, initDir);
    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected void onOk() {
        File currentFile = fileExplorer.getCurrentFile();
        DialogLog.print("picked directory: " + currentFile);
        if (onFilePickedListener != null) {
            onFilePickedListener.onFilePicked(currentFile);
        }
    }

    public void setInitDir(@ExplorerMode int explorerMode, File initDir) {
        this.explorerMode = explorerMode;
        this.initDir = initDir;
        if (initialized) {
            fileExplorer.setInitDir(explorerMode, initDir);
        }
    }

    public void setOnFilePickedListener(OnFilePickedListener listener) {
        this.onFilePickedListener = listener;
        fileExplorer.setOnFileClickedListener(new OnFileClickedListener() {
            @Override
            public void onFileClicked(@NonNull File file) {
                if (explorerMode == ExplorerMode.FILE) {
                    dismiss();
                    onFilePickedListener.onFilePicked(file);
                }
            }
        });
    }

    public final File getCurrentFile() {
        return fileExplorer.getCurrentFile();
    }

    public final FileExplorer getFileExplorer() {
        return fileExplorer;
    }

    public final RecyclerView getFileListView() {
        return fileExplorer.getFileListView();
    }

    public final TextView getEmptyHintView() {
        return fileExplorer.getEmptyHintView();
    }

    public final RecyclerView getPathListView() {
        return fileExplorer.getPathListView();
    }

}
