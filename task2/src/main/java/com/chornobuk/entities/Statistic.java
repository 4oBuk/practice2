package com.chornobuk.entities;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Map;

public class Statistic {
    private Year year;
    private Map<FineType, BigDecimal> totalAmountPerType;

    public Map<FineType, BigDecimal> getTotalAmountPerType() {
        return totalAmountPerType;
    }

    public void setTotalAmountPerType(Map<FineType, BigDecimal> totalAmountPerType) {
        this.totalAmountPerType = totalAmountPerType;
    }

    public Statistic() {
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Statistic(Year year, Map<FineType, BigDecimal> totalAmountPerType) {
        this.year = year;
        this.totalAmountPerType = totalAmountPerType;
    }

}
