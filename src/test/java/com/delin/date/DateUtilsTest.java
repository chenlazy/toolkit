package com.delin.date;

import org.junit.Test;

/**
 * DateUtilsTest
 *
 * @author: delingChen
 * @version: 1.0-SN
 * @date: 2023/4/6 22:25 星期四
 */
public class DateUtilsTest {

    @Test
    public void getNowTimeTest() {
        System.out.println(DateUtils.getNowTime());
    }

    @Test
    public void getNotMilliSecondTest() {
        System.out.println(DateUtils.getNotMilliSecond());
    }

    @Test
    public void getNowTimestampTest() {
        System.out.println(DateUtils.getNowTimestamp());
    }
}
