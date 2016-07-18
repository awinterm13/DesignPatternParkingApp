/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

/**
 * This is an abstract interface that is used to implement different Fee calculations.
 * @author andre_000
 */
public abstract interface FeeStrategy {
    
    
/**
 * This method calculates and returns the fee per car based on the client requirements.
 * @param hours double
 * @return 
 */
    public abstract double calculateFee(double hours);
  
}
