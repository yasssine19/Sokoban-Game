package entity;

/**
 * Énumération des contenus des cases pour l'IHM du jeu Sokoban 
 * 
 * Cette énumération figure dans le paquetage entity pour pouvoir
 * etre utilisée par les classes de ce paquetage sans introduire
 * une dépendance vers les paquetages control ou boundary.
 * 
 * @author Dominique Marcadet
 * @version 1.2
 *
 */
public enum ContenuZone {
    ZONE_VIDE,
    MUR,
    CIBLE,
    CAISSE,
    CAISSE_SUR_CIBLE,
    GARDIEN,
    GARDIEN_SUR_CIBLE
}
