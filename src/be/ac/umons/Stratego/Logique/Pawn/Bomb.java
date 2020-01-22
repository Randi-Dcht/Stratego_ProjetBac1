package be.ac.umons.Stratego.Logique.Pawn;

import be.ac.umons.Stratego.Logique.Other.Box;
import be.ac.umons.Stratego.Logique.Player.Player;

public class Bomb extends Piece
{
    public Bomb(Player joueur)
    {
        super(joueur,NomPiece.bombe,IdPiece.B11);
    }

    /**
     *la bombe ne peut pas attaquer.
     */
    public void attack(Piece pion)
    {

    }

    /**
     *la bombe ne peut pas se déplacer donc return false.
     @return false
     */
    public boolean possible(Box position)
    {
        return false;
    }
}
