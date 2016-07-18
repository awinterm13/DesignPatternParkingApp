/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

/**
 * An Interface for different custId Validator Strategies.
 * @author andre_000
 */
public abstract interface CustIdValidationStrategy {
    
    /**
     * A contractual abstract method of this interface. 
     * @param custID 
     */
    public abstract void validateCustId(int custID);
    
}
