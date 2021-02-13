package com.cvven.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import org.postgresql.Driver;

/**
 * Classe technique abstraite permettant de gérer la connexion à la BDD.
 * 
 * @author remi
 */
abstract class GestionBDDModele {
    /**
     * L'hôte de la BDD
     */
    private String urlHoteBdd;
    
    /**
     * L'utilisateur de la BDD
     */
    private String user;
    
    /**
     * Le mot de passe de la BDD
     */
    private String password;
    
    /**
     * La connexion à la BDD
     */
    private Connection db;
    
    /**
     * La requête
     */
    private PreparedStatement myStatement;
    
    /**
     * Constructeur par défaut GestionBDDModele.
     */
    protected GestionBDDModele() {
        this.urlHoteBdd = "localhost/gestionevenement";
        this.user = "remi";
        this.password = "test";
    } 
    
    /**
     * Constructeur par défaut de GestionBDDModele avec des paramètre.
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
     * Retourne l'url de l'hote de la bdd avec le nom de la base de données.
     * 
     * @return L'adresse de l' hôte de la bdd sous forme : hôte/nomBDD
     */
    public String getUrlHoteBdd() {
        return this.urlHoteBdd;
    }

    /**
     * Retourne l'utilisateur de la base de données.
     * 
     * @return l'utilisateur de la BDD
     */
    public String getUser() {
        return this.user;
    }

    /**
     * Retourne l'objet connexion relié à la BDD.
     * 
     * @return la connexion à la bdd
     */
    public Connection getDb() {
        return this.db;
    }
    
    /**
     * Retourne la délaration de requête réalisé préalablement.
     * 
     * @return la déclaration de requête
     */
    public PreparedStatement getMyStatement() {
        return this.myStatement;
    }

    /**
     * Défini l'url de l'hôte.
     * 
     * @param urlHoteBdd L'adresse de l' hôte de la bdd sous forme : hôte/nomBDD
     */
    public void setUrlHoteBdd(String urlHoteBdd) {
        this.urlHoteBdd = urlHoteBdd;
    }

    /**
     * Défini l'utilisateur de la base de données.
     * 
     * @param user Le nom d'utilisateur de la BDD
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Défini le mot de passe de l'utilisateur de la BDD.
     * 
     * @param password Le mot de passe de la BDD
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Définit et Ouvre une connexion à la BDD postgreSQL avec le driver JDBC.
     * 
     * @throws SQLException Exception à propos du SQL
     * @throws ClassNotFoundException Exception si la classe Java n'as pas été trouvé. 
     * 
     * @see org.postgresql.Driver
     */
    public void setDb() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        this.db = DriverManager.getConnection("jdbc:postgresql://"+this.urlHoteBdd, this.user, this.password);
    }
      
    /**
     * Déclare une requête préparée
     * 
     * @param query La requête à définir.
     * @throws SQLException Exception à propos du SQL
     */
    protected void setMyStatement(String query) throws SQLException{
         this.myStatement = this.db.prepareStatement(query);
    }
    
    /**
     * Ferme la connexion à la bdd.
     * 
     * @throws SQLException Exception à propos du SQL
     */
    public void closeMaBdd() throws SQLException{
        this.db.close();
    }
    
    /**
     * Ferme la déclaration de la requête.
     * 
     * @throws SQLException Exception à propos du SQL 
     */
    public void closeMyStatement() throws SQLException{
        this.myStatement.clearParameters();
        this.myStatement.close();
    }
    
    /**
     * Ferme la déclaration de la requête et la connexion vers la BDD.
     * 
     * @throws SQLException Exception à propos du SQL
     */
    public void closeAll() throws SQLException{
        this.myStatement.clearParameters();
        this.myStatement.close();
        this.db.close();
    }
    
    /**
     * Exécute la requête sans retourner de résultat.
     * 
     * @throws SQLException Exception à propos du SQL
     */
    protected void execSQLWithouthResult() throws SQLException{
        this.myStatement.execute();
    }
    
    /**
     * Retourne le résultat de la requête préparée
     * 
     * @return Le résultat sous forme d'objet ou null si aucun résultat n'est trouvé.
     * @throws SQLException Exception à propos du SQL.
     */
    protected ResultSet getResult() throws SQLException{
        ResultSet result = this.myStatement.executeQuery();
        if(result.next()){
            return result;
        }else{
            return null;
        }
        
    } 
}
