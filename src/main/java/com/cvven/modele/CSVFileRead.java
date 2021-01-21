/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvven.modele;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.DateValidator;
/**
 * Classe technique permettant de lire les fichiers CSV
 * 
 * @author remi
 */
public class CSVFileRead{
    /**
     * Le fichier à lire
     */
    private final File file;
    /**
     * Le fichier CSV
     */
    private CSVReader fileRead; 
    
    
    private ArrayList<String[]> lesLignes;
    
    /**
     * Constructeur par défaut
     * 
     * @param file le fichier à lire
     */
    public CSVFileRead(File file) {
        this.file = file;
        this.lesLignes = new ArrayList<>();
    }
    
    /**
     * Retourne le fichier
     * 
     * @return 
     */
    public File getFile(){
        return this.file;
    }
    
    /**
     * Retourne le fichier en mode lecture
     * 
     * @return le fichier à lire
     */
    public CSVReader getFileRead() {
        return this.fileRead;
    }
    
    /**
     * Retournes les lignes du fichier CSV si le fichier à été précedemment lu sinon elle ne renvoie rien.
     * 
     * Les lignes du fichier CSV, chacune de ces lignes contients diverses données placée dans cet ordre :
     * 1 : Le nom du participant.
     * 2 : Le prénom du participant.
     * 3 : L'adresse e-mail du partcipant.
     * 4 : La date de naissance du participant.
     * 5 : L'organisation du participant. 
     * 6 : La description du participant.
     *
     * @return Les lignes contenant les données
     */
    public ArrayList<String[]> getLesLignes() {
        return this.lesLignes;
    }

    /**
     * Ouvre le fichier s'il n'est pas un répertoire et qu'il à les droits de lecture.
     * 
     * @throws FileNotFoundException 
     * @throws Exception
     */
    public void openFile() throws FileNotFoundException, Exception{
        if(this.file.isDirectory() || !this.file.isFile()){
            throw new Exception("Le fichier est un répertoire");
        }else if(!this.file.canRead()){
            throw new Exception("Le fichier ne peut pas être lu !");
        }else{
            this.fileRead = new CSVReader(new FileReader(this.file));
        }
    }
    
    /**
     * Ferme le fichier.
     * 
     * @throws IOException 
     */
    public void closeFile() throws IOException{
        this.getFileRead().close();
    }
    
     /**
      * Lit le contenu du fichier, stock les informations du fichier et retourne les informations.
      * 
      * Le fichier est ouvert et fermé automatiquement.
      * 
      * @return Toutes les lignes du fichier
      */
    public ArrayList<String[]> readFile(){
        try {
            this.openFile();
            String uneLigne[];
            while((uneLigne = this.getFileRead().readNext()) != null){
                   this.lesLignes.add(uneLigne);  
            }
            this.closeFile();
            return this.lesLignes;
        } catch (FileNotFoundException ex) {
            DialogTools.openMessageDialog(ex.toString(), "Erreur Fichier Non Trouvée !", DialogTools.WARNING_MESSAGE);
        } catch (IOException ex) {
            DialogTools.openMessageDialog(ex.toString(), "Erreur Fichier Lecture !", DialogTools.WARNING_MESSAGE);
        } catch (Exception ex) {
            DialogTools.openMessageDialog(ex.toString(), "Erreur Fichier Données !", DialogTools.WARNING_MESSAGE);
        }
        return null;
    }
    
    /**
     * Lit le contenu du fichier, vérifie les informations, stock les informations vérifié et retourne les informations.Le fichier est ouvert et fermé automatiquement.
     * 
     * 
     * @return Les lignes du fichier controlés.
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public ArrayList<String[]> readControlFile() throws SQLException, ClassNotFoundException{
        if(this.readFile() == null){
            return null;
        }else{
            this.controlData();
            return this.lesLignes;
        }
    }
    
    /**
     * Controle les données du fichier
     * 
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    private void controlData() throws SQLException, ClassNotFoundException{
        ArrayList<String[]> lesLignesValides = new ArrayList<>();
        for(String[] uneLigne: this.lesLignes){
            boolean dataIsCorrect = true;
            for(String data : uneLigne){
                if(data.isBlank()){
                    dataIsCorrect = false;
                    break;
                }else{
                    switch(data){
                        case "nom":
                        case "prenom":
                        case "adressemail":
                        case "datenaissance":
                        case "organisation" :
                        case "description":
                            dataIsCorrect = false;
                            break; 
                    }
                    
                    if(!dataIsCorrect){
                        break;
                    }
                }
            }
            if(dataIsCorrect){
                if(EmailValidator.getInstance().isValid(uneLigne[2]) && DateValidator.getInstance().isValid(uneLigne[3]) && uneLigne[5].length() <= 255 && this.controlEmail(uneLigne[2])){ 
                    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                    uneLigne[3] = formatDate.format(uneLigne[3]);
                    lesLignesValides.add(uneLigne);
                }
            }
        }
        this.lesLignes = lesLignesValides;
    }
    
    /**
     * Controle si l'email est déja existant
     * 
     * @param email l'email
     * @return si l'email est existant ou non
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    private boolean controlEmail(String email) throws SQLException, ClassNotFoundException{
        GestionEvenementModele laGestionEvenementModele = new GestionEvenementModele();
        laGestionEvenementModele.setDb();
        return laGestionEvenementModele.countEmailParticipant(email).getInt("email") == 0;
    }
    
}
