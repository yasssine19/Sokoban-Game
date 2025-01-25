package control;

import entity.ContenuZone;
import entity.Direction;
import entity.Entrepot;
import entity.Position;

public class ControleurBouchon implements IControleur {

	private Entrepot entrepot;
	
	public ControleurBouchon() {
		try {
			this.entrepot = new Entrepot();
		} catch (Exception e) {}
	}
	
	@Override
	public void action(Direction direction) {
        entrepot.deplacerGardien(direction);
	}

	@Override
	public boolean jeuGagné() {
        for (int l = 0; l < getNbLignes(); l++) {
            for (int c = 0; c < getNbColonnes(); c++) {
                if (entrepot.getContenu(new Position(l, c)) == ContenuZone.CAISSE) {
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
                    int counter = 0;
                    if (entrepot.getContenu(new Position(l-1, c)) == ContenuZone.MUR) counter++;
                    if (entrepot.getContenu(new Position(l, c-1)) == ContenuZone.MUR) counter++;
                    if (entrepot.getContenu(new Position(l+1, c)) == ContenuZone.MUR) counter++;
                    if (entrepot.getContenu(new Position(l, c+1)) == ContenuZone.MUR) counter++;
                    if (counter >= 2) return true;
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
