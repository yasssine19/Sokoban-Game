package boundary;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import control.IControleur;
import entity.Direction;


/**
 * Fenêtre de l'IHM pour le jeu Sokoban
 * 
 * @author Dominique Marcadet
 * @version 1.2
 *
 */
@SuppressWarnings("serial")
public class FenetreSokoban extends JFrame implements KeyListener {

            static final int TAILLE_IMAGE = 32;
    
    private static final int LARGEUR_FENETRE = 20 * TAILLE_IMAGE;
	  private static final int HAUTEUR_FENETRE = 12 * TAILLE_IMAGE;
    private static final int HAUTEUR_TITRE_FENETRE = 20;
    private IControleur controleur;

    public FenetreSokoban( IControleur controleur ) {
        this.controleur = controleur;

        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setPreferredSize( new Dimension( LARGEUR_FENETRE, HAUTEUR_FENETRE + HAUTEUR_TITRE_FENETRE ));
        this.setTitle( "Sokoban" );

        this.add( new PanneauSokoban( controleur ));
        this.addKeyListener( this );

        this.pack();
        this.setVisible( true );
    }

    @Override
    public void keyTyped( KeyEvent e ) {
        // nothing
    }

    @Override
    public void keyPressed( KeyEvent e ) {
        Direction direction = null;
        
        switch( e.getKeyCode() ) {
        case KeyEvent.VK_UP:
            direction = Direction.HAUT;
            break;
        case KeyEvent.VK_DOWN:
            direction = Direction.BAS;
            break;
        case KeyEvent.VK_LEFT:
            direction = Direction.GAUCHE;
            break;
        case KeyEvent.VK_RIGHT:
            direction = Direction.DROITE;
            break;
        }
        if( direction == null ) return;
        controleur.action(direction);
        
        repaint();
        
        if(controleur.jeuGagné()) {
            JOptionPane.showMessageDialog( this, "Vous avez gagné !" );
            System.exit( 0 );
        }
        
        if(controleur.jeuPerdu()) {
            JOptionPane.showMessageDialog( this, "Vous avez perdu :(" );
            System.exit( 0 );
        }
    }

    @Override
    public void keyReleased( KeyEvent e ) {
        // nothing
    }

}
