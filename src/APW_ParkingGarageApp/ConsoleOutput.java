/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

/**
 * This class plays the role of an OutputStrategy, it outputs to the console. 
 * Used to simulate a receipt printer.
 * @author andre_000
 */
public class ConsoleOutput implements OutputStrategy {
    /**
     * This method outputs a string to the console.
     * @param string 
     */
    @Override
    public final void output(String string) {
        if( string == null || "".equals(string)){
            throw new IllegalArgumentException("Nothing to Output.");
        }
        
        System.out.println(string);
    }
}
