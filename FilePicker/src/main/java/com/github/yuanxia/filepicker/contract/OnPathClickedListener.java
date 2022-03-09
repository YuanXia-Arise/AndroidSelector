

package com.github.yuanxia.filepicker.contract;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.yuanxia.filepicker.adapter.ViewHolder;


public interface OnPathClickedListener {

    void onPathClicked(RecyclerView.Adapter<ViewHolder> adapter, int position, @NonNull String path);

}
