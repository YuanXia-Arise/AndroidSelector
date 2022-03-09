

package com.github.yuanxia.wheelpicker.contract;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

import com.github.yuanxia.wheelpicker.entity.ProvinceEntity;

import java.util.List;

/**
* Description :   地址数据接收器
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public interface AddressReceiver {

    @MainThread
    void onAddressReceived(@NonNull List<ProvinceEntity> data);

}
