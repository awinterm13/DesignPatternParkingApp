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
public class ShortBusinessReport implements BusinessReportFormatStrategy {
    private NumberFormat nf = NumberFormat.getCurrencyInstance();
    final String CRLF = "\n";
    final String CRLF2 = "\n\n";

    
    
/**
 * This method takes the following parameters and formats them to the clients requirements
 * then sends the string to an OutputStrategy.
 * @param bInfo a BusinessIno object
 * @param out a outputStrategy object
 * @param totalCarsParked int
 * @param totalHoursParked double
 * @param totalAmountCharged double
 */
    @Override
    public final void formatBusinessReport(BusinessInfo bInfo, OutputStrategy out, int totalCarsParked,
            double totalHoursParked, double totalAmountCharged, double hoursParkedToday, double amountChargedToday) {
        if(bInfo == null || out == null || totalCarsParked == 0 || totalHoursParked == 0 || totalAmountCharged == 0 ||
                hoursParkedToday < 0 || amountChargedToday < 0){
            throw new IllegalArgumentException("formatBusinessReport has been passed a null or 0.");
        }
        StringBuilder reportData = new StringBuilder("Status Report for " + bInfo.getName() + "\n\n");
        reportData.append("Total cars parked today: ").append(totalCarsParked).append(CRLF);
        reportData.append("Total hours parked today: ").append(hoursParkedToday).append(CRLF);
        reportData.append("Total amount collected today: ").append(nf.format(amountChargedToday)).append(CRLF2);

        out.output(reportData.toString());

    }

}
