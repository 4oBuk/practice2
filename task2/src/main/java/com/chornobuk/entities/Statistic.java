package com.chornobuk.entities;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statistic statistic)) return false;
        return year.equals(statistic.year) && totalAmountPerType.equals(statistic.totalAmountPerType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, totalAmountPerType);
    }
}
