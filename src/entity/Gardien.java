package entity;

public class Gardien extends Mobile {
	
    public Gardien(Position position, Entrepot entrepot) {
        super(position, entrepot);
    }

    public void deplacerGardien(Direction direction) {
    	Position newPosition = deplacer(direction);

        ContenuZone contenu = entrepot.getContenu(newPosition);
        if (contenu == null) return;
        
        switch (contenu) {
            case ZONE_VIDE:
            	if (entrepot.getContenu(position) == ContenuZone.GARDIEN_SUR_CIBLE) {
            		entrepot.setContenu(position, ContenuZone.CIBLE);
            	}
            	else entrepot.setContenu(position, ContenuZone.ZONE_VIDE);
            	entrepot.setContenu(newPosition, ContenuZone.GARDIEN);
            	this.setPosition(newPosition);
                break;

            case CIBLE:
            	entrepot.setContenu(position, ContenuZone.ZONE_VIDE);
            	entrepot.setContenu(newPosition, ContenuZone.GARDIEN_SUR_CIBLE);
            	this.setPosition(newPosition);
            	break;
                
            case CAISSE:
            	boolean deplacement = entrepot.getCaisse().deplacerCaisse(direction);
            	if (deplacement == false) break;
                deplacerGardien(direction);
                break;

            default:
                break;
        }
    }
}
