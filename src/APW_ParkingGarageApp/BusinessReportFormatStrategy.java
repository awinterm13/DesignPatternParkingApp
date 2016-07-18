/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

/**
 * This is an abstract interface used for formating data for business reporting
 * @author andre_000
 */

public abstract interface BusinessReportFormatStrategy {
/**
 * This method takes the following parameters and formats them to the clients requirements.
 * @param bInfo a BusinessIno object
 * @param out a outputStrategy object
 * @param totalCarsParked int
 * @param totalHoursParked double
 * @param totalAmountCharged double
 * @param hoursParkedToday double
 * @param amountChargedToday double
 */
public abstract void formatBusinessReport(BusinessInfo bInfo, OutputStrategy out, 
            int totalCarsParked, double totalHoursParked, double totalAmountCharged,
            double hoursParkedToday, double amountChargedToday);
    
}
