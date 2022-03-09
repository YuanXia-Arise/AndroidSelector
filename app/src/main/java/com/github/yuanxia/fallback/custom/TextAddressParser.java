

package com.github.yuanxia.fallback.custom;

import androidx.annotation.NonNull;

import com.github.yuanxia.wheelpicker.contract.AddressParser;
import com.github.yuanxia.wheelpicker.entity.CityEntity;
import com.github.yuanxia.wheelpicker.entity.CountyEntity;
import com.github.yuanxia.wheelpicker.entity.ProvinceEntity;

import java.util.ArrayList;
import java.util.List;

public class TextAddressParser implements AddressParser {
    private final List<ProvinceEntity> provinces = new ArrayList<>();

    @NonNull
    @Override
    public List<ProvinceEntity> parseData(@NonNull String text) {
        provinces.clear();
        String[] fullCodeAndNames = text.split(";");
        for (String fullCodeAndName : fullCodeAndNames) {
            String[] codeAndName = fullCodeAndName.split(",");
            if (codeAndName.length != 2) {
                continue;
            }
            String code = codeAndName[0];
            String name = codeAndName[1];
            if (code.startsWith("0000", 2)) {
                //省份
                ProvinceEntity province = new ProvinceEntity();
                province.setCode(code);
                province.setName(name);
                province.setCityList(new ArrayList<>());
                provinces.add(province);
            } else if (code.startsWith("00", 4)) {
                //地市
                ProvinceEntity province = findProvinceByCode(code.substring(0, 2));
                if (province != null) {
                    CityEntity city = new CityEntity();
                    city.setCode(code);
                    city.setName(name);
                    city.setCountyList(new ArrayList<>());
                    province.getCityList().add(city);
                }
            } else {
                //区县
                CityEntity city = findCityByCode(code.substring(0, 2), code.substring(2, 4));
                if (city != null) {
                    CountyEntity county = new CountyEntity();
                    county.setCode(code);
                    county.setName(name);
                    city.getCountyList().add(county);
                }
            }
        }
        return provinces;
    }

    private ProvinceEntity findProvinceByCode(String provinceCode) {
        for (ProvinceEntity province : provinces) {
            if (province.getCode().substring(0, 2).equals(provinceCode)) {
                return province;
            }
        }
        return null;
    }

    private CityEntity findCityByCode(String provinceCode, String cityCode) {
        for (ProvinceEntity province : provinces) {
            List<CityEntity> cities = province.getCityList();
            for (CityEntity city : cities) {
                if (province.getCode().substring(0, 2).equals(provinceCode) &&
                        city.getCode().substring(2, 4).equals(cityCode)) {
                    return city;
                }
            }
        }
        return null;
    }

}
