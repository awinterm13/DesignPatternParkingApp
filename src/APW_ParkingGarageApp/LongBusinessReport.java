/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

import java.text.NumberFormat;

/**
 * This plays the role of a BusinessReportFormatStrategy used for formating data for business reporting.
 * @author andre_000
 */
public class LongBusinessReport implements BusinessReportFormatStrategy {
     private NumberFormat nf = NumberFormat.getCurrencyInstance();
    private final String CRLF = "\n";
    private final String CRLF2 = "\n\n";

    
/**
  * This method takes the following parameters and formats them to the clients requirements.
 * @param bInfo a BusinessIno object
 * @param out a outputStrategy object
 * @param totalCarsParked int
 * @param totalHoursParked double
 * @param totalAmountCharged double
 * @param amountChargedToday double
 */
    
    @Override
    public final void formatBusinessReport(BusinessInfo bInfo, OutputStrategy out, int totalCarsParked,
            double totalHoursParked, double totalAmountCharged, double hoursParkedToday, double amountChargedToday) {
        if(bInfo == null || out == null || totalCarsParked == 0 || totalHoursParked == 0 || totalAmountCharged == 0 ||
                hoursParkedToday < 0 || amountChargedToday < 0){
        throw new IllegalArgumentException("Business Report element missing.");
        }
        double averageHoursParked = hoursParkedToday / totalCarsParked;
        double averageFeeCollectedPerCar = amountChargedToday / totalCarsParked;
        double averageFeeCollectedPerParkedHour = amountChargedToday / hoursParkedToday;
        StringBuilder reportData = new StringBuilder("Status Report for " + bInfo.getName() + "\n\n");
        reportData.append("Total cars parked Today: ").append(totalCarsParked).append(CRLF);
        reportData.append("Total hours parked: ").append(totalHoursParked).append(CRLF);
        reportData.append("Total amount collected: ").append(nf.format(totalAmountCharged)).append(CRLF2);
        reportData.append("Total cars parked Today: ").append(totalCarsParked).append(CRLF);
        reportData.append("Average fee per car today: ").append(nf.format(averageFeeCollectedPerCar)).append(CRLF);
        reportData.append("Average fee collected per hour today: ").append(nf.format(averageFeeCollectedPerParkedHour)).append(CRLF);
        reportData.append("Average hours parked per car today: ").append(averageHoursParked).append(CRLF);
        out.output(reportData.toString());
    }
}
