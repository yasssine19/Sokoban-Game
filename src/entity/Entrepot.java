package entity;

public class Entrepot {
	
	final private Zone[][] grille;
	
	final private Zone[][] grilleNiveau1 = new Zone[][]{
        {new Zone(new Position(0, 0), ContenuZone.MUR), new Zone(new Position(0, 1), ContenuZone.MUR), new Zone(new Position(0, 2), ContenuZone.MUR), new Zone(new Position(0, 3), ContenuZone.MUR), new Zone(new Position(0, 4), ContenuZone.MUR), new Zone(new Position(0, 5), ContenuZone.MUR), new Zone(new Position(0, 6), ContenuZone.MUR)},
        {new Zone(new Position(1, 0), ContenuZone.MUR), new Zone(new Position(1, 1), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 2), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 4), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 6), ContenuZone.MUR)},
        {new Zone(new Position(2, 0), ContenuZone.MUR), new Zone(new Position(2, 1), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 2), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 4), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 6), ContenuZone.MUR)},
        {new Zone(new Position(3, 0), ContenuZone.MUR), new Zone(new Position(3, 1), ContenuZone.GARDIEN), new Zone(new Position(3, 2), ContenuZone.ZONE_VIDE), new Zone(new Position(3, 3), ContenuZone.CAISSE), new Zone(new Position(3, 4), ContenuZone.ZONE_VIDE), new Zone(new Position(3, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(3, 6), ContenuZone.MUR)},
        {new Zone(new Position(4, 0), ContenuZone.MUR), new Zone(new Position(4, 1), ContenuZone.ZONE_VIDE), new Zone(new Position(4, 2), ContenuZone.ZONE_VIDE), new Zone(new Position(4, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(4, 4), ContenuZone.CIBLE), new Zone(new Position(4, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(4, 6), ContenuZone.MUR)},
        {new Zone(new Position(5, 0), ContenuZone.MUR), new Zone(new Position(5, 1), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 2), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 4), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 6), ContenuZone.MUR)},
        {new Zone(new Position(6, 0), ContenuZone.MUR), new Zone(new Position(6, 1), ContenuZone.MUR), new Zone(new Position(6, 2), ContenuZone.MUR), new Zone(new Position(6, 3), ContenuZone.MUR), new Zone(new Position(6, 4), ContenuZone.MUR), new Zone(new Position(6, 5), ContenuZone.MUR), new Zone(new Position(6, 6), ContenuZone.MUR)}
    };
	
    final private Zone[][] grilleNiveau2 = new Zone[][]{
        {new Zone(new Position(0, 0), ContenuZone.MUR), new Zone(new Position(0, 1), ContenuZone.MUR), new Zone(new Position(0, 2), ContenuZone.MUR), new Zone(new Position(0, 3), ContenuZone.MUR), new Zone(new Position(0, 4), ContenuZone.MUR), new Zone(new Position(0, 5), ContenuZone.MUR), new Zone(new Position(0, 6), ContenuZone.MUR), new Zone(new Position(0, 7), ContenuZone.MUR), new Zone(new Position(0, 8), ContenuZone.MUR)},
        {new Zone(new Position(1, 0), ContenuZone.MUR), new Zone(new Position(1, 1), ContenuZone.MUR), new Zone(new Position(1, 2), ContenuZone.MUR), new Zone(new Position(1, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 4), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 5), ContenuZone.MUR), new Zone(new Position(1, 6), ContenuZone.MUR), new Zone(new Position(1, 7), ContenuZone.MUR), new Zone(new Position(1, 8), ContenuZone.MUR)},
        {new Zone(new Position(2, 0), ContenuZone.MUR), new Zone(new Position(2, 1), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 2), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 4), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 6), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 7), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 8), ContenuZone.MUR)},
        {new Zone(new Position(3, 0), ContenuZone.MUR), new Zone(new Position(3, 1), ContenuZone.ZONE_VIDE), new Zone(new Position(3, 2), ContenuZone.ZONE_VIDE), new Zone(new Position(3, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(3, 4), ContenuZone.ZONE_VIDE), new Zone(new Position(3, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(3, 6), ContenuZone.CAISSE), new Zone(new Position(3, 7), ContenuZone.ZONE_VIDE), new Zone(new Position(3, 8), ContenuZone.MUR)},
        {new Zone(new Position(4, 0), ContenuZone.MUR), new Zone(new Position(4, 1), ContenuZone.ZONE_VIDE), new Zone(new Position(4, 2), ContenuZone.MUR), new Zone(new Position(4, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(4, 4), ContenuZone.ZONE_VIDE), new Zone(new Position(4, 5), ContenuZone.MUR), new Zone(new Position(5, 6), ContenuZone.CAISSE), new Zone(new Position(4, 7), ContenuZone.ZONE_VIDE), new Zone(new Position(4, 8), ContenuZone.MUR)},
        {new Zone(new Position(5, 0), ContenuZone.MUR), new Zone(new Position(5, 1), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 2), ContenuZone.CIBLE), new Zone(new Position(5, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 4), ContenuZone.CIBLE), new Zone(new Position(5, 5), ContenuZone.MUR), new Zone(new Position(5, 6), ContenuZone.GARDIEN), new Zone(new Position(5, 7), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 8), ContenuZone.MUR)},
        {new Zone(new Position(6, 0), ContenuZone.MUR), new Zone(new Position(6, 1), ContenuZone.MUR), new Zone(new Position(6, 2), ContenuZone.MUR), new Zone(new Position(6, 3), ContenuZone.MUR), new Zone(new Position(6, 4), ContenuZone.MUR), new Zone(new Position(6, 5), ContenuZone.MUR), new Zone(new Position(6, 6), ContenuZone.MUR), new Zone(new Position(6, 6), ContenuZone.MUR), new Zone(new Position(6, 8), ContenuZone.MUR)},
    };
    
	final private Zone[][] grilleNiveau3 = new Zone[][]{
        {new Zone(new Position(0, 0), ContenuZone.MUR), new Zone(new Position(0, 1), ContenuZone.MUR), new Zone(new Position(0, 2), ContenuZone.MUR), new Zone(new Position(0, 3), ContenuZone.MUR), new Zone(new Position(0, 4), ContenuZone.MUR), new Zone(new Position(0, 5), ContenuZone.MUR), new Zone(new Position(0, 6), ContenuZone.MUR), new Zone(new Position(0, 7), ContenuZone.MUR)},
        {new Zone(new Position(1, 0), ContenuZone.MUR), new Zone(new Position(1, 1), ContenuZone.MUR), new Zone(new Position(1, 2), ContenuZone.MUR), new Zone(new Position(1, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 4), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(1, 6), ContenuZone.MUR), new Zone(new Position(1, 7), ContenuZone.MUR)},
        {new Zone(new Position(2, 0), ContenuZone.MUR), new Zone(new Position(2, 1), ContenuZone.CIBLE), new Zone(new Position(2, 2), ContenuZone.GARDIEN), new Zone(new Position(2, 3), ContenuZone.CAISSE), new Zone(new Position(2, 4), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(2, 6), ContenuZone.MUR), new Zone(new Position(2, 7), ContenuZone.MUR)},
        {new Zone(new Position(3, 0), ContenuZone.MUR), new Zone(new Position(3, 1), ContenuZone.MUR), new Zone(new Position(3, 2), ContenuZone.MUR), new Zone(new Position(3, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(3, 4), ContenuZone.CAISSE), new Zone(new Position(3, 5), ContenuZone.CIBLE), new Zone(new Position(3, 6), ContenuZone.MUR), new Zone(new Position(3, 7), ContenuZone.MUR)},
        {new Zone(new Position(4, 0), ContenuZone.MUR), new Zone(new Position(4, 1), ContenuZone.CIBLE), new Zone(new Position(4, 2), ContenuZone.MUR), new Zone(new Position(4, 3), ContenuZone.MUR), new Zone(new Position(4, 4), ContenuZone.CAISSE), new Zone(new Position(4, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(4, 6), ContenuZone.MUR), new Zone(new Position(4, 7), ContenuZone.MUR)},
        {new Zone(new Position(5, 0), ContenuZone.MUR), new Zone(new Position(5, 1), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 2), ContenuZone.MUR), new Zone(new Position(5, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 4), ContenuZone.CIBLE), new Zone(new Position(5, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(5, 6), ContenuZone.MUR), new Zone(new Position(5, 6), ContenuZone.MUR)},
        {new Zone(new Position(6, 0), ContenuZone.MUR), new Zone(new Position(6, 1), ContenuZone.CAISSE), new Zone(new Position(6, 2), ContenuZone.ZONE_VIDE), new Zone(new Position(6, 3), ContenuZone.CAISSE_SUR_CIBLE), new Zone(new Position(6, 4), ContenuZone.CAISSE), new Zone(new Position(6, 5), ContenuZone.CAISSE), new Zone(new Position(6, 6), ContenuZone.CIBLE), new Zone(new Position(7, 6), ContenuZone.MUR)},
        {new Zone(new Position(7, 0), ContenuZone.MUR), new Zone(new Position(7, 1), ContenuZone.ZONE_VIDE), new Zone(new Position(7, 2), ContenuZone.ZONE_VIDE), new Zone(new Position(7, 3), ContenuZone.ZONE_VIDE), new Zone(new Position(7, 4), ContenuZone.CIBLE), new Zone(new Position(7, 5), ContenuZone.ZONE_VIDE), new Zone(new Position(7, 6), ContenuZone.ZONE_VIDE), new Zone(new Position(7, 6), ContenuZone.MUR)},
        {new Zone(new Position(8, 0), ContenuZone.MUR), new Zone(new Position(8, 1), ContenuZone.MUR), new Zone(new Position(8, 2), ContenuZone.MUR), new Zone(new Position(8, 3), ContenuZone.MUR), new Zone(new Position(8, 4), ContenuZone.MUR), new Zone(new Position(8, 5), ContenuZone.MUR), new Zone(new Position(8, 6), ContenuZone.MUR), new Zone(new Position(8, 7), ContenuZone.MUR)}
    };
    
    	  private Caisse[] caisses;
    	  private Gardien gardien;
    	  private Niveau niveauActuel;
    
    public Entrepot(Niveau niveau) {
    	niveauActuel = niveau;
    	
    	if (niveau == Niveau.NIVEAU1) grille = grilleNiveau1;
    	else if (niveau == Niveau.NIVEAU2) grille = grilleNiveau2;
    	else if (niveau == Niveau.NIVEAU3) grille = grilleNiveau3;
    	else grille = null;
        
    	for (int l = 0; l < getNbLignes(); l++) {
            for (int c = 0; c < getNbColonnes(); c++) {
            	if (grille[l][c].getContenu() == ContenuZone.GARDIEN) this.gardien = new Gardien(new Position(l, c), this);
            }
    	}
    	
    	int nombreCaisses = 0;
    	
    	for (int l = 0; l < getNbLignes(); l++) {
            for (int c = 0; c < getNbColonnes(); c++) {
            	if (grille[l][c].getContenu() == ContenuZone.CAISSE || grille[l][c].getContenu() == ContenuZone.CAISSE_SUR_CIBLE) nombreCaisses++;
            }
    	}
    	
    	caisses = new Caisse[nombreCaisses];
    	
    	int counter = 0;
    	for (int l = 0; l < getNbLignes(); l++) {
            for (int c = 0; c < getNbColonnes(); c++) {
            	if (grille[l][c].getContenu() == ContenuZone.CAISSE || grille[l][c].getContenu() == ContenuZone.CAISSE_SUR_CIBLE) {
            		this.caisses[counter++] = new Caisse(new Position(l, c), this);
            	}
            }
    	}
    }

    public Niveau getNiveauActuel() {
    	return niveauActuel;
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
    
    public Caisse getCaisse(Position position) {
    	if (!estPositionValide(position)) {
    		return null;
    	}
    	for (int i = 0; i < caisses.length; i++) {
    		if (caisses[i].getPosition().getLigne() == position.getLigne() && caisses[i].getPosition().getColonne() == position.getColonne()) {
    			return caisses[i];
    		}
    	}
    	System.out.println("mafamechi");
    	return null;
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
