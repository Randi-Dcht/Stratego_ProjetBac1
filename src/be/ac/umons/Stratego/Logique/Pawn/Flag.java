package Stratego.Logique.Pawn;

public class Flag
{
    public Flag(Player joueur)
    {
        super(joueur,NomPiece.drapeau,IdPiece.D00);
    }

    /**
     *Le drapeau ne peut pas attaquer.
     */
    public void attack(Piece pion)
    {}

    /**
     *Le drapeau ne pas bouger
     @ return false
     */
    public boolean possible(Box position)// throws ImpossibleToMove
    {
        return false;
    }
}
