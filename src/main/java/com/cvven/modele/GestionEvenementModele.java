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
     * Selectionne les informations utiles pour l'affichage des évènement ayant au moins une participation
     * 
     * @return le résultat de la requête
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
     * Selectionne les évènement existant avec uniquement l'id et l'intitule
     * 
     * @return le résultat de la requête
     * @throws SQLException 
     */
    public ResultSet selectLesEvent() throws SQLException{
        super.setMyStatement("SELECT evenement.id_evenement, evenement.intitule FROM public.evenement;");
        return super.getResult();
    }
    
    /**
     * Inscrit un participant à un évènement
     * 
     * @param intitule
     * @param email
     * @throws SQLException 
     */
    public void insertParticipation(String intitule, String email) throws SQLException{
        int idEvent = Integer.parseInt(String.valueOf(intitule.charAt(2)));
        super.setMyStatement("INSERT INTO public.participer VALUES((SELECT id_participant FROM participant WHERE email = ?),(SELECT id_evenement FROM evenement WHERE intitule = ?));");
        super.getMyStatement().setString(1, email);
        super.getMyStatement().setInt(2, idEvent);
        super.execSQLWithouthResult();
    }
    /*----------------------------------Table Salle--------------------------------------*/
    /**
     * 
     * @return le résultat de la requête
     * @throws SQLException 
     */
    public ResultSet selectInfoSalle() throws SQLException{
        super.setMyStatement("SELECT * FROM public.salle;");
        return super.getResult();
    }
    
    /*----------------------------------Table évènement----------------------------------*/
    
    /**
     * Compte le nombre d'évènement avec cet intitulé
     * 
     * @param intitule
     * @return le résultat de la requête
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
     * Un trigger vérifie si l'intitulé de l'évènement n'existe pas déja.
     * 
     * @param intitule Intitulé de l'évènement
     * @param theme Theme de l'évènement
     * @param dateEvent Date à laquelle se déroule l'évènement
     * @param duree Durée de l'évènement
     * @param description Description de l'évènement
     * @param organisateur Organisateur de l'évènement
     * @param typeEvent Type de l'évènement
     * @param salleChoisi La salle choisis par l'utilisateur le champs est sous format : 'N°' + id_salle + ' Salle de ' + typesalle + '(' + capacite + 'personne)'
     * @throws SQLException 
     * 
     */
    public void insertEvent(String intitule, String theme, String dateEvent, int duree, String description, 
            String organisateur, String typeEvent, String salleChoisi) throws SQLException{
        
            super.setMyStatement("INSERT INTO evenement(intitule, theme, date, duree, nb_participant_max, description, organisateur, type, id_user ,id_salle)"
                    + " VALUES(?, ?, ?, ?, (SELECT salle.capacite FROM public.salle WHERE salle.id_salle = ?), ?, ?, ?, ?, ?);");
        
            int idSalle = Integer.parseInt(String.valueOf(salleChoisi.charAt(2)));
            //Définitions des paramètres
            super.getMyStatement().setString(1, intitule);
            super.getMyStatement().setString(2, theme);
            super.getMyStatement().setObject(3, dateEvent, Types.DATE);
            super.getMyStatement().setInt(4, duree);
            super.getMyStatement().setInt(5, idSalle);
            super.getMyStatement().setString(6, description);
            super.getMyStatement().setString(7, organisateur);
            super.getMyStatement().setString(8, typeEvent);
            super.getMyStatement().setInt(9, Session.getIdUser());
            super.getMyStatement().setInt(10, idSalle);
            super.execSQLWithouthResult();
    }
    
    /*----------------------------------Table participant--------------------------------*/
     /**
     * Compte le nombre d'email existant
     * 
     * @param email
     * @return le résultat de la requête
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
            super.setMyStatement("INSERT INTO public.participant(nom, prenom, date_naissance, organisation, observations, email, id_user) VALUES(?, ?, ?, ?, ?, ?, ?);");
            super.getMyStatement().setString(1, nom);
            super.getMyStatement().setString(2, prenom);
            super.getMyStatement().setObject(3, dateNaissance, Types.DATE);
            super.getMyStatement().setString(4, organisation);
            super.getMyStatement().setString(5, observations);
            super.getMyStatement().setString(6, email);
            super.getMyStatement().setInt(7, Session.getIdUser());
            super.execSQLWithouthResult();
    }
    
    /*-----------------------------------Table user--------------------------------------*/
    /**
     * Retourne l'id de l'utilisateur
     * 
     * @param login
     * @param mdp
     * @return le résultat de la requête
     * @throws SQLException 
     */
    public ResultSet selectIdUser(String login, String mdp) throws SQLException{
        this.setMyStatement("SELECT id_user FROM public.user WHERE login = ? AND mdp = ?;");
        this.getMyStatement().setString(1, login);
        this.getMyStatement().setString(2, mdp);
        return this.getResult();
    }
    
    /**
     * Compte le nombre d'utilisateur ayant le login et le mot de passe indiqué
     * 
     * @param login
     * @param mdp
     * @return le résultat de la requête
     * @throws SQLException 
     */
    public ResultSet countUserLoginMdp(String login, String mdp) throws SQLException{
        this.setMyStatement("SELECT COUNT(*) AS nbUser FROM public.user WHERE login = ? AND mdp = ?;");
        this.getMyStatement().setString(1, login);
        this.getMyStatement().setString(2, mdp);
        return this.getResult();
    }    
}
