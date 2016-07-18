package APW_ParkingGarageApp;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * This class is used to simulate an in terminal for a parking garage.
 * @author andre_000
 */
public class InTerminal {
    private int custId = 1000;
    private LocalDateTime inTime = LocalDateTime.now();
    private ParkingLot parkingLot = new ParkingLot();

    
    /**
     * Getter for the parkingLot's list of cars
     * @return 
     */
    public final List getParkingLotCarList() {
        return parkingLot.getCars();
    }
    /**
     *  This method calls the parkingLots unparkCar method.
     * @param car 
     */
    public final void unparkCar(Car car){
       parkingLot.unparkCar(car);
    }
    
    /**
     * this is a setter for the parkingLot object.
     * @param parkingLot 
     */
    public final void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
    /**
     * This is a getter for the parkingLot object.
     * @return 
     */
    public final ParkingLot getParkingLot() {
        return parkingLot;
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
     * @param fileService
     * @param totalsData
     * @param dataFile
     * @param dateTimeUtility
 */
    public final void openForBusiness(CustIdValidationStrategy custIdValid, BusinessInfo bInfo, 
            CustomerReceiptFormatStrategy receiptFormat, OutputStrategy reportOut, 
            OutputStrategy receiptOut, FeeStrategy fs, BusinessReportFormatStrategy br, 
            FileService fileService, List<Map<String, String>> totalsData, File dataFile, 
            DateTimeUtilityStrategy dateTimeUtility) throws IllegalArgumentException {
        
            if(bInfo == null || receiptFormat == null || reportOut == null || receiptOut == null || 
                    fs == null || br == null || fileService == null || totalsData == null || 
                    dataFile == null || dateTimeUtility == null){
            throw new IllegalArgumentException("One of the openForBusiness Paramaters is null");
        }
        
        
        
        parkingLot.openForBusiness(custIdValid, bInfo, receiptFormat, reportOut, receiptOut, fs, br, fileService, totalsData, dataFile, dateTimeUtility);
    }
/**
 * This method takes a car and sets its ticket information.
 * Then sends it to the parkingLot class.
 * @param car Car object
 * 
 */
    public final void parkNewCar(Car car) {
        if(car == null){
            throw new IllegalArgumentException("Car is null");
        }
        car.setTicket(inTime);
        car.setCustId(custId);
        parkingLot.parkCar(car);
        custId++;
    }
}
