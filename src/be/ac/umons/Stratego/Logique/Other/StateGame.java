package be.ac.umons.Stratego.Logique.Other;

import be.ac.umons.Stratego.Logique.Player.Player;

public class StateGame
{
    /**
     *Cette méthode permet de voir si le drapeau a été attrapé par un des adversaires.
     @param joueur qui est une liste des joueur qui joue la partie.
     @return true si le drapeau est attrapé sinon false.
     */
    public static boolean endGame(Player[] joueur)
    {
        int cnt =0;
        for(int j=0; j < joueur.length ; j++ )
        {
            if (!joueur[j].myList()[0].getLife())
            {
                //Summary.WRITE("endGame : la partie est terminé, drapeau de " + joueur[j].myName() + " est attrapé");
                return true;
            }
            if(joueur[j].howMany() == 0)
            {
                cnt++;
            }
        }
        if(cnt == joueur.length)
        {
            //Summary.WRITE("endGame : la partie est terminé, il n'y a plus de pièces déplaçables");
            return true;
        }
        return false;
    }
}
