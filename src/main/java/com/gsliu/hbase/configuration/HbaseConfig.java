package com.gsliu.hbase.configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author liuguisen
 * @date 2018/12/5 17:37
 * @description
 */
@Configuration
@EnableConfigurationProperties(HbaseProperties.class)
public class HbaseConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final HbaseProperties properties;
    public static Connection connection;
    public HbaseConfig(HbaseProperties properties) {
        this.properties = properties;
    }
    @Bean
    public void configuration() {
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
        Map<String, String> config = properties.getConfig();
        Set<String> keySet = config.keySet();
        for (String key : keySet) {
            configuration.set(key, config.get(key));
        }

        try {
            connection = ConnectionFactory.createConnection(configuration);
            logger.info("获取connectiont连接成功！");
        } catch (IOException e) {
            e.printStackTrace ();
            logger.error("获取connectiont连接失败！");
        }
    }


}
