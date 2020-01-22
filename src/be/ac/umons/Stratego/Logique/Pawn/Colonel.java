package Stratego.Logique.Pawn;

import Stratego.Logique.Player.Player;

public class Colonel extends OneCase
{
    /**
     *Liste des pièces qui peuvent le tuer.
     */
    final NomPiece[] attaque={NomPiece.marechal,NomPiece.general,NomPiece.bombe};

    public Colonel(Player joueur)
    {
        super(joueur,NomPiece.colonel,IdPiece.C08);
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
