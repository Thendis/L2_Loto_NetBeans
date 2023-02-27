
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class CarteLoto {

    private int tab[][]; // tableau d’entiers à 2 dimensions représentant la carte avec ses nombres
    private int jetons[][]; // tableau d’entiers à 2 dimensions comportant les numéros recouverts par un jeton
    private int nbCol; // nb de colonnes des tableaux tab et jetons
    private int nbLig; // nb de lignes des tableaux tab et jetons
    private int nbNumeros; // nb de numéros présents sur la carte (dans le tableau tab)
    private double prix; // prix de la carte
    private final int valMax = 90; // valeur max des numéros d’une carte

    //Getters jusqu'à la ligne 47
    public int[][] getTab() {
        return tab;
    }
    //Dessine la carte dans le panneau jp avec les bouton de couleur coul
    public void dessineCarte(JPanel jp, Color coul){
        jp.removeAll();
        jp.setLayout(new GridLayout(this.getNbLig(),this.getNbCol()));
        for(int i =0;i<this.nbLig;i++){
            for(int j =0;j<this.nbCol;j++){
                JButton bouton;
                //Si la case est vide n'affiche pas 0
                if(getCase(i,j)==0){
                    bouton = new JButton("");
                } else {
                    bouton = new JButton(""+this.getCase(i, j));
                }
                if(this.jetons[i][j]!=0){
                    bouton.setBackground(Color.white);
                    bouton.setEnabled(false);
                } else {
                    bouton.setBackground(coul);
                }
                jp.add(bouton);
            }
        }
        jp.revalidate();
    }
    
    public int[][] getJetons() {
        return jetons;
    }

    public int getNbCol() {
        return nbCol;
    }

    public int getNbLig() {
        return nbLig;
    }

    public int getNbNumeros() {
        return nbNumeros;
    }

    public double getPrix() {
        return prix;
    }

    public int getValMax() {
        return valMax;
    }
    
    //Retourne la case de colonne i et de ligne j
    public int getCase(int i, int j) {
        if (i >= 0 && i < nbLig && j >= 0 && j < nbCol) {
            return tab[i][j];
        } else {
            return -1;
        }
    }

    //Constructeur par defaut
    public CarteLoto() {
        this.nbNumeros = 15; // fixe le nb de numéros de la carte à 15
        this.nbCol = 9; // fixe le nb de colonnes de la carte à 9
        this.nbLig = 3; // fixe le nb de lignes de la carte à 3
        this.tab = new int[nbLig][nbCol]; // allocation mémoire pour stocker les valeurs du tableau tab
        this.jetons = new int[nbLig][nbCol]; // allocation mémoire pour stocker les valeurs du tableau jetons
        this.prix = 5; // fixe le prix de la carte
        initValeursCarte();
    }

    //Constructeur 2 avec les paramètres
    public CarteLoto(int nbc, int nbVal) {
        this.nbNumeros = nbVal; //fixe le nb de numéros de la carte à la valeur nbVal fournie en paramètre
        this.nbCol = nbc; //fixe le nb de colonnes de la carte à la valeur nbCol fournie en paramètre
        this.nbLig = 3;
        this.tab = new int[nbLig][nbCol];
        this.jetons = new int[nbLig][nbCol];
        this.prix = 5;
        initValeursCarte();
    }

    //Remplie la carte de numéro aléatoire
    public void initValeursCarte() {
        int i, j, k, n;
//Toutes les valeurs des cases de la carte sont initialisées à 0 ainsi que toutes celles des jetons
        for (i = 0; i < this.nbLig; i++) {
            for (j = 0; j < this.nbCol; j++) {
                this.tab[i][j] = 0;
                this.jetons[i][j] = 0;
            }
        }
        i = 0;
//pour chaque numéro à placer
        for (k = 0; k < this.nbNumeros; k++) {
            // Pour la ligne courante, on recherche aléatoirement une case vide pour placer ce numéro (à itérer si la case n’est pas vide)
            do {
                j = (int) (Math.random() * this.nbCol);
            } while (this.tab[i][j] != 0);
//On génère aléatoirement ce numéro : un nombre compris entre 1 et la valeur maximum de numéros possibles (à itérer  si ce numéro est déjà présent dans la carte)
            do {
                n = (int) (Math.random() * this.valMax + 1);
            } while (contient(n));
//On place ce nombre dans la case vide
            this.tab[i][j] = n;
//on passe à la ligne suivante (ou à la première si nous sommes à la dernière)
            i++;
            if (i == this.nbLig) {
                i = 0;
            }
//ou i = (i+1)%this.nbLig;
        }
    }

    //Verifie si val est présent dans une carte
    public boolean contient(int val) {
        for (int i = 0; i < nbLig; i++) {
            for (int j = 0; j < nbCol; j++) {
                if (tab[i][j] == val) {
                    return true;
                }
            }
        }
        return false;
    }

    //Retourne un String qui contient les informations de la carte.
    public String toString() {
        String mes = "";
        for (int i = 0; i < nbLig; i++) {
            for (int j = 0; j < nbCol; j++) {
                mes += "" + tab[i][j]+" ";
            }
            mes += "\n";
        }
        return mes;
    }

    //Place un jeton si la carte contient la valeur Val. Renvoie true si le jeton est placé et false sinon.
    public boolean placePion(int val) {
        boolean res = false;
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++) //parcours des valeurs de la carte
            {
                if (tab[i][j] == val) //si la valeur val est présente dans la carte
                {
                    res = true;
                    jetons[i][j] = val;
                } //on modifie la valeur située au même endroit dans le tableau jetons (on place un jeton sur la carte)
            }
        }
        return res;
    }

    //Vérifie que la ligne lig de la carte est pleine. Renvoie true si c'est le cas et false sinon.
    public boolean estLignePleine(int lig) {
        boolean res = true; //on suppose la ligne pleine
        for (int j = 0; j < this.nbCol; j++) // parcours de la ligne
        {
            if (jetons[lig][j] != tab[lig][j]) {
                res = false; //si une valeur n’est pas recouverte par un jeton, la ligne n’est pas pleine
            }
        }
        return res;
    }

    //Retourne le nombre de lignes pleine (utilise estLignePleine())
    public int getNbLignesPleines() {
        int compter = 0;
        for (int i = 0; i < this.nbLig; i++) {
            if (estLignePleine(i) == true) {
                compter++;
            }
        }
        return compter;
    }

    //Return true ou false en fonction de si la carte contient autant de  ligne gagnantes que option
    public boolean cartonGagnant(int option) {
        return getNbLignesPleines() == option;
    }

    public String StringJetons(){
        String mes = "";
        for(int i =0;i<this.jetons.length;i++){
            for(int j = 0;j<this.jetons[i].length;j++){
                mes+=this.jetons[i][j]+"\t";
            }
            mes+="\n";
        }
        return mes;
    }
}
