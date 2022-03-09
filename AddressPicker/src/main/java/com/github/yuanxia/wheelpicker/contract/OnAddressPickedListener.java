

package com.github.yuanxia.wheelpicker.contract;

import com.github.yuanxia.wheelpicker.entity.CityEntity;
import com.github.yuanxia.wheelpicker.entity.CountyEntity;
import com.github.yuanxia.wheelpicker.entity.ProvinceEntity;

/**
* Description :   地址选择接口
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public interface OnAddressPickedListener {

    /**
     * 联动选择回调
     *
     * @param province 选中的省/直辖市/自治区
     * @param city     选中的地级市/自治州
     * @param county   选中的区/县/县级市
     */
    void onAddressPicked(ProvinceEntity province, CityEntity city, CountyEntity county);

}
