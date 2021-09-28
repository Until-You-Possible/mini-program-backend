package com.lin.missyou.util;


import com.lin.missyou.bo.PageCounter;

import java.util.Date;

public class CommonUtil {

    public static PageCounter ConvertToPageParameter (Integer start, Integer count) {

        int pageNum = start /  count;
        return PageCounter.builder()
                .page(pageNum)
                .count(count)
                .build();
    }


    public static Boolean isInTimeLine(Date date, Date start, Date end) {
        long time = date.getTime();
        long startTime = start.getTime();
        long endTime = end.getTime();
        return time > startTime && time < endTime;
    }



}
