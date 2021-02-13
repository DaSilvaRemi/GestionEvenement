/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import java.sql.SQLException;
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
    }

    /**
     * Test de la méthode getUrlHoteBdd, de la classe GestionBDDModele.
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
     * @throws java.sql.SQLException Exception à propos de la connexion SQL.
     * @throws java.lang.ClassNotFoundException Exception à propos du driver non trouvée.
     */
    @Test
    public void testGetDb() throws SQLException, ClassNotFoundException {
        System.out.println("Test de getDb");
        instance.setDb();
        assertNotNull(instance.getDb(), "Aucune connexion n'as été ouverte !");
        instance.closeMaBdd();
    }

    /**
     * Test of getMyStatement method, of class GestionBDDModele.
     * @throws java.sql.SQLException Exception à propos de la requête SQL
     * @throws java.lang.ClassNotFoundException Exception à propos du driver non trouvée.
     */
    @Test
    public void testGetMyStatement() throws SQLException, ClassNotFoundException {
        System.out.println("Test de getMyStatement");
        instance.setDb();
        instance.setMyStatement("SELECT id_user FROM public.user WHERE login = ?");
        assertNotNull(instance.getMyStatement(), "La requête n'as pas été créer !");
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
     * @throws java.sql.SQLException Exception à propos de la connexion SQL.
     * @throws java.lang.ClassNotFoundException Exception à propos du driver non trouv
     */
    @Test
    public void testSetDb() throws SQLException, ClassNotFoundException {
        System.out.println("Test de setDb");
        instance.setDb();
        assertNotNull(instance.getDb(), "La base de données n'a été pas ouverte !");
        instance.closeMaBdd();
    }

    /**
     * Test of setMyStatement method, of class GestionBDDModele.
     * @throws java.sql.SQLException Exception à propos de la requête SQL
     * @throws java.lang.ClassNotFoundException Exception à propos du driver non trouv
     */
    @Test
    public void testSetMyStatement() throws SQLException, ClassNotFoundException {
        System.out.println("Test de setMyStatement");
        instance.setDb();
        instance.setMyStatement("SELECT id_user FROM public.user WHERE login = ?");
        assertNotNull(instance.getMyStatement(), "La requête n'as pas été changé");
        instance.closeAll();
    }

    /**
     * Test of closeMaBdd method, of class GestionBDDModele.
     * @throws java.sql.SQLException Exception à propos de la requête SQL
     * @throws java.lang.ClassNotFoundException Exception à propos du driver non trouvé
     */
    @Test
    public void testCloseMaBdd() throws SQLException, ClassNotFoundException {
        System.out.println("Test de closeMaBdd");
        instance.setDb();
        instance.closeMaBdd();
    }

    /**
     * Test of closeMyStatement method, of class GestionBDDModele.
     * @throws java.sql.SQLException Exception à propos de la requête SQL
     * @throws java.lang.ClassNotFoundException Exception à propos du driver non trouvé
     */
    @Test
    public void testCloseMyStatement() throws SQLException, ClassNotFoundException {
        System.out.println("Test de closeMyStatement");
        instance.setDb();
        instance.setMyStatement("SELECT * FROM public.user");
        instance.closeMyStatement();
    }

    /**
     * Test of closeAll method, of class GestionBDDModele.
     * @throws java.sql.SQLException Exception à propos de la requête SQL
     * @throws java.lang.ClassNotFoundException Exception à propos du driver non trouvé
     */
    @Test
    public void testCloseAll() throws SQLException, ClassNotFoundException {
        System.out.println("Test de closeAll");
        instance.setDb();
        instance.setMyStatement("SELECT * FROM public.user");
        instance.closeAll();
    }

    /**
     * Test of execSQLWithouthResult method, of class GestionBDDModele.
     * @throws java.sql.SQLException Exception à propos de la requête SQL
     * @throws java.lang.ClassNotFoundException Exception à propos du driver non trouvé
     */
    @Test
    public void testExecSQLWithouthResult() throws SQLException, ClassNotFoundException {
        System.out.println("Test de execSQLWithouthResult");
        instance.setDb();
        instance.setMyStatement("SELECT id_user FROM public.user WHERE login = ?");
        instance.getMyStatement().setString(1, "admin");
        instance.execSQLWithouthResult();
        instance.closeAll();
    }

    /**
     * Test of getResult method, of class GestionBDDModele.
     * @throws java.sql.SQLException Exception à propos de la requête SQL
     * @throws java.lang.ClassNotFoundException Exception à propos du driver non trouvé
     */
    @Test
    public void testGetResult() throws SQLException, ClassNotFoundException {
        System.out.println("Test de getResult");
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
