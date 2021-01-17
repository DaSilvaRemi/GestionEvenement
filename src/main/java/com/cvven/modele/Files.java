/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import java.io.File;

/**
 * Classe Technique abstaite permettant de gérer des fichiers de diverses formats
 * 
 * @author remi
 */
public abstract class Files{
    /**
     * Le répertoire ou est stockée du fichier
     * 
     * ex : C:/Test/
     */
    private String fileRepository = "/com/cvven/files";
    
    /**
     * Le nom du fichier sans extension et nom de répertoire
     */
    private String fileName;
    
    /**
     * L'extension du fichier par défaut le fichier est au format txt
     */
    private String fileExtension = ".txt";
    
    /**
     * URI/Emplacement du fichier contenant les 3 paramètre :
     *  -fileRepository
     *  -fileName
     *  -fileExtension
     * 
     * ex : C:/Test/test2.txt
     */
    private String fileURI;
    
    /**
     * La fichier en format objet
     */
    private File file;
    
    /**
     * Constructeur par défaut nécessitant uniquement le nom du fichier
     * 
     * Le répertoire et l'extension du fichier seront déclarée avec des valeurs par défaut
     * 
     * @see fileRepository
     * @see fileExtension
     * @param fileName 
     */
    protected Files(String fileName) {
        this.fileName = fileName;
        this.fileURI = this.fileRepository + this.fileName + this.fileExtension;
        this.file = new File(this.fileURI);
    }
    
    /**
     * Constructeur par défaut nécessitant uniquement deux paramètre
     * 
     * L'extension sera mis automatiquement sur .txt
     * 
     * @param fileName
     * @param fileRepository 
     */
    protected Files(String fileName, String fileRepository) {
        this.fileName = fileName;
        this.fileRepository = fileRepository;
        this.fileURI = this.fileRepository + this.fileName + this.fileExtension;
        this.file = new File(this.fileURI);
    }
    
    /**
     * Constructeur par défaut
     * 
     * @param fileName
     * @param fileRepository 
     * @param fileExtension 
     */
    protected Files(String fileName, String fileRepository, String fileExtension) {
        this.fileName = fileName;
        this.fileRepository = fileRepository;
        this.fileExtension = fileExtension;
        this.fileURI = this.fileRepository + this.fileName + this.fileExtension;
        this.file = new File(this.fileURI);
    }

    /**
     * @return le répertoire du fichuer
     */
    public String getFileRepository() {
        return fileRepository;
    }

    /**
     * @return le nom du fichier
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @return l'extension
     */
    public String getFileExtension() {
        return fileExtension;
    }

    /**
     * @return l'URI du fichier
     */
    public String getFileURI() {
        return fileURI;
    }

    /**
     * @param fileRepository le répertoire ou est stockée le fichier
     */
    public void setFileRepository(String fileRepository) {
        this.fileRepository = fileRepository;
    }

    /**
     * @param fileName le nom du fichier
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @param fileExtension l'extension du fichier
     */
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    /**
     * @param fileURI l'URI du fichier
     */
    public void setFileURI(String fileURI) {
        this.fileURI = fileURI;
    }
    
    /**
     * @return le fichier
     */
    public File getFile() {
        return file;
    }
    
    /**
     * Remplace le fichier courant aen prenant comme chemin relatif par défault l'URI du fichier indiquée dans l'objet
     * 
     * @see fileURI
     */
    public void setFile(){
        this.file = new File(this.fileURI);
    }

    /**
     * Remplace le fichier courant
     * 
     * @param file le fichier
     */
    public void setFile(File file) {
        this.file = file;
    }
}
