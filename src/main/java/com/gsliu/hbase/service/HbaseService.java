package com.gsliu.hbase.service;

import java.util.List;
import java.util.Map;

/**
 * @author liuguisen
 * @date 2018/12/5 17:41
 * @description
 */
public interface HbaseService {

    boolean createTable(String tableName, List<String> columnFamily);

    boolean createTableBySplitKeys(String tableName, List<String> columnFamily, byte[][] splitKeys);

    byte[][] getSplitKeys(String[] keys);

    byte[][] getHexSplits(String startKey, String endKey, int numRegions);

    List<String> getAllTableNames();

    Map<String,Map<String,String>> getResultScanner(String tableName);

    Map<String,Map<String,String>> getResultScanner(String tableName, String startRowKey, String stopRowKey);

    Map<String,Map<String,String>> getResultScannerPrefixFilter(String tableName, String prefix);

    Map<String,Map<String,String>> getResultScannerColumnPrefixFilter(String tableName, String prefix);

    Map<String,Map<String,String>> getResultScannerRowFilter(String tableName, String keyword);

    Map<String,Map<String,String>> getResultScannerQualifierFilter(String tableName, String keyword);

    Map<String,String> getRowData(String tableName, String rowKey);

    String getColumnValue(String tableName, String rowKey, String familyName, String columnName);

    List<String> getColumnValuesByVersion(String tableName, String rowKey, String familyName, String columnName, int versions);

    void putData(String tableName, String rowKey, String familyName, String[] columns, String[] values);

    void setColumnValue(String tableName, String rowKey, String familyName, String column1, String value1);

    boolean deleteColumn(String tableName, String rowKey, String familyName, String columnName);

    boolean deleteRow(String tableName, String rowKey);

    boolean deleteColumnFamily(String tableName, String columnFamily);

    boolean deleteTable(String tableName);
}
