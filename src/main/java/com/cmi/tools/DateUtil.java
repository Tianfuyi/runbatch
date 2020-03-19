package com.cmi.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * @return
     * 获取当天日期
     */
    public static String getDate(){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String date =df.format(new Date());
        return date;
    }

    public static String getTime(){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date =df.format(new Date());
        return date;
    }
}
