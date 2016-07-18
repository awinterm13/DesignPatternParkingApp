/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

import java.time.LocalDateTime;

/**
 *
 * @author andre_000
 */
public abstract interface DateTimeUtilityStrategy {

    /**
     * This Method takes a LocalDateTime and formats it into a predetermined format.
     * @param date
     * @return
     */
    public abstract String dateToString(LocalDateTime date);

    /**
     * This takes two LocalDateTime objects and finds the difference in hours.
     * @param date1 LocalDateTime
     * @param date2 LocalDateTime
     * @return double
     */
    public abstract double differenceBetweenTwoDatesInHours(LocalDateTime date1, LocalDateTime date2);
    
}
