package com.delin.excel.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.cache.MapCache;
import com.alibaba.excel.read.metadata.ReadSheet;

import java.io.File;
import java.util.List;

/**
 * ExcelUtils
 *
 * @author: delingChen
 * &#064;version:  1.0-SN
 * @date: 2023/4/8 09:19 星期六
 */
public class ExcelUtils {

    private final ExcelReader excelReader;

    public ExcelUtils(File file, ExcelObserver excelObserver) {
        this(file, excelObserver, Boolean.FALSE);
    }

    public ExcelUtils(File file, ExcelObserver excelObserver, Boolean ignoreEmptyRow) {
        ImportBatchListener importBatchListener = new ImportBatchListener(excelObserver);
        this.excelReader = EasyExcel.read(file, importBatchListener).readCache(new MapCache()).ignoreEmptyRow(ignoreEmptyRow).build();
    }

    public void batchReadContent() {
        ReadSheet readSheet = EasyExcel.readSheet(0).headRowNumber(2).build();
        excelReader.read(readSheet);
        excelReader.finish();
    }

    public void batchReadContent(String sheetName) {
        ReadSheet readSheet = EasyExcel.readSheet(sheetName).build();
        excelReader.read(readSheet);
        excelReader.finish();
    }

    public String sheetName() {
        List<ReadSheet> readSheets = excelReader.excelExecutor().sheetList();
        return readSheets.get(0).getSheetName();
    }

    public static void main(String[] args) {
        ExcelUtils excelUtils = new ExcelUtils(new File("C:\\Users\\delin\\Downloads\\CtoCV4.xlsx"), new PriceListObserver());
        System.out.println(excelUtils.sheetName());
        excelUtils.batchReadContent();
    }
}
