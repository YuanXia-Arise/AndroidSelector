
package com.github.yuanxia.wheelpicker.entity;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
* Description :   日期数据实体
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
@SuppressWarnings({"unused"})
public class DateEntity implements Serializable {
    private int year;
    private int month;
    private int day;

    public static DateEntity target(int year, int month, int dayOfMonth) {
        DateEntity entity = new DateEntity();
        entity.setYear(year);
        entity.setMonth(month);
        entity.setDay(dayOfMonth);
        return entity;
    }

    public static DateEntity target(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        // 月份的值是从0开始的，转为从1开始
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return target(year, month, day);
    }

    public static DateEntity target(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return target(calendar);
    }

    public static DateEntity today() {
        return target(Calendar.getInstance());
    }

    public static DateEntity dayOnFuture(int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, dayOfMonth);
        return target(calendar);
    }

    public static DateEntity monthOnFuture(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, month);
        return target(calendar);
    }

    public static DateEntity yearOnFuture(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, year);
        return target(calendar);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public long toTimeInMillis() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DateEntity that = (DateEntity) o;
        return year == that.year &&
                month == that.month &&
                day == that.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @NonNull
    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

}
