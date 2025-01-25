package entity;

public abstract class Mobile {
	
    protected Position position;
    protected Entrepot entrepot;
    
    public Mobile(Position position, Entrepot entrepot) {
        this.position = position;
        this.entrepot = entrepot;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position.setPosition(position.getLigne(), position.getColonne());
    }
    
    public Position deplacer(Direction direction) {
		int dx = 0, dy = 0;
		
		switch (direction) {
	        case HAUT -> dx = -1;
	        case BAS -> dx = 1;
	        case GAUCHE -> dy = -1;
	        case DROITE -> dy = 1;
		}
		
		int nouvelleLigne = this.position.getLigne() + dx;
        int nouvelleColonne = this.position.getColonne() + dy;

        return new Position(nouvelleLigne, nouvelleColonne);
    }
}
