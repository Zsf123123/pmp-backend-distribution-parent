package com.muheda.utils;

/**
 * @desc 字符串解析工具类
 * @author zhangshaofan
 */
public class StringUtils {


    /**
     * 判断字符串是否为空
     * @param data
     * @return
     */
    public static boolean isEmpty(String data) {
        if (null == data || Contans.ZERO == data.trim ( ).length ( )|| Contans.NULL.equals ( data )) {
            return true;
        }
        return false;
    }

    public static String getProjectNameByFullPathName (String fullPathName, String regex){

        if(!isEmpty(fullPathName) && !isEmpty(regex)){
            String[] split = fullPathName.split(regex);
            if(split.length > Contans.ZERO){
                return split[split.length - Contans.ONE];
            }
        }else {
            throw  new IllegalArgumentException("文件名或文件分隔符有误，请检查");
        }

        return null;

    }

}
