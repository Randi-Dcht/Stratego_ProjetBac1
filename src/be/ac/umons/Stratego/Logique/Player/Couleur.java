package Stratego.Logique.Player;

public class Couleur
{
    final int rouge;
    final int vert;
    final int bleu;
    final String nom;

    public Couleur(int rg , int vt , int bl , String nom_)
    {
        rouge =  rg;
        vert  =  vt;
        bleu  =  bl;
        nom   =  nom_;
    }

    public String toString()
    {
        return nom;
    }
}
