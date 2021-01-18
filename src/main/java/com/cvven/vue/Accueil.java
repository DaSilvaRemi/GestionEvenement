/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.vue;

import com.cvven.modele.Session;

/**
 * Classe Métier Autogénérer Héritière de JFrame
 *
 * @author remi
 */
public class Accueil extends javax.swing.JFrame {

    /**
     * Créer un nouveau formulaire Accueil
     */
    public Accueil() {
        initComponents();
    }
    /**
     * Cette méthode est appelé dans le constructeur pour initialisez le formulaire
     * Attention : Ne modifiez surtout pas ce code ! Le contenue de la méthode est toujours regénéré par l'éditeur du formulaire
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        saisirEventButton = new javax.swing.JButton();
        saisirParticipantButton = new javax.swing.JButton();
        displayEventButton = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        navBar = new javax.swing.JMenuBar();
        accueilNav = new javax.swing.JMenu();
        inputEventNav = new javax.swing.JMenu();
        inputParticipantNav = new javax.swing.JMenu();
        DisplayEventNav = new javax.swing.JMenu();
        deconnexionNav = new javax.swing.JMenu();

        header.setBackground(java.awt.Color.darkGray);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Authentification");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        body.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion des évènements");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setText("Bienvenue sur l'application de gestion des évènements");

        saisirEventButton.setBackground(new java.awt.Color(20, 132, 242));
        saisirEventButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        saisirEventButton.setText("Saisir un évènement");
        saisirEventButton.setToolTipText("");
        saisirEventButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saisirEventButtonMouseClicked(evt);
            }
        });

        saisirParticipantButton.setBackground(new java.awt.Color(20, 132, 242));
        saisirParticipantButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        saisirParticipantButton.setText("Saisir un participant");
        saisirParticipantButton.setToolTipText("");
        saisirParticipantButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saisirParticipantButtonMouseClicked(evt);
            }
        });

        displayEventButton.setBackground(new java.awt.Color(20, 132, 242));
        displayEventButton.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        displayEventButton.setText("Afficher les évènements");
        displayEventButton.setToolTipText("");
        displayEventButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayEventButtonMouseClicked(evt);
            }
        });

        footer.setBackground(java.awt.Color.darkGray);
        footer.setForeground(java.awt.Color.white);

        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Application développé par le Groupe 2 PPE de la 2 BTS SIO SL au Lycée René Descartes");

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CVVEN");

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                        .addGap(0, 178, Short.MAX_VALUE)
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                                .addComponent(saisirEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(saisirParticipantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(187, 187, 187))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                                .addComponent(displayEventButton)
                                .addGap(286, 286, 286))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saisirEventButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saisirParticipantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(displayEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     * 
     * @param evt 
     */
    private void saisirEventButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saisirEventButtonMouseClicked
        AjoutEvenement fen = new AjoutEvenement();
        if(fen.setValueEvent()){
             fen.setVisible(true);
             this.dispose();
        }else {
            fen.dispose();
        }
    }//GEN-LAST:event_saisirEventButtonMouseClicked

    private void saisirParticipantButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saisirParticipantButtonMouseClicked
        AjoutParticipant fen = new AjoutParticipant();
        if(fen.setValueParticipant()){
            fen.setVisible(true);
            this.dispose();
        }else{
            fen.dispose();
        }
    }//GEN-LAST:event_saisirParticipantButtonMouseClicked

    private void displayEventButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayEventButtonMouseClicked
        AfficherEvenements fen = new AfficherEvenements();
        fen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_displayEventButtonMouseClicked

    /*-----------------------------Barre de navigation-----------------------------*/
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
        fen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DisplayEventNavMouseClicked

    /**
     * Ouvre la fenêtre de deconnexion lorsque le bouton Deconnexion de la barre de navigation est cliqué
     * 
     * @param evt 
     */
    private void deconnexionNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deconnexionNavMouseClicked
        Authentification fen = new Authentification();
        fen.setVisible(true);
        Session.destructSession();
        this.dispose();
    }//GEN-LAST:event_deconnexionNavMouseClicked

     /**
     * Ouvre la fenêtre d'affichage des évènements lorsque le bouton Acceuil de la barre de navigation est cliqué
     * 
     * @param evt 
     */
    private void accueilNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accueilNavMouseClicked
        Accueil fen = new Accueil();
        fen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_accueilNavMouseClicked

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
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accueil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu DisplayEventNav;
    private javax.swing.JMenu accueilNav;
    private javax.swing.JPanel body;
    private javax.swing.JMenu deconnexionNav;
    private javax.swing.JButton displayEventButton;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JMenu inputEventNav;
    private javax.swing.JMenu inputParticipantNav;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar navBar;
    private javax.swing.JButton saisirEventButton;
    private javax.swing.JButton saisirParticipantButton;
    // End of variables declaration//GEN-END:variables
}
