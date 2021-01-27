/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.vue;

import com.cvven.modele.DialogTools;
import com.cvven.modele.GestionEvenementModele;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * Classe Métier Autogénérer Héritière de JFrame
 *
 * @author remi
 */
public class AfficherEvenements extends javax.swing.JFrame {

    /**
     * Créer un nouveau formulaire AfficherEvenements
     */
    public AfficherEvenements() {
        initComponents();
    }
    
    /**
     * Met tous les évènements créer quelque soit leur état dans le tableau.
     * 
     * @return Un boolean selon si le remplissage des champs se sont bien passé.
     * @see DialogTools
     * @see ClassNotFoundException
     * @see SQLException
     */
    public final boolean setValueDisplayEvent(){
        try {
            GestionEvenementModele laGestionEvenementModele = new GestionEvenementModele();
            laGestionEvenementModele.setDb();
            ResultSet result = laGestionEvenementModele.selectInfoTableEvent();
            ArrayList<Object> listOfData = new ArrayList<Object>();
            while(result.next())
            {
                listOfData.add(result.getString("intitule"));
                listOfData.add(result.getString("type"));
                listOfData.add(result.getString("date"));
                listOfData.add(result.getInt("duree"));
                listOfData.add(result.getString("theme"));
                listOfData.add(result.getInt("nbParticipant"));
                listOfData.add(result.getString("organisateur"));
                listOfData.add(result.getBoolean("archive"));
                ((DefaultTableModel)tableEvent.getModel()).addRow(listOfData.toArray());
                listOfData.clear();
            }
            tableEvent.setShowGrid(true);
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            DialogTools.openMessageDialog(ex.getMessage(), "Erreur SQL !", DialogTools.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Cette méthode est appelé dans le constructeur pour initialisez le formulaire
     * Attention : Ne modifiez surtout pas ce code ! Le contenue de la méthode est toujours regénéré par l'éditeur du formulaire
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableEvent = new javax.swing.JTable();
        navBar = new javax.swing.JMenuBar();
        accueilNav = new javax.swing.JMenu();
        inputEventNav = new javax.swing.JMenu();
        inputParticipantNav = new javax.swing.JMenu();
        DisplayEventNav = new javax.swing.JMenu();
        deconnexionNav = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBackground(new java.awt.Color(254, 247, 247));

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Affichage des évènements");

        tableEvent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        tableEvent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Intitule", "Type", "Date", "Duree", "Theme", "Nombre participant", "Organisateur", "Archivé"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEvent.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tableEvent);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        navBar.setForeground(javax.swing.UIManager.getDefaults().getColor("MenuBar.background"));

        accueilNav.setText("Accueil");
        accueilNav.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        accueilNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accueilNavMouseClicked(evt);
            }
        });
        navBar.add(accueilNav);

        inputEventNav.setText("Saisir un évènement");
        inputEventNav.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        inputEventNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputEventNavMouseClicked(evt);
            }
        });
        navBar.add(inputEventNav);

        inputParticipantNav.setText("Saisir un participant");
        inputParticipantNav.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        inputParticipantNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputParticipantNavMouseClicked(evt);
            }
        });
        navBar.add(inputParticipantNav);

        DisplayEventNav.setText("Afficher les évènements");
        DisplayEventNav.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        DisplayEventNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DisplayEventNavMouseClicked(evt);
            }
        });
        navBar.add(DisplayEventNav);

        deconnexionNav.setText("Deconnexion");
        deconnexionNav.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        deconnexionNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deconnexionNavMouseClicked(evt);
            }
        });
        navBar.add(deconnexionNav);

        setJMenuBar(navBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Ouvre la fenêtre d'acceuil lorsque le bouton Acceuil de la barre de navigation est cliqué
     * 
     * @param evt 
     */
    private void accueilNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accueilNavMouseClicked
        Accueil fen = new Accueil();
        fen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_accueilNavMouseClicked

    /**
     * Ouvre la fenêtre d'ajout d'évènement lorsque le bouton Saisir un évènement de la barre de navigation est cliqué
     * 
     * @param evt 
     */
    private void inputEventNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputEventNavMouseClicked
        AjoutEvenement fen = new AjoutEvenement();
        if(fen.setValueEvent()){
             fen.setVisible(true);
             this.dispose();
        }else {
            fen.dispose();
        }
    }//GEN-LAST:event_inputEventNavMouseClicked

    /**
     * Ouvre la fenêtre d'ajout des participants lorsque le bouton Saisir un participant de la barre de navigation est cliqué
     * 
     * @param evt 
     */
    private void inputParticipantNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputParticipantNavMouseClicked
        AjoutParticipant fen = new AjoutParticipant();
        if(fen.setValueParticipant()){
            fen.setVisible(true);
            this.dispose();
        }else{
            fen.dispose();
        }
    }//GEN-LAST:event_inputParticipantNavMouseClicked

     /**
     * Ouvre la fenêtre d'affichage des évènements lorsque le bouton Afficher les évènements de la barre de navigation est cliqué
     * 
     * @param evt 
     */
    private void DisplayEventNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DisplayEventNavMouseClicked
        AfficherEvenements fen = new AfficherEvenements();
        if(fen.setValueDisplayEvent()){
            fen.setVisible(true);
            this.dispose();
        }else{
            fen.dispose();
        }
    }//GEN-LAST:event_DisplayEventNavMouseClicked

    /**
     * Ouvre la fenêtre de deconnexion lorsque le bouton Deconnexion de la barre de navigation est cliqué
     * 
     * @param evt 
     */
    private void deconnexionNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deconnexionNavMouseClicked
        Authentification fen = new Authentification();
        fen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_deconnexionNavMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AfficherEvenements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AfficherEvenements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AfficherEvenements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AfficherEvenements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AfficherEvenements().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu DisplayEventNav;
    private javax.swing.JMenu accueilNav;
    private javax.swing.JMenu deconnexionNav;
    private javax.swing.JMenu inputEventNav;
    private javax.swing.JMenu inputParticipantNav;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar navBar;
    private javax.swing.JTable tableEvent;
    // End of variables declaration//GEN-END:variables
}
