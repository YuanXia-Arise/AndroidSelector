

package com.github.yuanxia.wheelpicker.contract;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

/**
* Description :   地址数据加载器
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public interface AddressLoader {

    @MainThread
    void loadJson(@NonNull AddressReceiver receiver, @NonNull AddressParser parser);

}
