package PT2019.Assignment1.ProjectPolinom.Model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import PT2019.Assignment1.ProjectPolinom.View.GeneralView;

/**
 * 
 * @author Pentek Tamas
 * 
 *         Clasa Polinom contine partea Model din modelul MVC. Fiecare polinom
 *         este alcatuit din mai multe monoame. In aceasta clasa sunt prezentate
 *         operatiile cu polinoame.
 */
public class Polinom {

	private ArrayList<Monom> monomList;
	private ArrayList<Monom> tempList;

	/**
	 * Constructorul clasei
	 */
	public Polinom() {
		this.tempList = new ArrayList<Monom>();
		this.monomList = new ArrayList<Monom>();
		int i = 20;
		while (i >= 0) {
			Monom x = new Monom();
			x.setCoef(0);
			x.setCoefIntegrala(0);
			x.setRang(i);
			x.setComponent("");
			monomList.add(x);
			i--;
		}
	}

	/**
	 * Metoda getter pentru monomList
	 * 
	 * @return monomList
	 */
	public ArrayList<Monom> getMonomList() {
		return monomList;
	}

	/**
	 * Aceasta metoda citeste polinomul, aplica Regexul si salveaza monoamele intr-o
	 * lista de monoame temporara. Daca citirea esueaza, afiseaza un JOptionPane cu
	 * eroarea
	 * 
	 * @param polinom   este polinomul in formatul String
	 * @param nrPolinom este numarul polinomului care folosesc la afisarea erorii
	 * @return daca citirea s-a terminat cu succes returneaza true altfel returneaza
	 *         false
	 */
	public boolean readPolinom(String polinom, String nrPolinom) {
		boolean e = false;
		String pattern = "([+-]*\\d*[x]*\\^*\\d*)*";
		String pattern2 = "[+-]*\\d*[x]*\\^*\\d*";
		Pattern p = Pattern.compile(pattern2);
		Matcher m = p.matcher(polinom);
		if (Pattern.matches(pattern, polinom) && !(polinom.equals(""))) {
			while (m.find() && !(m.group(0).equals(""))) {
				Monom x = new Monom();
				if (m.group(0).endsWith("^")) {
					GeneralView.showError(nrPolinom, 0);
					return e;
				}
				x.setComponent(m.group(0));
				this.tempList.add(x);
				e = true;
			}
		} else {
			GeneralView.showError(nrPolinom, 0);
		}
		return e;
	}

	/**
	 * Aceasta metoda proceseaza polinomul, salveaza coeficientul, rangul si
	 * reprezentarea text a monoamele intr-o lista de monoame. Daca procesarea
	 * esueaza, afiseaza un JOptionPane cu eroarea
	 * 
	 * @param numePolinom este numele si numarul polinomului
	 * @return daca procesarea polinomului s-a terminat cu succes returneaza true
	 *         altfel returneaza false
	 */
	public boolean processPolinom(String numePolinom) {
		boolean x = false;
		try {
			this.processCoef(numePolinom);
			this.processRang(numePolinom);
			for (Monom m : this.monomList) {
				for (Monom n : this.tempList) {
					if (m.getRang() == n.getRang()) {
						m.setCoef(m.getCoef() + n.getCoef());
						m.setComponent(n.getComponent());
						m.setCoefIntegrala(m.getCoefIntegrala() + n.getCoefIntegrala());
					}
				}
			}
			x = true;
		} catch (Exception e) {
			GeneralView.showError(numePolinom, 0);
			return x;
		}
		return x;
	}

	/**
	 * Aceasta metoda proceseaza coeficientul fiecarui monom care alcatuieste
	 * polinomul respectiv. Salveaza in x1 coeficientul iar la final adauga in lista
	 * de monoame a polinomului. 1. if: trateaza situatia cand apare un + sau - la
	 * sfarsitul polinomului 2. if: trateaza situatia cand primul caracter este +
	 * sau - de ex. -x sau +x 3. if: trateaza situatia cand primul caracter este un
	 * x, fara semn, fara coeficient
	 * 
	 * 
	 * @param numePolinom este numele si numarul polinomului
	 * @throws Exception in cazul unei probleme arunca o exceptie
	 */
	public void processCoef(String numePolinom) throws Exception {
		Integer x1 = new Integer(0);
		for (Monom t : tempList) {
			if (t.getComponent().charAt(t.getComponent().length() - 1) == '+'
					|| t.getComponent().charAt(t.getComponent().length() - 1) == '-') {
				throw new Exception();
			}
			if (t.getComponent().replaceAll("[x]\\^*\\d*", "").length() == 1
					&& (t.getComponent().replaceAll("[x]\\^*\\d*", "").charAt(0) == '+'
							|| t.getComponent().replaceAll("[x]\\^*\\d*", "").charAt(0) == '-')) {
				x1 = Integer.parseInt(t.getComponent().replaceAll("[x]\\^*\\d*", "").concat("1"));
			} else if (Pattern.matches("[x]\\^*\\d*", "x^3") == true
					&& t.getComponent().replaceAll("[x]\\^*\\d*", "").length() == 0) {

				x1 = Integer.parseInt(t.getComponent().replaceAll("[x]\\^*\\d*", "").concat("1"));
			} else {
				x1 = Integer.parseInt(t.getComponent().replaceAll("[x]\\^*\\d*", ""));
			}
			t.setCoef(x1);
			t.setCoefIntegrala(x1);
		}
	}

