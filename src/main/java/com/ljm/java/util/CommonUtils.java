package com.ljm.java.util;

import java.text.SimpleDateFormat;
import java.util.*;

public final class CommonUtils {

    public static String getLastMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();
        String accDate = format.format(date);
        return accDate;
    }

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };


    /**
     * 字母和数字组合的id
     * len 位数
     * */
    public  static String randomCharsId(Integer len,String start){
        StringBuffer sb = new StringBuffer(start);
        System.out.println(sb.toString());
        for (int i = 0; i < len; i++) {
            int index = (int) (Math.random()* chars.length);
            String aChar = chars[index];
            sb.append(aChar);
        }
        return sb.toString();
    }


    /**
     * len:生成数字的长度
     * count：前缀字母几位
     *
     * */
    public  static String randomChars(Integer len){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 1;i <= len;++i){
            sb.append(random.nextInt(10));
        }
        return  sb.toString();
    }

    public static String getWeekByDate(Date date){
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.clear();// 清除信息
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int index = cal.get(Calendar.DAY_OF_WEEK);
        String weekDay = weekDays[index - 1];
        if(weekDays[0].equals(weekDay) ||weekDays[6].equals(weekDay)){
            return weekDay;
        }
        return null;
    }

    //获取给定时间的周一和周日
    public  static Map<String,Date> getMonAndSun(Date date){
        Map<String,Date> map = new HashMap<String,Date>(2);
        Calendar cld = Calendar.getInstance(Locale.CHINA);
        //以周一为首日
        cld.setFirstDayOfWeek(Calendar.MONDAY);
        //当前时间
        cld.setTime(date);
        //周一
        cld.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        map.put("mon",cld.getTime());
        //周日
        cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        map.put("sun",cld.getTime());
        return map;
    }

    public static int getSexByIdCard(String idCard){
        int i = 0;
        if(idCard.length() == 18){
            //如果身份证号18位，取身份证号倒数第二位
            char c = idCard.charAt(idCard.length() - 2);
            i = Integer.parseInt(String.valueOf(c));
        }else{
            //如果身份证号15位，取身份证号最后一位
            char c = idCard.charAt(idCard.length() - 1);
            i = Integer.parseInt(String.valueOf(c));
        }
        return i;
    }



    /***
     *
     * @param startDateOne 第一个时间段的开始时间
     * @param endDateOne 第一个时间段的结束时间
     * @param startDateTwo 第二个时间段的开始时间
     * @param endDateTwo 第二个时间段的结束时间
     * @return
     */
    public static Boolean timeConflict(Date startDateOne,Date endDateOne,Date startDateTwo,Date endDateTwo)
    {
        Date maxStartDate = startDateOne;
        if(maxStartDate.before(startDateTwo))
        {
            maxStartDate = startDateTwo;
        }

        Date minEndDate = endDateOne;
        if(minEndDate.after(endDateTwo))
        {
            minEndDate = endDateTwo;
        }
        if(maxStartDate.before(minEndDate) || (maxStartDate.getTime() == minEndDate.getTime()))
        {
            return true;
        }
        else {
            return  false;
        }
    }
}
