/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.gestioncollocation;
import com.cvven.vue.Authentification;

/**
 * Classe principale(main) éxécutant la page d'authentification.
 * 
 * @author remi
 */
public class GestionCollocation {

    /**
     * Fontion main affichant la fenêtre d'authentification.
     * 
     * @param args Les arguments en ligne de commande
     */
    public static void main(String[] args) {
        Authentification fen = new Authentification();
        fen.setVisible(true);
    }
    
}
