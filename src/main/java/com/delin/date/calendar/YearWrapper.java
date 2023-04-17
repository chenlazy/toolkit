package com.delin.date.calendar;

import com.delin.date.calculator.DateTimeCalculatorUtil;

import java.io.Serializable;
import java.util.List;

/**
 * YearWrapper
 *
 * @author: delingChen
 * @version: 1.0-SN
 * @date: 2023/4/6 23:02 星期四
 */
public class YearWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 年
     */
    private int year;

    /**
     * 当前年所有月
     */
    private List<MonthWrapper> months;

    /**
     * 是否闰月
     */
    private boolean isLeapYear;

    /**
     * 当前年包含的天数
     */
    private int length;

    public YearWrapper(int year, List<MonthWrapper> months) {
        super();
        this.year = year;
        this.months = months;
        this.isLeapYear = DateTimeCalculatorUtil.isLeapYear(year);
        if(isLeapYear){
            this.length = 366;
        }else{
            this.length = 365;
        }
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<MonthWrapper> getMonths() {
        return months;
    }

    public void setMonths(List<MonthWrapper> months) {
        this.months = months;
    }

    public boolean isLeapYear() {
        return isLeapYear;
    }

    public void setLeapYear(boolean isLeapYear) {
        this.isLeapYear = isLeapYear;
    }

    public int getLength() {
        return length;
    }


    public void setLength(int length) {
        this.length = length;
    }
}
