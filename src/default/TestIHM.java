import javax.swing.SwingUtilities;

import boundary.FenetreSokoban;
import control.ControleurBouchon;

/**
 * Application de test de l'IHM du jeu Sokoban en utilisant le controleur bouchon
 * 
 * @author Dominique Marcadet
 * @version 1.2
 *
 */
public class TestIHM implements Runnable {

	@Override
	public void run() {
    	new FenetreSokoban(new ControleurBouchon());
	}

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new TestIHM());
    }
}
