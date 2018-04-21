package com.cn.bafang.backstage.manage.util;

import com.cn.bafang.backstage.manage.common.exception.BusinessException;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Properties文件加载工具
 * Created by Martin on 2016/7/01.
 */
public class PropertiesUtil {
    public static Properties properties = new Properties();
    public static List<String> configFile = Arrays.asList(
            "payNotify_config.properties", "server_config.properties", "sys_config.properties", "payRequest_config.properties");

    static {
        try {
            for(String fileName:configFile) {
                InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
                if (in != null){
                    properties.load(in);
                }
            }
        } catch (Exception e) {
            throw new BusinessException("读取配置文件错误！");
        }
    }

    public static String getValue(String key){
        return properties.getProperty(key,"");
    }

}

