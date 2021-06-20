package com.lin.missyou.util;


import com.lin.missyou.bo.PageCounter;

public class CommonUtil {

    public static PageCounter ConvertToPageParameter (Integer start, Integer count) {

        int pageNum = start /  count;
        return PageCounter.builder()
                .page(pageNum)
                .count(count)
                .build();
    }

}
