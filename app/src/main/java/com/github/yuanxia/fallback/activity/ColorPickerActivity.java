

package com.github.yuanxia.fallback.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.github.yuanxia.colorpicker.BrightnessGradientView;
import com.github.yuanxia.colorpicker.ColorGradientView;
import com.github.yuanxia.colorpicker.ColorPicker;
import com.github.yuanxia.colorpicker.OnColorChangedListener;
import com.github.yuanxia.colorpicker.OnColorPickedListener;
import com.github.yuanxia.fallback.R;

/**
* Description :   颜色选择器
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class ColorPickerActivity extends BackAbleActivity implements View.OnClickListener, OnColorChangedListener {
    private BrightnessGradientView brightnessGradientView;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_color);
        button = findViewById(R.id.color_picker_button);
        button.setOnClickListener(this);
        ColorGradientView colorGradientView = findViewById(R.id.color_picker_panel);
        colorGradientView.setPointerDrawable(android.R.drawable.ic_menu_compass);
        colorGradientView.setColor(0xFF7FF7FF);
        colorGradientView.setOnColorChangedListener(this);
        brightnessGradientView = findViewById(R.id.color_picker_bright);
        brightnessGradientView.setColor(0xFF377377);
        brightnessGradientView.setOnColorChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.color_picker_button) {
            ColorPicker picker = new ColorPicker(this);
            picker.setInitColor(0xFF7FF7FF);
            picker.setOnColorPickListener(new OnColorPickedListener() {
                @Override
                public void onColorPicked(int pickedColor) {
                    button.setTextColor(pickedColor);
                }
            });
            picker.show();
        }
    }

    @Override
    public void onColorChanged(ColorGradientView gradientView, int color) {
        if (gradientView.getId() == R.id.color_picker_panel) {
            brightnessGradientView.setColor(color);
        }
        button.setTextColor(color);
    }

}
