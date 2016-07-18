/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APW_ParkingGarageApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This is a class that Writes to a file.
 *
 * @author andre_000
 */
public class TextWriter {

    private FileServiceTextFormatStrategy formatter;

    /**
     * Constructor for TextWriter it takes a FileServiceTextFormatStrategy
     * object.
     *
     * @param formatter
     */
    public TextWriter(FileServiceTextFormatStrategy formatter) {
        if (formatter == null) {
            throw new IllegalArgumentException("TextWriter has been given a null formatter.");
        }

        this.formatter = formatter;
    }

    /**
     * This method takes a list of maps and formats them using a
     * FileServiceTextFormatStrategy object Then it writes it to the file
     * overwriting the data there.
     *
     * @param file File
     * @param data List of Maps
     * @throws IOException
     */
    public final void overWriteFile(File file, List<Map<String, String>> data) throws IOException {
        if (data == null || file == null) {
            throw new IllegalArgumentException("overWriteFile has been passed a null value.");
        }
        boolean append = false;
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, append)));
        out.println(formatter.encode(data));
        out.close();
    }

    /**
     * This method takes a list of maps and formats them using a
     * FileServiceTextFormatStrategy object Then it writes it to the file
     * overwriting the data there.
     *
     * @param file File
     * @param data List of Maps
     * @throws IOException
     */
    public final void appendToFile(File file, List<Map<String, String>> data) throws IOException {
        if (file == null || data == null) {
            throw new IllegalArgumentException("appendToFile has been passed a null value.");
        }
        boolean append = true;
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, append)));
        out.println(formatter.encode(data));
        out.close();
    }
    /**
     * This method is to be used if the data in the file is missing to reset the values to 0.
     * @param file File
     * @throws IOException 
     */
    public final void recoverLostData(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("Data unrecoverable. File is null.");
        }

        boolean append = false;
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, append)));
        out.println("0 0");
        out.close();
    }
}
