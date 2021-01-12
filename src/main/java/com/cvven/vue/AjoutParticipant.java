/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.vue;
import com.cvven.modele.DialogTools;
import com.cvven.modele.GestionEvenementModele;
import java.sql.SQLException;
import org.apache.commons.validator.routines.EmailValidator;

/**
 * Classe Métier Autogénérer Héritière de JFrame
 *
 * @author remi
 */
public class AjoutParticipant extends javax.swing.JFrame {

    /**
     * Créer un nouveau formulaire AjoutParticipant
     */
    public AjoutParticipant() {
        initComponents();
    }
    
    /**
     * Efface tous les champs et la selection
     */
    public void clearField(){
        selectLesEvents.setSelectedIndex(-1);
        nomParticipant.setText(null);
        prenomParticipant.setText(null);
        adresseMailParticipant.setText(null);
        dateNaissanceParticipant.setDateFormatString(null);
        organisationParticipant.setText(null);
        observationsParticipant.setText(null);
    }

    /*-----------------------------Initialisation des composents----------------------
    /**
     * Cette méthode est appelé dans le constructeur pour initialisez le formulaire
     * Attention : Ne modifiez surtout pas ce code ! Le contenue de la méthode est toujours regénéré par l'éditeur du formulaire
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        selectLesEvents = new javax.swing.JList<>();
        nomParticipant = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        prenomParticipant = new javax.swing.JTextField();
        adresseMailParticipant = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        organisationParticipant = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateNaissanceParticipant = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        observationsParticipant = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        nbCharObservation = new javax.swing.JLabel();
        addParticipant = new javax.swing.JButton();
        annulerParticipant = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        navBar = new javax.swing.JMenuBar();
        accueilNav = new javax.swing.JMenu();
        inputEventNav = new javax.swing.JMenu();
        inputParticipantNav = new javax.swing.JMenu();
        DisplayEventNav = new javax.swing.JMenu();
        deconnexionNav = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(623, 745));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ajouter un participant");

        selectLesEvents.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        selectLesEvents.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Aucun évènement !" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(selectLesEvents);

        nomParticipant.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel2.setText("Nom");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel3.setText("Prénom");

        prenomParticipant.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        adresseMailParticipant.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel4.setText("Adresse mail");

        organisationParticipant.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel5.setText("Organisation");

        dateNaissanceParticipant.setDateFormatString("yyyy-MM-dd");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel6.setText("Date de naissance");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel7.setText("Observations");

        observationsParticipant.setColumns(20);
        observationsParticipant.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        observationsParticipant.setRows(5);
        observationsParticipant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                observationsParticipantKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                observationsParticipantKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(observationsParticipant);

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel8.setText("Selectionner un ou plusieurs évènements");

        nbCharObservation.setText("/255");

        addParticipant.setBackground(new java.awt.Color(34, 139, 34));
        addParticipant.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        addParticipant.setText("Ajouter");
        addParticipant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addParticipantMouseClicked(evt);
            }
        });

        annulerParticipant.setBackground(new java.awt.Color(151, 21, 40));
        annulerParticipant.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        annulerParticipant.setText("Annuler");
        annulerParticipant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                annulerParticipantMouseClicked(evt);
            }
        });

        footer.setBackground(java.awt.Color.darkGray);
        footer.setForeground(java.awt.Color.white);

        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setText("Application développé par le Groupe 2 PPE de la 2 BTS SIO SL au Lycée René Descartes");

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE))
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(addParticipant, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(annulerParticipant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel8)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nbCharObservation))
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(organisationParticipant)
                    .addComponent(dateNaissanceParticipant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adresseMailParticipant)
                    .addComponent(prenomParticipant)
                    .addComponent(nomParticipant)
                    .addComponent(jScrollPane1))
                .addContainerGap(152, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomParticipant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prenomParticipant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adresseMailParticipant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateNaissanceParticipant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(organisationParticipant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nbCharObservation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addParticipant)
                    .addComponent(annulerParticipant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
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
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*----------------------------Barre de navigation----------------------------*/
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
        if(fen.insertSalleEvent()){
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
        fen.setVisible(true);
        this.dispose();
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
        this.dispose();
    }//GEN-LAST:event_deconnexionNavMouseClicked

