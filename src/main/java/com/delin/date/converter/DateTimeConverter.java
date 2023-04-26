package com.delin.date.converter;

import com.delin.date.calculator.DateTimeCalculatorUtil;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Objects;

/**
 * DateTimeConverter
 *
 * @author: delingChen
 * @version: 1.0-SN
 * @date: 2023/4/8 11:44 星期六
 */
public class DateTimeConverter {

    public static LocalDateTime toLocalDateTime(Date date) {
        return null;
    }

    /**
     * Timestamp转LocalDateTime
     * @param timestamp Timestamp
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
        Objects.requireNonNull(timestamp, "timestamp");
        return timestamp.toLocalDateTime();
    }

    /**
     * LocalDate转LocalDateTime
     * @param localDate LocalDate
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(LocalDate localDate) {
        Objects.requireNonNull(localDate, "localDate");
        return localDate.atStartOfDay();
    }

    /**
     * LocalTime转LocalDateTime
     * 以当天的日期+LocalTime组成新的LocalDateTime
     * @param localTime LocalTime
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(LocalTime localTime) {
        Objects.requireNonNull(localTime, "localTime");
        return LocalDate.now().atTime(localTime);
    }

    /**
     * Instant转LocalDateTime
     * @param instant Instant
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Instant instant) {
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * 时间戳epochMilli毫秒转LocalDateTime
     * @param epochMilli 时间戳
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(long epochMilli) {
        Objects.requireNonNull(epochMilli, "epochMilli");
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault());
    }

  /*  *//**
     * temporal转LocalDateTime
     * @param temporal TemporalAccessor
     * @return LocalDateTime
     *//*
    public static LocalDateTime toLocalDateTime(TemporalAccessor temporal) {
        return toLocalDateTime(toZonedDateTime(temporal));
    }*/

    /**
     * ZonedDateTime转LocalDateTime
     * 注意时间对应的时区和默认时区差异
     * @param zonedDateTime ZonedDateTime
     * @return LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(ZonedDateTime zonedDateTime) {
        Objects.requireNonNull(zonedDateTime, "zonedDateTime");
        return zonedDateTime.toLocalDateTime();
    }

    /**
     * temporal转时间戳
     * @param temporal TemporalAccessor
     * @return 时间戳
     */
   /* public static long toEpochMilli(TemporalAccessor temporal) {
        return toEpochMilli(toZonedDateTime(temporal));
    }
*/
    /**
     * Date转ZonedDateTime，时区为系统默认时区
     * @param date Date
     * @return ZonedDateTime
     */
    public static ZonedDateTime toZonedDateTime(Date date) {
        Objects.requireNonNull(date, "date");
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault());
    }

    /**
     * Date转ZonedDateTime，可以直接转换为对应的时区
     * @param date Date 没有时区区分
     * @param zoneId 目标时区
     * @return ZonedDateTime
     */
    public static ZonedDateTime toZonedDateTime(Date date, String zoneId) {
        Objects.requireNonNull(zoneId, "zoneId");
        return toZonedDateTime(date, ZoneId.of(zoneId));
    }

    /**
     * Date转ZonedDateTime
     * @param date Date
     * @param zone 目标时区
     * @return ZonedDateTime
     */
    public static ZonedDateTime toZonedDateTime(Date date, ZoneId zone) {
        Objects.requireNonNull(date, "date");
        Objects.requireNonNull(zone, "zone");
        return Instant.ofEpochMilli(date.getTime()).atZone(zone);
    }

    /**
     * LocalDateTime转ZonedDateTime，时区为系统默认时区
     * @param localDateTime LocalDateTime
     * @return ZonedDateTime
     */
    public static ZonedDateTime toZonedDateTime(LocalDateTime localDateTime) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        return localDateTime.atZone(ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转ZonedDateTime，时区为zoneId对应时区<br>
     * 注意，需要保证localDateTime和zoneId是对应的，不然会出现错误<br>
     * 比如，localDateTime是巴黎时区下的对象，zoneId也应该是巴黎时区id<br>
     * @param localDateTime LocalDateTime
     * @param zoneId 时区id
     * @return ZonedDateTime
     */
    public static ZonedDateTime toZonedDateTime(LocalDateTime localDateTime, String zoneId) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zoneId");
        return localDateTime.atZone(ZoneId.of(zoneId));
    }

    /**
     * LocalDateTime转ZonedDateTime，当前时区的LocalDateTime转换为目标时区的ZonedDateTime<br>
     * 注意，需要保证localDateTime当前时区下的对象<br>
     *
     * @param localDateTime LocalDateTime 系统默认时区的localDateTime对象
     * @param targetZoneId 目标时区id
     * @return ZonedDateTime
     */
  /*  public static ZonedDateTime toZonedDateTimeAndTransformZone(LocalDateTime localDateTime, String targetZoneId) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(targetZoneId, "targetZoneId");
        return DateTimeCalculatorUtil.transform(localDateTime.atZone(ZoneId.systemDefault()), targetZoneId);
    }*/

    /**
     * LocalDate转ZonedDateTime，时区为系统默认时区
     * @param localDate LocalDate
     * @return ZonedDateTime such as 2020-02-19T00:00+08:00[Asia/Shanghai]
     */
    public static ZonedDateTime toZonedDateTime(LocalDate localDate) {
        Objects.requireNonNull(localDate, "localDate");
        return localDate.atStartOfDay().atZone(ZoneId.systemDefault());
    }

    /**
     * LocalTime转ZonedDateTime
     * 以当天的日期+LocalTime组成新的ZonedDateTime，时区为系统默认时区
     * @param localTime LocalTime
     * @return ZonedDateTime
     */
    public static ZonedDateTime toZonedDateTime(LocalTime localTime) {
        Objects.requireNonNull(localTime, "localTime");
        return LocalDate.now().atTime(localTime).atZone(ZoneId.systemDefault());
    }

    /**
     * Instant转ZonedDateTime，时区为系统默认时区
     * @param instant Instant
     * @return ZonedDateTime
     */
    public static ZonedDateTime toZonedDateTime(Instant instant) {
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).atZone(ZoneId.systemDefault());
    }

    /**
     * 时间戳epochMilli毫秒转ZonedDateTime，时区为系统默认时区
     * @param epochMilli 时间戳
     * @return ZonedDateTime
     */
    public static ZonedDateTime toZonedDateTime(long epochMilli) {
        Objects.requireNonNull(epochMilli, "epochMilli");
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault())
                .atZone(ZoneId.systemDefault());
    }
}
