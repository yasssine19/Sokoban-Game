package entity;

public class Caisse extends Mobile {
	
	public Caisse(Position position, Entrepot entrepot) {
		super(position, entrepot);
	}

	public boolean deplacerCaisse(Direction direction) {
		Position newPosition = deplacer(direction);
		
		ContenuZone contenu = entrepot.getContenu(newPosition);
		if (contenu == null || !entrepot.estPositionValide(newPosition)) return false;
        
        switch (contenu) {
        	case ZONE_VIDE:
	        	if (entrepot.getContenu(position) == ContenuZone.CAISSE_SUR_CIBLE) {
	        		entrepot.setContenu(position, ContenuZone.CIBLE);
	        	}
	        	else entrepot.setContenu(position, ContenuZone.ZONE_VIDE);
	        	entrepot.setContenu(newPosition, ContenuZone.CAISSE);
	        	this.setPosition(newPosition);
	        	return true;
        
    		case CIBLE:
    			if (entrepot.getContenu(position) == ContenuZone.CAISSE_SUR_CIBLE) {
    				entrepot.setContenu(position, ContenuZone.CIBLE);
    			}
    			else entrepot.setContenu(position, ContenuZone.ZONE_VIDE);
	        	entrepot.setContenu(newPosition, ContenuZone.CAISSE_SUR_CIBLE);
	        	this.setPosition(newPosition);
	            return true;
	            
    		case CAISSE, CAISSE_SUR_CIBLE:
    			boolean deplacement = entrepot.getCaisse(newPosition).deplacerCaisse(direction);
    			if (!deplacement) return false;
    			if (deplacement) {
    				if (entrepot.getContenu(newPosition) == ContenuZone.ZONE_VIDE) entrepot.setContenu(newPosition, ContenuZone.CAISSE);
    				else entrepot.setContenu(newPosition, ContenuZone.CAISSE_SUR_CIBLE);
    			}
    			if (entrepot.getContenu(position) == ContenuZone.CAISSE_SUR_CIBLE)entrepot.setContenu(position, ContenuZone.CIBLE);
    			else entrepot.setContenu(position, ContenuZone.ZONE_VIDE);
    			this.setPosition(newPosition);
    			return true;
    				
            default:
            	return false;
        }
	}
}
