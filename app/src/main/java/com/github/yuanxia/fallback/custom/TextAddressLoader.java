

package com.github.yuanxia.fallback.custom;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import com.github.yuanxia.wheelpicker.contract.AddressLoader;
import com.github.yuanxia.wheelpicker.contract.AddressParser;
import com.github.yuanxia.wheelpicker.contract.AddressReceiver;
import com.github.yuanxia.wheelpicker.entity.ProvinceEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.Executors;

public class TextAddressLoader implements AddressLoader {
    private final Context context;

    public TextAddressLoader(Context context) {
        this.context = context;
    }

    @Override
    public void loadJson(@NonNull final AddressReceiver receiver, @NonNull final AddressParser parser) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                AssetManager am = context.getAssets();
                try (BufferedReader bf = new BufferedReader(new InputStreamReader(am.open("city.txt")))) {
                    String line;
                    while ((line = bf.readLine()) != null) {
                        sb.append(line);
                    }
                } catch (IOException ignore) {
                }
                String json = sb.toString();
                try {
                    final List<ProvinceEntity> data = parser.parseData(json);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            receiver.onAddressReceived(data);
                        }
                    });
                } catch (Exception ignore) {
                }
            }
        });
    }

}