	/**
	 * Aceasta metoda proceseaza rangul fiecarui monom care alcatuieste polinomul
	 * respectiv. Salveaza in x2 rangul iar la final adauga in lista de monoame a
	 * polinomului. 1. if: trateaza situatia cand avem x => rangul este 1 2. if: are
	 * rolul de a evita termenul liber( adica sa nu numara si ca si un coeficient,
	 * si ca si un rang (rang 0)
	 * 
	 * @param numePolinom este numele si numarul polinomului
	 * @throws Exception in cazul unei probleme arunca o exceptie
	 */
	public void processRang(String numePolinom) throws Exception {
		Integer x2 = new Integer(0);
		for (Monom t : tempList) {
			if (t.getComponent().replaceAll("[+-]*\\d*[x]\\^*", "").length() == 0) {
				x2 = Integer.parseInt(t.getComponent().replaceAll("[+-]*\\d*[x]\\^*", "1"));
				if (x2 < 0) {
					throw new Exception();
				}
			} else if (t.getComponent().replaceAll("[+-]*\\d*", "").length() != 0) {
				x2 = Integer.parseInt(t.getComponent().replaceAll("[+-]*\\d*[x]\\^", ""));
				if (x2 < 0) {
					throw new Exception();
				}
			} else {
				x2 = 0;
			}
			t.setRang(x2);
		}
	}

	/**
	 * In aceasta metoda se face adunarea intre doua polinoame
	 * 
	 * @param p1 este primul polinom
	 * @param p2 este al doilea polinom
	 * @return rezultatul adunarii
	 */
	public static Polinom adunare(Polinom p1, Polinom p2) {
		Polinom rez = new Polinom();
		for (Monom m1 : p1.monomList) {
			for (Monom m2 : p2.monomList) {
				if (m1.getRang() == m2.getRang())
					rez.monomList.add(Monom.adunare(m1, m2));
			}
		}
		return rez;
	}

	/**
	 * In aceasta metoda se face scaderea intre doua polinoame
	 * 
	 * @param p1 este primul polinom
	 * @param p2 este al doilea polinom
	 * @param op este un numar cu care decidem daca scaderea vrem sa folosim la
	 *           impartire(op=1) sau nu
	 * @return rezultatul scaderii
	 */
	public static Polinom scadere(Polinom p1, Polinom p2, int op) {
		Polinom rez = new Polinom();
		for (Monom m1 : p1.monomList) {
			for (Monom m2 : p2.monomList) {
				if (op == 1) {
					if (m1.getRang() == m2.getRang() && (m1.getCoef() != 0))
						rez.monomList.add(Monom.scadere(m1, m2));
				} else {
					if (m1.getRang() == m2.getRang())
						rez.monomList.add(Monom.scadere(m1, m2));
				}
			}
		}
		return rez;
	}

	/**
	 * In aceasta metoda se face inmultirea intre doua polinoame
	 * 
	 * @param p1 este primul polinom
	 * @param p2 este al doilea polinom
	 * @return rezultatul inmultirii
	 */
	public static Polinom inmultire(Polinom p1, Polinom p2) {
		Polinom rez = new Polinom();
		for (Monom m1 : p1.monomList) {
			for (Monom m2 : p2.monomList) {
				rez.monomList.add(Monom.inmultire(m1, m2));
			}
		}
		Polinom temp = new Polinom();
		temp = temp.insumare(rez);
		return temp;
	}

	/**
	 * In aceasta metoda se face impartirea intre doua polinoame
	 * 
	 * @param p1 este primul polinom
	 * @param p2 este al doilea polinom
	 * @param r  este restul impartirii
	 * @return rezultatul impartirii( returneaza catul)
	 */
	public static Polinom impartire(Polinom p1, Polinom p2, Polinom r) {
		Polinom q = new Polinom();
		r.monomList.addAll(p1.monomList);
		Polinom aux = new Polinom();
		Polinom aux2 = new Polinom();
		Polinom r14 = new Polinom();
		Monom a = new Monom();
		Monom b = new Monom();
		Monom rez = new Monom();
		Polinom pp = new Polinom();
		a = r.highestRank();
		b = p2.highestRank();
		int i = 0;
		while (a.getRang() >= b.getRang()) {
			if (i == 100) {
				GeneralView.showError("împărțire!", 1);
				break;
			}
			rez = Monom.impartire(a, b);
			aux2.resetPolinom();
			aux2.monomList.add(rez);
			q.monomList.add(rez);
			aux.resetPolinom();
			aux = Polinom.inmultire(aux2, p2);
			pp.resetPolinom();
			for (Monom m : pp.monomList) {
				for (Monom n : aux.monomList) {
					if (m.getRang() == n.getRang()) {
						m.setCoef(m.getCoef() + n.getCoef());
						m.setComponent(n.getComponent());
					}
				}
			}
			r14.resetPolinom();
			r14 = Polinom.scadere(r, pp, 1);
			r.resetPolinom();
			r.monomList.addAll(r14.monomList);
			a = r.highestRank();
			i++;
		}
		return q;
	}

