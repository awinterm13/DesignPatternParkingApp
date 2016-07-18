/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;


import java.util.List;
import java.util.Map;

/**
 * Text Format Strategy Interface for the FileService MGR class.
 * @author andre_000
 */
public abstract interface FileServiceTextFormatStrategy {
    /**
     * Contractual decode method of the FileServiceTextFormatStrategy.
     * @param data
     * @return 
     */
    public abstract List<Map<String, String>> decode(String data);
    /**
     * Contractual encode method of the FileServiceTextFormatStrategy.
     * @param data
     * @return 
     */
    public abstract String encode(List<Map<String, String>> data);
    
    
}
