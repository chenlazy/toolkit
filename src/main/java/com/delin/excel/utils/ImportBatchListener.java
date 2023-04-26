package com.delin.excel.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.metadata.holder.ReadSheetHolder;
import com.alibaba.excel.util.ListUtils;

import java.util.Map;

/**
 * ImportBatchListener
 *
 * @author: chendl
 * @date: Created in 2023/4/20 11:44
 * @description: com.delin.excel.utils.ImportBatchListener
 */
public class ImportBatchListener extends BatchListener {

    private final ExcelObserver excelObserver;

    private int readCount;

    public ImportBatchListener(ExcelObserver excelObserver) {
        this.excelObserver = excelObserver;
    }

    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        this.invoke(headMap, context);
    }

    @Override
    public void invoke(Map<Integer, String> rowDataMap, AnalysisContext analysisContext) {
        ReadSheetHolder readSheetHolder = analysisContext.readSheetHolder();
        Integer number = readSheetHolder.getApproximateTotalRowNumber();
        getBatchDataList().add(rowDataMap);
        readCount++;
        if (getBatchDataList().size() >= batch_count) {
            notifyExcelContent();
        }
        if (readCount >= number) {
            notifyExcelContent();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }

    private void notifyExcelContent() {
        //推送数据集合
        excelObserver.sendExcelDataContent(getBatchDataList());
        //清理 list
        setBatchDataList(ListUtils.newArrayListWithCapacity(batch_count));
    }
}
