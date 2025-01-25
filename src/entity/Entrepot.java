package entity;

public class Entrepot {
	
	final private Zone[][] grille;
    	  private Caisse caisse;
    	  private Gardien gardien;
    
    public Entrepot() throws Exception {
    	grille = new Zone[][]{
            {new Zone(new Position(0, 0), ContenuZone.MUR), new Zone(new Position(0, 1), ContenuZone.MUR), new Zone(new Position(0, 2), ContenuZone.MUR), new Zone(new Position(0, 3), ContenuZone.MUR), new Zone(new Position(0, 4), ContenuZone.MUR), new Zone(new Position(0, 5), ContenuZone.MUR), new Zone(new Position(0, 6), ContenuZone.MUR)},
            {new Zone(new Position(1, 0), ContenuZone.MUR), new Zone(new Position(1, 1), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 2), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 4), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 6), ContenuZone.MUR)},
            {new Zone(new Position(2, 0), ContenuZone.MUR), new Zone(new Position(2, 1), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 2), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 4), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 6), ContenuZone.MUR)},
            {new Zone(new Position(3, 0), ContenuZone.MUR), new Zone(new Position(3, 1), ContenuZone.GARDIEN), new Zone(new Position(3, 2), ContenuZone.ZONE_VIDE), new Zone(new Position(3, 3), ContenuZone.CAISSE), new Zone(new Position(3, 4), ContenuZone.ZONE_VIDE), new Zone(new Position(3, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(3, 6), ContenuZone.MUR)},
            {new Zone(new Position(4, 0), ContenuZone.MUR), new Zone(new Position(4, 1), ContenuZone.ZONE_VIDE), new Zone(new Position(4, 2), ContenuZone.ZONE_VIDE), new Zone(new Position(4, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(4, 4), ContenuZone.CIBLE), new Zone(new Position(4, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(4, 6), ContenuZone.MUR)},
            {new Zone(new Position(5, 0), ContenuZone.MUR), new Zone(new Position(5, 1), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 2), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 4), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 6), ContenuZone.MUR)},
            {new Zone(new Position(6, 0), ContenuZone.MUR), new Zone(new Position(6, 1), ContenuZone.MUR), new Zone(new Position(6, 2), ContenuZone.MUR), new Zone(new Position(6, 3), ContenuZone.MUR), new Zone(new Position(6, 4), ContenuZone.MUR), new Zone(new Position(6, 5), ContenuZone.MUR), new Zone(new Position(6, 6), ContenuZone.MUR)}
        };
        
        this.gardien = new Gardien(new Position(3, 1), this);
        this.caisse = new Caisse(new Position(3, 3), this);
    }

    public Zone[][] getGrille() {
        return grille;
    }
    
    public Zone getZone(Position position) {
    	return grille[position.getLigne()][position.getColonne()];
    }

    public int getNbLignes() {
        return grille.length;
    }

    public int getNbColonnes() {
        return grille[0].length;
    }

    public ContenuZone getContenu(Position position) {
    	if (!estPositionValide(position)) return null;
        return getZone(position).getContenu();
    }
    
    public void setContenu(Position position, ContenuZone nouveauContenu) {
        grille[position.getLigne()][position.getColonne()].setContenu(nouveauContenu);
    }
    
    public boolean estPositionValide(Position position) {
    	return position.getLigne() >= 0 && position.getLigne() < getNbLignes() && position.getColonne() >= 0 && position.getColonne() < getNbColonnes();
    }
    
    public Caisse getCaisse() {
    	return caisse;
    }
    
    public Gardien getGardien() {
    	return gardien;
    }
    
    public void deplacerGardien(Direction direction) {
    	getGardien().deplacerGardien(direction);
    }
    
    public boolean contientGardien(Position position) {
    	if (!estPositionValide(position)) return false;
    	return getZone(position).contientGardien();
    }
    
    public boolean contientCaisse(Position position) {
    	if (!estPositionValide(position)) return false;
    	return getZone(position).contientCaisse();
    }
}
