package com.mkee.ladder.com.mkee.ladder.util;

/**
 * ���ڿ� ���� Util
 * Created by wonny on 2015-11-08.
 */
public class StringUtil {

    /**
     * ���ڿ� null äũ
     * @param str ���ڿ�
     * @return null �Ǵ� �� äũ����
     */
    public static boolean isNull(String str){

        boolean flag = false;

        if(str == null || "".equals(str)){
            flag = true;
        }

        return flag;
    }


    /**
     * null �˻� �� ��ü ���ڿ� ��ȯ
     * @param str �⺻ ���ڿ�
     * @param str2 null ��ü�� ���ڿ�
     * @return
     */
    public static String nvl(String str, String str2){

        if(isNull(str)){
            str = str2;
        }

        return str;
    }
}