	/**
	 * In aceasta metoda se face derivarea polinomului
	 * 
	 * @param p este polinomul
	 * @return rezultatul derivarii
	 */
	public static Polinom derivare(Polinom p) {
		Polinom rez = new Polinom();
		for (Monom m : p.monomList) {
			rez.monomList.add(Monom.derivare(m));
		}
		Polinom temp = new Polinom();
		temp = temp.insumare(rez);
		return temp;
	}

	/**
	 * In aceasta metoda se face integrarea polinomului
	 * 
	 * @param p este polinomul
	 * @return rezultatul integrarii
	 */
	public static Polinom integrare(Polinom p) {
		Polinom rez = new Polinom();
		for (Monom m : p.monomList) {
			rez.monomList.add(Monom.integrare(m));
		}
		return rez;
	}

	/**
	 * In aceasta metoda se face insumarea termenilor cu acelasi rang de exemplu
	 * dupa inmultire
	 * 
	 * @param rez este polinomul
	 * @return rezultatul insumarii
	 */
	public Polinom insumare(Polinom rez) {
		Polinom temp = new Polinom();
		while (!(rez.monomList.isEmpty())) {
			boolean okay = true;
			Monom x = rez.monomList.get(0);
			rez.monomList.remove(x);
			int j = 0;
			Monom wer = x;
			while (j < rez.monomList.size() && !(rez.monomList.isEmpty())) {
				boolean rank = x.getRang() != 0 && rez.monomList.get(j).getRang() != 0;
				boolean coefy = x.getCoef() != 0 && rez.monomList.get(j).getCoef() != 0;
				if (x.getRang() == rez.monomList.get(j).getRang() && rank && coefy) {
					wer = Monom.adunare(wer, rez.monomList.get(j));
					rez.monomList.remove(j);
					okay = false;
				}
				j++;
			}
			if (okay)
				temp.monomList.add(x);
			else
				temp.monomList.add(wer);
		}
		return temp;
	}

	/**
	 * Aceasta metoda gaseste monomul cu cel mai mare rang din lista de monoame a
	 * polinomului. Folosim la algoritmul de impartire
	 * 
	 * @return monomul polinomului cu rangul cel mai mare
	 */
	public Monom highestRank() {
		Monom a = new Monom();
		for (Monom m1 : this.monomList) {
			if (m1.getCoef() != 0) {
				a.setCoef(m1.getCoef());
				a.setCoefIntegrala(m1.getCoefIntegrala());
				a.setRang(m1.getRang());
				a.setComponent(m1.getComponent());
				break;
			}
		}
		return a;
	}

	/**
	 * Aceasta metoda converteste polinomul in format String care folosim la
	 * afisarea rezultatului adunarii, scaderii, inmultirii, impartirii si
	 * derivarii. Metoda lucreaza cu coeficienti int
	 */
	public String toString() {
		String rez = "";
		for (Monom m : this.monomList) {
			if (m.getCoef() > 0)
				m.setComponent("+" + m.getComponent());
			if (m.getCoef() == 0)
				m.setComponent("");
			rez = rez + m.getComponent();
		}
		if (rez.length() == 0)
			rez = "0";
		if (rez.charAt(0) == '+')
			rez = rez.substring(1, rez.length());
		return rez;
	}

	/**
	 * Aceasta metoda converteste polinomul in format String care folosim la
	 * afisarea rezultatului integrarii. Metoda lucreaza cu coeficienti double
	 */
	public String toString2() {
		String rez = "";
		for (Monom m : this.monomList) {
			if (m.getCoefIntegrala() > 0d)
				m.setComponent("+" + m.getComponent());
			if (m.getCoefIntegrala() == 0f)
				m.setComponent("");
			rez = rez + m.getComponent();
		}
		if (rez.length() == 0)
			rez = "0";
		if (rez.charAt(0) == '+')
			rez = rez.substring(1, rez.length());
		return rez;
	}

	/**
	 * Aceasta metoda reseteaza polinomul. Folosim pentru a reseta polinomul dupa
	 * efectuarea unei operatii.
	 */
	public void resetPolinom() {
		this.tempList.clear();
		this.monomList.clear();
		int i = 20;
		while (i >= 0) {
			Monom x = new Monom();
			x.setCoef(0);
			x.setCoefIntegrala(0);
			x.setRang(i);
			x.setComponent("");
			this.monomList.add(x);
			i--;
		}
	}
}
