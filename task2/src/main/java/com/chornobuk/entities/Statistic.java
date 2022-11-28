package com.chornobuk.entities;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class Statistic {
    private Integer year;
    private Map<FineType, BigDecimal> totalAmountPerType;

    public Map<FineType, BigDecimal> getTotalAmountPerType() {
        return totalAmountPerType;
    }

    public void setTotalAmountPerType(Map<FineType, BigDecimal> totalAmountPerType) {
        this.totalAmountPerType = totalAmountPerType;
    }

    public Statistic() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Statistic(int year, Map<FineType, BigDecimal> totalAmountPerType) {
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
