package com.dateformat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/11/12
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataFormat {
    public static String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}
