package control;

import entity.ContenuZone;
import entity.Direction;

/**
 * Interface du controleur pour le jeu Sokoban 
 * 
 * @author Dominique Marcadet
 * @version 1.2
 *
 */

public interface IControleur {

	/**
	 * Méthode appellée par l'IHM quand le joueur appuie sur l'une des
	 * flèches du clavier.
	 * 
	 * @param direction direction de la progression demandée par le joueur
	 */
    void action( Direction direction );

	/**
	 * Méthode appellée par l'IHM pour savoir si le jeu est gagné.
	 * 
	 * @return true si le jeu est terminé, false sinon
	 */
    boolean jeuGagné();
    
    /**
	 * Méthode appellée par l'IHM pour savoir si le jeu est perdu.
	 * 
	 * @return true si le jeu est terminé, false sinon
	 */
    boolean jeuPerdu();

	/**
	 * Méthode appellée par l'IHM pour connaître le nombre de
	 * lignes de l'entrepot courant.
	 * 
	 * @return le nombre de lignes de l'entrepot
	 */
    int getNbLignes();

	/**
	 * Méthode appellée par l'IHM pour connaître le nombre de
	 * colonnes de l'entrepot courant.
	 * 
	 * @return le nombre de colonnes de l'entrepot
	 */
    int getNbColonnes();

	/**
	 * Méthode appellée par l'IHM pour connaître le contenu
	 * d'une case de l'entrepot courant.
	 * 
	 * @param ligne numéro de la ligne de la case (de 0 à getNbLines() - 1)
	 * @param colonne numéro de la colonne de la case (de 0 à getNbColumns() - 1)
	 * @return le type de la case
	 */
    ContenuZone getContenu( int ligne, int colonne );

}
