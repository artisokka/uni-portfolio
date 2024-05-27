/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.datetime;

import java.time.*;

/**
 *
 * @author janik
 */
public class Date {

    private int year;
    private int month;
    private int day;


    public Date(int year, int month, int day) throws DateException {
        boolean isLeapYear = false;
        boolean isValid = true;

        if (year > 0) {
            if (year % 4 * 100 == 0) {
                isLeapYear = true;
            }
            if (month > 0 && month < 13) {
                if (day < 0) {
                    isValid = false;
                } else if (month == 2 && isLeapYear) {
                    if (day > 29) {
                        isValid = false;
                    }
                } else if (month == 2) {
                    if (day > 28) {
                        isValid = false;
                    }
                } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    if (day > 31) {
                        isValid = false;
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day > 30) {
                        isValid = false;
                    }
                }
            } else {
                isValid = false;
            }
        } else {
            isValid = false;
        }
        if (!isValid) {
            throw new DateException(String.format("Illegal date %02d.%02d.%d", day, month, year));

        } else {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }
    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;

    }

    public int getDay() {
        return this.day;
    }

    @Override
    public String toString() {
        return String.format("%02d.%02d.%d", day, month, year);
        //day + "." + month + "." + year;
    }


}
