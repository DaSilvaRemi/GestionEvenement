/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import org.postgresql.Driver;

/**
 * Classe métier permettant de gérer la connexion à la BDD
 * 
 * @author remi
 */
abstract class GestionBDDModele {
    private String urlHoteBdd;
    private String user;
    private String password;
    private Connection db;
    private PreparedStatement myStatement;
    
    /**
     * Constructeur par défaut
     * 
     */
    protected GestionBDDModele() {
        this.urlHoteBdd = "localhost/gestionevenement";
        this.user = "remi";
        this.password = "test";
    } 
    
    /**
     * Constructeur par défaut avec des paramètre
     * 
     * @param urlHoteBdd L'adresse de l' hôte de la bdd sous forme : hôte/nomBDD
     * @param user Le nom d'utilisateur de la BDD
     * @param password Le mot de passe de la BDD
     */
    protected GestionBDDModele(String urlHoteBdd, String user, String password) {
        this.urlHoteBdd = urlHoteBdd;
        this.user = user;
        this.password = password;
    }

    /**
     * Retourne l'url de l'hote de la bdd avec le nom de la base de données
     * 
     * @return L'adresse de l' hôte de la bdd sous forme : hôte/nomBDD
     */
    public String getUrlHoteBdd() {
        return this.urlHoteBdd;
    }

    /**
     * Retourne l'utilisateur de la base de données
     * 
     * @return l'utilisateur de la BDD
     */
    public String getUser() {
        return this.user;
    }

    /**
     * Retourne l'objet connexion relié à la BDD
     * 
     * @return la connexion à la bdd
     */
    public Connection getDb() {
        return this.db;
    }
    
    /**
     * Retourne la délaration de requête réalisé préalablement
     * 
     * @return la déclaration de requête
     */
    public PreparedStatement getMyStatement() {
        return this.myStatement;
    }

    /**
     * Défini l'url de l'hôte
     * 
     * @param urlHoteBdd L'adresse de l' hôte de la bdd sous forme : hôte/nomBDD
     */
    public void setUrlHoteBdd(String urlHoteBdd) {
        this.urlHoteBdd = urlHoteBdd;
    }

    /**
     * Défini l'utilisateur de la base de données
     * 
     * @param user Le nom d'utilisateur de la BDD
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Défini le mot de passe de l'utilisateur de la BDD
     * 
     * @param password Le mot de passe de la BDD
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Définit et Ouvre une connexion à la BDD postgreSQL avec le driver JDBC
     * 
     * @throws SQLException
     * @throws ClassNotFoundException 
     * 
     * @see org.postgresql.Driver
     */
    public void setDb() throws SQLException,ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        this.db = DriverManager.getConnection("jdbc:postgresql://"+this.urlHoteBdd, this.user, this.password);
    }
      
    /**
     * Déclare une requête préparée
     * 
     * @throws SQLException 
     */
    protected void setMyStatement(String query) throws SQLException{
         this.myStatement = this.db.prepareStatement(query);
    }
    
    /**
     * Ferme la connexion à la bdd
     * 
     * @throws SQLException 
     */
    public void closeMaBdd() throws SQLException{
        this.db.close();
    }
    
    /**
     * Ferme la déclaration de la requête
     * 
     * @throws SQLException 
     */
    public void closeMyStatement() throws SQLException{
        this.myStatement.clearParameters();
        this.myStatement.close();
    }
    
    /**
     * Ferme la déclaration de la requête et la connexion vers la BDD
     * 
     * @throws SQLException 
     */
    public void closeAll() throws SQLException{
        this.myStatement.clearParameters();
        this.myStatement.close();
        this.db.close();
    }
    
    /**
     * Retourne le résultat de la requête préparée
     * 
     * @return le résultat sous forme d'objet
     * @throws SQLException 
     */
    protected ResultSet getResult() throws SQLException{
        ResultSet result = this.myStatement.executeQuery();
        result.next();
        return result;
    }
}
