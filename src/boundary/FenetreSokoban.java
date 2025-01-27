package boundary;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import control.ControleurBouchon;
import control.IControleur;
import entity.Direction;
import entity.Niveau;


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

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize( new Dimension(LARGEUR_FENETRE, HAUTEUR_FENETRE + HAUTEUR_TITRE_FENETRE));
        if (controleur.getNiveauActuel() == Niveau.NIVEAU1) this.setTitle("Sokoban: Niveau 1");
        else if (controleur.getNiveauActuel() == Niveau.NIVEAU2) this.setTitle("Sokoban: Niveau 2");
        else if (controleur.getNiveauActuel() == Niveau.NIVEAU3) this.setTitle("Sokoban: Niveau 3");

        this.add(new PanneauSokoban(controleur));
        this.addKeyListener( this );

        this.pack();
        this.setVisible( true );
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Direction direction = null;
        
        switch(e.getKeyCode()) {
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
        if(direction == null) return;
        controleur.action(direction);
        
        repaint();
        
        if(controleur.jeuGagné() && controleur.getNiveauActuel() == Niveau.NIVEAU1) {
            JOptionPane.showMessageDialog( this, "Vous avez gagné le 1er niveau =D Procédons avec le 2ème niveau!");
        	this.dispose();
        	SwingUtilities.invokeLater(() -> new FenetreSokoban(new ControleurBouchon(Niveau.NIVEAU2)));
        }
        
        if(controleur.jeuGagné() && controleur.getNiveauActuel() == Niveau.NIVEAU2) {
            JOptionPane.showMessageDialog( this, "Vous avez gagné le 2ème niveau =D Procédons avec le 3ème niveau!");
        	this.dispose();
        	SwingUtilities.invokeLater(() -> new FenetreSokoban(new ControleurBouchon(Niveau.NIVEAU3)));
        }
        
        if(controleur.jeuGagné() && controleur.getNiveauActuel() == Niveau.NIVEAU3) {
            JOptionPane.showMessageDialog( this, "Félicitations! Vous avez gagné tous les niveaux =D");
            System.exit(0);
        }
        
        if(controleur.jeuPerdu() && controleur.getNiveauActuel() == Niveau.NIVEAU1) {
            JOptionPane.showMessageDialog( this, "Vous avez perdu le 1er niveau :( Réessayez de le résoudre!");
            this.dispose();
        	SwingUtilities.invokeLater(() -> new FenetreSokoban(new ControleurBouchon(Niveau.NIVEAU1)));
        }
        
        if(controleur.jeuPerdu() && controleur.getNiveauActuel() == Niveau.NIVEAU2) {
            JOptionPane.showMessageDialog( this, "Vous avez perdu le 2ème niveau :( Réessayez de le résoudre!");
            this.dispose();
        	SwingUtilities.invokeLater(() -> new FenetreSokoban(new ControleurBouchon(Niveau.NIVEAU2)));
        }
        
        if(controleur.jeuPerdu() && controleur.getNiveauActuel() == Niveau.NIVEAU1) {
            JOptionPane.showMessageDialog( this, "Vous avez perdu le 3ème niveau :( Réessayez de le résoudre!");
            this.dispose();
        	SwingUtilities.invokeLater(() -> new FenetreSokoban(new ControleurBouchon(Niveau.NIVEAU3)));
        }
    }

    @Override
    public void keyReleased( KeyEvent e ) {
        // nothing
    }

}
