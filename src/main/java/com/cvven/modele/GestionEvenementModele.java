package com.cvven.modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Classe technique finale héritaire de GestionBDDModele gérant les requêtes pourla BDD.
 * 
 * @author remi
 * @see com.cvven.modele.GestionBDDModele
 */
public final class GestionEvenementModele extends GestionBDDModele {
    
    /**
     * Constructeur par défaut
     * 
     * @see com.cvven.modele.GestionBDDModele::GestionBDDModele
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
     * 
     * @see com.cvven.modele.GestionBDDModele::GestionBDDModele
     */
    public GestionEvenementModele(String urlHoteBdd, String user, String password) {
        super(urlHoteBdd, user, password);
    }
    
    /*-----------------------------------Table participer--------------------------------*/
    /**
     * Selectionne les informations nécessaire pour l'affichage des évènement.
     * Les informations retournés sont : 
     * -l'intitule
     * -le type
     * -la date de l'évènement
     * -le thème
     * -le nombre de participant.
     * -l'organisateur
     * -l'état d'archivage de l'évènement
     * 
     * @return le résultat de la requête
     * @throws SQLException Exception à propos du SQL
     */
    public ResultSet selectInfoTableEvent() throws SQLException{
        super.setMyStatement("SELECT evenement.intitule, evenement.type, evenement.date, evenement.duree, evenement.theme, "
                + "COUNT(participer.id_participant) AS nbParticipant, evenement.organisateur, evenement.archive "
                + "FROM public.participer INNER JOIN public.evenement ON participer.id_evenement = evenement.id_evenement "
                + "GROUP BY evenement.intitule, evenement.type, evenement.date, evenement.duree, evenement.theme, evenement.organisateur, evenement.archive "
                + "ORDER BY evenement.date DESC;");
        return super.getResult();
    }
    
    
    /**
     * Inscrit un participant à un évènement
     * 
     * @param intitule L'intitule de l'évènement
     * @param email L'e-mail du participant
     * @throws SQLException Exception à propos du SQL
     */
    public void insertParticipation(String intitule, String email) throws SQLException{
        int idEvent = Integer.parseInt(String.valueOf(intitule.substring(intitule.indexOf("°")+1, intitule.indexOf("Intitulé")-1)));
        super.setMyStatement("INSERT INTO public.participer(id_evenement, id_participant) VALUES(?, (SELECT id_participant FROM public.participant WHERE email = ?));");
        super.getMyStatement().setInt(1, idEvent);
        super.getMyStatement().setString(2, email);
        super.execSQLWithouthResult();
    }
    /*----------------------------------Table Salle--------------------------------------*/
    /**
     * Permet de récupérer les informations de toutes les salles.
     * Les informations retournés sont :
     * -L'id de la salle
     * -Le type de la salle
     * 
     * @return le résultat de la requête
     * @throws SQLException Exception à propos du SQL
     */
    public ResultSet selectInfoAllSalle() throws SQLException{
        super.setMyStatement("SELECT * FROM public.salle;");
        return super.getResult();
    }
    
     /**
     * Permet de récupérer les information d'une salle avec son id.
     * Les informations retournés sont :
     * -L'id de la salle
     * -Le type de la salle
     * 
     * @param idSalle L'id de la salle
     * @return le résultat de la requête
     * @throws SQLException Exception à propos du SQL
     */
    public ResultSet selectInfoSalle(int idSalle) throws SQLException{
        super.setMyStatement("SELECT * FROM public.salle;");
        return super.getResult();
    }
    
    /*----------------------------------Table évènement----------------------------------*/
    /**
     * Selectionne les informations nécessaire pour l'affichage des évènement.
     * Les informations retournés sont : 
     * -l'intitule
     * -le type
     * -la date de l'évènement
     * -le thème
     * -l'organisateur
     * -l'état d'archivage de l'évènement
     * 
     * @return le résultat de la requête
     * @throws SQLException Exception à propos du SQL
     */
    public ResultSet selectInfoTableEventWithNoParticipation() throws SQLException{
        super.setMyStatement("SELECT evenement.intitule, evenement.type, evenement.date, evenement.duree, evenement.theme, evenement.organisateur, evenement.archive "
                + "FROM public.evenement WHERE evenement.id_evenement NOT IN (SELECT participer.id_evenement FROM participer)"
                + "GROUP BY evenement.intitule, evenement.type, evenement.date, evenement.duree, evenement.theme, evenement.organisateur, evenement.archive "
                + "ORDER BY evenement.date DESC;");
        return super.getResult();
    }
    
    /**
     * Retourne les informations de l'évènement à partir de l'intitulé.
     * Les informations retournés sont : 
     * -l'intitule
     * -le type
     * -la date de l'évènement
     * -le thème
     * -le nombre de participant.
     * -l'organisateur
     * -l'état d'archivage de l'évènement
     * -L'id de l'utilisateur
     * -L'id de la salle
     * 
     * @param intitule L'intitule de l'évènement
     * @return Le résultat de la requête
     * @throws SQLException Exception à propos du SQL 
     */
    public ResultSet selectInfoEventWithIntitule(String intitule) throws SQLException{
        super.setMyStatement("SELECT evenement.intitule, evenement.theme, evenement.date, evenement.duree, evenement.description, evenement.organisateur, evenement.type,"
                + "evenement.archive, evenement.id_user, evenement.id_salle FROM public.evenement WHERE evenement.intitule = ?");
        super.getMyStatement().setString(1, intitule);
        return super.getResult();
    }
    
