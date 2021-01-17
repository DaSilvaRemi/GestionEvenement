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
/**
 * Classe technique permettant de lire les fichiers CSV
 * 
 * @author remi
 */
public class CSVFileRead extends Files{
    private CSVReader fileRead; 
    private ArrayList<String[]> data;
    
    /**
     * Constructeur par défaut nécessitant uniquement le nom du fichier
     * 
     * @param fileName 
     */
    public CSVFileRead(String fileName) {
        super(fileName);
        super.setFileExtension(".csv");
    }
    
    /**
     * Constructeur par défaut nécessitant le nom du fichier et du répertoire
     * 
     * @param fileName
     * @param fileRepository 
     */    
    public CSVFileRead(String fileName, String fileRepository) {
        super(fileName, fileRepository, ".csv");
    }
    
    /**
     * @return le fichier à lire
     */
    public CSVReader getFileRead() {
        return fileRead;
    }

    /**
     * @return les données
     */
    public ArrayList<String[]> getData() {
        return data;
    }

    /**
     * @param fileRead le fichier à lire
     */
    public void setFileRead(CSVReader fileRead) {
        this.fileRead = fileRead;
    }

    /**
     * Ouvre le fichier
     * 
     * @throws FileNotFoundException 
     */
    public void openFile() throws FileNotFoundException{
        this.setFileRead(new CSVReader(new FileReader(super.getFile())));
    }
    
    /**
     * Ferme le fichier
     * 
     * @throws IOException 
     */
    public void closeFile() throws IOException{
        this.getFileRead().close();
    }
    
     /**
      * Lit le fichier
      * 
      */
    public void readFileWithoutControl(){
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
    
    public void readFileWithControl(){
    
    }
    
    private void readFile(int index){
        try {
            this.openFile();
            String line[];
            while((line = this.getFileRead().readNext()) != null){
                if(index == 1){
                    this.data.add(line);
                }else{
                    this.data.add(line);
                }
            }
            this.closeFile();
        } catch (FileNotFoundException ex) {
            DialogTools.openMessageDialog(ex.getMessage(), "Erreur Fichier !", DialogTools.WARNING_MESSAGE);
        } catch (IOException ex) {
            DialogTools.openMessageDialog(ex.getMessage(), "Erreur Fichier !", DialogTools.WARNING_MESSAGE);
        }
    }
    
    /**
     * 
     * @return 
     */
    private boolean controlData(){
        return true;
    }
    
}
