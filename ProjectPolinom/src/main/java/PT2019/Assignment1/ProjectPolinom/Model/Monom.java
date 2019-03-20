package PT2019.Assignment1.ProjectPolinom.Model;

import java.text.DecimalFormat;

/**
 * 
 * @author Pentek Tamas
 * 
 *         Clasa Monom contine partea Model din modelul MVC. Fiecare polinom
 *         este alcatuit din mai multe monoame. In aceasta clasa sunt prezentate
 *         operatiile cu monoame.
 */
public class Monom {
	private String component;
	private int coef;
	private int rang;
	private double coefIntegrala;

	/**
	 * Constructorul clasei
	 */
	public Monom() {
		component = new String(" ");
		coef = 0;
		rang = 0;
	}

	/**
	 * In aceasta metoda se face adunarea intre doua monoame
	 * 
	 * @param m1 este primul monom
	 * @param m2 este al doilea monom
	 * @return rezultatul adunarii
	 */
	public static Monom adunare(Monom m1, Monom m2) {
		Monom rez = new Monom();
		rez.coef = m1.coef + m2.coef;
		rez.coefIntegrala = m1.coefIntegrala + m2.coefIntegrala;
		rez.rang = m1.rang;
		rez.component = rez.toString();
		return rez;
	}

	/**
	 * In aceasta metoda se face scaderea intre doua monoame
	 * 
	 * @param m1 este primul monom
	 * @param m2 este al doilea monom
	 * @return rezultatul scaderii
	 */
	public static Monom scadere(Monom m1, Monom m2) {
		Monom rez = new Monom();
		rez.coef = m1.coef - m2.coef;
		rez.coefIntegrala = m1.coefIntegrala - m2.coefIntegrala;
		rez.rang = m1.rang;
		rez.component = rez.toString();
		return rez;
	}

	/**
	 * In aceasta metoda se face inmultirea intre doua monoame
	 * 
	 * @param m1 este primul monom
	 * @param m2 este al doilea monom
	 * @return rezultatul inmultirii
	 */
	public static Monom inmultire(Monom m1, Monom m2) {
		Monom rez = new Monom();
		rez.coef = m1.coef * m2.coef;
		rez.coefIntegrala = m1.coefIntegrala * m2.coefIntegrala;
		rez.rang = m1.rang + m2.rang;
		rez.component = rez.toString();
		return rez;
	}
	/**
	 * In aceasta metoda se face impartirea intre doua monoame
	 * 
	 * @param m1 este primul monom
	 * @param m2 este al doilea monom
	 * @return rezultatul impartirii
	 */
	public static Monom impartire(Monom m1, Monom m2) {
		Monom rez = new Monom();
		if (m2.coef != 0 && m2.coefIntegrala != 0)
			rez.coef = m1.coef / m2.coef;
		rez.coefIntegrala = m1.coefIntegrala / m2.coefIntegrala;
		rez.rang = m1.rang - m2.rang;
		rez.component = rez.toString();
		return rez;

	}

	/**
	 * In aceasta metoda se face derivarea monomului
	 * 
	 * @param m este monomul
	 * @return rezultatul derivarii
	 */
	public static Monom derivare(Monom m) {
		Monom rez = new Monom();
		rez.coef = m.coef * m.rang;
		rez.rang = m.rang - 1;
		rez.component = rez.toString();
		return rez;
	}

	/**
	 * In aceasta metoda se face integrarea monomului
	 * 
	 * @param m este monomul
	 * @return rezultatul integrarii
	 */
	public static Monom integrare(Monom m) {
		Monom rez = new Monom();
//		rez.coefIntegrala = (m.coefIntegrala * 1d / (m.rangIntegrala + 1));
		rez.coefIntegrala = (m.coefIntegrala * 1d / (m.rang + 1));
		rez.coef = (int) rez.coefIntegrala;
//		rez.rangIntegrala = m.rangIntegrala + 1;
		rez.rang = m.rang + 1;
		rez.component = rez.toString2();
		return rez;
	}

	/**
	 * Metode getter si setter
	 */
	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public int getCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	public double getCoefIntegrala() {
		return coefIntegrala;
	}

	public void setCoefIntegrala(double coefIntegrala) {
		this.coefIntegrala = coefIntegrala;
	}

	/**
	 * Aceasta metoda converteste monomul in format String care folosim la afisarea
	 * rezultatului adunarii, scaderii, inmultirii, impartirii si derivarii. Metoda
	 * lucreaza cu coeficienti int
	 */
	public String toString() {
		String coef;
		String rang;
		if (this.coef == 1)
			coef = "";
		else if (this.coef == -1)
			coef = "-";
		else
			coef = this.coef + "";
		if (this.rang == 0) {
			rang = "";
		} else if (this.rang == 1)
			rang = "x";
		else
			rang = "x^" + this.rang;
		if (this.rang == 0 && this.coef == 1) {
			rang = "";
			coef = "1";
		}
		if (this.rang == 0 && this.coef == -1) {
			rang = "";
			coef = "-1";
		}
		return coef + rang;
	}

	/**
	 * Aceasta metoda converteste monomul in format String care folosim la afisarea
	 * rezultatului integrarii. Metoda lucreaza cu coeficienti double
	 */
	public String toString2() {
		String coef;
		String rang;
		DecimalFormat numberFormat = new DecimalFormat("0.00");
		if (this.coefIntegrala == 1d)
			coef = "";
		else if (this.coefIntegrala == -1d)
			coef = "-";
		else
			coef = numberFormat.format(this.coefIntegrala) + "";
		if (this.rang == 0) {
			rang = "";
		} else if (this.rang == 1)
			rang = "x";
		else
			rang = "x^" + this.rang;
		if (this.rang == 0 && this.coefIntegrala == 1d) {
			rang = "";
			coef = "1";
		}
		if (this.rang == 0 && this.coefIntegrala == -1d) {
			rang = "";
			coef = "-1";
		}
		return coef + rang;
	}
}