    /**
     * Selectionne les évènement non archivé existant avec uniquement l'id et l'intitule.
     * Les informations retournés sont :
     * -L'id de l'évènement
     * -L'intitulé de lévènement
     * 
     * @return le résultat de la requête
     * @throws SQLException Exception à propos du SQL
     */
    public ResultSet selectLesEventNonArchiver() throws SQLException{
        super.setMyStatement("SELECT evenement.id_evenement, evenement.intitule FROM public.evenement WHERE evenement.archive IS NULL;");
        return super.getResult();
    }
    
    /**
     * Compte le nombre d'évènement avec l'intitulé de l'évènement.
     * 
     * @param intitule Intitulé de l'évènement
     * @return le résultat de la requête
     * @throws SQLException Exception à propos du SQL
     */
    public ResultSet countEventWithIntitule(String intitule) throws SQLException{
        super.setMyStatement("SELECT COUNT(intitule) AS nbEvent FROM evenement WHERE intitule = ?;");
        super.getMyStatement().setString(1, intitule);
        return super.getResult();
    }
    
    
    /**
     * Insère un évènement à la BDD.Un trigger vérifie si l'intitulé de l'évènement n'existe pas déja.
     * 
     * 
     * @param intitule Intitulé de l'évènement
     * @param theme Theme de l'évènement
     * @param dateEvent Date à laquelle se déroule l'évènement
     * @param duree Durée de l'évènement
     * @param description Description de l'évènement
     * @param organisateur Organisateur de l'évènement
     * @param typeEvent Type de l'évènement
     * @param salleChoisi La salle choisis par l'utilisateur le champs est sous format : 'N°' + id_salle + ' Salle de ' + typesalle + '(' + capacite + 'personne)'
     * @param idUser L'id de l'utilisateur
     * @throws SQLException Exception à propos du SQL
     * 
     */
    public void insertEvent(String intitule, String theme, String dateEvent, int duree, String description, 
            String organisateur, String typeEvent, String salleChoisi, int idUser) throws SQLException{
        
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
            super.getMyStatement().setInt(9, idUser);
            super.getMyStatement().setInt(10, idSalle);
            super.execSQLWithouthResult();
    }
    
    /*----------------------------------Table participant--------------------------------*/
    /**
     * Retourne les informations du participants à partir de son email.
     * Les informations retournée sont : 
     * -Le nom du participant
     * -Le prénom du participant
     * -La date de naissance du participant
     * -L'organisation du participant
     * -L'observation du partcipant
     * -L'email du participant
     * 
     * @param email L'email du participant
     * @return le résultat de la requête sur les informations du participant.
     * @throws SQLException Exception à propos du SQL
     */
    public ResultSet selectInfoParticipantWithEmail(String email) throws SQLException{
        super.setMyStatement("SELECT participant.nom, participant.prenom, participant.date_naissance, participant.organisation, participant.observations, participant.email FROM "
                + "public.participant WHERE participant.email = ?");
        super.getMyStatement().setString(1, email);
        return super.getResult();
    }
    
     /**
     * Compte le nombre d'email existant des participants.
     * 
     * @param email L'email du participant
     * @return le résultat de la requête
     * @throws SQLException Exception à propos du SQL
     */
    public ResultSet countEmailParticipant(String email) throws SQLException{
        super.setMyStatement("SELECT COUNT(id_participant) AS nbParticipant FROM public.participant WHERE participant.email = ?;");
        super.getMyStatement().setString(1, email);
        return super.getResult();
    }
    
    /**
     * Insert un nouveau participant à la base de données
     * 
     * @param nom Nom du participant
     * @param prenom Prénom du participant
     * @param email Email du participant
     * @param dateNaissance Date de naissance du participant
     * @param organisation L'organsation du participant
     * @param observations Les observations du participant
     * @param idUser L'id de l'utilisateur.
     * @throws SQLException Exception à propos du SQL
     */
    public void insertParticipant(String nom, String prenom, String email, String dateNaissance, String organisation, String observations, int idUser) 
            throws SQLException{
            super.setMyStatement("INSERT INTO public.participant(nom, prenom, date_naissance, organisation, observations, email, id_user) VALUES(?, ?, ?, ?, ?, ?, ?);");
            super.getMyStatement().setString(1, nom);
            super.getMyStatement().setString(2, prenom);
            super.getMyStatement().setObject(3, dateNaissance, Types.DATE);
            super.getMyStatement().setString(4, organisation);
            super.getMyStatement().setString(5, observations);
            super.getMyStatement().setString(6, email);
            super.getMyStatement().setInt(7, idUser);
            super.execSQLWithouthResult();
    }
    
    /*-----------------------------------Table user--------------------------------------*/
    /**
     * Retourne l'id de l'utilisateur ayant le login et le mot de passe indiqué.
     * 
     * @param login Login de l'utilisateur
     * @param mdp Mot de passe de l'utilisateur
     * @return le résultat de la requête
     * @throws SQLException Exception à propos du SQL
     */
    public ResultSet selectIdUser(String login, String mdp) throws SQLException{
        this.setMyStatement("SELECT id_user FROM public.user WHERE login = ? AND mdp = MD5(?);");
        this.getMyStatement().setString(1, login);
        this.getMyStatement().setString(2, mdp);
        return this.getResult();
    }
    
    /**
     * Compte le nombre d'utilisateur ayant le login et le mot de passe indiqué
     * 
     * @param login Login de l'utilisateur
     * @param mdp Mot de passe de l'utilisateur
     * @return le résultat de la requête
     * @throws SQLException Exception à propos du SQL
     */
    public ResultSet countUserLoginMdp(String login, String mdp) throws SQLException{
        this.setMyStatement("SELECT COUNT(*) AS nbUser FROM public.user WHERE login = ? AND mdp = MD5(?);");
        this.getMyStatement().setString(1, login);
        this.getMyStatement().setString(2, mdp);
        return this.getResult();
    }    
}
