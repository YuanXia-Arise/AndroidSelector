

package com.github.yuanxia.fallback.bean;

import androidx.annotation.NonNull;

import com.github.yuanxia.wheelview.contract.TextProvider;

import java.io.Serializable;

/**
* Description :   示例数据实体
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public class GoodsCategoryBean implements Serializable, TextProvider {
    private int id;
    private String name;

    public GoodsCategoryBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String provideText() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return "GoodsCategoryBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
