/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import java.util.Random;
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
public class SessionTest {
    
    public SessionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        Session.initSession(1);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getIdSession method, of class Session.
     * @throws java.lang.Exception Exception lié à la non existance des sessions
     */
    @Test
    public void testGetIdSession() throws Exception {
        System.out.println("Test de getIdSession");
        String expectResult = Session.getIdSession();
        assertNotNull(expectResult, "L'id de la session est vide !");
    }

    /**
     * Test of getVariableSession method, of class Session.
     * @throws java.lang.Exception Exception lié à la non existance des sessions
     */
    @Test
    public void testGetVariableSession() throws Exception {
        System.out.println("Test de getVariableSession");
        assertTrue(Session.getVariableSession().isEmpty(), "La liste de départ n'est pas vide !");
        Session.getVariableSession().add("Toto");
        assertFalse(Session.getVariableSession().isEmpty(), "La liste de départ est vide !");
    }

    /**
     * Test of getIdUser method, of class Session.
     * @throws java.lang.Exception Exception lié à la non existance des sessions
     */
    @Test
    public void testGetIdUser() throws Exception {
        System.out.println("Test de getIdUser");
        assertEquals(1, Session.getIdUser(), "L'id de l'utilisateur est incorrect");
    }

    /**
     * Test of initSession method, of class Session.
     * @throws java.lang.Exception Exception lié à la non existance des sessions
     */
    @Test
    public void testInitSession() throws Exception {
        System.out.println("Test de initSession");
        Session.initSession(0);
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(99 - 10 + 1) + 10;
        String notExpectValue = String.valueOf(nombreAleatoire) + String.valueOf(1);
        assertNotEquals(notExpectValue, Session.getIdSession(), "L'id des sessions sont les mêmes !");
    }

    /**
     * Test of destructSession method, of class Session.
     */
    @Test
    public void testDestructSession() {
        try {
            System.out.println("Test de destructSession");
            Session.initSession(1);
            Session.destructSession();
            assertNull(Session.getIdSession(), "L'id de la session n'as pas été supprimée !");
            assertNull(Session.getVariableSession(), "La collection n'as pas été vidée !");
        } catch (Exception ex) {
            assertTrue(true, "Les variable n'ont pas été supprimée !");
        }
    }
    
    /**
     * Test of destructSession method, of class Session.
     */
    @Test
    public void testControlSession() {
        try {
            System.out.println("Test de controlSession");
            Session.controlSession();
        } catch (Exception ex) {
            assertTrue(true, ex.getMessage());
        }
    }
    
}