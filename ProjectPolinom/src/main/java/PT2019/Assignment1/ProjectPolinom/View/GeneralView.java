package PT2019.Assignment1.ProjectPolinom.View;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

/**
 * 
 * @author Pentek Tamas
 * 
 *         Clasa GeneralView contine partea View din modelul MVC
 */

public class GeneralView extends JFrame {

	private JTextField polinom1 = new JTextField();
	private JTextField polinom2 = new JTextField();
	private JLabel pol1 = new JLabel("Introduceți primul polinom:");
	private JLabel pol2 = new JLabel("Introduceți al doilea polinom:        ");
	private JLabel opSelect = new JLabel("Selectați operația:");
	private JRadioButton b1 = new JRadioButton("Adunare");
	private JRadioButton b2 = new JRadioButton("Scădere");
	private JRadioButton b3 = new JRadioButton("Înmulțire");
	private JRadioButton b4 = new JRadioButton("Împărțire");
	private JRadioButton b5 = new JRadioButton("Derivare");
	private JRadioButton b6 = new JRadioButton("Integrare");
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JButton b = new JButton(" OK ");
	private GridLayout layout1 = new GridLayout(0, 3);
	private GridLayout layout2 = new GridLayout(0, 1);
	private String[] posibilitati = { "Polinomul 1", "Polinomul 2" };
	private JComboBox selectie = new JComboBox(posibilitati);
	private JLabel selLabel = new JLabel("Selectați polinomul:   ");
	private JLabel verify = new JLabel("                 (Apăsați enter)");
	private JLabel verify2 = new JLabel("                 (Apăsați enter)");
	private JTextField result = new JTextField();
	private JLabel resultLabel = new JLabel("Rezultat: ");

