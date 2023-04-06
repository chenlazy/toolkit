package com.delin.date;

/**
 * DateConstant
 *
 * @author: delingChen
 * @version: 1.0-SN
 * @date: 2023/4/6 22:22 星期四
 */
public interface DateConstant {

    /** ==================================yyyy-MM-dd相关Pattern================================== */

    /**
     * yyyy-MM-dd 比如：  2020-05-23
     */
    String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * yyyy-M-d 比如：  2020-5-23
     */
    String YYYY_M_D = "yyyy-M-d";

    /**
     * yyyyMMdd  比如：  20200523
     */
    String YYYYMMDD = "yyyyMMdd";

    /**
     * yyyy/MM/dd  比如：  2020/05/23
     */
    String YYYY_MM_DD_EN = "yyyy/MM/dd";

    /**
     * yyyy/M/d 不补0  比如：  2020/5/23
     */
    String YYYY_M_D_EN = "yyyy/M/d";

    /**
     * yyyy年MM月dd日  比如： 2020年05月23日
     */
    String YYYY_MM_DD_CN = "yyyy年MM月dd日";

    /**
     * yyyy年M月d日 不补0  比如： 2020年5月23日
     */
    String YYYY_M_D_CN = "yyyy年M月d日";

    /**
     * yyyy.MM.dd  比如：2020.05.23
     */
    String YYYY_MM_DD_POINT = "yyyy.MM.dd";

    /**
     * yyyy.M.d 不补0  比如：2020.5.23
     */
    String YYYY_M_D_POINT = "yyyy.M.d";

    /**
     * yy/MM/dd  比如：20/05/23
     */
    String YY_MM_DD_EN = "yy/MM/dd";

    /**
     * yy/M/d  比如：20/5/23
     */
    String YY_M_D_EN = "yy/M/d";

    /**
     * MM/dd/yy  比如：05/23/20
     */
    String MM_DD_YY_EN = "MM/dd/yy";

    /**
     * M/d/yy  比如：5/23/20
     */
    String M_D_YY_EN = "M/d/yy";

    /**
     * yyyy-MM-dd E  比如：2020-05-23 星期六
     */
    String YYYY_MM_DD_E = "yyyy-MM-dd E";

    /**
     * yy 年的后2位  比如： 20
     */
    String YY = "yy";

    /**
     * yyyy  比如：2020
     */
    String YYYY = "yyyy";

    /**
     * yyyy-MM  比如：2020-05
     */
    String YYYY_MM = "yyyy-MM";

    /**
     * yyyyMM  比如：202005
     */
    String YYYYMM = "yyyyMM";

    /**
     * yyyy/MM  比如：2020/05
     */
    String YYYY_MM_EN = "yyyy/MM";

    /**
     * yyyy年MM月  比如：2020年05月
     */
    String YYYY_MM_CN = "yyyy年MM月";

    /**
     * yyyy年M月  比如：2020年5月
     */
    String YYYY_M_CN = "yyyy年M月";

    /**
     * MM-dd  比如：05-23
     */
    String MM_DD = "MM-dd";

    /**
     * MMdd  比如：0523
     */
    String MMDD = "MMdd";

    /**
     * MM/dd  比如：05/23
     */
    String MM_DD_EN = "MM/dd";

    /**
     * M/d 不补0  比如：5/23
     */
    String M_D_EN = "M/d";

    /**
     * MM月dd日  比如：05月23日
     */
    String MM_DD_CN = "MM月dd日";

    /**
     * M月d日 不补0  比如：5月23日
     */
    String M_D_CN = "M月d日";

    /** ==================================yyyy-MM-dd HH:mm:ss 相关Pattern================================== */
    String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyy-M-d H:m:s 比如：2020-5-23 17:6:30
     */
    String YYYY_M_D_H_M_S = "yyyy-M-d H:m:s";
}
