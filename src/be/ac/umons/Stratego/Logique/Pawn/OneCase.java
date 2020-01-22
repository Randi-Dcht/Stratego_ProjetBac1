package Stratego.Logique.Pawn;

import Stratego.Logique.Other.Box;
import Stratego.Logique.Player.Player;

public abstract class OneCase extends AttackOpponent
{
    public OneCase(Player joueur, NomPiece nom, IdPiece id)
    {
        super(joueur,nom,id);
    }

    public abstract  boolean research(Piece piece);

    /**
     *Cette méthode permet de vérifier si la pièce se déplace bien d'une case à la fois.
     @param position d'arrivée de la pièce.
     @return true si la pièce se déplace d'une case sinon false.
     */
    public boolean oneByOne(Box position)
    {
        int[] tableau = delta(position);
        if (tableau[0] < 2 &&  tableau[1] < 2)
        {
            return true;
        }

        return false;
    }

    /**
     *Méthode de déplacement général qui appelle les autres méthodes pour vérifier le bon déplacement
     *d'une case à la fois.
     @param position d'arrivée.
     @return true si le pion s'est déplacé sinon false.
     */
    public boolean possible(Box position) //throws InvalidBoxExecption
    {
        //Summary.WRITE("displacement : " + this + " veut déplace d'une case");
        if(oneByOne(position))
        {
            return super.possible(position);
        }
        else
        {
            return false;
        }
    }
}
