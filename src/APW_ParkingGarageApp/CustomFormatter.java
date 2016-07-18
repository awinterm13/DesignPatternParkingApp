/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;


import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the CustomFormatter used by the FileService's readers and writers. 
 * It has a decode and encode method for reading from a file and writing to it. 
 * It converts strings to Lists and Lists to Strings.
 * @author andre_000
 */
public class CustomFormatter implements FileServiceTextFormatStrategy {

    /**
     * Takes a Big String and breaks it up into an array on the " "'s.
     * Then puts those into a Map and finally into a List of Maps.
     * @param data String
     * @return List of Maps
     */
    @Override
    public final List<Map<String, String>> decode(String data) {
        if(data == null){
            throw new IllegalArgumentException("Nothing to decode");
        }
        String[] dataPieces = data.split(" ");
        Map<String, String> record = new LinkedHashMap<>();
        record.put("totalHours", dataPieces[0]);
        record.put("totalFees", dataPieces[1]);
        List<Map<String, String>> records = new ArrayList<>();
        records.add(record);
        return records;
    }
    /**
     * Encode takes a List of Maps and turns them into a String.
     * @param data List of Maps
     * @return String
     */
    @Override
    public final String encode(List<Map<String, String>> data) {
        if(data == null){
             throw new IllegalArgumentException("Nothing to encode");
        }
        String dataAsString = data.get(0).get("totalHours") + " " + data.get(0).get("totalFees");
        return dataAsString;
    }
    
}
