

package com.github.yuanxia.fallback.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.github.yuanxia.dialog.DialogConfig;
import com.github.yuanxia.dialog.DialogStyle;
import com.github.yuanxia.fallback.R;
import com.github.yuanxia.fallback.custom.AntFortuneLikeProvider;
import com.github.yuanxia.wheelpicker.OptionPicker;
import com.github.yuanxia.wheelpicker.contract.OnOptionPickedListener;
import com.github.yuanxia.wheelpicker.widget.LinkageWheelLayout;
import com.github.yuanxia.wheelpicker.widget.OptionWheelLayout;
import com.github.yuanxia.wheelview.widget.WheelView;

import java.util.Arrays;

/**
* Description :   主界面
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_main);
        WheelView wheelView = findViewById(R.id.wheel_view);
        wheelView.setData(Arrays.asList("第1项", "第2项", "第3项", "第4项", "第5项", "第6项", "第7项", "第8项", "第9项",
                "第10项", "第11项", "第12项", "第13项", "第14项", "第15项", "第N项"));
        OptionWheelLayout optionWheelLayout = findViewById(R.id.wheel_option);
        optionWheelLayout.setData(Arrays.asList("aaa", "bbb", "ccc", "123", "xxx", "yyy", "zzz"));
        LinkageWheelLayout linkageWheelLayout = findViewById(R.id.wheel_linkage);
        linkageWheelLayout.setData(new AntFortuneLikeProvider());
    }

    private void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    public void onDialogStyle(View view) {
        OptionPicker picker = new OptionPicker(this);
        picker.setData("默认-屏幕底部弹窗", "样式1-屏幕底部弹窗", "样式3-屏幕中间弹窗");
        picker.setOnOptionPickedListener(new OnOptionPickedListener() {
            @Override
            public void onOptionPicked(int position, Object item) {
                switch (position) {
                    case 1:
                        DialogConfig.setDialogStyle(DialogStyle.One);
                        break;
                    case 2:
                        DialogConfig.setDialogStyle(DialogStyle.Two);
                        break;
                    case 3:
                        DialogConfig.setDialogStyle(DialogStyle.Three);
                        break;
                    case 0:
                    default:
                        DialogConfig.setDialogStyle(DialogStyle.Default);
                        break;
                }
            }
        });
        picker.show();
    }

    public void onDateTimePicker(View view) {
        startActivity(DateTimePickerActivity.class);
    }

    public void onSinglePicker(View view) {
        startActivity(SinglePickerActivity.class);
    }

    public void onLinkagePicker(View view) {
        startActivity(LinkagePickerActivity.class);
    }

    public void onAddressPicker(View view) {
        startActivity(AddressPickerActivity.class);
    }

    public void onColorPicker(View view) {
        startActivity(ColorPickerActivity.class);
    }

    public void onFilePicker(View view) {
        startActivity(FilePickerActivity.class);
    }

    public void onCalendarPicker(View view) {
        startActivity(CalendarPickerActivity.class);
    }

    public void onImagePicker(View view) {
        startActivity(ImagePickerActivity.class);
    }

}
