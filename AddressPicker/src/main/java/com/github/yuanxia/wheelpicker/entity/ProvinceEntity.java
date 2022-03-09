

package com.github.yuanxia.wheelpicker.entity;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
* Description :   省级数据实体
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class ProvinceEntity extends AddressEntity {
    private List<CityEntity> cityList;

    @NonNull
    public List<CityEntity> getCityList() {
        if (cityList == null) {
            cityList = new ArrayList<>();
        }
        return cityList;
    }

    public void setCityList(List<CityEntity> cityList) {
        this.cityList = cityList;
    }

}
