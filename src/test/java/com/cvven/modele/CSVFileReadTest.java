/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author remi
 */
public class CSVFileReadTest {
    
    private CSVFileRead instance;
    private static int compteur = 0;
    
    public CSVFileReadTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new CSVFileRead(new File("/home/remi/Documents/Deuxième Année/Deuxième Semestre/PPE/Gestion des évènements/Application Java-(PPE7)/ExempleCSV.csv"));
        compteur++;
        System.out.println("-------Test N°" + compteur + " en cours-----");
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("-------Test N°" + compteur + " réalisée-----");
    }

    /**
     * Test de la méthode getFile, de la classe CSVFileRead.
     */
    @Test
    public void testGetFile() {
        System.out.println("Test de getFile");
        
        assertNotNull(instance.getFile(), "Le fichier est vide !");
        
        String expResult = new File("/home/remi/Documents/Deuxième Année/Deuxième Semestre/PPE/Gestion des évènements/Application Java-(PPE7)/ExempleCSV.csv").getPath();
        String result = instance.getFile().getPath();
        assertEquals(expResult, result, "Les chemins ne sont pas les même !");
    }

    /**
     * Test de la méthode getFileRead, de la classe CSVFileRead.
     */
    @Test
    public void testGetFileRead() throws Exception {
            System.out.println("Test de getFileRead");
            assertNull(instance.getFileRead(), "Le fichier à été ouvert !");
            instance.openFile();
            assertNotNull(instance.getFileRead(), "Le fichier n'as pas été ouvert !");
    }

    /**
     * Test de la méthode getLesLignes, de la classe CSVFileRead.
     */
    @Test
    public void testGetLesLignes() {
        System.out.println("Test de getLesLignes");
        
        assertNotNull(instance.getFile(), "Le fichier est vide !");
        
        String expResultFile = new File("/home/remi/Documents/Deuxième Année/Deuxième Semestre/PPE/Gestion des évènements/Application Java-(PPE7)/ExempleCSV.csv").getPath();
        String resultFile = instance.getFile().getPath();
        assertEquals(expResultFile, resultFile, "Les chemins ne sont pas les même !");
        
        assertNotNull(instance.getLesLignes(), "Le fichier n'as aucune ligne !");
    }

    /**
     * Test de la méthode OpenFile, de la classe CSVFileRead.
     */
    @Test
    public void testOpenFile() throws Exception {
        System.out.println(" Test de openFile");
        instance.openFile();
        assertNotNull(instance.getFile(), "Le fichier n'as pas été ouvert !");
    }

    /**
     * Test de la méthode getFileRead, de la classe CSVFileRead.
     */
    @Test
    public void testCloseFile() throws Exception {
        System.out.println("Test de closeFile");
        instance.openFile();
        instance.closeFile();
    }

    /**
     * Test de la méthode getFileRead, de la classe CSVFileRead.
     */
    @Test
    public void testReadFile() {
        System.out.println("Test de readFile");
        assertNotNull(instance.readFile(),"Le fichier n'a aucune ligne !");
    }

    /**
     * Test de la méthode getFileRead, de la classe CSVFileRead.
     */
    @Test
    public void testReadControlFile() {
        try {
            System.out.println("Test de readControlFile !");
            assertNotNull(instance.readControlFile(), "Le fichier n'a aucune donnée !");
        } catch (SQLException | ClassNotFoundException ex) {
            assertNotNull(ex.getMessage(), "Les controles se sont mal passé !");
        }
    }
    
}
