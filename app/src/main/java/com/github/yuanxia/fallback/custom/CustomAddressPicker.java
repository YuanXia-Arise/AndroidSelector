

package com.github.yuanxia.fallback.custom;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;

import com.github.yuanxia.dialog.BottomDialog;
import com.github.yuanxia.fallback.R;
import com.github.yuanxia.wheelpicker.annotation.AddressMode;
import com.github.yuanxia.wheelpicker.contract.AddressLoader;
import com.github.yuanxia.wheelpicker.contract.AddressReceiver;
import com.github.yuanxia.wheelpicker.contract.OnAddressPickedListener;
import com.github.yuanxia.wheelpicker.entity.CityEntity;
import com.github.yuanxia.wheelpicker.entity.CountyEntity;
import com.github.yuanxia.wheelpicker.entity.ProvinceEntity;
import com.github.yuanxia.wheelpicker.impl.AddressProvider;
import com.github.yuanxia.wheelpicker.impl.AssetAddressLoader;
import com.github.yuanxia.wheelpicker.utility.AddressJsonParser;
import com.github.yuanxia.wheelpicker.widget.LinkageWheelLayout;

import java.util.List;

/**
* Description :   自定义地址选择器
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class CustomAddressPicker extends BottomDialog implements AddressReceiver, View.OnClickListener {
    protected LinkageWheelLayout wheelLayout;
    private OnAddressPickedListener onAddressPickedListener;

    public CustomAddressPicker(@NonNull Activity activity) {
        super(activity);
    }

    public CustomAddressPicker(@NonNull Activity activity, int themeResId) {
        super(activity, themeResId);
    }

    @NonNull
    @Override
    protected View createContentView() {
        return View.inflate(activity, R.layout.wheel_picker_custom_ui_address, null);
    }

    @Override
    protected void initView() {
        super.initView();
        contentView.findViewById(R.id.wheel_picker_address_cancel).setOnClickListener(this);
        contentView.findViewById(R.id.wheel_picker_address_confirm).setOnClickListener(this);
        wheelLayout = contentView.findViewById(R.id.wheel_picker_address_wheel);
    }

    @Override
    protected void initData() {
        super.initData();
        wheelLayout.showLoading();
        AddressLoader addressLoader = new AssetAddressLoader(getContext(), "pca-code.json");
        addressLoader.loadJson(this,
                new AddressJsonParser.Builder()
                        .provinceCodeField("code")
                        .provinceNameField("name")
                        .provinceChildField("children")
                        .cityCodeField("code")
                        .cityNameField("name")
                        .cityChildField("children")
                        .countyCodeField("code")
                        .countyNameField("name")
                        .build());
    }

    @Override
    public void onAddressReceived(@NonNull List<ProvinceEntity> data) {
        wheelLayout.hideLoading();
        wheelLayout.setData(new AddressProvider(data, AddressMode.PROVINCE_CITY_COUNTY));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.wheel_picker_address_cancel) {
            dismiss();
            return;
        }
        if (id == R.id.wheel_picker_address_confirm) {
            if (onAddressPickedListener != null) {
                ProvinceEntity province = wheelLayout.getFirstWheelView().getCurrentItem();
                CityEntity city = wheelLayout.getSecondWheelView().getCurrentItem();
                CountyEntity county = wheelLayout.getThirdWheelView().getCurrentItem();
                onAddressPickedListener.onAddressPicked(province, city, county);
            }
            dismiss();
        }
    }

    public void setDefaultValue(String province, String city, String county) {
        wheelLayout.setDefaultValue(province, city, county);
    }

    public void setOnAddressPickedListener(OnAddressPickedListener onAddressPickedListener) {
        this.onAddressPickedListener = onAddressPickedListener;
    }

}
