package com.delin.excel.utils;

import com.alibaba.excel.event.AnalysisEventListener;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * BatchListener
 *
 * @author: chendl
 * @date: Created in 2023/4/20 11:42
 * @description: com.delin.excel.utils.BatchListener
 */
public abstract class BatchListener extends AnalysisEventListener<Map<Integer, String>> {

    /**
     * 分批条数，每过5000条写入到文件中
     */
    protected static final int batch_count = 5000;

    private List<Map<Integer, String>> batchDataList = new ArrayList<>(batch_count);


    public List<Map<Integer, String>> getBatchDataList() {
        return batchDataList;
    }

    public void setBatchDataList(List<Map<Integer, String>> batchDataList) {
        this.batchDataList = batchDataList;
    }
}
