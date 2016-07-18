/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

/**
 * This is an experiment in validation. It only validates custId properties on an made up requirement. 
 * This is a great idea and will be played with over the break. 
 * @author andre_000
 */
public class CustIdMaximum10000000Validator implements CustIdValidationStrategy {
    private final int MAX_CUSTID = 10000000;
    
    /**
     * This overrides the abstract method from the CustIdValidationStrategy interface.
     * If custID greater then 10000000 it throws an exception.
     * @param custId int
     */
    @Override
    public final void validateCustId(int custId){
        if(custId > MAX_CUSTID ){
            throw new IllegalArgumentException("Too many cars parked today, something is wrong.");
        }
    }
    // Jim showed me a boolean version that is more portable. If this is future drew and you are looking for that info
    // check your google drive, you saved a picture of it. 
}