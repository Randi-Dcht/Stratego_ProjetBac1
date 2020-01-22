package Stratego.Logique.Pawn;

import Stratego.Logique.Other.Board;
import Stratego.Logique.Other.Box;
import Stratego.Logique.Player.Player;

public abstract class ManyCase
{
    final int nbcase;

    public ManyCase(Player joueur, NomPiece nom, IdPiece id, int nbcase_)
    {
        super(joueur,nom,id);
        nbcase = nbcase_;
    }


    /**
     *Cette méthode est méthode redefinis pour un piont qui peut se déplacer sur
     *plusieurs cases à la fois.

     @throws InvalidBoxExecption quand le pion va sur une case non autoriséee.
     @param position qui est la case où le pion veut aller.
     @see displacement(MovePiece) qui est la méthode de déplaement principale.
     */
    public boolean possible(Box position) //throws InvalidBoxExecption
    {
        int[] tab = super.delta(position);
        if(howCase(tab) && noPeople(position))
        {
            return super.possible(position);
        }
        else
        {
            return false;
        }
    }

    public int[] deltaSpc(Box nouvelle)
    {
        int x = this.position.x - nouvelle.x;
        int y = this.position.y - nouvelle.y;
        int[] liste = {x,y};
        return liste;
    }
    /**
     *Cette méthode permet de regarder si la pièce ne passe pas au dessus d'une autre pièce
     * ou d'un obstacle.
     @param position qui est la position final d''arrivée.
     @return true s'il n'y a personne sinon false.
     */
    public boolean noPeople(Box position)
    {
        System.out.println("ok");
        int[] delta = deltaSpc(position);
        int cnt;
        if(delta[0] == 0)
        {
            cnt = delta[1];
            while(true)
            {
                System.out.println("=> " + cnt);
                if(cnt == 1 || cnt == -1)
                {
                    return true;
                }
                if(!(Board.plateau[this.position.x][this.position.y + cnt].occupe ))
                {
                    return false;
                }
                if(cnt < 0)
                    cnt++;
                else
                    cnt--;
            }
        }
        else
        {
            cnt = delta[0];
            while(true)
            {
                System.out.println("=> " + cnt);
                if(cnt == 1 || cnt == -1)
                {
                    return true;
                }
                if(!(Board.plateau[this.position.x + cnt][this.position.y].occupe ))
                {
                    return false;
                }
                if(cnt < 0)
                    cnt++;
                else
                    cnt--;
            }
        }
    }

    /**
     *Cette méthode permet de regarder si la pièce ne se déplace pas de plus de case qu'autorisée.
     @param valeur qui est la différence position entre les deux cases.
     @return true s'il ne dépasse pas le nombre de case limite sinon false.
     */
    public boolean howCase(int[] valeur)
    {
        if(valeur[0] <= nbcase  && valeur[1] <= nbcase )
        {
            return true;
        }
        return false;
    }


    public abstract  boolean research(Piece piece);
}
