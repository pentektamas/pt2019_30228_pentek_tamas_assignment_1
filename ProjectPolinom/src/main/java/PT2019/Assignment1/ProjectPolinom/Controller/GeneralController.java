package PT2019.Assignment1.ProjectPolinom.Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import PT2019.Assignment1.ProjectPolinom.Model.Polinom;
import PT2019.Assignment1.ProjectPolinom.View.GeneralView;

/**
 * 
 * @author Pentek Tamas
 * 
 *         Clasa GeneralController contine partea Controller din modelul MVC. In
 *         aceasta clasa se face legatura intre Model si View.
 *
 */
public class GeneralController {

	private GeneralView view = new GeneralView();
	private Polinom poli1 = new Polinom();
	private Polinom poli2 = new Polinom();

	/**
	 * Constructorul clasei
	 * 
	 * @param gView este view-ul
	 */
	public GeneralController(GeneralView gView) {
		view = gView;
		view.addDerIntListener(new DerIntListener());
		view.addButtonsListener(new ButtonListener());
		view.addPolinom1Listener(new Polinom1Listener());
		view.addPolinom2Listener(new Polinom2Listener());
		view.addOkButtonListener(new OkButtonListener());
	}

	/**
	 * 
	 * Aceasta este o clasa care implementeaza ActionListener si folosim pentru
	 * butonul de derivare si integrare, ca sa activam optiunile Polinom 1 si
	 * Polinom 2
	 *
	 */
	class DerIntListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			view.getLabel().setVisible(true);
			view.getSelectie().setVisible(true);
		}
	}

	/**
	 * 
	 * Aceasta este o clasa care implementeaza ActionListener si folosim pentru
	 * butonul de adunare, scadere, inmultire, impartire ca sa dezactivam optiunile
	 * Polinom 1 si Polinom 2
	 *
	 */
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			view.getLabel().setVisible(false);
			view.getSelectie().setVisible(false);

		}
	}

	/**
	 * 
	 * Aceasta este o clasa care implementeaza ActionListener si folosim pentru
	 * primul JTextField ca sa citim si sa procesam primul polinom
	 *
	 */
	class Polinom1Listener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String polinom1 = view.getPolinom1().getText();
			poli1.resetPolinom();
			boolean read = poli1.readPolinom(polinom1, "polinomul 1");
			boolean rez = poli1.processPolinom("polinomul 1");
			if (rez == true && read == true)
				view.getPolinom1().setBackground(Color.GREEN);
			else
				view.getPolinom1().setBackground(Color.RED);
		}
	}

	/**
	 * 
	 * Aceasta este o clasa care implementeaza ActionListener si folosim pentru al
	 * doilea JTextField ca sa citim si sa procesam al doilea polinom
	 *
	 */
	class Polinom2Listener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String polinom2 = view.getPolinom2().getText();
			poli2.resetPolinom();
			boolean read = poli2.readPolinom(polinom2, "polinomul 2");
			boolean rez = poli2.processPolinom("polinomul 2");
			if (rez == true && read == true)
				view.getPolinom2().setBackground(Color.GREEN);
			else
				view.getPolinom2().setBackground(Color.RED);
		}
	}

	/**
	 * 
	 * Aceasta este o clasa care implementeaza ActionListener si folosim pentru
	 * butonul de OK si verificam care operatie este selectata si in functie de
	 * operatia selectata apelam metodele din clasa Polinom si afisam rezultatul cu
	 * diferite culoare
	 *
	 */
	class OkButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			view.getPolinom1().setBackground(Color.WHITE);
			view.getPolinom2().setBackground(Color.WHITE);
			Polinom p = new Polinom();
			if (view.getB1().isSelected()) {
				p = Polinom.adunare(poli1, poli2);
				view.getResult().setBackground(Color.RED);
			}
			if (view.getB2().isSelected()) {
				p = Polinom.scadere(poli1, poli2, 0);
				view.getResult().setBackground(Color.ORANGE);
			}
			if (view.getB3().isSelected()) {
				p = Polinom.inmultire(poli1, poli2);
				view.getResult().setBackground(Color.YELLOW);
			}
			if (view.getB4().isSelected()) {
				Polinom r = new Polinom();
				p = Polinom.impartire(poli1, poli2, r);
				view.getResult().setText("Câtul: " + p.toString() + "   Restul: " + r.toString());
				view.getResult().setBackground(Color.CYAN);
				return;
			}
			if (view.getB5().isSelected()) {
				view.getResult().setBackground(Color.GREEN);
				if (view.getSelectie().getSelectedItem().equals("Polinomul 1"))
					p = Polinom.derivare(poli1);
				else
					p = Polinom.derivare(poli2);
			}
			if (view.getB6().isSelected()) {
				view.getResult().setBackground(Color.MAGENTA);
				if (view.getSelectie().getSelectedItem().equals("Polinomul 1"))
					p = Polinom.integrare(poli1);
				else
					p = Polinom.integrare(poli2);
				view.getResult().setText(" " + p.toString2());
				return;
			}
			view.getResult().setText(p.toString());
		}
	}
}