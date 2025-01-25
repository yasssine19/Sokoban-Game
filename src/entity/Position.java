package entity;

public class Position {
    private int ligne;
    private int colonne;

    public Position(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }
    
    public void setPosition(int ligne, int colonne) {
    	this.ligne = ligne;
    	this.colonne = colonne;
    }
    
}
