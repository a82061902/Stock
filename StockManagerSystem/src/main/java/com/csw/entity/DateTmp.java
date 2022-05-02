package com.csw.entity;

public class DateTmp {
    private Integer year;
    private String month;
    private Integer count;

    public DateTmp() {
    }

    public DateTmp(Integer year, String month, Integer count) {
        this.year = year;
        this.month = month;
        this.count = count;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "DateTmp{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", count=" + count +
                '}';
    }
}
