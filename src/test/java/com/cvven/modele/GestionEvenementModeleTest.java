/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import java.sql.ResultSet;
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
public class GestionEvenementModeleTest {
    
    private static int compteur = 0;
    private GestionEvenementModele instance;
    
    public GestionEvenementModeleTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new GestionEvenementModele();
        compteur++;
        System.out.println("-------Test N°" + compteur + " en cours-----");
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("-------Test N°" + compteur + " réalisée-----");
    }
    
    /**
     * Test of selectInfoTableEventWithParticipation method, of class GestionEvenementModele.
     */
    @Test
    public void testSelectInfoAllEvent() throws Exception {
        System.out.println("Test de : selectInfoAllEvent");
        ResultSet expResult = null;
        //ResultSet result = instance.selectInfoTableEventWithParticipation();
        //assertEquals(expResult, result);
    }

    /**
     * Test of insertParticipation method, of class GestionEvenementModele.
     */
    @Test
    public void testInsertParticipation() throws Exception {
        System.out.println("Test de : insertParticipation");
        String email = "";
        String intitule = "";
        instance.insertParticipation(email, intitule);
    }

    /**
     * Test of selectInfoAllSalle method, of class GestionEvenementModele.
     */
    @Test
    public void testSelectInfoSalle() throws Exception {
        System.out.println("Test de : selectInfoSalle");
        GestionEvenementModele instance = null;
        ResultSet expResult = null;
        ResultSet result = instance.selectInfoAllSalle();
        assertEquals(expResult, result);
    }

    /**
     * Test of countEventWithIntitule method, of class GestionEvenementModele.
     */
    @Test
    public void testCountEvent() throws Exception {
        System.out.println("countEvent");
        ResultSet result = instance.countEventWithIntitule("Test1");
        result.next();
        assertEquals(1, result.getInt("nbEvent"));
    }

    /**
     * Test of insertEvent method, of class GestionEvenementModele.
     */
    @Test
    public void testInsertEvent() throws Exception {
        System.out.println("insertEvent");
        String intitule = "Test1";
        String theme = "Test1";
        String dateEvent = "Test1";
        int duree = 45;
        String description = "Test1";
        String organisateur = "Test1";
        String type = "Test1";
        String typeSalle = "";
        instance.insertEvent(intitule, theme, dateEvent, duree, description, organisateur, type, typeSalle);
    }

    /**
     * Test of insertParticipant method, of class GestionEvenementModele.
     */
    @Test
    public void testInsertParticipant() throws Exception {
        System.out.println("insertParticipant");
        String nom = "TestParticipant1";
        String prenom = "TestParticipant1";
        String email = "test1@gmail.com";
        String dateNaissance = "27/08/2001";
        String organisation = "TestParticipant1";
        String observations = "TestParticipant1";
        instance.insertParticipant(nom, prenom, email, dateNaissance, organisation, observations);
    }

    /**
     * Test of countUserLoginMdp method, of class GestionEvenementModele.
     */
    @Test
    public void testCountUserLoginMdp() throws Exception {
        System.out.println("countUserLoginMdp");
        GestionEvenementModele instance = null;
        ResultSet result = instance.countUserLoginMdp("remi", "test");
        assertEquals(1, result.getInt("nbUser"), "L'utilisateur n'est pas connecté");
    }
    
}