	/**
	 * Constructorul clasei
	 */
	public GeneralView() {
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		pol1.setFont(new Font("Arial", Font.BOLD, 22));
		pol2.setFont(new Font("Arial", Font.BOLD, 22));
		verify.setFont(new Font("Arial", Font.BOLD, 22));
		verify2.setFont(new Font("Arial", Font.BOLD, 22));
		b1.setFont(new Font("Arial", Font.BOLD, 22));
		b2.setFont(new Font("Arial", Font.BOLD, 22));
		b3.setFont(new Font("Arial", Font.BOLD, 22));
		b4.setFont(new Font("Arial", Font.BOLD, 22));
		b5.setFont(new Font("Arial", Font.BOLD, 22));
		b6.setFont(new Font("Arial", Font.BOLD, 22));
		b.setFont(new Font("Arial", Font.BOLD, 22));
		opSelect.setFont(new Font("Arial", Font.BOLD, 22));
		selLabel.setFont(new Font("Arial", Font.BOLD, 22));
		selectie.setFont(new Font("Arial", Font.BOLD, 22));
		polinom1.setFont(new Font("Arial", Font.BOLD, 18));
		polinom2.setFont(new Font("Arial", Font.BOLD, 18));
		b1.setBackground(Color.RED);
		b2.setBackground(Color.ORANGE);
		b3.setBackground(Color.YELLOW);
		b4.setBackground(Color.CYAN);
		b5.setBackground(Color.GREEN);
		b6.setBackground(Color.MAGENTA);
		p1.add(pol1);
		p1.add(polinom1);
		p1.add(verify);
		p1.add(pol2);
		p1.add(polinom2);
		p1.add(verify2);
		p1.setLayout(layout1);
		p4.add(opSelect);
		buttonGroup.add(b1);
		buttonGroup.add(b2);
		buttonGroup.add(b3);
		buttonGroup.add(b4);
		buttonGroup.add(b5);
		buttonGroup.add(b6);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p3.add(b);
		p6.add(resultLabel);
		p6.add(result);
		result.setEditable(false);
		result.setPreferredSize(new Dimension(400, 30));
		result.setFont(new Font("Arial", Font.BOLD, 18));
		result.setBackground(Color.WHITE);
		resultLabel.setFont(new Font("Arial", Font.BOLD, 22));
		p.setLayout(layout2);
		p.add(p1);
		p.add(p4);
		p.add(p2);
		p.add(p5);
		p.add(p3);
		p.add(p6);
		p1.setBackground(Color.LIGHT_GRAY);
		p2.setBackground(Color.LIGHT_GRAY);
		p3.setBackground(Color.LIGHT_GRAY);
		p4.setBackground(Color.LIGHT_GRAY);
		p5.setBackground(Color.LIGHT_GRAY);
		p6.setBackground(Color.LIGHT_GRAY);
		p5.add(selLabel);
		p5.add(selectie);
		selectie.setVisible(false);
		selLabel.setVisible(false);
		this.setContentPane(p);
		this.pack();
		this.setTitle("Operații cu polinoame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * In aceasta metoda adaugam ActionListeners pentru butonul 5 si 6 care
	 * reprezinta integrarea si derivarea.
	 * 
	 * @param al este un ActionListener
	 */
	public void addDerIntListener(ActionListener al) {
		b5.addActionListener(al);
		b6.addActionListener(al);
	}

	/**
	 * In aceasta metoda adaugam ActionListeners pentru Radiobutonul 1, 2, 3 si 4
	 * care reprezinta adunarea, scaderea, inmultirea si impartirea.
	 * 
	 * @param al este un ActionListener
	 */
	public void addButtonsListener(ActionListener al) {
		b1.addActionListener(al);
		b2.addActionListener(al);
		b3.addActionListener(al);
		b4.addActionListener(al);
	}

	/**
	 * In aceasta metoda adaugam ActionListener pentru butonul OK
	 * 
	 * @param al este un ActionListener
	 */
	public void addOkButtonListener(ActionListener al) {
		b.addActionListener(al);
	}

	/**
	 * In aceasta metoda adaugam ActionListener pentru JTextField1 in care introduce
	 * utilizatorul primul polinom
	 * 
	 * @param al este un ActionListener
	 */
	public void addPolinom1Listener(ActionListener al) {
		polinom1.addActionListener(al);
	}

	/**
	 * In aceasta metoda adaugam ActionListener pentru JTextField2 in care introduce
	 * utilizatorul al doilea polinom
	 * 
	 * @param al este un ActionListener
	 */
	public void addPolinom2Listener(ActionListener al) {
		polinom2.addActionListener(al);
	}

	/**
	 * In aceasta metoda afisam un JOptionPane cu diferite mesaje de eroare
	 * 
	 * @param x este o parte din textul care va fi afisat in JOptionPane
	 * @param i este numarul cu care alegem care mesaj vrem sa afisam
	 */
	public static void showError(String x, int i) {
		UIManager.put("OptionPane.minimumSize", new Dimension(400, 100));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.BOLD, 22)));
		if (i == 0)
			JOptionPane.showMessageDialog(null, "Ați introdus greșit " + x + " !\n" + "Introduceți din nou !",
					"ERROR !!!", JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "ERROR " + x, "ERROR !!!", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Metode getter si setter
	 */
	public JRadioButton getB1() {
		return b1;
	}

	public void setB1(JRadioButton b1) {
		this.b1 = b1;
	}

	public JRadioButton getB2() {
		return b2;
	}

	public void setB2(JRadioButton b2) {
		this.b2 = b2;
	}

	public JRadioButton getB3() {
		return b3;
	}

	public void setB3(JRadioButton b3) {
		this.b3 = b3;
	}

	public JRadioButton getB4() {
		return b4;
	}

	public void setB4(JRadioButton b4) {
		this.b4 = b4;
	}

	public JRadioButton getB5() {
		return b5;
	}

	public void setB5(JRadioButton b5) {
		this.b5 = b5;
	}

	public JRadioButton getB6() {
		return b6;
	}

	public void setB6(JRadioButton b6) {
		this.b6 = b6;
	}

	public JButton getB() {
		return b;
	}

	public void setB(JButton b) {
		this.b = b;
	}

	public JTextField getResult() {
		return result;
	}

	public void setResult(JTextField result) {
		this.result = result;
	}

	public JLabel getLabel() {
		return selLabel;
	}

	public void setLabel(JLabel label) {
		this.selLabel = label;
	}

	public JComboBox getSelectie() {
		return selectie;
	}

	public void setSelectie(JComboBox selectie) {
		this.selectie = selectie;
	}

	public JTextField getPolinom1() {
		return polinom1;
	}

	public void setPolinom1(JTextField polinom1) {
		this.polinom1 = polinom1;
	}

	public JTextField getPolinom2() {
		return polinom2;
	}

	public void setPolinom2(JTextField polinom2) {
		this.polinom2 = polinom2;
	}

	public JLabel getVerify() {
		return verify;
	}

	public void setVerify(JLabel verify) {
		this.verify = verify;
	}

	public JLabel getVerify2() {
		return verify2;
	}

	public void setVerify2(JLabel verify2) {
		this.verify2 = verify2;
	}
}
