
public class Lot {

    private String label;
    private boolean categorie;
    private int niveau;
    private double valeur;

    public Lot() {
        this.label = "/";
        this.categorie = true;
        this.niveau = 0;
        this.valeur = 0;
    }

    public Lot(String label, boolean categorie, int niveau, double valeur) {
        this.label = label;
        this.categorie = categorie;
        this.niveau = niveau;
        this.valeur = valeur;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    //Aurait du servir pour savoir si un lot est un coupon ou un objet
    public boolean getCategorie() {
        return categorie;
    }

    public void setCategorie(boolean catégorie) {
        this.categorie = catégorie;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
}
