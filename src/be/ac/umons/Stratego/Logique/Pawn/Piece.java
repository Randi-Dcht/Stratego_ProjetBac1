package Stratego.Logique.Pawn;

import Stratego.Logique.Other.Box;
import Stratego.Logique.Player.Player;

public abstract class Piece
{
    enum IdPiece{E01,E02,D03,S04,L05,C06,C07,C08,G09,M10,D00,B11}; //c'est première lettre du nom + grade
    protected Box position;
    public final Player joueur;               /*Utiliser dans la méthode stateLife pour prévenir le joueur*/
    public final NomPiece monNom;
    public final IdPiece id;
    protected boolean vivant = true;   /*permet de savoir si le pion est mort ou vivant*/
    protected boolean visible = false; /*permet de voir si l'adversiare l'a déjà vu*/
    protected boolean jattaque = false; /*permet de savoir s'il y a eu une attaque lors d'un déplacement*/

    public Piece(Player joueur_, NomPiece nom, IdPiece id_)//changer avec nom du joueur directement
    {
        joueur = joueur_;
        this.monNom = nom;
        this.id = id_;
    }



    /**
     *Cette méthode permet de voir si le pion est mort par la variable vivant qui est un boolean
     *qui sera false si le pion meurt lors d'un combat.
     *Elle va retirer le pion de la grille et prévenir le joueur qu'un de ses pions est mort.
     */
    public void stateLife() /*il faut intégrer le joueur pour le nombre de piece mort*/
    {
        if(!this.vivant)
        {
            //Summary.WRITE("stateLife : le piont " + this + "est mort");
            position.from();
            position = null;
            joueur.dead();    /*on appelle la méthode dead du joueur pour lui dire que ce pion est mort*/
        }
    }



    /**
     *Cette méthode est <b> appelé juste une fois </b> lorsque l'on veut placer le pion sur la grille

     @param endroit qui est un emplacement dans la grille
     */
    public boolean placeMe(Box endroit)
    {
        if(joueur.wherePlace()[0] <= endroit.x && joueur.wherePlace()[1] >= endroit.x && joueur.wherePlace()[2] <= endroit.y && joueur.wherePlace()[3] >= endroit.y && !endroit.occupe)
        {
            position = endroit;
            position.arrived(this);
            //Summary.WRITE("placeMe : "+ this.monNom + " en " + endroit);
            return true;
        }
        else
        {
            //Summary.WRITE("placeMe : erreur d'emplacement pour ce pion("+this+")");
            return false;
        }
    }

    /**
     *Cette méthode peut être appeler lorque l'on a mal placé un pion et que l'on veut le changer de
     *place pour le replacer par la suite.
     */
    public void removeMe()
    {
        position.from();
        position = null;
    }

    public String toString()
    {
        return "[" + monNom + " à " + joueur + position + "]";
    }

    public boolean displacement(Box position)
    {
        if(possible(position) && position != null)
        {
            this.position.from();/*prévient la case que le piont quitte cette case*/
            this.position = position;
            this.position.arrived(this); /*prévient la case que le piont arrive*/
            return true;
        }
        return false;
    }

    public boolean getLife()
    {
        return vivant;
    }

    /*les méthodes abstraites (définit dans MovePiece et AttackOpponent)*/
    public abstract boolean possible(Box position);
    public abstract void attack(Piece pion);
}
