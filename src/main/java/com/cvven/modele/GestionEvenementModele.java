/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Classe Technique héritaire finale de GestionBDDModele
 * 
 * @author remi
 */
public final class GestionEvenementModele extends GestionBDDModele {
    
    /**
     * Constructeur par défaut
     * 
     * @param urlHoteBdd L'adresse de l' hôte de la bdd sous forme : hôte/nomBDD
     * @param user Le nom d'utilisateur de la BDD
     * @param password Le mot de passe de la BDD
     */
    public GestionEvenementModele(String urlHoteBdd, String user, String password) {
        super(urlHoteBdd, user, password);
    }
    
    /*-----------------------------------Table participer--------------------------------*/
    /**
     * Selectionne toutes les informations utile pour l'affichage de l'évènement
     * 
     * @return
     * @throws SQLException 
     */
    public ResultSet selectInfoAllEvent() throws SQLException{
        this.setMyStatement("SELECT evenement.intitule, evenement.type, evenement.datedebut, evenement.duree, evenement.theme, "
                + "COUNT(particper.id_participant) AS nbParticipant, organisateur "
                + "FROM public.particper INNER JOIN public.evenement ON participer.id_evenement = evenement.id_evenement "
                + "INNER JOIN public.participant ON participer.id_participant = participant.id_participant;");
        return this.getResult();
    }
    
    /**
     * Inscrit un participant à un évènement
     * 
     * @param email
     * @param intitule
     * @throws SQLException 
     */
    public void insertParticipation(String email, String intitule) throws SQLException{
        this.setMyStatement("INSERT INTO public.participer VALUES((SELECT id_participant FROM participant WHERE email = ?),(SELECT id_evenement FROM evenement WHERE intitule = ?));");
        this.getMyStatement().setString(1, email);
        this.getMyStatement().setString(2, intitule);
        this.getResult();
    }
    /*----------------------------------Table Salle--------------------------------------*/
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public ResultSet selectInfoSalle() throws SQLException{
        this.setMyStatement("SELECT * FROM public.salle;");
        return this.getResult();
    }
    
    /*----------------------------------Table évènement----------------------------------*/
    
    /**
     * 
     * @param intitule
     * @return
     * @throws SQLException 
     */
    public ResultSet countEvent(String intitule) throws SQLException{
        this.setMyStatement("SELECT COUNT(intitule) AS nbEvent FROM evenement WHERE intitule = ?;");
        this.getMyStatement().setString(1, intitule);
        return this.getResult();
    }
    
    
    /**
     * Insère un évènement à la BDD
     * 
     * @param intitule Intitulé de l'évènement
     * @param theme Theme de l'évènement
     * @param dateEvent Date à laquelle se déroule l'évènement
     * @param duree Durée de l'évènement
     * @param description Description de l'évènement
     * @param organisateur Organisateur de l'évènement
     * @param type Type de l'évènement
     * @param typeSalle Type de la Salle
     * @param capacite Capacite de la salle
     * @throws SQLException 
     * 
     */
    public void insertEvent(String intitule, String theme, String dateEvent, int duree, String description, 
            String organisateur, String type, String typeSalle, String capacite) throws SQLException{
        
        ResultSet result = this.countEvent(intitule);
        result.next();
        if(result.getString("nbEvent").equals(0)){
            this.setMyStatement("INSERT INTO evenement(intitule, theme, datedebut, duree, nb_participant_max, description, organisateur, type, id_salle) "
                + "VALUES(?, ?, ?, ?, (SELECT capacite FROM salle WHERE typesalle = ? AND capacite = ?), ?, ?, ?, "
                + "(SELECT id_salle FROM salle WHERE typesalle = ? AND capacite = ?)");
        
            //Définitions des paramètres
            this.getMyStatement().setString(1, intitule);
            this.getMyStatement().setString(2, theme);
            this.getMyStatement().setObject(3, dateEvent, Types.DATE);
            this.getMyStatement().setInt(4, duree);
            this.getMyStatement().setString(5, typeSalle);
            this.getMyStatement().setString(6, capacite); 
            this.getMyStatement().setString(7, description);
            this.getMyStatement().setString(8, organisateur);
            this.getMyStatement().setString(9, type);
            this.getMyStatement().setString(10, typeSalle);
            this.getMyStatement().setString(11, capacite);
            this.getResult();
        }else{
            throw new SQLException("L'intitule de l'évènement existe déja !");
        }
    }
    
    /*----------------------------------Table participant--------------------------------*/
    /**
     * Insert un nouveau participant à la base de données
     * 
     * @param nom Nom du participant
     * @param prenom Prénom du participant
     * @param email Email du participant
     * @param dateNaissance Date de naissance du participant
     * @param organisation
     * @param observations
     * @throws SQLException 
     */
    public void insertParticipant(String nom, String prenom, String email, String dateNaissance, String organisation, String observations) 
            throws SQLException{
        this.setMyStatement("INSERT INTO public.participant(nom, prenom, date_naissance, organisation, observations, email) VALUES(?, ?, ?, ?, ?, ?);");
        this.getMyStatement().setString(1, nom);
        this.getMyStatement().setString(2, prenom);
        this.getMyStatement().setObject(3, dateNaissance, Types.DATE);
        this.getMyStatement().setString(4, organisation);
        this.getMyStatement().setString(5, observations);
        this.getMyStatement().setString(6, email);
        this.getResult();
    }
    
    /*-----------------------------------Table user--------------------------------------*/
    /**
     * Compte le nombre d'utilisateur ayant le login et le mot de passe indiqué
     * 
     * @param login
     * @param mdp
     * @return
     * @throws SQLException 
     */
    public ResultSet countUserLoginMdp(String login, String mdp) throws SQLException{
        this.setMyStatement("SELECT COUNT(*) AS nbUser FROM user WHERE login = ? AND mdp = ?;");
        this.getMyStatement().setString(1, login);
        this.getMyStatement().setString(2, mdp);
        return this.getResult();
    }

}
