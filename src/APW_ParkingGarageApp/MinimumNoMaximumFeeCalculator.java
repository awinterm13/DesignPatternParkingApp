
package APW_ParkingGarageApp;

/**
 * This plays the role of a FeeStrategy that is used to set Fee calculations.
 * @author andre_000
 */
public class MinimumNoMaximumFeeCalculator implements FeeStrategy {

    
    private double minimumFee = 1.50;
    private int minimumHours = 2;
    private double hourlyRate = .75;
    private double maximumFee = 10.00;

    
    public MinimumNoMaximumFeeCalculator() {
    }
    /**
     * getter for MinimumFee
     * @return 
     */
    public final double getMinimumFee() {
        return minimumFee;
    }
    /**
     * setter for minimumFee
     * @param minimumFee double
     */
    public final void setMinimumFee(double minimumFee) {
        if(minimumFee <= 0){
             throw new IllegalArgumentException("minimumFee must be greater than 0.");
        }
        this.minimumFee = minimumFee;
    }
    /**
     * Getter for MinimumHours
     * @return int
     */
    public final int getMinimumHours() {
        return minimumHours;
    }

    /**
     * Setter MinimumHours
     * @param minimumHours int 
     */
    public final void setMinimumHours(int minimumHours) {
        if(minimumHours <= 0){
             throw new IllegalArgumentException("minimumHours must be greater than 0.");
        }
        this.minimumHours = minimumHours;
    }
    /**
     * Getter for HourlyRate
     * @return double
     */
    public final double getHourlyRate() {
        return hourlyRate;
    }
    /**
     * setter for HourlyRate
     * @param hourlyRate double
     */
    public final void setHourlyRate(double hourlyRate) {
        if(hourlyRate <= 0){
             throw new IllegalArgumentException("hourlyRate must be greater than 0.");
        }
        this.hourlyRate = hourlyRate;
    }
    /**
     * getter for MaximumFee
     * @return  double
     */
    public final double getMaximumFee() {
        return maximumFee;
    }
    /**
     * Setter for MaximumFee
     * @param maximumFee double
     */
    public final void setMaximumFee(double maximumFee) {
        if ( maximumFee <= 0){
             throw new IllegalArgumentException("maximumFee must be greater than 0.");
        }
        this.maximumFee = maximumFee;
    }
    
    /**
    * This method calculates and returns the fee per car based on the client requirements.
    * @param hoursParked double
     */
    
    @Override
    public final double calculateFee(double hoursParked) {
        if ( hoursParked <= 0){     
            throw new IllegalArgumentException("hoursParked must be greater than 0.");
        }
        
        if (hoursParked < minimumHours) {
            return minimumFee;
        } else {
            return Math.ceil(hoursParked - minimumHours) * hourlyRate + minimumFee;
        }
    }

}
