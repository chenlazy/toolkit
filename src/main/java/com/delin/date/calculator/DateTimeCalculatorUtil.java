package com.delin.date.calculator;

/**
 * DateTimeCalculatorUtil
 *
 * @author: delingChen
 * @version: 1.0-SN
 * @date: 2023/4/8 09:13 星期六
 */
public class DateTimeCalculatorUtil {

    /**
     * 判断是否闰年
     * @param year 年
     * @return boolean
     */
    public static boolean isLeapYear(int year){
        return ((year % 4) == 0) && ((year % 100) != 0 || (year % 400) == 0);
    }
}
