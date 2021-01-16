/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import java.util.ArrayList;
import java.util.Random;
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
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getIdSession method, of class Session.
     */
    @Test
    public void testGetIdSession() {
        System.out.println("getIdSession");
        Session.initSession(1);
        assertNotNull(Session.getIdSession(), "L'id de la session est vide !");
    }

    /**
     * Test of getVariableSession method, of class Session.
     */
    @Test
    public void testGetVariableSession() {
        System.out.println("getVariableSession");
        ArrayList<Object> expResult = new ArrayList<Object>();
        
        assertTrue(Session.getVariableSession().isEmpty(), "La liste de départ n'est pas vide");
        
        Session.getVariableSession().add("Toto");
        expResult.add("Toto");
        assertEquals(expResult, Session.getVariableSession(), "Les listes n'ont pas les mêmes éléments");
    }

    /**
     * Test of getIdUser method, of class Session.
     */
    @Test
    public void testGetIdUser() {
        System.out.println("getIdUser");
        Session.initSession(1);
        assertEquals(1, Session.getIdUser(), "L'id de l'utilisateur est incorrect");
    }

    /**
     * Test of initSession method, of class Session.
     */
    @Test
    public void testInitSession() {
        System.out.println("initSession");
        Session.initSession(0);
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(99 - 10 + 1) + 10;
        String notExpectValue = String.valueOf(nombreAleatoire) + String.valueOf(0);
        assertNotEquals(notExpectValue, Session.getIdSession(), "L'id des sessions sont les mêmes !");
    }

    /**
     * Test of destructSession method, of class Session.
     */
    @Test
    public void testDestructSession() {
        System.out.println("destructSession");
        Session.destructSession();
        assertNull(Session.getIdSession(), "L'id de la session n'as pas été supprimée !");
        assertTrue(Session.getVariableSession().isEmpty(), "La collection n'as pas été vidée !");
    }
    
    /**
     * Test of destructSession method, of class Session.
     */
    @Test
    public void testControlSession() {
        try {
            System.out.println("controlSession");
            Session.controlSession();
            assertTrue(false, "Aucune exception n'as été levée !");
        } catch (Exception ex) {
            assertTrue(true);
        }
    }
    
}
