package Stratego.Logique.Pawn;

public class Commander
{
    /**
     *Liste des pièces qui peuvent le tuer.
     */
    final NomPiece[] attaque={NomPiece.marechal,NomPiece.general,NomPiece.colonel,NomPiece.bombe};

    public Commander(Player joueur)
    {
        super(joueur,NomPiece.commandant,IdPiece.C07);
    }

    /**
     *Cette méthode permet de voir si le pion que l'on attaque est dans la liste si on est mort.
     @param piece que l'on veut attaquer.
     @return true si la pièce se trouve dans la liste sinon false.
     */
    public boolean research(Piece piece)//à modifier pour être plus symple O(n)
    {
        for(int i =0; i < attaque.length ; i++)
        {
            if ((piece.monNom).equals(attaque[i]))
            {
                return true;
            }
        }
        return false;
    }
}
