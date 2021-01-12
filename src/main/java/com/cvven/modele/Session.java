/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author remi
 */
public abstract class Session {
    
    /**
     * Composé d'un nombre aléatoire + l'idUser
     */
    private static String idSession;
    private static ArrayList<Object> lesVarSession = new ArrayList<Object>();

    /**
     * Retourne la clé de session composé d'un nombre aléatoire + l'idUser
     * 
     * @return la clé de session
     */
    public static String getIdSession() {
        return idSession;
    }

    /**
     * Retroune les variable session sous forme de tableau
     * 
     * @return les variables sessions
     */
    public static ArrayList<Object> getVariableSession() {
        return lesVarSession;
    }
    
    /**
     * Retourne l'id de l'utilisateur stocké dans la variable d'id Session
     * 
     * @return l'id de l'utilisateur
     */
    public static int getIdUser(){
        return Integer.parseInt(String.valueOf(idSession.charAt(2)));
    }

    /**
     * Défini les variable sessions
     * 
     * @param sessionVar the variableSession to set
     */
    public static void setVariableSession(ArrayList<Object> sessionVar) {
        lesVarSession = sessionVar;
    }
    
    /**
     * Initialise la session
     * 
     * @param idUser 
     */
    public static void initSession(int idUser){
        Random rand = new Random(); 
        int nombreAleatoire = rand.nextInt(99 - 10 + 1) + 10;
        idSession = String.valueOf(nombreAleatoire) + String.valueOf(idUser);
    }
    
    /**
     * Efface les données de la session
     */
    public static void destructSession(){
        idSession = null;
        lesVarSession.clear();
    } 
}
