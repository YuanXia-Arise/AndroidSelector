

package com.github.yuanxia.fallback.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.github.yuanxia.fallback.R;
import com.github.yuanxia.fallback.custom.CustomAddressPicker;
import com.github.yuanxia.fallback.custom.TextAddressLoader;
import com.github.yuanxia.fallback.custom.TextAddressParser;
import com.github.yuanxia.wheelpicker.AddressPicker;
import com.github.yuanxia.wheelpicker.annotation.AddressMode;
import com.github.yuanxia.wheelpicker.contract.OnAddressPickedListener;
import com.github.yuanxia.wheelpicker.contract.OnLinkageSelectedListener;
import com.github.yuanxia.wheelpicker.entity.CityEntity;
import com.github.yuanxia.wheelpicker.entity.CountyEntity;
import com.github.yuanxia.wheelpicker.entity.ProvinceEntity;
import com.github.yuanxia.wheelpicker.utility.AddressJsonParser;
import com.github.yuanxia.wheelpicker.widget.LinkageWheelLayout;
import com.github.yuanxia.wheelview.annotation.CurtainCorner;

/**
* Description :   地址滚轮选择器
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class AddressPickerActivity extends BackAbleActivity implements OnAddressPickedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_address);
    }

    @Override
    public void onAddressPicked(ProvinceEntity province, CityEntity city, CountyEntity county) {
        Toast.makeText(this, province + " " + city + " " + county, Toast.LENGTH_SHORT).show();
    }

    public void onProvinceCityCounty(View view) {
        AddressPicker picker = new AddressPicker(this);
        picker.setAddressMode(AddressMode.PROVINCE_CITY_COUNTY);
        picker.setDefaultValue("江西省", "上饶市", "万年县");
        picker.setOnAddressPickedListener(this);
        picker.getWheelLayout().setOnLinkageSelectedListener(new OnLinkageSelectedListener() {
            @Override
            public void onLinkageSelected(Object first, Object second, Object third) {
                picker.getTitleView().setText(String.format("%s%s%s",
                        picker.getFirstWheelView().formatItem(first),
                        picker.getSecondWheelView().formatItem(second),
                        picker.getThirdWheelView().formatItem(third)));
            }
        });
        picker.show();
    }

    public void onProvinceCity(View view) {
        AddressPicker picker = new AddressPicker(this);
        picker.setTitle("省市选择");
        picker.setAddressMode(AddressMode.PROVINCE_CITY);
        picker.setDefaultValue("360000", "361100", "");
        picker.setOnAddressPickedListener(this);
        picker.getWheelLayout().setOnLinkageSelectedListener(new OnLinkageSelectedListener() {
            @Override
            public void onLinkageSelected(Object first, Object second, Object third) {
                picker.getTitleView().setText(String.format("%s%s%s",
                        picker.getFirstWheelView().formatItem(first),
                        picker.getSecondWheelView().formatItem(second),
                        picker.getThirdWheelView().formatItem(third)));
            }
        });
        picker.show();
    }

    public void onProvinceCityForGuiZhou(View view) {
        AddressPicker picker = new AddressPicker(this);
        picker.setAddressMode("china_address_guizhou_city.json", AddressMode.PROVINCE_CITY,
                new AddressJsonParser.Builder()
                        .provinceCodeField("code")
                        .provinceNameField("name")
                        .provinceChildField("city")
                        .cityCodeField("code")
                        .cityNameField("name")
                        .cityChildField("area")
                        .countyCodeField("code")
                        .countyNameField("name")
                        .build());
        picker.setTitle("贵州省地址选择");
        picker.setDefaultValue("贵州省", "毕节市", "纳雍县");
        picker.setOnAddressPickedListener(this);
        LinkageWheelLayout wheelLayout = picker.getWheelLayout();
        wheelLayout.setTextSize(15 * view.getResources().getDisplayMetrics().scaledDensity);
        wheelLayout.setSelectedTextSize(17 * view.getResources().getDisplayMetrics().scaledDensity);
        wheelLayout.setSelectedTextBold(true);
        wheelLayout.setCurtainEnabled(true);
        wheelLayout.setCurtainColor(0xEE0081FF);
        wheelLayout.setCurtainRadius(8 * view.getResources().getDisplayMetrics().density);
        int padding = (int) (10 * view.getResources().getDisplayMetrics().density);
        wheelLayout.setPadding(padding, 0, padding, 0);
        wheelLayout.setOnLinkageSelectedListener(new OnLinkageSelectedListener() {
            @Override
            public void onLinkageSelected(Object first, Object second, Object third) {
                picker.getTitleView().setText(String.format("%s%s%s",
                        picker.getProvinceWheelView().formatItem(first),
                        picker.getCityWheelView().formatItem(second),
                        picker.getCountyWheelView().formatItem(third)));
            }
        });
        picker.getProvinceWheelView().setCurtainCorner(CurtainCorner.LEFT);
        picker.getCityWheelView().setCurtainCorner(CurtainCorner.RIGHT);
        picker.show();
    }

    public void onCityCounty(View view) {
        AddressPicker picker = new AddressPicker(this);
        picker.setAddressMode("china_address_guizhou.json", AddressMode.CITY_COUNTY,
                new AddressJsonParser.Builder()
                        .provinceCodeField("code")
                        .provinceNameField("name")
                        .provinceChildField("city")
                        .cityCodeField("code")
                        .cityNameField("name")
                        .cityChildField("area")
                        .countyCodeField("code")
                        .countyNameField("name")
                        .build());
        picker.setTitle("贵州省地址选择");
        picker.setDefaultValue("贵州省", "毕节市", "纳雍县");
        picker.setOnAddressPickedListener(this);
        picker.getWheelLayout().setOnLinkageSelectedListener(new OnLinkageSelectedListener() {
            @Override
            public void onLinkageSelected(Object first, Object second, Object third) {
                picker.getTitleView().setText(String.format("%s%s%s",
                        picker.getFirstWheelView().formatItem(first),
                        picker.getSecondWheelView().formatItem(second),
                        picker.getThirdWheelView().formatItem(third)));
            }
        });
        picker.show();
    }

    public void onCustomUi(View view) {
        CustomAddressPicker picker = new CustomAddressPicker(this);
        picker.setDefaultValue("贵州省", "毕节市", "纳雍县");
        picker.setOnAddressPickedListener(this);
        picker.show();
    }

    public void onCustomDataByJson(View view) {
        AddressPicker picker = new AddressPicker(this);
        picker.setAddressMode("city.json", AddressMode.PROVINCE_CITY_COUNTY,
                new AddressJsonParser.Builder()
                        .provinceCodeField("code")
                        .provinceNameField("name")
                        .provinceChildField("city")
                        .cityCodeField("code")
                        .cityNameField("name")
                        .cityChildField("area")
                        .countyCodeField("code")
                        .countyNameField("name")
                        .build());
        picker.setDefaultValue("贵州省", "毕节市", "纳雍县");
        picker.setOnAddressPickedListener(this);
        picker.getWheelLayout().setOnLinkageSelectedListener(new OnLinkageSelectedListener() {
            @Override
            public void onLinkageSelected(Object first, Object second, Object third) {
                picker.getTitleView().setText(String.format("%s%s%s",
                        picker.getFirstWheelView().formatItem(first),
                        picker.getSecondWheelView().formatItem(second),
                        picker.getThirdWheelView().formatItem(third)));
            }
        });
        picker.show();
    }

    public void onCustomDataByText(View view) {
        AddressPicker picker = new AddressPicker(this);
        picker.setAddressLoader(new TextAddressLoader(this), new TextAddressParser());
        picker.setDefaultValue("贵州省", "毕节地区", "纳雍县");
        picker.setOnAddressPickedListener(this);
        picker.getWheelLayout().setOnLinkageSelectedListener(new OnLinkageSelectedListener() {
            @Override
            public void onLinkageSelected(Object first, Object second, Object third) {
                picker.getTitleView().setText(String.format("%s%s%s",
                        picker.getFirstWheelView().formatItem(first),
                        picker.getSecondWheelView().formatItem(second),
                        picker.getThirdWheelView().formatItem(third)));
            }
        });
        picker.show();
    }

}
