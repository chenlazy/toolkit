package com.delin.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * DateUtils
 *
 * @author: delingChen
 * @version: 1.0-SN
 * @date: 2023/4/6 22:14 星期四
 */
public class DateUtils {

    /**
     * 获取当前时间, 默认格式为 {@link DateConstant#YYYY_MM_DD_HH_MM_SS}
     * @return 返回字符串格式
     */
    public static String getNowTime() {
        return getNowTime(DateConstant.YYYY_MM_DD_HH_MM_SS);
    }

    public static String getNowTime(String pattern) {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前时间时间戳，单位秒
     */
    public static long getNowTimestamp() {
        return dateTimeToTimestamp(LocalDateTime.now()).getEpochSecond();
    }

    /**
     * 获取当前时间时间戳，单位毫秒
     */
    public static long getNotMilliSecond() {
        return dateTimeToTimestamp(LocalDateTime.now()).toEpochMilli();
    }

    /**
     * java.time.LocalDateTime 转换为 java.util.Date，默认时区为东8区
     */
    public static Date localDateTimeConvertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
    }


    public static Date getNowDate() {
        LocalDate nowLocalDate = LocalDate.now();
        return Date.from(nowLocalDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
    }

    /**
     * 时间戳转换成LocalDateTime
     * 思路：LocalDateTime先转为Instant，设置时区，然后转timestamp
     * @param timestamp 时间戳
     */
    private static LocalDateTime timestampToDatetime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换成时间戳
     */
    private static Instant dateTimeToTimestamp(LocalDateTime dateTime) {
        return dateTime.toInstant(ZoneOffset.of("+8"));
    }
}
