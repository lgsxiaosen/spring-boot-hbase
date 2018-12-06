package com.gsliu.hbase.controller;

import com.gsliu.hbase.service.HbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liuguisen
 * @date 2018/12/6 10:02
 * @description
 */
@RestController
public class HbaseController {

    @Autowired
    HbaseService hbaseService;

    @GetMapping("/getRowData")
    public Map<String, String> getRowData(@RequestParam String tableName, @RequestParam String rowKey){
        return hbaseService.getRowData(tableName, rowKey);
    }

}
