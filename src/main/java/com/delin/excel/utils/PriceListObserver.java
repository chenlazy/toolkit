package com.delin.excel.utils;

import java.util.List;
import java.util.Map;

/**
 * PriceListObserver
 *
 * @author: chendl
 * @date: Created in 2023/4/21 16:25
 * @description: com.delin.excel.utils.PriceListObserver
 */
public class PriceListObserver extends ExcelObserver {

    private int row = 1;

    @Override
    public boolean sendExcelDataContent(List<Map<Integer, String>> batchDataList) {
        for (Map<Integer, String> integerStringMap : batchDataList) {
            System.out.println(integerStringMap.toString());
            row++;
        }
        System.out.println(row);

        return true;
    }
}
