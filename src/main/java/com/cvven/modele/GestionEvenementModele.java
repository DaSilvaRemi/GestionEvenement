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
     */
    public GestionEvenementModele() {
        super();
    }
    
    
    /**
     * Constructeur par défaut avec des paramètres
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
        super.setMyStatement("SELECT evenement.intitule, evenement.type, evenement.datedebut, evenement.duree, evenement.theme, "
                + "COUNT(particper.id_participant) AS nbParticipant, organisateur "
                + "FROM public.particper INNER JOIN public.evenement ON participer.id_evenement = evenement.id_evenement "
                + "INNER JOIN public.participant ON participer.id_participant = participant.id_participant;");
        return super.getResult();
    }
    
    /**
     * Inscrit un participant à un évènement
     * 
     * @param email
     * @param intitule
     * @throws SQLException 
     */
    public void insertParticipation(String email, String intitule) throws SQLException{
        super.setMyStatement("INSERT INTO public.participer VALUES((SELECT id_participant FROM participant WHERE email = ?),(SELECT id_evenement FROM evenement WHERE intitule = ?));");
        super.getMyStatement().setString(1, email);
        super.getMyStatement().setString(2, intitule);
        super.getResult();
    }
    /*----------------------------------Table Salle--------------------------------------*/
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public ResultSet selectInfoSalle() throws SQLException{
        super.setMyStatement("SELECT * FROM public.salle;");
        return super.getResult();
    }
    
    /*----------------------------------Table évènement----------------------------------*/
    
    /**
     * 
     * @param intitule
     * @return
     * @throws SQLException 
     */
    public ResultSet countEvent(String intitule) throws SQLException{
        super.setMyStatement("SELECT COUNT(intitule) AS nbEvent FROM evenement WHERE intitule = ?;");
        super.getMyStatement().setString(1, intitule);
        return super.getResult();
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
     * @param typeSalle Type de la Salle concaténé avec la capacité
     * @throws SQLException 
     * 
     */
    public void insertEvent(String intitule, String theme, String dateEvent, int duree, String description, 
            String organisateur, String type, String typeSalle) throws SQLException{
        
        ResultSet result = this.countEvent(intitule);
        result.next();
        if(result.getInt("nbEvent") == 0){
            super.closeMyStatement();
            super.setMyStatement("INSERT INTO evenement(intitule, theme, datedebut, duree, nb_participant_max, description, organisateur, type, id_salle) "
                + "VALUES(?, ?, ?, ?, (SELECT capacite FROM salle WHERE typesalle = ? AND capacite = ?), ?, ?, ?, "
                + "(SELECT id_salle FROM salle WHERE typesalle = ? AND capacite = ?)");
        
            String capacite = typeSalle.substring(typeSalle.indexOf("(")+1,typeSalle.indexOf(")"));
            typeSalle = typeSalle.substring(0,typeSalle.indexOf("("));
            //Définitions des paramètres
            super.getMyStatement().setString(1, intitule);
            super.getMyStatement().setString(2, theme);
            super.getMyStatement().setObject(3, dateEvent, Types.DATE);
            super.getMyStatement().setInt(4, duree);
            super.getMyStatement().setString(5, typeSalle);
            super.getMyStatement().setString(6, capacite); 
            super.getMyStatement().setString(7, description);
            super.getMyStatement().setString(8, organisateur);
            super.getMyStatement().setString(9, type);
            super.getMyStatement().setString(10, typeSalle);
            super.getMyStatement().setString(11, capacite);
            super.getResult();
        }else{
            throw new SQLException("L'intitule de l'évènement existe déja !");
        }
    }
    
    /*----------------------------------Table participant--------------------------------*/
     /**
     * Compte le nombre d'email existant
     * 
     * @param email
     * @return
     * @throws SQLException 
     */
    public ResultSet countEmailParticipant(String email) throws SQLException{
        super.setMyStatement("SELECT COUNT(id_participant) AS nbParticipant FROM public.participant WHERE participant.email;");
        return super.getResult();
    }
    
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
        if(this.countEmailParticipant(email).getInt("nbParticipant") == 0){
            super.setMyStatement("INSERT INTO public.participant(nom, prenom, date_naissance, organisation, observations, email) VALUES(?, ?, ?, ?, ?, ?);");
            super.getMyStatement().setString(1, nom);
            super.getMyStatement().setString(2, prenom);
            super.getMyStatement().setObject(3, dateNaissance, Types.DATE);
            super.getMyStatement().setString(4, organisation);
            super.getMyStatement().setString(5, observations);
            super.getMyStatement().setString(6, email);
            super.getResult();
        }else{
            throw new SQLException("L'émail existe déja");
        }
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
