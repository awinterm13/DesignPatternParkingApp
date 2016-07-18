
package APW_ParkingGarageApp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * This class is used to simulate a parking lot. 
 * @author andre_000
 */
public class ParkingLot {
    private List<Car> cars = new ArrayList<>();
    private OutTerminal outComp = new OutTerminal();
    /**
     *  getter for the cars list.
     * @return List
     */
    public final List<Car> getCars() {
        return cars;
    }
    /**
     * setter for the cars List
     * @param cars List
     */
    public final void setCars(List<Car> cars) {
        if(cars == null){
             throw new IllegalArgumentException("cars cannot be null.");
        }
        this.cars = cars;
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
     * @param dateTimeUtility USADateTimeUtility
     */
    
    public final void openForBusiness(CustIdValidationStrategy custIdValid, BusinessInfo bInfo, 
            CustomerReceiptFormatStrategy receiptFormat, OutputStrategy reportOut, 
            OutputStrategy receiptOut, FeeStrategy fs, BusinessReportFormatStrategy br, 
            FileService fileService, List<Map<String, String>> totalsData, File dataFile, 
            DateTimeUtilityStrategy dateTimeUtility) throws IllegalArgumentException{
         
        if(bInfo == null || receiptFormat == null || reportOut == null || receiptOut == null || fs == null || br == null || fileService == null || totalsData == null || dataFile == null || dateTimeUtility == null){
            throw new IllegalArgumentException("One of the openForBusiness Paramaters is null");
        }
        outComp.openForBusiness(custIdValid, bInfo, receiptFormat, reportOut, receiptOut, fs, br, fileService, totalsData, dataFile, dateTimeUtility );
    }
    /**
     * This method takes a car object and stores it in an array.
     * This was done to simulate a parking lot. 
     * It then runs a private method oneDayGoesBy
     * this simulates time passing.
     * 
     * @param car Car
     */
    
    public final void parkCar(Car car) {
        if (car == null){
            throw new IllegalArgumentException("Car cannot be null.");
        }
        cars.add(car);
    }
    /**
     * This method calls the OutTerminal unparkCar method and passes in a Car object.
     * @param car 
     */
    public final void unparkCar(Car car){
        if(car == null){
             throw new IllegalArgumentException("car cannot be null.");
        }
        outComp.unparkCar(car);
    }
}
    
   
    
    
    

