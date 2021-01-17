/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author remi
 */
public class CSVFileRead extends Files{
    private CSVReader fileRead; 
    private ArrayList<String[]> data;
    
    /**
     * @return the fileRead
     */
    public CSVReader getFileRead() {
        return fileRead;
    }

    /**
     * @return the data
     */
    public ArrayList<String[]> getData() {
        return data;
    }

    /**
     * @param fileRead the fileRead to set
     */
    public void setFileRead(CSVReader fileRead) {
        this.fileRead = fileRead;
    }

    /**
     * @param data the data to set
     */
    public void setData(ArrayList<String[]> data) {
        this.data = data;
    }
    
    /**
     * 
     * @param fileName 
     */
    public CSVFileRead(String fileName) {
        super(fileName);
    }
    
    /**
     * 
     * @param fileName
     * @param fileRepository 
     */    
    public CSVFileRead(String fileName, String fileRepository) {
        super(fileName, fileRepository);
    }
    
    /**
     * 
     * @param fileName
     * @param fileRepository 
     * @param fileExtension 
     */    
    public CSVFileRead(String fileName, String fileRepository, String fileExtension) {
        super(fileName, fileRepository);
    }
    
    public void openFile() throws FileNotFoundException{
        this.setFileRead(new CSVReader(new FileReader(super.getFile())));
    }
    
    public void closeFile() throws IOException{
        this.getFileRead().close();
    }
     /**
      * 
      */
    public void readFile(){
        try {
            this.openFile();
            String line[];
            while((line = this.getFileRead().readNext()) != null){
                this.data.add(line);
            }
            this.closeFile();
        } catch (FileNotFoundException ex) {
            DialogTools.openMessageDialog(ex.getMessage(), "Erreur Fichier !", DialogTools.WARNING_MESSAGE);
        } catch (IOException ex) {
            DialogTools.openMessageDialog(ex.getMessage(), "Erreur Fichier !", DialogTools.WARNING_MESSAGE);
        }
    }
    
    
    
}
