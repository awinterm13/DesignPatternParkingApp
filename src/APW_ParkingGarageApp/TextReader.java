/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author andre_000
 */
public class TextReader {

    private final FileServiceTextFormatStrategy formatter;
    /**
     * Constructor for TextReader requires a formatter
     * @param formatter TextFormatStrategy
     */
    public TextReader(FileServiceTextFormatStrategy formatter) {
        if(formatter == null){
             throw new IllegalArgumentException("TextReader is missing formatter.");
        }
        
        this.formatter = formatter;
    }
    
    /**
     * This Method takes a File object and reads it and then returns a string of what it read.
     * @param file
     * @return String
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public List<Map<String, String>> readFile(File file) throws FileNotFoundException, IOException  {
        if(file == null){
             throw new IllegalArgumentException("Cannot Read Null File.");
        }
        
        BufferedReader in = null;
        StringBuilder data = new StringBuilder();
//        try {
            in = new BufferedReader(new FileReader(file));
            String line = in.readLine();

            while (line != null) {
                data.append(line);
                line = in.readLine();
            }

//        } catch (IOException ioe) {
//            System.out.println(ioe);
//        } finally {
//            try {
//                in.close();
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
        return (formatter.decode(data.toString()));
    }

}
