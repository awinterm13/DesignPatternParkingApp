/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

import java.text.NumberFormat;

import java.time.LocalDateTime;

/**
 * This plays the role of a CustomerReceiptFormatStrategy that is used to format the customer receipt.
 * @author andre_000
 */
public class WideFormatCustomerReceipt implements CustomerReceiptFormatStrategy {
    private NumberFormat nf = NumberFormat.getCurrencyInstance();
    final String CRLF = "\n";
    final String CRLF2 = "\n\n";

    /**
    * This method takes the following data and formats the receipt to the clients requirements.
    * It then passes that data to a output object.
    * @param bInfo BusinessInfo object
    * @param output OutputStrategy object
    * @param inTime localDateTime object
    * @param outTime LocalDateTime object
    * @param hours double
    * @param fee double
     */
    @Override
    public final void formatCustomerReceipt(int custID, BusinessInfo bInfo, OutputStrategy output, LocalDateTime inTime, LocalDateTime outTime, double hours, double fee, DateTimeUtilityStrategy dateTimeUtility) {
         if(bInfo == null || output == null || inTime == null || outTime == null || hours == 0 || fee == 0 || dateTimeUtility == null){
            throw new IllegalArgumentException("formatCustomerReceipt cannot use null values");
        }
        StringBuilder customerReceiptData = new StringBuilder("THANK YOU FOR PARKING AT " + bInfo.getName() + ".\n\n");
        customerReceiptData.append("Cust ID:        \t\t\t").append(custID).append(CRLF);
        customerReceiptData.append("In Time:        \t\t\t").append(dateTimeUtility.dateToString(inTime)).append(CRLF);
        customerReceiptData.append("Out Time:       \t\t\t").append(dateTimeUtility.dateToString(outTime)).append(CRLF);
        customerReceiptData.append("Hours Parked:   \t\t\t").append(hours).append(CRLF);
        customerReceiptData.append("Amount charged: \t\t\t").append(nf.format(fee)).append(CRLF);
        customerReceiptData.append("----------------------------------------").append(CRLF2);
        output.output(customerReceiptData.toString());
    }
}
