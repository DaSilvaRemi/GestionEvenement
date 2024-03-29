/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import java.util.ArrayList;
import java.util.Random;

/**
 *Classe technique abstraite permettant de gérer les sessions
 * 
 * @author remi
 */
public abstract class Session {
    
    /**
     * Composé d'un nombre aléatoire + l'idUser
     */
    private static String idSession;
    private static ArrayList<Object> lesVarSession;

    /**
     * Retourne la clé de session composé d'un nombre aléatoire + l'idUser si l'utilisateur est connecté.Génère une erreur si l'utilisateur n'est pas connecté !
     * 
     * 
     * @return la clé de session ou null si l'utilisateur n'est pas connecté
     * @throws java.lang.Exception Exception à propos du contrôle.
     */
    public static String getIdSession() throws Exception {
        Session.controlSession();
        return idSession;
    }

    /**
     * Retroune les variable session sous forme de tableau si l'utilisateur est connecté.
     * 
     * Génère une erreur si l'utilisateur n'est pas connecté !
     * 
     * @return les variables sessions ou null si l'utilisateur n'est pas connecté
     * @throws java.lang.Exception Exception à propos du contrôle.
     */
    public static ArrayList<Object> getVariableSession() throws Exception {
        Session.controlSession();
        return lesVarSession;
    }
    
    /**
     * Retourne l'id de l'utilisateur stocké dans la variable d'id Session si l'utilisateur est connecté.
     * 
     * Génère une erreur si l'utilisateur n'est pas connecté !
     * 
     * @return l'id de l'utilisateur ou -1 si l'utilisateur n'est pas connecté
     * @throws java.lang.Exception Exception à propos du contrôle.
     */
    public static int getIdUser() throws Exception{
        Session.controlSession();
        return Integer.parseInt(String.valueOf(idSession.charAt(2)));
    }

    /**
     * Défini les variable sessions
     * 
     * @param sessionVar tableau contenant des variable pour la sessions
     */
    public static void setVariableSession(ArrayList<Object> sessionVar) {
        lesVarSession = sessionVar;
    }
    
    /**
     * Initialise la session.
     * 
     * @param idUser L'id de l'utilisateur
     */
    public static void initSession(int idUser){
        Random rand = new Random(); 
        int nombreAleatoire = rand.nextInt(99 - 10 + 1) + 10;
        idSession = String.valueOf(nombreAleatoire) + String.valueOf(idUser);
        lesVarSession = new ArrayList<Object>();
    }
    
    /**
     * Efface les données de la session
     */
    public static void destructSession(){
        idSession = null;
        lesVarSession = null;
    } 
    
    /**
     * Controle si la session est correct, si elle ne l'est pas elle détruit les donnée et généère une exception.
     * 
     * @throws Exception Génère une exception si l'idSession est vide.
     */
    public static void controlSession() throws Exception{
        if(idSession == null || idSession.isBlank()){
            Session.destructSession();
            throw new Exception("Erreur : Vous n'êtes pas connecté ou votre session est incorrect !");
        }
    }
}
