package com.delin.date;

import java.io.Serializable;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

/**
 * LunarDate
 * 农历日期<br>
 * 1.农历日期年月日计算<br>
 * 2.农历岁次，生肖属相计算<br>
 * 3.二十四节气计算<br>
 * 4.农历转公历<br>
 * 仅支持公历1900-2100年的农历转换<br>
 *
 * @author: delingChen
 * @version: 1.0-SN
 * @date: 2023/4/6 23:04 星期四
 */
public class LunarDate implements Temporal, Serializable {
    @Override
    public boolean isSupported(TemporalUnit unit) {
        return false;
    }

    @Override
    public Temporal with(TemporalField field, long newValue) {
        return null;
    }

    @Override
    public Temporal plus(long amountToAdd, TemporalUnit unit) {
        return null;
    }

    @Override
    public long until(Temporal endExclusive, TemporalUnit unit) {
        return 0;
    }

    @Override
    public boolean isSupported(TemporalField field) {
        return false;
    }

    @Override
    public long getLong(TemporalField field) {
        return 0;
    }
}
