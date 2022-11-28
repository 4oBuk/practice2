package com.chornobuk.testdata;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import com.chornobuk.entities.FineType;
import com.chornobuk.entities.Statistic;

public class TestStatisticData {
    public static Statistic getStatistic2020() {
        Map<FineType, BigDecimal> typeAmountMap = new LinkedHashMap<>();
        typeAmountMap.put(FineType.DRUNKDRIVING, new BigDecimal("60000"));
        typeAmountMap.put(FineType.PARKING, new BigDecimal("3000"));
        typeAmountMap.put(FineType.SPEEDING, new BigDecimal("840.50"));
        int year = 2020;
        return new Statistic(year, typeAmountMap);
    }

    public static Statistic getStatistic2021() {
        Map<FineType, BigDecimal> typeAmountMap = new LinkedHashMap<>();
        typeAmountMap.put(FineType.PARKING, new BigDecimal("60000"));
        typeAmountMap.put(FineType.SPEEDING, new BigDecimal("3000"));
        typeAmountMap.put(FineType.DRUNKDRIVING, new BigDecimal("840.50"));
        int year = 2021;
        return new Statistic(year, typeAmountMap);
    }
}
