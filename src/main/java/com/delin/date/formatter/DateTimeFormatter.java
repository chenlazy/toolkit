package com.delin.date.formatter;


import com.delin.date.converter.DateTimeConverter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * DateTimeFormatter
 *
 * @author: delingChen
 * @version: 1.0-SN
 * @date: 2023/4/8 11:42 星期六
 */
public class DateTimeFormatter {


    /**
     * 中文日期格式化，isUpperCase false：2021年09月11日 true： 二〇二一年九月十一日
     * @param date Date
     * @param isUpperCase 是否大写，false：2021年09月11日 true： 二〇二一年九月十一日
     * @return String
     */
    public static String formatToChineseDateStr(Date date, boolean isUpperCase){
        return formatToChineseDateStr(DateTimeConverter.toLocalDateTime(date), isUpperCase);
    }

    /**
     * 中文日期格式化，isUpperCase false：2021年09月11日 true： 二〇二一年九月十一日
     * @param localDateTime LocalDateTime
     * @param isUpperCase 是否大写，false：2021年09月11日 true： 二〇二一年九月十一日
     * @return String
     */
    public static String formatToChineseDateStr(LocalDateTime localDateTime, boolean isUpperCase){
        Objects.requireNonNull(localDateTime, "localDateTime");
        if(isUpperCase){
            StringBuilder buf = new StringBuilder();
            //年
            String year = String.valueOf(localDateTime.getYear());
            int yearLength = year.length();
            for(int i=0; i<yearLength; i++){
                buf.append(ChineseDateDigitEnum.ENUMS[year.charAt(i)-48].getChineseDigit());
            }
            buf.append("年");
            //月
            buf.append(ChineseDateDigitEnum.ENUMS[localDateTime.getMonthValue()].getChineseDigit());
            buf.append("月");
            //日
            buf.append(ChineseDateDigitEnum.ENUMS[localDateTime.getDayOfMonth()].getChineseDigit());
            buf.append("日");
            return buf.toString();
        }else{
            return format(localDateTime, YYYY_MM_DD_CN_FMT);
        }
    }
}
