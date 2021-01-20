/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.postgresql.Driver;

/**
 *
 * @author remi
 */
public class GestionBDDModeleTest {
    
    private GestionBDDModele instance;
    
    public GestionBDDModeleTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new GestionBDDModeleImpl();
    }
    
    @AfterEach
    public void tearDown() {
        instance = new GestionBDDModeleImpl();
    }

    /**
     * Test of getUrlHoteBdd method, of class GestionBDDModele.
     */
    @Test
    public void testGetUrlHoteBdd() {
        System.out.println("Test de : getUrlHoteBdd");
        assertEquals("localhost/gestionevenement", instance.getUrlHoteBdd(), "L'url de la BDD est incorrect !");
    }

    /**
     * Test of getUser method, of class GestionBDDModele.
     */
    @Test
    public void testGetUser() {
        System.out.println("Test de getUser");
        assertNotNull(instance.getUser(), "L'utilisateur est incorrect !");
    }

    /**
     * Test of getDb method, of class GestionBDDModele.
     */
    @Test
    public void testGetDb() throws SQLException, ClassNotFoundException {
        System.out.println("Test de getDb");
        instance.setDb();
        Class.forName("org.postgresql.Driver");
        Connection expect = DriverManager.getConnection("jdbc:postgresql://"+instance.getUrlHoteBdd(), instance.getUser(), "test");
        Connection result = instance.getDb();
        assertEquals(expect, result, "Les objets connection ne sont pas semblable");
        instance.closeMaBdd();
    }

    /**
     * Test of getMyStatement method, of class GestionBDDModele.
     */
    @Test
    public void testGetMyStatement() throws SQLException, ClassNotFoundException {
        System.out.println("Test de getMyStatement");
        instance.setDb();
        instance.setMyStatement("SELECT id_user FROM public.user WHERE login = ?");
        PreparedStatement expect = instance.getDb().prepareStatement("SELECT id_user FROM public.user WHERE login = ?");
        PreparedStatement result = instance.getMyStatement();
        assertEquals(expect, result, "La requête n'est pas la même");
        instance.closeAll();
    }

    /**
     * Test of setUrlHoteBdd method, of class GestionBDDModele.
     */
    @Test
    public void testSetUrlHoteBdd() {
        System.out.println("Test de setUrlHoteBdd");
        instance.setUrlHoteBdd("192.168.1.14/gestionevenement");
        assertEquals("192.168.1.14/gestionevenement", instance.getUrlHoteBdd(), "L'URL de la BDD n'as pas été changé !");
    }

    /**
     * Test of setUser method, of class GestionBDDModele.
     */
    @Test
    public void testSetUser() {
        System.out.println("Test de setUser");
        instance.setUser("toto");
        assertEquals("toto", instance.getUser());
    }

    /**
     * Test of setDb method, of class GestionBDDModele.
     */
    @Test
    public void testSetDb() throws SQLException, ClassNotFoundException {
        System.out.println("Test de setDb");
        instance.setDb();
        Class.forName("org.postgresql.Driver");
        Connection expect = DriverManager.getConnection("jdbc:postgresql://"+instance.getUrlHoteBdd(), instance.getUser(), "test");
        Connection result = instance.getDb();
        assertEquals(expect, result, "La connection n'as pas été changée !");
        instance.closeMaBdd();
    }

    /**
     * Test of setMyStatement method, of class GestionBDDModele.
     */
    @Test
    public void testSetMyStatement() throws SQLException, ClassNotFoundException {
        instance.setDb();
        instance.setMyStatement("SELECT id_user FROM public.user WHERE login = ?");
        PreparedStatement expect = instance.getDb().prepareStatement("SELECT id_user FROM public.user WHERE login = ?");
        PreparedStatement result = instance.getMyStatement();
        assertEquals(expect, result, "La requête n'as pas été changé");
        instance.closeAll();
    }

    /**
     * Test of closeMaBdd method, of class GestionBDDModele.
     */
    @Test
    public void testCloseMaBdd() throws SQLException, ClassNotFoundException {
        System.out.println("closeMaBdd");
        GestionBDDModele instance = new GestionBDDModeleImpl();
        instance.closeMaBdd();
    }

    /**
     * Test of closeMyStatement method, of class GestionBDDModele.
     */
    @Test
    public void testCloseMyStatement() throws SQLException, ClassNotFoundException {
        System.out.println("closeMyStatement");
        GestionBDDModele instance = new GestionBDDModeleImpl();
        instance.closeMyStatement();
    }

    /**
     * Test of closeAll method, of class GestionBDDModele.
     */
    @Test
    public void testCloseAll() throws SQLException, ClassNotFoundException {
        System.out.println("closeAll");
        GestionBDDModele instance = new GestionBDDModeleImpl();
        instance.closeAll();
    }

    /**
     * Test of execSQLWithouthResult method, of class GestionBDDModele.
     */
    @Test
    public void testExecSQLWithouthResult() throws SQLException, ClassNotFoundException {
        System.out.println("execSQLWithouthResult");
        instance.setDb();
        instance.setMyStatement("SELECT id_user FROM public.user WHERE login = ?");
        instance.getMyStatement().setString(1, "admin");
        instance.execSQLWithouthResult();
        instance.closeAll();
    }

    /**
     * Test of getResult method, of class GestionBDDModele.
     */
    @Test
    public void testGetResult() throws SQLException, ClassNotFoundException {
        System.out.println("getResult");
        System.out.println("execSQLWithouthResult");
        instance.setDb();
        instance.setMyStatement("SELECT id_user FROM public.user WHERE login = ?");
        instance.getMyStatement().setString(1, "admin");
        assertEquals(1,instance.getResult().getInt("id_user"));
        instance.closeAll();
    }

    public class GestionBDDModeleImpl extends GestionBDDModele {
        GestionBDDModeleImpl(){
            super();
        }
    }
    
}
