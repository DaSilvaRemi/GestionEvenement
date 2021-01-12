/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.text.Element;

/**
 *
 * @author remi
 */
public abstract class Session {
    
    private static String idSession;
    private static ArrayList<Object> lesVarSession = new ArrayList<Object>();

    /**
     * @return the idSession
     */
    public static String getIdSession() {
        return idSession;
    }

    /**
     * @return the variableSession
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
     * 
     * 
     * @param sessionVar the variableSession to set
     */
    public static void setVariableSession(ArrayList<Object> sessionVar) {
        lesVarSession = sessionVar;
    }
    
    public static void initSession(int idUser){
        Random rand = new Random(); 
        int nombreAleatoire = rand.nextInt(99 - 10 + 1) + 10;
        idSession = String.valueOf(nombreAleatoire) + String.valueOf(idUser);
    }
}
