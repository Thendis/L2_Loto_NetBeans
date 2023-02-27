
import java.util.ArrayList;


public class LesJoueurs {
    private ArrayList<Joueur> lst;
    
    public LesJoueurs(){
        this.lst=new ArrayList<Joueur>();
    }
    
    //Retourne le nb de joueurs sous forme de int
    public int getNbJoueurs(){
        return this.lst.size();
    }
    
    //Retourne le joueur a l'indice i
    public Joueur getJoueur(int i){
        if(i>=0 && i<getNbJoueurs()){
            return lst.get(i);
        } else {
            return null;
        }
    }
    
    //Ajoute le joueur a en fin de liste
    public void ajoutJoueur(Joueur a){
        this.lst.add(a);
    }
    
    //Supprimer le joueur J
    public void supprimeJoueur(Joueur j){
        lst.remove(j);
        /* ou :
        for(int i =0; i<getNbJoueurs() ; i++){
            if(getJoueur(i).toString().equals(j.toString())){
                lst.remove(i);
            }
        }
        */
    }
    
    //recherche le joueur dont le pseudo est donné en paramètre. Retourne null s'il n'existe pas.
    public Joueur rechJoueur(String ps){
        for(int i =0; i<getNbJoueurs() ; i++){
            if(getJoueur(i).getPseudo().equals(ps)){
                return getJoueur(i);
            }
        }
        return null;
    }
    
    public String toString(){
        String mes="";
        for(int i =0; i<getNbJoueurs() ; i++){
            mes+="Joueur "+(i+1)+"\n";
            mes+=getJoueur(i).toString();
            mes+="\n";
        }
        return mes;
    }
    
    //Vide lst
    public void clean(){
        this.lst.clear();
    }
}
