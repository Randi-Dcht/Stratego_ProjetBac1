package be.ac.umons.Stratego.Logique.Other;

import be.ac.umons.Stratego.Gui.BoardGui;
import be.ac.umons.Stratego.Logique.Player.Player;
import javafx.stage.Stage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveOldGame
{
    /**
     *Cette méthode sauveguarde dans un fichier binaire la partie.
     @param joueurs qui sont les joueurs qui ont jouée la partie.
     @param plateauJeu qui est le plateau de jeu avec les pièces.
     @param paysage qui permet de sauveguarder le paysage choisie par l'utilisateur.
     */
    public static void saveGame(String fichier, Player[] joueurs, Box[][] plateauJeu, String[] paysage)
    {
        try
        {
            ObjectOutputStream sortie;
            sortie = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("misc/" + fichier+".save"))));
            sortie.writeObject(joueurs);
            sortie.writeObject(plateauJeu);
            sortie.writeObject(paysage);
            sortie.close();
        }
        catch(IOException e)
        {
            //Summary.ERROR(e,"saveGame");
        }
    }

    /**
     *Cette méthode permet d'ouvrir une partie déjà commencée.
     @param fichier du fichier de la partie.
     */
    public static void oldGame(String fichier)
    {
        try
        {
            ObjectInputStream entree;
            entree = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("misc/" + fichier +".save"))));
            Player[] liste = (Player[]) entree.readObject();
            Box[][] plateau = (Box[][]) entree.readObject();
            String[] paysage = (String[]) entree.readObject();
            /* -- permet de démarer la partie demandé (ancienne) -- */
            Stage stg = new Stage();
            //Summary.REOPEN(fichier);
            BoardGui bg = new BoardGui(liste,plateau,paysage,fichier);
            Board.plateau = plateau;
            bg.start(stg);
        }
        catch(ClassNotFoundException  e)
        {
            //Summary.ERROR(e,"oldGame");
        }
        catch (FileNotFoundException e)
        {
            //Summary.ERROR(e,"oldGame");
        }
        catch (IOException e)
        {
            //Summary.ERROR(e,"oldGame");
        }
    }

    /**
     *Cette méthode permet de supprimer le fichier binaire de la partie lorsque celle-ci est finie.
     @param fichier (String)
     */
    public static void finishGame(String fichier)
    {
        try
        {
            File supprime = new File("misc/" + fichier +".save");
            supprime.delete();
        }
        catch(Exception e)
        {
            //Summary.ERROR(e,"finishGame");
        }
    }

    /**
     *Cette méthode permet de nettoyer une chaine de caractère.
     @param chaine qui est le String à nettoyer.
     */
    public static String analyser(String chaine)
    {
        String[] decoupe  = chaine.split("[/.]");
        return decoupe[2];
    }

    /**
     *Cette méthode permet de voir le nom de tous les fichiers dans un répertoire.
     */
    public static File[] listItems()
    {
        File repertoire = new File("misc/");
        File[] fichiers =repertoire.listFiles();
        return fichiers;
    }

}
