package control;

import entity.ContenuZone;
import entity.Direction;
import entity.Entrepot;
import entity.Niveau;
import entity.Position;

public class ControleurBouchon implements IControleur {

	private Entrepot entrepot;
	private Niveau niveauActuel;
	
	public ControleurBouchon(Niveau niveau) {
		try {
			this.entrepot = new Entrepot(niveau);
		} catch (Exception e) {}
		
		niveauActuel = niveau;
	}
	
	public Niveau getNiveauActuel() {
		return entrepot.getNiveauActuel();
	}
	
	@Override
	public void action(Direction direction) {
        entrepot.deplacerGardien(direction);
	}

	@Override
	public boolean jeuGagné() {
        for (int l = 0; l < getNbLignes(); l++) {
            for (int c = 0; c < getNbColonnes(); c++) {
                if (entrepot.getContenu(new Position(l, c)) == ContenuZone.CAISSE || entrepot.getContenu(new Position(l, c)) == ContenuZone.CIBLE) {
                    return false;
                }
            }
        }
        return true;
    }
	
	@Override
    public boolean jeuPerdu() {
		for (int l = 0; l < getNbLignes(); l++) {
            for (int c = 0; c < getNbColonnes(); c++) {
                if (entrepot.getContenu(new Position(l, c)) == ContenuZone.CAISSE) {
                    if (entrepot.getContenu(new Position(l-1, c)) == ContenuZone.MUR && entrepot.getContenu(new Position(l, c-1)) == ContenuZone.MUR) return true;
                    if (entrepot.getContenu(new Position(l-1, c)) == ContenuZone.MUR && entrepot.getContenu(new Position(l, c+1)) == ContenuZone.MUR) return true;
                    if (entrepot.getContenu(new Position(l+1, c)) == ContenuZone.MUR && entrepot.getContenu(new Position(l, c-1)) == ContenuZone.MUR) return true;
                    if (entrepot.getContenu(new Position(l+1, c)) == ContenuZone.MUR && entrepot.getContenu(new Position(l, c+1)) == ContenuZone.MUR) return true;
                    if (entrepot.getNiveauActuel() == Niveau.NIVEAU2) {
                    	if (entrepot.getContenu(new Position(l+1, c)) == ContenuZone.MUR && entrepot.getContenu(new Position(l, c+2)) == ContenuZone.MUR &&
                		entrepot.getContenu(new Position(l, c+1)) == ContenuZone.CAISSE_SUR_CIBLE) return true;
                    	if (entrepot.getContenu(new Position(l+1, c)) == ContenuZone.CAISSE_SUR_CIBLE && entrepot.getContenu(new Position(l+2, c)) == ContenuZone.MUR &&
                		entrepot.getContenu(new Position(l, c+1)) == ContenuZone.MUR) return true;
                    }
                }
            }
        }
        return false;
	}

	@Override
	public int getNbLignes() {
		return entrepot.getNbLignes();
	}

	@Override
	public int getNbColonnes() {
		return entrepot.getNbColonnes();
	}

	@Override
	public ContenuZone getContenu(int ligne, int colonne) {
		return entrepot.getContenu(new Position(ligne, colonne));
	}
}
