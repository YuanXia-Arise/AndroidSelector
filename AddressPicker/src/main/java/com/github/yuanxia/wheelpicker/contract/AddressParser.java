

package com.github.yuanxia.wheelpicker.contract;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;

import com.github.yuanxia.wheelpicker.entity.ProvinceEntity;

import java.util.List;

/**
* Description :   地址数据解析器
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public interface AddressParser {

    @WorkerThread
    @NonNull
    List<ProvinceEntity> parseData(@NonNull String text);

}
