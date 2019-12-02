package com.muheda.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc 读取配置文件类，获取application.properties的信息
 */
public class ReadProperty {
    private static Log logger = LogFactory.getLog(ReadProperty.class);
    /**
     * 系统配置变量
     */
    private static volatile Map<String, String> confDataMap = null;

    /**
     * 获取系统变量
     *
     * @param key
     * @return
     */
    public static String getConfigData(String key) {

        if (confDataMap != null) {
            return confDataMap.get(key);
        }

        InputStream sysInputStream = null;
        InputStream devInputStream = null;
        confDataMap = new ConcurrentHashMap<>(16);
        try {

            sysInputStream = ReadProperty.class.getResourceAsStream("/application.properties");

            Properties prop = new Properties();

            prop.load(sysInputStream);

            String valueString = prop.getProperty("sys.config.file");
            if (Contans.APPLICATION_PROPERTIES.equals(valueString)) {
                Iterator<String> it = prop.stringPropertyNames().iterator();
                String proKeyString;
                while (it.hasNext()) {
                    proKeyString = it.next();
                    confDataMap.put(proKeyString, prop.getProperty(proKeyString));
                }
                return confDataMap.get(key);
            }

            // 若非正式环境下的配置文件
            confDataMap.clear();
            devInputStream = ReadProperty.class.getResourceAsStream("/" + valueString);
            prop = new Properties();
            prop.load(devInputStream);
            Iterator<String> it = prop.stringPropertyNames().iterator();
            String proKeyString;
            while (it.hasNext()) {
                proKeyString = it.next();
                confDataMap.put(proKeyString, prop.getProperty(proKeyString));
            }
            return confDataMap.get(key);

        } catch (Exception e) {
            logger.error(e);
            return null;
        } finally {
            try {
                if (sysInputStream != null) {
                    sysInputStream.close();
                }
                if (devInputStream != null) {
                    devInputStream.close();
                }
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }




}