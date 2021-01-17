/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import java.io.File;

/**
 *
 * @author remi
 */
public abstract class Files{

    private String fileRepository = "/com/cvven/files";
    private String fileName;
    private String fileExtension = ".txt";
    private String fullFileName;
    private File file;
    
    /**
     * 
     * @param fileName 
     */
    protected Files(String fileName) {
        this.fileName = fileName;
        this.fullFileName = this.fileRepository + this.fileName + this.fileExtension;
        this.file = new File(this.fullFileName);
    }
    
    /**
     * 
     * @param fileName
     * @param fileRepository 
     */
    protected Files(String fileName, String fileRepository) {
        this.fileName = fileName;
        this.fileRepository = fileRepository;
        this.fullFileName = this.fileRepository + this.fileName + this.fileExtension;
        this.file = new File(this.fullFileName);
    }
    
    /**
     * 
     * @param fileName
     * @param fileRepository 
     * @param fileExtension 
     */
    protected Files(String fileName, String fileRepository, String fileExtension) {
        this.fileName = fileName;
        this.fileRepository = fileRepository;
        this.fileExtension = fileExtension;
        this.fullFileName = this.fileRepository + this.fileName + this.fileExtension;
        this.file = new File(this.fullFileName);
    }

    /**
     * @return the fileRepository
     */
    public String getFileRepository() {
        return fileRepository;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @return the extension
     */
    public String getFileExtension() {
        return fileExtension;
    }

    /**
     * @return the fullFileName
     */
    public String getFullFileName() {
        return fullFileName;
    }

    /**
     * @param fileRepository the fileRepository to set
     */
    public void setFileRepository(String fileRepository) {
        this.fileRepository = fileRepository;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @param fileExtension the extension to set
     */
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    /**
     * @param fullFileName the fullFileName to set
     */
    public void setFullFileName(String fullFileName) {
        this.fullFileName = fullFileName;
    }
    
    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }
    
    /**
     * 
     */
    public void setFile(){
        this.file = new File(this.fullFileName);
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }
}
