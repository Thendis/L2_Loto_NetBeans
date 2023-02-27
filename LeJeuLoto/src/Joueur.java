
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Joueur {

    private String pseudo;
    private Color couleur;
    private double solde;
    private ImageIcon photo;
    private LesCartes mesC;
    private LesCartes mesCG; // Stock le scartons gagnants du joueur
    private LesLots mesLots; //Liste des lots du joueur

    public LesCartes getMesC() {
        return mesC;
    }

    public void setMesC(LesCartes mesC) {
        this.mesC = mesC;
    }

    public LesLots getMesLots() {
        return mesLots;
    }

    public void setMesLots(LesLots mesLots) {
        this.mesLots = mesLots;
    }

    public Joueur() {
        this.pseudo = "/";
        this.couleur = Color.BLACK;
        this.solde = 0;
        this.photo = new ImageIcon(getClass().getResource("/imgs/defaultImg.png"));
        this.mesC = new LesCartes();
        this.mesCG = new LesCartes();
        this.mesLots = new LesLots();
    }

    public void setMesCG(LesCartes mesCG) {
        this.mesCG = mesCG;
    }
    //Transfert les cartons gagnant dans mesCG et le retir de mesC
    public void tradWinCard(int[] parametres) {
        switch (this.mesC.getTaille()) {
            case 1:
                if (mesC.getCarte(0).cartonGagnant(parametres[0])) {
                    mesCG.ajouteCarte(mesC.getCarte(0));
                    mesC.videCartes();
                }
                break;
            case 2:
                if (mesC.getCarte(0).cartonGagnant(parametres[0])) {
                    mesCG.ajouteCarte(mesC.getCarte(0));
                    mesC.videCartes();
                } else if (mesC.getCarte(1).cartonGagnant(parametres[0])) {
                    mesCG.ajouteCarte(mesC.getCarte(1));
                    CarteLoto tmp = new CarteLoto();
                    tmp = this.mesC.getCarte(0);
                    mesC.videCartes();
                    mesC.ajouteCarte(tmp);
                }
                break;
        }
    }
    //Affiche le message de victoire ps : N'a rien a faire ici, mais j'ai peur de tout désorganiser en changeant maitenant.
    public void gagneLot(Lot l, JLabel txt) {
        if (l == null) {
            txt.setText("Il n'y a plus de lot a gagner");
        } else {
            this.mesLots.ajoutLot(l);
            this.solde += l.getValeur();
        }

    }

    public Joueur(String pseudo, Color couleur, double solde) {
        this.pseudo = pseudo;
        this.couleur = couleur;
        this.solde = solde;
        this.photo = new ImageIcon(getClass().getResource("/imgs/defaultImg.png"));
        this.mesC = new LesCartes(); //Sera mis a jour en sortie de l'achat de carte
        this.mesCG = new LesCartes();
        this.mesLots = new LesLots();
    }

    public Joueur(String pseudo, Color couleur, double solde, ImageIcon photo) {
        this.pseudo = pseudo;
        this.couleur = couleur;
        this.solde = solde;
        this.photo = photo;
        this.mesC = new LesCartes(); //Sera mis a jour en sortie de l'achat de carte
        this.mesCG = new LesCartes();
        this.mesLots = new LesLots();
        this.photo = photo;
    }

    public String toString() {
        String res = "\nJoueur " + this.pseudo;
        res += "\nCouleur " + this.couleur;
        res += "\nSolde " + this.solde;
        res += "\nNombre de cartes : " + this.mesC.getTaille();
        return res;
    }

    public LesCartes getMesCartes() {
        return this.mesC;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public ImageIcon getPhoto() {
        return this.photo;
    }

    public void setPhoto(ImageIcon img) {
        this.photo = img;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    //Ajoute la cart c a mesC et actualise le solde du joueur
    public boolean acheter(CarteLoto c) {
        //Si assez d'argent et moins de 2 cartes
        if (c.getPrix() <= this.solde && mesC.getTaille() < 2) {
            this.mesC.ajouteCarte(c);
            this.solde -= c.getPrix();
            return true;
        }
        return false;
    }

    //Retir un certain montant du solde si possible
    public boolean retirSolde(double cout) {
        //Si assez d'argent et moins de 2 cartes
        if ((this.solde - cout) >= 0) {
            this.solde -= cout;
            return true;
        }
        return false;
    }
}
