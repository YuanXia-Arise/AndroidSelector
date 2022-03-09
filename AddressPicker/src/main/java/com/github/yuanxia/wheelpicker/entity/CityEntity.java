

package com.github.yuanxia.wheelpicker.entity;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
* Description :   市级数据实体
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class CityEntity extends AddressEntity {
    private List<CountyEntity> countyList;

    @NonNull
    public List<CountyEntity> getCountyList() {
        if (countyList == null) {
            countyList = new ArrayList<>();
        }
        return countyList;
    }

    public void setCountyList(List<CountyEntity> countyList) {
        this.countyList = countyList;
    }

}
