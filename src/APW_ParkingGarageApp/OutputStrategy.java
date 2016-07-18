/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

/**
 * This is an abstract interface used to set different output methods.
 * @author andre_000
 */
public abstract interface OutputStrategy {
    /**
     * Contractual method of the outputStrategy interface
     * @param string 
     */
    public abstract void output(String string);

}
