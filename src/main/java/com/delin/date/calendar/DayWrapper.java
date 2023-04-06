package com.delin.date.calendar;

import com.delin.date.LunarDate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * DayWrapper
 *
 * @author: delingChen
 * @version: 1.0-SN
 * @date: 2023/4/6 23:03 星期四
 */
public class DayWrapper implements Serializable {

    /**
     * date
     */
    private Date date;

    /**
     * java8 localDateTime 丰富方法可以使用
     */
    private LocalDateTime localDateTime;

    /**
     * 日期 yyyy-MM-dd
     */
    private String dateStr;

    /**
     * 天，当月第几天
     */
    private int day;

    /**
     * 星期，数字，1-7
     */
    private int week;

    /**
     * 星期，中文简写，比如星期一为一
     */
    private String weekCnShort;

    /**
     * 星期，中文全称，比如星期一
     */
    private String weekCnLong;

    /**
     * 星期，英文简写，比如星期一为Mon
     */
    private String weekEnShort;

    /**
     * 星期，英文简写大写，比如星期一为MON
     */
    private String weekEnShortUpper;


    /**
     * 星期，英文全称，比如星期一为Monday
     */
    private String weekEnLong;

    /**
     * 公历节日
     */
    private String localHoliday;

    /**
     * 农历
     */
    private LunarDate lunarDate;

    /**
     * 农历节日
     */
    private String chineseHoliday;

    /**
     * 农历日期
     */
    private String lunarDateStr;

    /**
     * 农历天，比如初一
     */
    private String lunarDay;

    /**
     * 二十四节气
     */
    private String solarTerm;

    /**
     * 日期类型，0休息日，1其他为工作日
     */
    private int dateType;

    /**
     * 扩展信息
     */
    private Object obj;

}
