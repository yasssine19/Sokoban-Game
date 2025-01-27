import javax.swing.SwingUtilities;

import boundary.FenetreSokoban;
import control.ControleurBouchon;
import entity.Niveau;

public class TestIHM implements Runnable {

	@Override
	public void run() {
    	new FenetreSokoban(new ControleurBouchon(Niveau.NIVEAU1));
	}

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new TestIHM());
    }
}
