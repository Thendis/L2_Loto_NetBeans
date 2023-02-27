
import java.util.ArrayList;

public class LesLots {

    private ArrayList<Lot> lstL;

    public LesLots() {
        lstL = new ArrayList<Lot>();
    }

    public LesLots(ArrayList<Lot> lstL) {
        this.lstL = lstL;
    }

    public void retirLot(int i) {
        this.lstL.remove(i);
    }

    public void retirLot(Lot l) {
        this.lstL.remove(l);
    }

    public void ajoutLot(Lot l) {
        this.lstL.add(l);
    }

    public int getTaille() {
        return this.lstL.size();
    }
    //Utilise lors de l'affichage des lots de VisuJoueur
    public String toString() {
        String mes = "";
        for (int i = 0; i < this.lstL.size(); i++) {
            mes += this.lstL.get(i).getLabel() + this.lstL.get(i).getValeur() + "\n";
        }
        return mes;
    }
    
    public Lot getLot(int i) {
        return this.lstL.get(i);
    }
}
