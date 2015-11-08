package com.mkee.ladder.com.mkee.ladder.util;

/**
 * 문자열 관련 Util
 * Created by wonny on 2015-11-08.
 */
public class StringUtil {

    /**
     * 문자열 null 채크
     * @param str 문자열
     * @return null 또는 빈값 채크여부
     */
    public static boolean isNull(String str){

        boolean flag = false;

        if(str == null || "".equals(str)){
            flag = true;
        }

        return flag;
    }


    /**
     * null 검사 후 대체 문자열 변환
     * @param str 기본 문자열
     * @param str2 null 대체할 문자열
     * @return
     */
    public static String nvl(String str, String str2){

        if(isNull(str)){
            str = str2;
        }

        return str;
    }
}
