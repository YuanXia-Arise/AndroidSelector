

package com.github.yuanxia.wheelpicker.contract;

/**
* Description :   时间显示文本格式化接口
* Modified By：   <chenghuang>
* Modified Date:  <2021/4/6>
* Version:        <v1>
*/
public interface TimeFormatter {

    /**
     * 格式化小时数
     *
     * @param hour 小时数
     * @return 格式化后最终显示的小时数字符串
     */
    String formatHour(int hour);

    /**
     * 格式化分钟数
     *
     * @param minute 分钟数
     * @return 格式化后最终显示的分钟数字符串
     */
    String formatMinute(int minute);

    /**
     * 格式化秒数
     *
     * @param second 秒数
     * @return 格式化后最终显示的秒数字符串
     */
    String formatSecond(int second);

}
