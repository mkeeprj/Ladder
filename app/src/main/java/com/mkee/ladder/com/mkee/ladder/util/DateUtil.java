package com.mkee.ladder.com.mkee.ladder.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by wonny on 2015-11-08.
 */
public class DateUtil {

    /**
     * 현재날짜
     * 패턴 0:    yyyymmdd
     * 패턴 1:    yyyyMMddHHmmss
     * @param nPattern
     * @return
     *
     *  필요시 추가 기존 패턴 삭제 금지
     */
    public static String getDate(int nPattern){

        String pattern;

        if(nPattern == 1){
            pattern = "yyyyMMddHHmmss";
        }else{
            pattern = "yyyyMMdd";
        }

        Date dt = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        String date = sdf.format(dt);

        return date;
    }

    public static String getPatternDate(String sDate){

        if(sDate == null || StringUtil.isNull(sDate)){
            return sDate;
        }

        String date;

        String yyyy = sDate.substring(0,4);
        String mm = sDate.substring(4,6);
        String dd = sDate.substring(6,8);
        String hh = sDate.substring(8,10);
        String mm2 = sDate.substring(10,12);
        String ss = sDate.substring(12,14);

        if(sDate.length() == 8){
            date = yyyy + "-" + mm + "-" + dd;
        }else{
            date = yyyy + "-" + mm + "-" + dd + " " + hh + ":" + mm2 + ":" + ss;
        }

        return date;
    }
}
