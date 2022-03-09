

package com.github.yuanxia.fallback.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.github.yuanxia.fallback.R;
import com.github.yuanxia.fallback.custom.AntFortuneLikePicker;
import com.github.yuanxia.wheelpicker.CarPlatePicker;
import com.github.yuanxia.wheelpicker.contract.OnCarPlatePickedListener;
import com.github.yuanxia.wheelpicker.contract.OnLinkagePickedListener;

public class LinkagePickerActivity extends BackAbleActivity implements OnCarPlatePickedListener, OnLinkagePickedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_linkage);
    }

    @Override
    public void onCarNumberPicked(String province, String letter) {
        Toast.makeText(getApplication(), province + " " + letter, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLinkagePicked(Object first, Object second, Object third) {
        Toast.makeText(getApplication(), first + " " + second + " " + third, Toast.LENGTH_SHORT).show();
    }

    public void onCarNumber(View view) {
        CarPlatePicker picker = new CarPlatePicker(this);
        picker.setBodyWidth(100);
        picker.setDefaultValue("贵", "F", "");
        picker.setOnCarPlatePickedListener(this);
        picker.show();
    }

    public void onLikeAntFortune(View view) {
        AntFortuneLikePicker picker = new AntFortuneLikePicker(this);
        picker.setOnLinkagePickedListener(this);
        picker.show();
    }

}
