/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program is very simple Parking Garage Simulator.
 *
 *
 * @author andre_000
 */
public class StartUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InTerminal inComp = new InTerminal();

        File dataFile = new File("src/totals.txt");

        FileService fileService = new FileService(new TextReader(new CustomFormatter()),
                new TextWriter(new CustomFormatter()));

        List<Map<String, String>> totalsData = null;

        try {
            totalsData = fileService.readFile(dataFile);
        } catch (IOException ex) {
            Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArrayIndexOutOfBoundsException e) {
            try {
                fileService.recoverLostData(dataFile);
                totalsData = fileService.readFile(dataFile);
            } catch (IOException ex) {
                Logger.getLogger(StartUp.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }

        try {
            inComp.openForBusiness(new CustIdMaximum10000Validator(), new BusinessInfo(), new StandardFormatCustomerReceipt(),
                    new JOptionPaneOutput(), new ConsoleOutput(), new MinimumNoMaximumFeeCalculator(),
                    new LongBusinessReport(), fileService, totalsData, dataFile, new USADateTimeUtility());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InTerminalGUI(inComp).setVisible(true);
            }
        });

    }

}
