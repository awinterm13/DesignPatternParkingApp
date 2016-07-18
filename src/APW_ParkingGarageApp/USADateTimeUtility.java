/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This is a very simple dateTime Utility, it provides some basic methods for date calculations and formatting.
 * @author andre_000
 */
public class USADateTimeUtility implements DateTimeUtilityStrategy {
        // this is rigidity you can remove if you have time. I don't think Jim will knock you for it.
        // If you really have time, Factory pattern USA vs EUROPE.
        // If you want to sell this program out of the USA you have to make these constants an enum and factory this.
        private final String USA_DATE_FORMAT = "MM-dd-yyyy hh:mm";
      
        
        

        public USADateTimeUtility() {
        }
        
       
        /**
         * This Method takes a LocalDateTime and formats it into a predetermined format.
         * @param date
         * @return 
         */
    @Override
        public final String dateToString(LocalDateTime date){
        if(date == null){
          throw new IllegalArgumentException("Date must not be null.");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(USA_DATE_FORMAT);
        String formattedDate = date.format(formatter);
        return formattedDate;
        }
        
        /**
         * This takes two LocalDateTime objects and finds the difference in hours.
         * @param date1 LocalDateTime
         * @param date2 LocalDateTime
         * @return double
         */
    @Override
        public final double differenceBetweenTwoDatesInHours(LocalDateTime date1, LocalDateTime date2){
             if( date1 == null || date2 == null ){
          throw new IllegalArgumentException("Date objects cannot be null.");
        }
            return Duration.between(date1, date2).toHours();
        }
        
    
}
