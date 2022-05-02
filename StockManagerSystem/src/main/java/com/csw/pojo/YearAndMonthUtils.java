package com.csw.pojo;

import com.csw.common.vo.YearAndMonth;

public class YearAndMonthUtils {

    private YearAndMonthUtils() {
    }

    public static YearAndMonth monthInit(YearAndMonth yearAndMonth){
        yearAndMonth.setJanuary(0);
        yearAndMonth.setFebruary(0);
        yearAndMonth.setMarch(0);
        yearAndMonth.setApril(0);
        yearAndMonth.setMay(0);
        yearAndMonth.setJune(0);
        yearAndMonth.setJuly(0);
        yearAndMonth.setAugust(0);
        yearAndMonth.setSeptember(0);
        yearAndMonth.setOctober(0);
        yearAndMonth.setNovember(0);
        yearAndMonth.setDecember(0);

        return yearAndMonth;
    }

}
