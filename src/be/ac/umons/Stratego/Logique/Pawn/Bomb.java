package Stratego.Logique.Pawn;

public class Bomb
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
