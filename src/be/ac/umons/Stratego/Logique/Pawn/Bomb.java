package Stratego.Logique.Pawn;

import Stratego.Logique.Other.Box;
import Stratego.Logique.Player.Player;

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
