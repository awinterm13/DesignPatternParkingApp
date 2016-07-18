/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

import javax.swing.JOptionPane;

/**
 * This class plays the role of an OutputStrategy, it outputs a string to a JOptionpane. 
 * 
 * @author andre_000
 */
public class JOptionPaneOutput implements OutputStrategy {
    /**
     * This method outputs a string to a JOptionpane. 
     * @param line 
     */
    @Override
    public final void output(String line) {
        if("".equals(line) || line == null){
            throw new IllegalArgumentException("Nothing to output.");
        }
        
        JOptionPane.showMessageDialog(null, line);
    }
}
