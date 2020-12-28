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

/**
 * Classe métier permettant de gérer la connexion à la BDD
 * 
 * @author remi
 */
class GestionBDDModele {
    private String urlHoteBdd;
    private String user;
    private String password;
    private Connection db;
    private PreparedStatement myStatement;
    
    /**
     * Constructeur par défaut
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
    * Destructeur de classe
    * 
    * Lors de la suppression de l'objet on ferme forcément la connexion
    * 
    * @throws SQLException 
    */
    protected void finalize() throws SQLException{
        this.closeMyStatement();
        this.closeMaBdd();
    }
    
    /**
     * Retourne l'url de l'hote de la bdd avec le nom de la base de données
     * 
     * @return L'adresse de l' hôte de la bdd sous forme : hôte/nomBDD
     */
    protected String getUrlHoteBdd() {
        return urlHoteBdd;
    }

    /**
     * Retourne l'utilisateur de la base de données
     * 
     * @return l'utilisateur de la BDD
     */
    protected String getUser() {
        return user;
    }

    /**
     * Retourne l'objet connexion relié à la BDD
     * 
     * @return la connexion à la bdd
     */
    protected Connection getDb() {
        return db;
    }
    
    /**
     * Retourne la délaration de requête réalisé préalablement
     * 
     * @return la déclaration de requête
     */
    protected PreparedStatement getMyStatement() {
        return myStatement;
    }

    /**
     * Défini l'url de l'hôte
     * 
     * @param urlHoteBdd L'adresse de l' hôte de la bdd sous forme : hôte/nomBDD
     */
    protected void setUrlHoteBdd(String urlHoteBdd) {
        this.urlHoteBdd = urlHoteBdd;
    }

    /**
     * Défini l'utilisateur de la base de données
     * 
     * @param user Le nom d'utilisateur de la BDD
     */
    protected void setUser(String user) {
        this.user = user;
    }

    /**
     * Défini le mot de passe de l'utilisateur de la BDD
     * 
     * @param password Le mot de passe de la BDD
     */
    protected void setPassword(String password) {
        this.password = password;
    }

    /**
     * Définit et Ouvre une connexion à la BDD postgreSQL avec le driver JDBC
     * 
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    protected void setDb() throws SQLException,ClassNotFoundException {
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
    protected void closeMaBdd() throws SQLException{
        this.db.close();
    }
    
    /**
     * Ferme la déclaration de la requête
     * 
     * @throws SQLException 
     */
    protected void closeMyStatement() throws SQLException{
        this.myStatement.clearParameters();
        this.myStatement.close();
    }
    
    /**
     * Retourne le résultat de la requête préparée
     * 
     * @return le résultat sous forme d'objet
     * @throws SQLException 
     */
    protected ResultSet getResult() throws SQLException{
        return this.myStatement.executeQuery();
    }
}
