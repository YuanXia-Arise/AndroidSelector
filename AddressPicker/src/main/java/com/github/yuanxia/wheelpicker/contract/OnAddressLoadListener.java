

package com.github.yuanxia.wheelpicker.contract;

import androidx.annotation.NonNull;

import com.github.yuanxia.wheelpicker.entity.ProvinceEntity;

import java.util.List;


public interface OnAddressLoadListener {

    void onAddressLoadStarted();

    void onAddressLoadFinished(@NonNull List<ProvinceEntity> data);

}
