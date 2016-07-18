/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

/**
 * This plays the role of a FeeStrategy that is used to set Fee calculations.
 * @author andre_000
 */
public class MinimumMaximumFeeCalculator implements FeeStrategy {

    private double minimumFee = 2.00;
    private int minimumHours = 3;
    private double hourlyRate = .50;
    private double maximumFee = 10.00;

    public MinimumMaximumFeeCalculator() {
    }
    /**
     * Getter for MinimumFee
     * @return 
     */
    public final double getMinimumFee() {
        return minimumFee;
    }
    /**
     * setter for MinimumFee 
     * @param minimumFee double
     */
    public final void setMinimumFee(double minimumFee) {
        if(minimumFee <= 0){
             throw new IllegalArgumentException("Minimum Fee must be greater then 0.");
        }
        this.minimumFee = minimumFee;
    }
    /**
     * getter for MinimumHours
     * @return int
     */
    public final int getMinimumHours() {
        return minimumHours;
    }
    /**
     * setter for MinimumHours
     * @param minimumHours  int
     */
    public final void setMinimumHours(int minimumHours) {
        if(minimumHours <= 0){
             throw new IllegalArgumentException("minimumHours must be greater than 0.");
        }
        this.minimumHours = minimumHours;
    }
    /**
     * Getter for hourly rate
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
     * @return double
     */
    public final double getMaximumFee() {
        return maximumFee;
    }
    /**
     * Setter for MaximumFee
     * @param maximumFee double
     */
    public final void setMaximumFee(double maximumFee) {
        if(maximumFee <= 0){
             throw new IllegalArgumentException("maximumFee must be Greater than 0.");
        }
        this.maximumFee = maximumFee;
    }
    
    /**
     * This method calculates and returns the fee per car based on the client requirements.
     * @param hoursParked double
     * @return a double 
     */
    
    @Override
    public final double calculateFee(double hoursParked) {
        if(hoursParked <= 0){
            throw new IllegalArgumentException("hoursParked must be greater than 0.");
        }
        
        if (hoursParked <= 3) {
            return minimumFee;
        } else if ((Math.ceil(hoursParked - minimumHours) * hourlyRate + minimumFee) < maximumFee) {
            return Math.ceil(hoursParked - minimumHours) * hourlyRate + minimumFee;
        } else {
            return maximumFee;
        }
    }
}
