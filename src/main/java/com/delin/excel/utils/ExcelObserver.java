package com.delin.excel.utils;


import java.util.List;
import java.util.Map;

/**
 * ExcelObserver
 *
 * @author: chendl
 * @date: Created in 2023/4/21 16:14
 * @description: com.delin.excel.utils.ExcelObserver
 */
public abstract class ExcelObserver {

    public abstract boolean sendExcelDataContent(List<Map<Integer, String>> batchDataList);

    protected void sendExcelSheetName(String sheetName) {

    }
}
