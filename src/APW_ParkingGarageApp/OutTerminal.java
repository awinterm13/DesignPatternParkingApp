package APW_ParkingGarageApp;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is used to simulate the Out Terminal of a parking garage.
 * @author andre_000
 */
public class OutTerminal {

    
    private final int HOURS_PER_DAY = 24;
    private CustIdValidationStrategy custIdValid;
    private CustomerReceiptFormatStrategy receiptFormat;
    private BusinessInfo bInfo;
    private BusinessReportFormatStrategy reportFormat;
    private FeeStrategy fs;
    private OutputStrategy reportOut;
    private OutputStrategy receiptOut;
    private int totalCarsParked;
    private double totalHoursParked;
    private double totalAmountCharged;
    private FileService fileService;
    private List<Map<String, String>> totalsData;
    private File dataFile;
    private double hoursParkedToday;
    private double amountChargedToday;
    private DateTimeUtilityStrategy dateTimeUtility;

    public OutTerminal() {
    }
    /**
    * This method is used to set all the strategy objects used in the program.
     * @param custIdValid CustIdValidationStrategy object
    * @param bInfo BusinessInfo object
    * @param receiptFormat CustomerReceiptFormatStrategy
    * @param reportOut OutputStrategy
    * @param receiptOut OutputStrategy
    * @param fs FeeStrategy object
    * @param br BusinessReportFormatStrategy object
     * @param fileService FileService
     * @param totalsData List of Maps
     * @param dataFile File
     * @param dateTimeUtility DateTimeStrategy
     */
    public final void openForBusiness(CustIdValidationStrategy custIdValid, BusinessInfo bInfo, CustomerReceiptFormatStrategy receiptFormat, OutputStrategy reportOut, OutputStrategy receiptOut, FeeStrategy fs, BusinessReportFormatStrategy br, FileService fileService, List<Map<String, String>> totalsData, File dataFile, DateTimeUtilityStrategy dateTimeUtility) {
        if(bInfo == null || receiptFormat == null || reportOut == null || receiptOut == null || fs == null || br == null || fileService == null || totalsData == null || dataFile == null || dateTimeUtility == null){
            throw new IllegalArgumentException("One of the openForBusiness Paramaters is null");
        }
        this.custIdValid = custIdValid;
        this.bInfo = bInfo;
        this.receiptOut = receiptOut;
        this.reportOut = reportOut;
        this.fs = fs;
        this.reportFormat = br;
        this.receiptFormat = receiptFormat;
        this.fileService = fileService;
        this.totalsData = totalsData;
        this.dataFile = dataFile;
        this.dateTimeUtility = dateTimeUtility;
    }
    /**
     * This method gets information stored in the cars ticket object and sends to to the correct output formatters.
     * It also counts cars, hours, and fees, and stores their running totals and assigns a rng generated outTime.
     * @param car car object. 
     */
    public final void unparkCar(Car car) {
        if (car == null){
            throw new IllegalArgumentException("Car is null.");
        }
        custIdValid.validateCustId(car.getCustId());
        
        totalCarsParked++;
        Random randomNumber = new Random();
        LocalDateTime outTime = car.getInTime().plusHours(randomNumber.nextInt(HOURS_PER_DAY - 1 + 1) + 1);
        hoursParkedToday += dateTimeUtility.differenceBetweenTwoDatesInHours(car.getInTime(), outTime);
        amountChargedToday += fs.calculateFee(Duration.between(car.getInTime(), outTime).toHours());
        totalHoursParked = Double.parseDouble(totalsData.get(0).get("totalHours"));
        totalAmountCharged = Double.parseDouble(totalsData.get(0).get("totalFees"));
        totalHoursParked += dateTimeUtility.differenceBetweenTwoDatesInHours(car.getInTime(), outTime);
        totalAmountCharged += fs.calculateFee(Duration.between(car.getInTime(), outTime).toHours());
        totalsData.get(0).replace("totalHours", String.valueOf(totalHoursParked));
        totalsData.get(0).replace("totalFees", String.valueOf(totalAmountCharged));
        
        
        
        try {
            fileService.writeToFile(dataFile, totalsData);
        } catch (IOException ex) {
            Logger.getLogger(OutTerminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        generateCustomerReceipt(car.getCustId(), bInfo, receiptOut, car.getInTime(), outTime, Duration.between(car.getInTime(), outTime).toHours(), fs.calculateFee(Duration.between(car.getInTime(), outTime).toHours()), dateTimeUtility);
        generateBusinessReport();
    }
    /**
     * sends objects and data to the customerReceiptFormatStrategy object. 
     * @param bInfo BuisnessInfo object
     * @param out OutputStrategy
     * @param inTime LocalDateTime
     * @param outTime LocalDateTime
     * @param hours double
     * @param fee double
     */
    private void generateCustomerReceipt(int custId, BusinessInfo bInfo, OutputStrategy out, LocalDateTime inTime, LocalDateTime outTime, double hours, double fee, DateTimeUtilityStrategy dateTimeUtility) {
         if(bInfo == null || out == null || inTime == null || outTime == null || hours == 0 || fee == 0){
            throw new IllegalArgumentException("Argument null or 0 in generateCustomerReceipt.");
        }
        
        receiptFormat.formatCustomerReceipt(custId, bInfo, out, inTime, outTime, hours, fee, dateTimeUtility);
    }
    
    
    /**
     * Calls the formatBusinessReport method from the BusinessReportFormatStrategy object.
     */
    
    private void generateBusinessReport() {
        
        reportFormat.formatBusinessReport(bInfo, reportOut, totalCarsParked, totalHoursParked, totalAmountCharged, hoursParkedToday, amountChargedToday);
    }

}
