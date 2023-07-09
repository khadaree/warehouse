/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wms.util;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author khada
 */
public class StringHelper {
    public static int stringToInt(String numberStr){
        int result =0;
        try{
            result = Integer.parseInt(numberStr);
        }catch(NumberFormatException nfe){}
        return result;
    }

    public static String calendarToString(Calendar calendar){
        if(calendar == null)
            return "";
        Date date = calendar.getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        return dateFormat.format(date);  
    }
}