    /*----------------------------Event Annuler----------------------------*/
    /**
     * Ouvre la fenêtre d'acceuil lorsque le bouton Annuler est cliqué
     * 
     * @param evt 
     */
    private void annulerParticipantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_annulerParticipantMouseClicked
        Accueil fen = new Accueil();
        fen.setVisible(true);
        this.clearField();
        this.dispose();
    }//GEN-LAST:event_annulerParticipantMouseClicked

    /*----------------------------Event Nb Char----------------------------*/
    /**
     * Compte le nombre de caractère du champ "observation" lorsque une touche est préssé
     * 
     * @param evt 
     */
    private void observationsParticipantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_observationsParticipantKeyPressed
        nbCharObservation.setText(observationsParticipant.getText().length() + "/255");
    }//GEN-LAST:event_observationsParticipantKeyPressed

    /**
     * Compte le nombre de caractère du champ "observation" lorsque une touche est relaché
     * 
     * @param evt 
     */
    private void observationsParticipantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_observationsParticipantKeyReleased
        nbCharObservation.setText(observationsParticipant.getText().length() + "/255");
    }//GEN-LAST:event_observationsParticipantKeyReleased

    /*----------------------------Event Envoyer----------------------------*/
    /**
     * Ajoute un participant lorsque le bouton "Ajouter" est cliqué et que tous les champs sont remplis sinon on affiche un message d'erreur sur une fenêtre JDialog.
     * -Pour le champ "Observation" il est aussi vérifé que le nombre de caractère ne dépassent pas 255 caractères
     * 
     * Une fois vérifié on insère les données en capturant les evenutels erreurs;
     *  -Si une erreur est capturé alors on affiche le message sur une JDialog
     * 
     * @param evt
     * 
     * @see clearField
     * @see JDateChooser
     * @see DialogTools
     * @see SQLException
     * @see ClassNotFoundException
     */
    private void addParticipantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addParticipantMouseClicked
        if(selectLesEvents.getSelectedValuesList().isEmpty()){
            DialogTools.openMessageDialog("Veuilllez selectionnez au moins un évènement !", "Erreur", DialogTools.ERROR_MESSAGE);
        }else if(nomParticipant.getText().isBlank()){
            DialogTools.openMessageDialog("Veuilllez entrez un nom !", "Erreur", DialogTools.ERROR_MESSAGE);
        }else if(prenomParticipant.getText().isBlank()){
            DialogTools.openMessageDialog("Veuilllez entrez un prénom !", "Erreur", DialogTools.ERROR_MESSAGE);
        }else if(adresseMailParticipant.getText().isBlank() || !EmailValidator.getInstance().isValid(adresseMailParticipant.getText())){
            DialogTools.openMessageDialog("Veuilllez entrez une adresse mail valide !", "Erreur", DialogTools.ERROR_MESSAGE);
        }else if(dateNaissanceParticipant.getDateFormatString().isBlank()){
            DialogTools.openMessageDialog("Veuilllez entrez une date de naissance !", "Erreur", DialogTools.ERROR_MESSAGE);
        }else if(organisationParticipant.getText().isBlank()){
            DialogTools.openMessageDialog("Veuilllez selectionnez au moins un évènement !", "Erreur", DialogTools.ERROR_MESSAGE);
        }else if(observationsParticipant.getText().isBlank() || observationsParticipant.getText().length() > 255){
            if(observationsParticipant.getText().isBlank()){
                DialogTools.openMessageDialog("Veuillez indiquez une observation", "Erreur", DialogTools.ERROR_MESSAGE);
            }else{
                DialogTools.openMessageDialog("Veuillez ne pas dépassez les 255 caractères", "Erreur", DialogTools.ERROR_MESSAGE);
            }
        }else{
            try {
                GestionEvenementModele laGestionEvenementModele = new GestionEvenementModele();
                laGestionEvenementModele.setDb();
                laGestionEvenementModele.insertParticipant(nomParticipant.getText(), prenomParticipant.getText(), adresseMailParticipant.getText(),
                        dateNaissanceParticipant.getDateFormatString(), organisationParticipant.getText(), observationsParticipant.getText());
                laGestionEvenementModele.closeAll();
                DialogTools.openMessageDialog("L'ajout de participant est terminée !","Ajout Terminée");
                this.clearField();
            } catch (SQLException | ClassNotFoundException ex) {
                DialogTools.openMessageDialog(ex.getMessage(), "Erreur !", DialogTools.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_addParticipantMouseClicked
            
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
            java.util.logging.Logger.getLogger(AjoutParticipant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutParticipant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutParticipant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutParticipant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjoutParticipant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu DisplayEventNav;
    private javax.swing.JMenu accueilNav;
    private javax.swing.JButton addParticipant;
    private javax.swing.JTextField adresseMailParticipant;
    private javax.swing.JButton annulerParticipant;
    private javax.swing.JPanel body;
    private com.toedter.calendar.JDateChooser dateNaissanceParticipant;
    private javax.swing.JMenu deconnexionNav;
    private javax.swing.JPanel footer;
    private javax.swing.JMenu inputEventNav;
    private javax.swing.JMenu inputParticipantNav;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar navBar;
    private javax.swing.JLabel nbCharObservation;
    private javax.swing.JTextField nomParticipant;
    private javax.swing.JTextArea observationsParticipant;
    private javax.swing.JTextField organisationParticipant;
    private javax.swing.JTextField prenomParticipant;
    private javax.swing.JList<String> selectLesEvents;
    // End of variables declaration//GEN-END:variables
}