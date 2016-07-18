/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

import java.time.LocalDateTime;

/**
 * This is an abstract interface that is used to format the customer receipt.
 * @author andre_000
 */
public abstract interface CustomerReceiptFormatStrategy {
/**
 * This method takes the following data and formats the receipt to the clients requirements.
 * @param custID int
 * @param bInfo BusinessInfo object
 * @param output OutputStrategy object
 * @param inTime localDateTime object
 * @param outTime LocalDateTime object
 * @param hours double
 * @param fee double
 * @param dateTimeUtility USADateTimeUtility
 */
    public abstract void formatCustomerReceipt(int custID, BusinessInfo bInfo, OutputStrategy output, LocalDateTime inTime, LocalDateTime outTime, double hours, double fee, DateTimeUtilityStrategy dateTimeUtility);
}
