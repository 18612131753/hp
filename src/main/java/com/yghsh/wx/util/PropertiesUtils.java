package com.yghsh.wx.util;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtils {
	
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
    
    private static ConcurrentMap<String,Properties> propertiesMap=new ConcurrentHashMap<String,Properties>();

    /**
     * 获取配置文件属性
     * */
    public static String getPerVal(String fileName,String key){
        String val=null;
        Properties properties=null;
        if(fileName==null||"".equals(fileName)||key==null||"".equals(key)){
            logger.info("读取配置信息失败，入参信息不全");
            return "";
        }
        try{
            if(propertiesMap.get(fileName)!=null){
                return propertiesMap.get(fileName).getProperty(key);
            }else{
                InputStream in =PropertiesUtils.class.getResourceAsStream(fileName);
                properties=new Properties();
                properties.load(in);
                val=properties.getProperty(key);
                propertiesMap.put(fileName,properties);
                in.close();
            }
        }catch(Exception e){
            logger.info("加载配置信息异常：",e);
        }
        return val;
    }
}
