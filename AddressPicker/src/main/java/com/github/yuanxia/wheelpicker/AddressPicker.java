

package com.github.yuanxia.wheelpicker;

import android.app.Activity;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

import com.github.yuanxia.dialog.DialogLog;
import com.github.yuanxia.wheelpicker.annotation.AddressMode;
import com.github.yuanxia.wheelpicker.contract.AddressLoader;
import com.github.yuanxia.wheelpicker.contract.AddressParser;
import com.github.yuanxia.wheelpicker.contract.AddressReceiver;
import com.github.yuanxia.wheelpicker.contract.LinkageProvider;
import com.github.yuanxia.wheelpicker.contract.OnAddressLoadListener;
import com.github.yuanxia.wheelpicker.contract.OnAddressPickedListener;
import com.github.yuanxia.wheelpicker.contract.OnLinkagePickedListener;
import com.github.yuanxia.wheelpicker.entity.CityEntity;
import com.github.yuanxia.wheelpicker.entity.CountyEntity;
import com.github.yuanxia.wheelpicker.entity.ProvinceEntity;
import com.github.yuanxia.wheelpicker.impl.AddressProvider;
import com.github.yuanxia.wheelpicker.impl.AssetAddressLoader;
import com.github.yuanxia.wheelpicker.utility.AddressJsonParser;
import com.github.yuanxia.wheelview.widget.WheelView;

import java.util.List;

/**
 * 省市区县滚轮选择
 * <p>
 * 数据来源：
 * 1、国家民政局：http://www.mca.gov.cn/article/sj/xzqh
 * 2、国家统计局：http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm
 * 3、台湾维基数据：https://zh.wikipedia.org/wiki/中华人民共和国行政区划代码_(7区)
 * 4、港澳维基数据：https://zh.wikipedia.org/wiki/中华人民共和国行政区划代码_(8区)
 * 5、数据抓取转化：https://github.com/small-dream/China_Province_City
 *
 */
@SuppressWarnings({"unused"})
public class AddressPicker extends LinkagePicker implements AddressReceiver {
    private AddressLoader addressLoader;
    private AddressParser addressParser;
    private int addressMode;
    private OnAddressPickedListener onAddressPickedListener;
    private OnAddressLoadListener onAddressLoadListener;

    public AddressPicker(@NonNull Activity activity) {
        super(activity);
    }

    public AddressPicker(@NonNull Activity activity, @StyleRes int themeResId) {
        super(activity, themeResId);
    }

    @Override
    protected void initData() {
        super.initData();
        if (addressLoader == null || addressParser == null) {
            return;
        }
        wheelLayout.showLoading();
        if (onAddressLoadListener != null) {
            onAddressLoadListener.onAddressLoadStarted();
        }
        DialogLog.print("Address data loading");
        addressLoader.loadJson(this, addressParser);
    }

    @Override
    public void onAddressReceived(@NonNull List<ProvinceEntity> data) {
        DialogLog.print("Address data received");
        wheelLayout.hideLoading();
        if (onAddressLoadListener != null) {
            onAddressLoadListener.onAddressLoadFinished(data);
        }
        wheelLayout.setData(new AddressProvider(data, addressMode));
    }

    @Deprecated
    @Override
    public void setData(@NonNull LinkageProvider data) {
        throw new UnsupportedOperationException("Use setAddressMode or setAddressLoader instead");
    }

    @Deprecated
    @Override
    public void setOnLinkagePickedListener(OnLinkagePickedListener onLinkagePickedListener) {
        throw new UnsupportedOperationException("Use setOnAddressPickedListener instead");
    }

    @Override
    protected void onOk() {
        if (onAddressPickedListener != null) {
            ProvinceEntity province = wheelLayout.getFirstWheelView().getCurrentItem();
            CityEntity city = wheelLayout.getSecondWheelView().getCurrentItem();
            CountyEntity county = wheelLayout.getThirdWheelView().getCurrentItem();
            onAddressPickedListener.onAddressPicked(province, city, county);
        }
    }


    public void setOnAddressPickedListener(@NonNull OnAddressPickedListener onAddressPickedListener) {
        this.onAddressPickedListener = onAddressPickedListener;
    }

    public void setOnAddressLoadListener(@NonNull OnAddressLoadListener onAddressLoadListener) {
        this.onAddressLoadListener = onAddressLoadListener;
    }

    public void setAddressLoader(@NonNull AddressLoader loader, @NonNull AddressParser parser) {
        this.addressLoader = loader;
        this.addressParser = parser;
    }

    public void setAddressMode(@AddressMode int addressMode) {
        setAddressMode("china_address.json", addressMode);
    }

    public void setAddressMode(@NonNull String assetPath, @AddressMode int addressMode) {
        setAddressMode(assetPath, addressMode, new AddressJsonParser());
    }

    public void setAddressMode(@NonNull String assetPath, @AddressMode int addressMode,
                               @NonNull AddressJsonParser jsonParser) {
        this.addressMode = addressMode;
        setAddressLoader(new AssetAddressLoader(getContext(), assetPath), jsonParser);
    }

    public final WheelView getProvinceWheelView() {
        return wheelLayout.getFirstWheelView();
    }

    public final WheelView getCityWheelView() {
        return wheelLayout.getSecondWheelView();
    }

    public final WheelView getCountyWheelView() {
        return wheelLayout.getThirdWheelView();
    }

    public final TextView getProvinceLabelView() {
        return wheelLayout.getFirstLabelView();
    }

    public final TextView getCityLabelView() {
        return wheelLayout.getSecondLabelView();
    }

    public final TextView getCountyLabelView() {
        return wheelLayout.getThirdLabelView();
    }

}
