/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Charles Navarro
 */
public class CSVWriter extends User{
    private static final String CSV_SEPARATOR_SLASH = "/";
    private static final String CSV_SEPARATOR_COMMA = ",";
    private static final String CSV_SEPARATOR_SEMICOLON = ":";
    private static final String CSV_SEPARATOR_NEXTLINE = "\n";
    private static final String FILE_HEADER = "Username, Password, Date and Time";
    
    ArrayList<CSVWriter> eventWriteCSVArrayList = new ArrayList<CSVWriter>();
     
    public CSVWriter(String username, String password) {
        super(username, password);
        setUsername(username);
        setPassword(password);
    }
    
    public void writeCSV(String username,String password){
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy, HH:mm:ss");  
    Date date = new Date();  
    System.out.println();  
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("AuditLogs.csv",true);
            fileWriter.append(username);
            fileWriter.append(CSV_SEPARATOR_COMMA);
            fileWriter.append(password);
            fileWriter.append(CSV_SEPARATOR_COMMA);
            fileWriter.append(formatter.format(date));
            fileWriter.append(CSV_SEPARATOR_NEXTLINE);

            System.out.println("CSV file was written successfully !!!");
        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e) {
        }finally {
            try{
                fileWriter.flush();
                fileWriter.close();

            }catch (IOException e){
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public ArrayList<CSVWriter> getEventWriteCSVArrayList() {
        return eventWriteCSVArrayList;
    }

    public void setEventWriteCSVArrayList(ArrayList<CSVWriter> eventWriteCSVArrayList) {
        this.eventWriteCSVArrayList = eventWriteCSVArrayList;
    }
}
