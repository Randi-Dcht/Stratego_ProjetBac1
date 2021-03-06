package be.ac.umons.Stratego.Logique.Pawn;

import be.ac.umons.Stratego.Logique.Other.Box;
import be.ac.umons.Stratego.Logique.Player.Player;

public abstract class MovePiece extends Piece
{
    public MovePiece(Player joueur, NomPiece nom, IdPiece id)
    {
        super(joueur,nom,id);

    }



    /**
     *cette méthode permet de calculer une différence entre deux points

     @param position c'est la position où le pion doit aller après son déplacement.
     @return un tableau de int avec l'absice en position 0 et l'ordonnée en position 1.
     */
    public int[] delta (Box position)
    {
        int[] tab = new int[2];
        tab[0] = Math.abs(position.x - this.position.x);
        tab[1] = Math.abs(position.y - this.position.y);
        return tab;
    }


    /**
     *Cette méthode regarde si le pion se déplace bien en ligne droite sur le plateau.
     @param tableau qui contient la différence des absice et des ordonnées.
     @return true si le pion va tout droit et false si le pion se déplace en diagonal.
     */
    public boolean goright(int[] tableau) //bonne utilisation: utiliser la méthode delta pour le tableau en paramètre
    {
        if(tableau[0] == 0 || tableau[1] == 0)
        {
            return true;
        }
        return false;
    }



    /**
     *Cette méthode permet de déplacer le pion sur le grille en <b>modifiant</b> la varaible position.

     @param position elle prend uniquement la case où le pion sera après son déplacement.
     */
    public boolean possible(Box position)
    {
        jattaque = false;
        if(position.player() != this.joueur && goright(delta(position)))
        {
            //Summary.WRITE("displacement : déplacement de "+ this + " à " + position);
            if (position.occupe && position.whoOccupant() != null) //regarde s'il est possible d'attaquer un piont adverse et appelle la méthode t'attaque.
            {
                jattaque = true;
                attack(position.whoOccupant());
            }
            if (position.occupe && position.whoOccupant() == null) //si c'est un obstacle alors pas déplacement
            {
                return false;
            }
            if (this.position != null) //si le pion est mort il ne doit plus être déplacé
            {
                return true;
            }
            //return true;
        }
        //Summary.WRITE("displacement :"+this.monNom+" déplecement impossible en " + position);
        return false;
    }


    public abstract void attack(Piece piece);
}
