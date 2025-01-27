package boundary;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import control.IControleur;
import entity.ContenuZone;


/**
 * Panneau de l'IHM pour le jeu Sokoban
 * 
 * @author Dominique Marcadet
 * @version 1.2
 *
 */
@SuppressWarnings("serial")
public class PanneauSokoban extends JPanel {

    private static final int IMAGE_SIZE = FenetreSokoban.TAILLE_IMAGE;

    private static EnumMap< ContenuZone, Image > images;

    private IControleur controleur;

    public PanneauSokoban(IControleur controleur) {
        this.controleur = controleur;
        try {
            images = new EnumMap< ContenuZone, Image >(
                Map.of(
                    ContenuZone.ZONE_VIDE       ,  ImageIO.read( new File( "img/EmptyFloor.jpg" )),
                    ContenuZone.MUR             ,  ImageIO.read( new File( "img/Wall.jpg" )),
                    ContenuZone.CAISSE          ,  ImageIO.read( new File( "img/Box.jpg" )),
                    ContenuZone.CAISSE_SUR_CIBLE,  ImageIO.read( new File( "img/BoxOnGoal.jpg" )),
                    ContenuZone.CIBLE           ,  ImageIO.read( new File( "img/Goal.jpg" )),
                    ContenuZone.GARDIEN         ,  ImageIO.read( new File( "img/Man.jpg" )),
                    ContenuZone.GARDIEN_SUR_CIBLE, ImageIO.read( new File( "img/ManOnGoal.jpg" ))
                )
            );
        }
        catch( IOException e ) {
            e.printStackTrace();
        }
    }

    public void paint( Graphics g ) {
        super.paint( g );

        // Le côté métier raisonne en [ligne, colonne]
        // Le côté IHM raisonne en [x, y]
        // Donc x <=> colonne et y <=> ligne
        for( int l = 0; l < controleur.getNbLignes(); ++l ) {
            for( int c = 0; c < controleur.getNbColonnes(); ++c ) {
                g.drawImage( images.get( controleur.getContenu( l, c )), c * IMAGE_SIZE, l * IMAGE_SIZE, IMAGE_SIZE, IMAGE_SIZE, null );
            }
        }
    }

}
