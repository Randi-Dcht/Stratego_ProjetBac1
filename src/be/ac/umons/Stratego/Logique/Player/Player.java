package be.ac.umons.Stratego.Logique.Player;

import be.ac.umons.Stratego.Logique.Pawn.Piece;

public interface Player
{
    void assignment(Player joueur, Piece[] liste, int nombrePiece);
    Player next();
    void dead();
    Couleur myColor();
    int howMany();
    Piece[] myList();
    int[] wherePlace();
    String myName();
    void catchOther(Piece piece);
    Piece[] captureList();
}
