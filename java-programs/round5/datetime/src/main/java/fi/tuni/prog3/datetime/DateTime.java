package fi.tuni.prog3.datetime;

import java.time.Month;

/**
 *
 * @author janik
 */
public class DateTime extends Date {

    private int hour;
    private int minute;
    private int second;
    private boolean isValid = true;

    public DateTime(int year, int month, int day, int hour, int minute, int second) throws DateException {
        super(year, month, day);
        if ((hour < 0 || hour > 23) || (minute < 0 || minute > 59) || (second <
                0 || second > 59)) {
            this.isValid = false;
        }        else if (this.isValid) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
        if (!this.isValid) {
            throw new DateException(String.format("Illegal time %02d:%02d:%02d", hour, minute, second));
        }
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    @Override
    public String toString() {
        String dateTime = super.toString();
        if (this.isValid) {
            dateTime = super.toString() + String.format(" %02d:%02d:%02d", this.hour, this.minute, this.second);
        }
        return dateTime;
    }

}
