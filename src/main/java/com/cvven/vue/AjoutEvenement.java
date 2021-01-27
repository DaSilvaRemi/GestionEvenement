/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.vue;
import com.cvven.modele.DialogTools;
import com.cvven.modele.GestionEvenementModele;
import com.cvven.modele.Session;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe Métier Autogénérer Héritière de JFrame
 *
 * @author remi
 */
public class AjoutEvenement extends javax.swing.JFrame {

    /**
     * Créer un nouveau formulaire AjoutEvenement
     */
    public AjoutEvenement() {
        initComponents();
    }
    
    
    /**
     * Efface tous les champs et remet les select à la valeur initial
     */
    private void setDefaultValue(){
        intituleEvent.setText(null);
        themeEvent.setText(null);
        dateEvent.setDate(null);
        dureeEvent.setValue(15);
        organisateurEvent.setText(null);
        choixSalleEvent.setSelectedIndex(0);
        typeEvent.setSelectedIndex(0);
        descriptionEvent.setText(null);
        nbCharDescEvent.setText("0/255");
    }
    
    /**
     * Met les valeur par défault récupéré dans la BDD dans la liste de choix de salle
     * 
     * Affiche les exception dans une JDialog
     * 
     * @return Un boolean selon si le remplissage des champs se sont bien passé.
     * @see DialogTools
     * @see ClassNotFoundException
     * @see SQLException
     * 
     */
    public final boolean setValueEvent(){
        try {
            GestionEvenementModele laGestionEvenementModele = new GestionEvenementModele();
            laGestionEvenementModele.setDb();
            ResultSet result = laGestionEvenementModele.selectInfoAllSalle();
            
            if(result != null){
                boolean isExist = false;
                do{
                    String salle = "N°" + result.getString("id_salle") + " Salle de " + result.getString("typesalle") + "("+result.getString("capacite") + ")";
                    for(int i = 0; i < this.choixSalleEvent.getItemCount(); i++){
                        if(this.choixSalleEvent.getItemAt(i).equalsIgnoreCase(salle)){
                            isExist = true;
                        }
                    }
                    if(!isExist){
                        this.choixSalleEvent.addItem(salle);
                    }
                    isExist = false;
                }while(result.next());
            
                laGestionEvenementModele.closeAll();
                return true;
            }else{
                throw new SQLException("Aucune salle n'as été trouvée ! Veillez contactez l'administrateur.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            DialogTools.openMessageDialog(ex.getMessage(), "Erreur", DialogTools.ERROR_MESSAGE);
            return false;
        }
    }

    /*-----------------------------Initialisation des composents----------------------*/
    /**
     * Cette méthode est appelé dans le constructeur pour initialisez le formulaire
     * Attention : Ne modifiez surtout pas ce code ! Le contenue de la méthode est toujours regénéré par l'éditeur du formulaire
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        body = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        footer = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        intituleEvent = new javax.swing.JTextField();
        themeEvent = new javax.swing.JTextField();
        dateEvent = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionEvent = new javax.swing.JTextArea();
        organisateurEvent = new javax.swing.JTextField();
        typeEvent = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cancelEvent = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        choixSalleEvent = new javax.swing.JComboBox<>();
        ajouterEvent = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nbCharDescEvent = new javax.swing.JLabel();
        dureeEvent = new javax.swing.JSpinner();
        navBar = new javax.swing.JMenuBar();
        accueilNav = new javax.swing.JMenu();
        inputEventNav = new javax.swing.JMenu();
        inputParticipantNav = new javax.swing.JMenu();
        DisplayEventNav = new javax.swing.JMenu();
        deconnexionNav = new javax.swing.JMenu();

        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 0));
        setMinimumSize(new java.awt.Dimension(630, 780));
        setPreferredSize(new java.awt.Dimension(600, 780));
        setResizable(false);

        body.setBackground(new java.awt.Color(254, 254, 254));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ajouter un évènement");

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

        intituleEvent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        themeEvent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        dateEvent.setDateFormatString("yyyy-MM-dd");
        dateEvent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        descriptionEvent.setColumns(20);
        descriptionEvent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        descriptionEvent.setRows(5);
        descriptionEvent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descriptionEventKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descriptionEventKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(descriptionEvent);

        organisateurEvent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        typeEvent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        typeEvent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Veuillez choisir une option", "colloques", "séminaires", "congrès" }));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel1.setLabelFor(intituleEvent);
        jLabel1.setText("Intitulé de l'évènement");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel2.setLabelFor(themeEvent);
        jLabel2.setText("Thème de l'évènement");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel4.setLabelFor(dateEvent);
        jLabel4.setText("Date de l'évènement");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel6.setLabelFor(dureeEvent);
        jLabel6.setText("Durée de l'évènement(minutes)");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel7.setLabelFor(organisateurEvent);
        jLabel7.setText("Organisateur");

        cancelEvent.setBackground(new java.awt.Color(151, 21, 40));
        cancelEvent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        cancelEvent.setForeground(new java.awt.Color(1, 1, 1));
        cancelEvent.setText("Annuler");
        cancelEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelEventMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel8.setLabelFor(choixSalleEvent);
        jLabel8.setText("Choix de la salle");

        choixSalleEvent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        choixSalleEvent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Veuillez choisir une option" }));

        ajouterEvent.setBackground(new java.awt.Color(34, 139, 34));
        ajouterEvent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        ajouterEvent.setForeground(new java.awt.Color(1, 1, 1));
        ajouterEvent.setText("Créer");
        ajouterEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajouterEventMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel10.setLabelFor(typeEvent);
        jLabel10.setText("Type évènement");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel9.setLabelFor(descriptionEvent);
        jLabel9.setText("Description de l'évènement");

        nbCharDescEvent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        nbCharDescEvent.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nbCharDescEvent.setText("0/255");

        dureeEvent.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        dureeEvent.setModel(new javax.swing.SpinnerNumberModel(15, 15, 240, 1));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(intituleEvent)
                    .addComponent(themeEvent)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(ajouterEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nbCharDescEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(dureeEvent)
                    .addComponent(dateEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(organisateurEvent)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(choixSalleEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(103, Short.MAX_VALUE))
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intituleEvent, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(themeEvent, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dureeEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(organisateurEvent, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeEvent)
                    .addComponent(choixSalleEvent))
                .addGap(18, 18, 18)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nbCharDescEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ajouterEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
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

    /*----------------------------Event Body----------------------------*/
    /**
     * Compte le nombre de caractère du champ "observation" lorsque une touche est relaché
     * 
     * @param evt 
     */
    private void descriptionEventKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionEventKeyReleased
        nbCharDescEvent.setText(descriptionEvent.getText().length() + "/255");
    }//GEN-LAST:event_descriptionEventKeyReleased

    /**
     * Compte le nombre de caractère du champ "observation" lorsque une touche est tapé
     * 
     * @param evt 
     */
    private void descriptionEventKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionEventKeyTyped
        nbCharDescEvent.setText(descriptionEvent.getText().length() + "/255");
    }//GEN-LAST:event_descriptionEventKeyTyped

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
        Session.destructSession();
        this.dispose();
    }//GEN-LAST:event_deconnexionNavMouseClicked

    /*--------------------------------Boutons--------------------------------------*/
    /**
     * Ouvre la fenêtre d'acceuil lorsque le bouton Annuler est cliqué
     * 
     * @param evt 
     */
    private void cancelEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelEventMouseClicked
        Accueil fen = new Accueil();
        fen.setVisible(true);
        this.setDefaultValue();
        this.dispose();
    }//GEN-LAST:event_cancelEventMouseClicked

    /**
     * Créer un évènement lorsque le bouton "Créer" est cliqué et que tous les champs sont remplis sinon on affiche un message d'erreur sur une fenêtre JDialog.
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
    private void ajouterEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajouterEventMouseClicked
        if(intituleEvent.getText().isBlank()){
            DialogTools.openMessageDialog("Veuillez indiquez l'intitule de l'évènement", "Erreur", DialogTools.ERROR_MESSAGE);
        }else if(themeEvent.getText().isBlank()){
            DialogTools.openMessageDialog("Veuillez indiquez le thème de l'évènement", "Erreur", DialogTools.ERROR_MESSAGE);
        }else if(dateEvent.getDate() == null || dateEvent.getDate().before(new Date())){
            if(dateEvent.getDate()== null){
                DialogTools.openMessageDialog("Veuillez indiquez la date de l'évènement", "Erreur", DialogTools.ERROR_MESSAGE);
            }else if(dateEvent.getDate().before(new Date())){
                DialogTools.openMessageDialog("La date de l'évènement doit se dérouler après la date actuelle", "Erreur", DialogTools.ERROR_MESSAGE);
            }
        }else if(organisateurEvent.getText().isBlank()){
            DialogTools.openMessageDialog("Veuillez indiquez l'organisateur de l'évènement", "Erreur", DialogTools.ERROR_MESSAGE);
        }else if(typeEvent.getItemAt(typeEvent.getSelectedIndex()).equalsIgnoreCase("Veuillez choisir une option")){
            DialogTools.openMessageDialog("Veuillez choisir un évènement", "Erreur", DialogTools.ERROR_MESSAGE);
        }else if(choixSalleEvent.getItemAt(choixSalleEvent.getSelectedIndex()).equalsIgnoreCase("Veuillez choisir une option")){
            DialogTools.openMessageDialog("Veuillez choisir une salle", "Erreur", DialogTools.ERROR_MESSAGE);
        }else if(descriptionEvent.getText().isBlank() || descriptionEvent.getText().length() > 255){
            if(descriptionEvent.getText().isBlank()){
                DialogTools.openMessageDialog("Veuillez indiquez une description à l'évènement", "Erreur", DialogTools.ERROR_MESSAGE);
            }else{
                DialogTools.openMessageDialog("Veuillez ne pas dépassez les 255 caractères", "Erreur", DialogTools.ERROR_MESSAGE);
            }
        }else{
            try {
                GestionEvenementModele laGestionEvenementModele = new GestionEvenementModele();
                laGestionEvenementModele.setDb();
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                laGestionEvenementModele.insertEvent(intituleEvent.getText(), themeEvent.getText(), formatDate.format(dateEvent.getDate()), ((Integer)dureeEvent.getValue()),
                        descriptionEvent.getText(), organisateurEvent.getText(), typeEvent.getItemAt(typeEvent.getSelectedIndex()), 
                        choixSalleEvent.getItemAt(choixSalleEvent.getSelectedIndex()), Session.getIdUser());
                laGestionEvenementModele.closeAll();
                DialogTools.openMessageDialog("Insertion de l'évènement terminée !","Insertion Terminée");
                this.setDefaultValue();
            } catch (SQLException | ClassNotFoundException ex) {
                DialogTools.openMessageDialog(ex.getMessage(), "Erreur SQL Event !", DialogTools.ERROR_MESSAGE);
            } catch (Exception ex) {
                DialogTools.openMessageDialog(ex.toString(), "Erreur Session Event !", DialogTools.ERROR_MESSAGE);
                Authentification fen = new Authentification();
                fen.setVisible(true);
                Session.destructSession();
                this.dispose();
            }
        }
    }//GEN-LAST:event_ajouterEventMouseClicked

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
            java.util.logging.Logger.getLogger(AjoutEvenement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutEvenement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutEvenement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutEvenement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjoutEvenement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu DisplayEventNav;
    private javax.swing.JMenu accueilNav;
    private javax.swing.JButton ajouterEvent;
    private javax.swing.JPanel body;
    private javax.swing.JButton cancelEvent;
    private javax.swing.JComboBox<String> choixSalleEvent;
    private com.toedter.calendar.JDateChooser dateEvent;
    private javax.swing.JMenu deconnexionNav;
    private javax.swing.JTextArea descriptionEvent;
    private javax.swing.JSpinner dureeEvent;
    private javax.swing.JPanel footer;
    private javax.swing.JMenu inputEventNav;
    private javax.swing.JMenu inputParticipantNav;
    private javax.swing.JTextField intituleEvent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JMenuBar navBar;
    private javax.swing.JLabel nbCharDescEvent;
    private javax.swing.JTextField organisateurEvent;
    private javax.swing.JTextField themeEvent;
    private javax.swing.JComboBox<String> typeEvent;
    // End of variables declaration//GEN-END:variables
}
