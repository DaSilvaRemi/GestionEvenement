/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test de GestionEvenementModele
 * 
 * @author remi
 */
public class GestionEvenementModeleTest {
    
    private GestionEvenementModele instance;
    
    /**
     * Constructeur de la classe test
     */
    public GestionEvenementModeleTest() {
    }
    
    /**
     * Se déclenche avant la classe
     */
    @BeforeAll
    public static void setUpClass() {
    }
    
    /**
     * Se déclenche après la classe
     */
    @AfterAll
    public static void tearDownClass() {
    }
    
    /**
     * Se déclenche avant chaque test
     * Déclare un objet
     */
    @BeforeEach
    public void setUp() {
        instance = new GestionEvenementModele();
    }
    
    /**
     * Se déclenche après chaque test
     */
    @AfterEach
    public void tearDown() {
    }

     /**
     * Test de la méthode selectInfoTableEvent, de la classe GestionEvenementModele.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testSelectInfoTableEvent() throws SQLException, ClassNotFoundException {
        System.out.println("Test de selectInfoTableEvent");
        instance.setDb();
        assertNotNull(instance.selectInfoTableEvent(), "Les évènements sont vides !");
        instance.closeAll();
    }

     /**
     * Test de la méthode selectInfoAllSalle, de la classe GestionEvenementModele.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testSelectInfoAllSalle() throws SQLException, ClassNotFoundException {
        System.out.println("Test de selectInfoAllSalle");
        instance.setDb();
        assertNotNull(instance.selectInfoAllSalle(), "Les salles sont vides !");
        instance.closeAll();
    }

     /**
     * Test de la méthode selectInfoSalle, de la classe GestionEvenementModele.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testSelectInfoSalle() throws SQLException, ClassNotFoundException {
        System.out.println("Test de selectInfoSalle");
        int idSalle = 0;
        instance.setDb();
        assertNotNull(instance.selectInfoSalle(idSalle), "La salle n'as pas d'information !");
        instance.closeAll();
    }

     /**
     * Test de la méthode selectInfoEventWithIntitule, de la classe GestionEvenementModele.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testSelectInfoEventWithIntitule() throws SQLException, ClassNotFoundException {
        System.out.println("Test de selectInfoEventWithIntitule");
        instance.setDb();
        assertNotNull(instance.selectInfoEventWithIntitule("a"), "Aucun évènement récupéré !");
    }

     /**
     * Test de la méthode selectLesEventNonArchiver, de la classe GestionEvenementModele.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testSelectLesEventNonArchiver() throws SQLException, ClassNotFoundException {
        System.out.println("Test de selectLesEventNonArchiver");
        instance.setDb();
        assertNotNull(instance.selectLesEventNonArchiver(), "Aucun évènement non archivé récupéré !");
        instance.closeAll();
    }

     /**
     * Test de la méthode countEventWithIntitule, de la classe GestionEvenementModele.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testCountEventWithIntitule() throws SQLException, ClassNotFoundException {
        System.out.println("Test de countEventWithIntitule");
        instance.setDb();
        assertNotNull(instance.countEventWithIntitule("a"), "Aucun résultat obtenu pour la table évènement !");
        instance.closeAll();
    }

     /**
     * Test de la méthode selectInfoParticipantWithEmail, de la classe GestionEvenementModele.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testSelectInfoParticipantWithEmail() throws SQLException, ClassNotFoundException {
        System.out.println("Test de selectInfoParticipantWithEmail");
        instance.setDb();
        assertNotNull(instance.selectInfoParticipantWithEmail("jj@gmail.com"), "Aucun participant avec e-mail n'as été récupéré !");
        instance.closeAll();
    }

    /**
     * Test de la méthode countEmailParticipant, de la classe GestionEvenementModele.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testCountEmailParticipant() throws SQLException, ClassNotFoundException {
        System.out.println("Test de countEmailParticipant");
        instance.setDb();
        assertNotNull(instance.countEmailParticipant("a@gmail.com"), "Aucun résultat du nombre de participant avec cet e-mail récupéré !");
        instance.closeAll();
    }

    /**
     * Test de la méthode selectIdUser, de la classe GestionEvenementModele.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testSelectIdUser() throws SQLException, ClassNotFoundException {
        System.out.println("Test de selectIdUser");
        instance.setDb();
        ResultSet result = instance.selectIdUser("admin", "admin");
        assertNotNull(result, "Aucun id récupéré !");
        assertEquals(1, result.getInt("id_user"));
        instance.closeAll();
    }

    /**
     * Test de la méthode countUserLoginMdp, de la classe GestionEvenementModele.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testCountUserLoginMdp() throws SQLException, ClassNotFoundException {
        System.out.println("countUserLoginMdp");
        instance.setDb();
        assertEquals(1, instance.countUserLoginMdp("admin", "admin").getInt("nbUser"), "Aucun utilisateur avec se login et mot de passe !");
        instance.closeAll();
    }
    
}
