package com.delin.excel.utils;

import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;

/**
 * ExcelContent
 *
 * @author: chendl
 * @date: Created in 2023/4/21 15:42
 * @description: com.delin.excel.utils.ExcelContent
 */
public class ExcelContent implements Serializable {

    private static final long serializeID = 2364782073248974L;

    private String sheetName;

    private int sheetIndex;

    private List<T> contentList;

    /**
     * 总行数
     */
    private int totalRow;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public int getSheetIndex() {
        return sheetIndex;
    }

    public void setSheetIndex(int sheetIndex) {
        this.sheetIndex = sheetIndex;
    }

    public List<T> getContentList() {
        return contentList;
    }

    public void setContentList(List<T> contentList) {
        this.contentList = contentList;
    }
}
