package entity;

public class Zone {
	
    private Position position;
    private ContenuZone contenu;

    public Zone(Position position, ContenuZone contenu) {
        this.position = position;
        this.contenu = contenu;
    }
    
    public Zone getZone() {
    	return this;
    }
    
    public Position getPosition() {
        return position;
    }

    public ContenuZone getContenu() {
        return contenu;
    }
    
    public void setContenu(ContenuZone contenu) {
        this.contenu = contenu;
    }
    
    public boolean contientCaisse() {
        return contenu == ContenuZone.CAISSE || contenu == ContenuZone.CAISSE_SUR_CIBLE;
    }
    
    public boolean contientGardien() {
        return contenu == ContenuZone.GARDIEN || contenu == ContenuZone.GARDIEN_SUR_CIBLE;
    }

}
