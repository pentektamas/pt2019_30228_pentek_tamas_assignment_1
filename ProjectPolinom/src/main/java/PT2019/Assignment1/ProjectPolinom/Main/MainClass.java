package PT2019.Assignment1.ProjectPolinom.Main;

import PT2019.Assignment1.ProjectPolinom.Controller.GeneralController;
import PT2019.Assignment1.ProjectPolinom.View.GeneralView;

/**
 * 
 * @author Pentek Tamas
 * 
 *         Clasa MainClass contine functia main
 *
 */
public class MainClass {
	public static void main(String[] args) {
		GeneralView v = new GeneralView();
		GeneralController c = new GeneralController(v);
		v.setVisible(true);

	}
}
