package com.chornobuk.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fine {
    
    private LocalDateTime dateTime;
    
    @JsonProperty("first_name")
    private String firstName;
    
    @JsonProperty("last_name")
    private String lastName;
    
    @JsonProperty("type")
    private FineType type;

    @JsonProperty("fine_amount")
    private BigDecimal fineAmount;

    public Fine() {

    }

    public Fine(LocalDateTime dateTime, String firstName, String lastName, FineType type, BigDecimal fineAmount) {
        this.dateTime = dateTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.fineAmount = fineAmount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(BigDecimal fineAmount) {
        this.fineAmount = fineAmount;
    }

    public FineType getType() {
        return type;
    }

    public void setType(FineType type) {
        this.type = type;
    }

    @JsonProperty("date_time")
    public void setDataFromXml(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        dateTime = LocalDateTime.parse(date, formatter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fine fine)) return false;
        return dateTime.equals(fine.dateTime) && firstName.equals(fine.firstName) && lastName.equals(fine.lastName) && type == fine.type && fineAmount.equals(fine.fineAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, firstName, lastName, type, fineAmount);
    }
}
