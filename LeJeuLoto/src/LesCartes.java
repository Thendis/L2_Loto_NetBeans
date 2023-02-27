
import java.util.ArrayList;

public class LesCartes {

    private ArrayList<CarteLoto> lst;

    //constructeur par défaut
    public LesCartes() {
        lst = new ArrayList<CarteLoto>();
    }

    //Retourne la taille de l'objet
    public int getTaille() {
        return this.lst.size();
    }

    //Retourne la carte à l'indice i
    public CarteLoto getCarte(int i) {
        if (i < getTaille() && i >= 0) {
            return this.lst.get(i); //équivalent à tab[i]
        } else {
            return null;
        }
    }

    //Ajoute la carte c à l'objet
    public void ajouteCarte(CarteLoto c) {
        this.lst.add(c);
    }

    //Retire le premier objet c
    public void retireCarte(CarteLoto c) {
        this.lst.remove(c);
    }

    //Retire le contenue de l'indice i
    public void retireCarte(int i) {
        this.lst.remove(i);
    }

    //Nettoie tous le contenue de l'objet
    public void videCartes() {
        this.lst.clear();
    }

    //Retourne un objet LesCartes qui contient toute les cartes avec le numéro num
    public LesCartes rechCartes(int num) {
//NON ! ArrayList<CarteLoto> nouList=new ArrayList<CarteLoto>();
        LesCartes lc = new LesCartes();
        for (int i = 0; i < getTaille(); i++) {
            if (getCarte(i).contient(num)) {
                lc.ajouteCarte(getCarte(i));
            }
        }
        return lc;
    }

    //Remplie l'ArrayList de n cartes avec nbcol colonnes et nbval valeurs
    public void initLesCartes(int n, int nbcol, int nbval) {
        //n nombre de carte, nbcol colonnes, nbval le nombre de numero sur chaque carte
        for (int i = 0; i < n; i++) {
            CarteLoto carte = new CarteLoto(nbcol, nbval);
            this.ajouteCarte(carte);
        }

    }

    public String toString(){
        String res = "" ;
        for (int i = 0; i < getTaille(); i++) {
            res = res + "Carte n° " + (i + 1) + "\n" + getCarte(i).toString() + "\n";
        }
        return res;
    }

}
