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


/**
 *  This is a mgr class that makes use of an abstract reader and writer class. 
 *  It reads and writes to a file.
 * @author andre_000
 */
public class FileService {
       private TextReader reader;
       private TextWriter writer;

    /**
     * Constructor, takes a TextReader and a TextWriter object.
     * @param reader TextReader
     * @param writer TextWriter
     */   
    public FileService(TextReader reader, TextWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
    
    /**
     * This calls the readers readFile method on a file object.
     * Throws an IOException.
     * @param file File
     * @return List of Maps
     * @throws IOException 
     */
    public final List<Map<String, String>> readFile(File file) throws IOException {
        return reader.readFile(file);     
    }  
    
    /**
     *  This Takes a file object and then calls the writers writeToFile method to convert data from 
     *  a list of Maps to a file.
     * Throws a IOException.
     * @param file File
     * @param data List of Maps
     * @throws IOException 
     */
    public final void writeToFile(File file, List<Map<String, String>> data) throws IOException{
        writer.overWriteFile(file, data);
    }
        
    public final void recoverLostData(File file) throws IOException{
        writer.recoverLostData(file);
    }

}
